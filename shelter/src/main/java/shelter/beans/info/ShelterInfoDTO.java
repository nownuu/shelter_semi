package shelter.beans.info;

public class ShelterInfoDTO {
    private String careNm;
    private String orgNm;
    private String divisionNm;
    private String saveTrgtAnimal;
    private String careAddr;
    private String jibunAddr;
	public String getCareNm() {
		return careNm;
	}
	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public String getDivisionNm() {
		return divisionNm;
	}
	public void setDivisionNm(String divisionNm) {
		this.divisionNm = divisionNm;
	}
	public String getSaveTrgtAnimal() {
		return saveTrgtAnimal;
	}
	public void setSaveTrgtAnimal(String saveTrgtAnimal) {
		this.saveTrgtAnimal = saveTrgtAnimal;
	}
	public String getCareAddr() {
		return careAddr;
	}
	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}
	public String getJibunAddr() {
		return jibunAddr;
	}
	public void setJibunAddr(String jibunAddr) {
		this.jibunAddr = jibunAddr;
	}
	@Override
	public String toString() {
		return "ShelterInfoDTO [careNm=" + careNm + ", orgNm=" + orgNm + ", divisionNm=" + divisionNm
				+ ", saveTrgtAnimal=" + saveTrgtAnimal + ", careAddr=" + careAddr + ", jibunAddr=" + jibunAddr + "]";
	}
    
    
}

