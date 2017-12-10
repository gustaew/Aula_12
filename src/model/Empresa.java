package model;

public class Empresa {
	private String CNPJ;
	private String razaoSocial;
	private int temperatura;
	private String horarioInicio;
	private String horarioFim;
	private String horarioArInicio;
	private String horarioArFim;

	public Empresa(String cnpj, String razaoSocial, int temperatura, String horarioInicio, String horarioFim,
			String horarioArInicio, String horarioArFim) {
		setCNPJ(cnpj);
		setRazaoSocial(razaoSocial);
		setTemperatura(temperatura);
		setHorarioInicio(horarioInicio);
		setHorarioFim(horarioFim);
		setHorarioArInicio(horarioArInicio);
		setHorarioArFim(horarioArFim);
	}

	public String toString() {
		return "[ " + CNPJ + " " + razaoSocial + " " + temperatura + " " + horarioInicio + " " + horarioFim + " "
				+ horarioArInicio + " " + horarioArInicio + " ]";

	}

	public Empresa() {
		setCNPJ("");
		setRazaoSocial("");
		setTemperatura(0);
		setHorarioInicio("");
		setHorarioFim("");
		setHorarioArInicio("");
		setHorarioArFim("");
	}

	public void setCNPJ(String cnpj) {
		this.CNPJ = cnpj;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	public void setHorarioArInicio(String horarioArInicio) {
		this.horarioArInicio = horarioArInicio;
	}

	public void setHorarioArFim(String horarioArFim) {
		this.horarioArFim = horarioArFim;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public String getHorarioArInicio() {
		return horarioArInicio;
	}

	public String getHorarioArFim() {
		return horarioArFim;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		if (horarioArFim == null) {
			if (other.horarioArFim != null)
				return false;
		} else if (!horarioArFim.equals(other.horarioArFim))
			return false;
		if (horarioArInicio == null) {
			if (other.horarioArInicio != null)
				return false;
		} else if (!horarioArInicio.equals(other.horarioArInicio))
			return false;
		if (horarioFim == null) {
			if (other.horarioFim != null)
				return false;
		} else if (!horarioFim.equals(other.horarioFim))
			return false;
		if (horarioInicio == null) {
			if (other.horarioInicio != null)
				return false;
		} else if (!horarioInicio.equals(other.horarioInicio))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (temperatura != other.temperatura)
			return false;
		return true;
	}

}
