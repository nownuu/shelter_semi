package shelter.beans.info;

public class ShelterInfo {

	private String careNm;
    private String orgNm;
    private String divisionNm;
    private String saveTrgtAnimal;
    private String careAddr;
    private String jibunAddr;
    private double lat;
    private double lng;
    private String dsignationDate;
    private String weekOprStime;
    private String weekOprEtime;
    private String weekCellStime;
    private String weekCellEtime;
    private String weekendOprStime;
    private String weekendOprEtime;
    private String weekendCellStime;
    private String weekendCellEtime;
    private String closeDay;
    private int vetPersonCnt;
    private int specsPersonCnt;
    private int medicalCnt;
    private int breedCnt;
    private int quarabtineCnt;
    private int feedCnt;
    private int transCarCnt;
    private String careTel;
    private String dataStdDt;
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
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getDsignationDate() {
		return dsignationDate;
	}
	public void setDsignationDate(String dsignationDate) {
		this.dsignationDate = dsignationDate;
	}
	public String getWeekOprStime() {
		return weekOprStime;
	}
	public void setWeekOprStime(String weekOprStime) {
		this.weekOprStime = weekOprStime;
	}
	public String getWeekOprEtime() {
		return weekOprEtime;
	}
	public void setWeekOprEtime(String weekOprEtime) {
		this.weekOprEtime = weekOprEtime;
	}
	public String getWeekCellStime() {
		return weekCellStime;
	}
	public void setWeekCellStime(String weekCellStime) {
		this.weekCellStime = weekCellStime;
	}
	public String getWeekCellEtime() {
		return weekCellEtime;
	}
	public void setWeekCellEtime(String weekCellEtime) {
		this.weekCellEtime = weekCellEtime;
	}
	public String getWeekendOprStime() {
		return weekendOprStime;
	}
	public void setWeekendOprStime(String weekendOprStime) {
		this.weekendOprStime = weekendOprStime;
	}
	public String getWeekendOprEtime() {
		return weekendOprEtime;
	}
	public void setWeekendOprEtime(String weekendOprEtime) {
		this.weekendOprEtime = weekendOprEtime;
	}
	public String getWeekendCellStime() {
		return weekendCellStime;
	}
	public void setWeekendCellStime(String weekendCellStime) {
		this.weekendCellStime = weekendCellStime;
	}
	public String getWeekendCellEtime() {
		return weekendCellEtime;
	}
	public void setWeekendCellEtime(String weekendCellEtime) {
		this.weekendCellEtime = weekendCellEtime;
	}
	public String getCloseDay() {
		return closeDay;
	}
	public void setCloseDay(String closeDay) {
		this.closeDay = closeDay;
	}
	public int getVetPersonCnt() {
		return vetPersonCnt;
	}
	public void setVetPersonCnt(int vetPersonCnt) {
		this.vetPersonCnt = vetPersonCnt;
	}
	public int getSpecsPersonCnt() {
		return specsPersonCnt;
	}
	public void setSpecsPersonCnt(int specsPersonCnt) {
		this.specsPersonCnt = specsPersonCnt;
	}
	public int getMedicalCnt() {
		return medicalCnt;
	}
	public void setMedicalCnt(int medicalCnt) {
		this.medicalCnt = medicalCnt;
	}
	public int getBreedCnt() {
		return breedCnt;
	}
	public void setBreedCnt(int breedCnt) {
		this.breedCnt = breedCnt;
	}
	public int getQuarabtineCnt() {
		return quarabtineCnt;
	}
	public void setQuarabtineCnt(int quarabtineCnt) {
		this.quarabtineCnt = quarabtineCnt;
	}
	public int getFeedCnt() {
		return feedCnt;
	}
	public void setFeedCnt(int feedCnt) {
		this.feedCnt = feedCnt;
	}
	public int getTransCarCnt() {
		return transCarCnt;
	}
	public void setTransCarCnt(int transCarCnt) {
		this.transCarCnt = transCarCnt;
	}
	public String getCareTel() {
		return careTel;
	}
	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}
	public String getDataStdDt() {
		return dataStdDt;
	}
	public void setDataStdDt(String dataStdDt) {
		this.dataStdDt = dataStdDt;
	}
	@Override
	public String toString() {
		return "ShelterInfo [careNm=" + careNm + ", orgNm=" + orgNm + ", divisionNm=" + divisionNm + ", saveTrgtAnimal="
				+ saveTrgtAnimal + ", careAddr=" + careAddr + ", jibunAddr=" + jibunAddr + ", lat=" + lat + ", lng="
				+ lng + ", dsignationDate=" + dsignationDate + ", weekOprStime=" + weekOprStime + ", weekOprEtime="
				+ weekOprEtime + ", weekCellStime=" + weekCellStime + ", weekCellEtime=" + weekCellEtime
				+ ", weekendOprStime=" + weekendOprStime + ", weekendOprEtime=" + weekendOprEtime
				+ ", weekendCellStime=" + weekendCellStime + ", weekendCellEtime=" + weekendCellEtime + ", closeDay="
				+ closeDay + ", vetPersonCnt=" + vetPersonCnt + ", specsPersonCnt=" + specsPersonCnt + ", medicalCnt="
				+ medicalCnt + ", breedCnt=" + breedCnt + ", quarabtineCnt=" + quarabtineCnt + ", feedCnt=" + feedCnt
				+ ", transCarCnt=" + transCarCnt + ", careTel=" + careTel + ", dataStdDt=" + dataStdDt + "]";
	}
    
    
}
