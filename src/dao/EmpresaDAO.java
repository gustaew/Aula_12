package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;

public class EmpresaDAO {
	Connection conn;
	PreparedStatement prepared;

	public EmpresaDAO() {
		prepared = null;
	}

	public Empresa consultar(String cnpj) {
		String sqlRead = ("select * from empresa where CNPJ = ?");
		ResultSet result = null;
		Empresa empresa = new Empresa();
		try {
			conn = ConnectionFactory.obtemConexao();
			prepared = conn.prepareStatement(sqlRead);
			prepared.setString(1, cnpj);
			result = prepared.executeQuery();

			if (result.next()) {

				empresa.setCNPJ(result.getString("CNPJ"));
				empresa.setRazaoSocial(result.getString("razaoSocial"));
				empresa.setTemperatura(result.getInt("temperatura"));
				empresa.setHorarioInicio(result.getString("horaInicio"));
				empresa.setHorarioFim(result.getString("horaFim"));
				empresa.setHorarioArInicio(result.getString("horaArInicio"));
				empresa.setHorarioArFim(result.getString("horaArFim"));
				result.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqlE) {
				System.out.print(sqlE.getLocalizedMessage());
			}
		} finally {
			if (prepared != null) {
				try {
					prepared.close();
					conn.close();
				} catch (SQLException sqlE) {
					System.out.print(sqlE.getLocalizedMessage());
				}
			}
		}

		return empresa;
	}

	public boolean excluir(String cnpj) {
		String sqlDelete = ("delete from empresa where CNPJ = ?");
		boolean saida = false;

		try {
			conn = ConnectionFactory.obtemConexao();
			prepared = conn.prepareStatement(sqlDelete);
			prepared.setString(1, cnpj);
			saida = prepared.execute();

		} catch (Exception e) {
			saida = false;
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqlE) {
				System.out.print(sqlE.getLocalizedMessage());
			}
		} finally {
			if (prepared != null) {
				try {
					prepared.close();
					conn.close();
				} catch (SQLException sqlE) {
					System.out.print(sqlE.getLocalizedMessage());
				}
			}
		}

		return saida;
	}

	public boolean cadastrar(Empresa empresa) {

		String sqlInsert = ("insert into empresa ( CNPJ, razaoSocial, temperatura, horaInicio, horaFim, "
				+ "horaArInicio, horaArFim ) values ( ?, ?, ?, ?, ?, ?, ? )");
		boolean sucesso = false;
		try {
			conn = ConnectionFactory.obtemConexao();
			prepared = conn.prepareStatement(sqlInsert);
			prepared.setString(1, empresa.getCNPJ());
			prepared.setString(2, empresa.getRazaoSocial());
			prepared.setInt(3, empresa.getTemperatura());
			prepared.setString(4, empresa.getHorarioInicio());
			prepared.setString(5, empresa.getHorarioFim());
			prepared.setString(6, empresa.getHorarioArInicio());
			prepared.setString(7, empresa.getHorarioArFim());
			prepared.execute();
			sucesso = true;
		} catch (Exception e) {

			if (e instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException) {
				throw new RuntimeException("" + 0); // 0 retorna quando CNPJ
													// duplicado
			}

			if (e instanceof com.mysql.jdbc.MysqlDataTruncation) {
				throw new RuntimeException("" + 1); // 1 retorna quando um campo
													// ta vazio
			}
			try {
				conn.rollback();
			} catch (SQLException sqlE) {
				// System.out.print(sqlE.getLocalizedMessage());
			}
		} finally {
			if (prepared != null) {
				try {
					// fecha prepapredStatement
					prepared.close();
					// fecha conexão
					conn.close();
				} catch (SQLException sqlE) {
					System.out.print(sqlE.getLocalizedMessage());
				}
			}
		}
		return sucesso;

	}

	public boolean atualizar(Empresa empresa) {
		String sqlUpdate = ("UPDATE empresa SET razaoSocial = ?, temperatura = ?, horaInicio = ?, horaFim = ?, "
				+ "horaArInicio = ?, horaArFim = ? where CNPJ = ?");
		boolean saida = false;

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement prepared = conn.prepareStatement(sqlUpdate);) {

			prepared.setString(1, empresa.getRazaoSocial());
			prepared.setInt(2, empresa.getTemperatura());
			prepared.setString(3, empresa.getHorarioInicio());
			prepared.setString(4, empresa.getHorarioFim());
			prepared.setString(5, empresa.getHorarioArInicio());
			prepared.setString(6, empresa.getHorarioArFim());
			prepared.setString(7, empresa.getCNPJ());
			prepared.execute();
			saida = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saida;
	}

	public ArrayList<Empresa> listar() {

		String sql = "SELECT * FROM empresa";
		ArrayList<Empresa> lista = new ArrayList<Empresa>();

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement prepared = conn.prepareStatement(sql)) {

			try (ResultSet result = prepared.executeQuery();) {

				while (result.next()) {
					Empresa empresa = new Empresa();
					empresa.setCNPJ(result.getString("CNPJ"));
					empresa.setRazaoSocial(result.getString("razaoSocial"));
					empresa.setTemperatura(result.getInt("temperatura"));
					empresa.setHorarioInicio(result.getString("horaInicio"));
					empresa.setHorarioFim(result.getString("horaFim"));
					empresa.setHorarioArInicio(result.getString("horaArInicio"));
					empresa.setHorarioArFim(result.getString("horaArFim"));
					lista.add(empresa);
				}

			} catch (Exception e) {
				System.out.print(e.getStackTrace());
			}

		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		}

		return lista;
	}

	public ArrayList<Empresa> listar(String nome) {

		String sql = "SELECT * FROM empresa where upper(razaoSocial) like ?";
		ArrayList<Empresa> lista = new ArrayList<Empresa>();

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement prepared = conn.prepareStatement(sql)) {
			prepared.setString(1, "%" + nome.toUpperCase() + "%");

			try (ResultSet result = prepared.executeQuery();) {

				while (result.next()) {
					Empresa empresa = new Empresa();
					empresa.setCNPJ(result.getString("CNPJ"));
					empresa.setRazaoSocial(result.getString("razaoSocial"));
					empresa.setTemperatura(result.getInt("temperatura"));
					empresa.setHorarioInicio(result.getString("horaInicio"));
					empresa.setHorarioFim(result.getString("horaFim"));
					empresa.setHorarioArInicio(result.getString("horaArInicio"));
					empresa.setHorarioArFim(result.getString("horaArFim"));
					lista.add(empresa);
				}

			} catch (Exception e) {
				System.out.print(e.getStackTrace());
			}

		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		}

		return lista;
	}
}
