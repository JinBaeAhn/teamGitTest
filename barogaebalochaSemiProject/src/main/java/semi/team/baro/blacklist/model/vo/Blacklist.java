package semi.team.baro.blacklist.model.vo;

public class Blacklist {
	private int blackNo;
	private int memberNo;
	private String memberId;
	private String blackMember;
	private String blackTitle;
	private String blackContent;
	private String regDate;
	private String blackFilepath;
	private int blackStatus;
	private int memberLevel;
	public Blacklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blacklist(int blackNo, int memberNo, String memberId, String blackMember, String blackTitle,
			String blackContent, String regDate, String blackFilepath, int blackStatus, int memberLevel) {
		super();
		this.blackNo = blackNo;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.blackMember = blackMember;
		this.blackTitle = blackTitle;
		this.blackContent = blackContent;
		this.regDate = regDate;
		this.blackFilepath = blackFilepath;
		this.blackStatus = blackStatus;
		this.memberLevel = memberLevel;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int getMemberLevel) {
		this.memberLevel = memberLevel;
	}
	public int getBlackNo() {
		return blackNo;
	}
	public void setBlackNo(int blackNo) {
		this.blackNo = blackNo;
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
	public String getBlackMember() {
		return blackMember;
	}
	public void setBlackMember(String blackMember) {
		this.blackMember = blackMember;
	}
	public String getBlackTitle() {
		return blackTitle;
	}
	public void setBlackTitle(String blackTitle) {
		this.blackTitle = blackTitle;
	}
	public String getBlackContent() {
		return blackContent;
	}
	public String getBlackContentBr() {
		return blackContent.replaceAll("\r\n", "<br>");
	}
	public void setBlackContent(String blackContent) {
		this.blackContent = blackContent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getBlackFilepath() {
		return blackFilepath;
	}
	public void setBlackFilepath(String blackFilepath) {
		this.blackFilepath = blackFilepath;
	}
	public int getBlackStatus() {
		return blackStatus;
	}
	public void setBlackStatus(int blackStatus) {
		this.blackStatus = blackStatus;
	}
}
