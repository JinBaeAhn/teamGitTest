package semi.team.baro.member.model.vo;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberMail;
	private String memberPhone;
	private String memberAddr;
	private int memberLevel;
	private String enrollDate;
	private String memberContent;
	private String filepath;
	private int memberCredit;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int memberNo, String memberId, String memberPw, String memberName, String memberMail,
			String memberPhone, String memberAddr, int memberLevel, String enrollDate, String memberContent,
			String filepath, int memberCredit) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberMail = memberMail;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberLevel = memberLevel;
		this.enrollDate = enrollDate;
		this.memberContent = memberContent;
		this.filepath = filepath;
		this.memberCredit = memberCredit;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberMail() {
		return memberMail;
	}

	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberContent() {
		return memberContent;
	}

	public void setMemberContent(String memberContent) {
		this.memberContent = memberContent;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getMemberCredit() {
		return memberCredit;
	}

	public void setMemberCredit(int memberCredit) {
		this.memberCredit = memberCredit;
	}
	
}
