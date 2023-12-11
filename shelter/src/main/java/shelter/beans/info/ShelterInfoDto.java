package shelter.beans.info;

public class ShelterInfoDto {
	private String careRegNo;
    private String careNm;
    private String location;
	public ShelterInfoDto(String careRegNo2, String careNm2, String location2) {
		// TODO Auto-generated constructor stub
		this.careRegNo = careRegNo;
        this.careNm = careNm;
        this.location = location;
	}
	public String getCareRegNo() {
		return careRegNo;
	}
	public void setCareRegNo(String careRegNo) {
		this.careRegNo = careRegNo;
	}
	public String getCareNm() {
		return careNm;
	}
	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    
    
}
