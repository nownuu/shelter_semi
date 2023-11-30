package shelter.beans.member;

import java.sql.Timestamp;

/*
CREATE TABLE `member` (
    `member_id` varchar(128) primary key,
    `member_pw` varchar(128) not null,
    `member_name` varchar(64) not null,
    `member_nickname` varchar(64) not null,
    `member_phone` char(11) not null,
    `member_email` varchar(128) not null,
    `member_gender` varchar(2) not NULL CHECK (`member_gender` IN ('남', '녀')),
    `member_address` varchar(256) not null,
    `member_join` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `member_grade` varchar(16) DEFAULT '일반회원' CHECK (`member_grade` IN ('일반회원', '보호소', '관리자'))
);
 * */
public class MemberDto {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberNickname;
    private String memberPhone;
    private String memberEmail;
    private String memberGender;
    private String memberAddress;
    private Timestamp memberJoin; // 회원 가입일 - 자동 등록
    private String memberGrade;

    
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberNickname=" + memberNickname + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", memberGender=" + memberGender + ", memberAddress=" + memberAddress + ", memberJoin=" + memberJoin
				+ ", memberGrade=" + memberGrade + "]";
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNickname() {
		return memberNickname;
	}


	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}


	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public Timestamp getMemberJoin() {
		return memberJoin;
	}
	public void setMemberJoin(Timestamp memberJoin) {
		this.memberJoin = memberJoin;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
}
