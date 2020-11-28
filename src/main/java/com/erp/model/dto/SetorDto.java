package com.erp.model.dto;

public class SetorDto {

	private String idSetor;

	private String cdChamda;

	private String nmSetor;

	public SetorDto(String idSetor, String cdChamda, String nmSetor) {
		super();
		this.idSetor = idSetor;
		this.cdChamda = cdChamda;
		this.nmSetor = nmSetor;
	}

	public SetorDto() {
		super();
	}

	public String getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor;
	}

	public String getCdChamda() {
		return cdChamda;
	}

	public void setCdChamda(String cdChamda) {
		this.cdChamda = cdChamda;
	}

	public String getNmSetor() {
		return nmSetor;
	}

	public void setNmSetor(String nmSetor) {
		this.nmSetor = nmSetor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetorDto other = (SetorDto) obj;
		if (idSetor == null) {
			if (other.idSetor != null)
				return false;
		} else if (!idSetor.equals(other.idSetor))
			return false;
		return true;
	}

}
