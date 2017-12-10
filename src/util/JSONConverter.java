package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Empresa;

public class JSONConverter {

	public static String criarJSON(HttpServletRequest request) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();

		while (reader.ready()) {
			String linha = reader.readLine();
			sb.append(linha);
		}

		reader.close();

		return sb.toString();
	}

	public static Empresa jsonToEmpresa(String json) throws IOException {
		try {
			Empresa empresa = new Empresa();
			JSONObject objeto = new JSONObject(json);
			empresa.setCNPJ(objeto.getString("cnpj"));
			empresa.setHorarioArFim(objeto.getString("horarioArFim"));
			empresa.setHorarioArInicio(objeto.getString("horarioArInicio"));
			empresa.setHorarioFim(objeto.getString("horarioFim"));
			empresa.setHorarioInicio(objeto.getString("horarioInicio"));
			empresa.setRazaoSocial(objeto.getString("razaoSocial"));
			empresa.setTemperatura(objeto.getInt("temperatura"));
			return empresa;
		} catch (JSONException e) {
			throw new IOException(e);
		}
	}

	public static String empresaToJSON(Empresa empresa) throws IOException {
		try {
			JSONObject objeto = new JSONObject();

			objeto.put("cnpj", empresa.getCNPJ());
			objeto.put("horarioArFim", empresa.getHorarioArFim());
			objeto.put("horarioFim", empresa.getHorarioFim());
			objeto.put("horarioInicio", empresa.getHorarioInicio());
			objeto.put("razaoSocial", empresa.getRazaoSocial());
			objeto.put("temperatura", empresa.getTemperatura());
			objeto.put("horarioArInicio", empresa.getHorarioArInicio());

			return objeto.toString();
		} catch (JSONException e) {
			throw new IOException(e);
		}

	}

	public static String listEmpresaToJSON(ArrayList<Empresa> empresas) throws IOException {

		try {

			JSONArray array = new JSONArray();
			Iterator<Empresa> iterator = empresas.iterator();

			while (iterator.hasNext()) {
				Empresa empresa = iterator.next();
				JSONObject objeto = new JSONObject();
				objeto.put("cnpj", empresa.getCNPJ());
				objeto.put("horarioArFim", empresa.getHorarioArFim());
				objeto.put("horarioFim", empresa.getHorarioFim());
				objeto.put("horarioInicio", empresa.getHorarioInicio());
				objeto.put("razaoSocial", empresa.getRazaoSocial());
				objeto.put("temperatura", empresa.getTemperatura());
				objeto.put("horarioArInicio", empresa.getHorarioArInicio());
				array.put(objeto);
			}

			return array.toString();

		} catch (JSONException e) {
			throw new IOException(e);
		}

	}

}
