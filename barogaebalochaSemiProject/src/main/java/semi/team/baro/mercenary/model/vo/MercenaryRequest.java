package semi.team.baro.mercenary.model.vo;

public class MercenaryRequest {
	private int mercenaryRequestNo;
	private int mercenaryNo;
	private int memberNo;
	private String memberId;
	private String mercenaryRequestContent;
	private int level;
	private String mercenaryRequestDate;
	private String mercenaryRequestResult;
	public MercenaryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MercenaryRequest(int mercenaryRequestNo, int mercenaryNo, int memberNo, String memberId,
			String mercenaryRequestContent, int level, String mercenaryRequestDate, String mercenaryRequestResult) {
		super();
		this.mercenaryRequestNo = mercenaryRequestNo;
		this.mercenaryNo = mercenaryNo;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.mercenaryRequestContent = mercenaryRequestContent;
		this.level = level;
		this.mercenaryRequestDate = mercenaryRequestDate;
		this.mercenaryRequestResult = mercenaryRequestResult;
	}
	public int getMercenaryRequestNo() {
		return mercenaryRequestNo;
	}
	public void setMercenaryRequestNo(int mercenaryRequestNo) {
		this.mercenaryRequestNo = mercenaryRequestNo;
	}
	public int getMercenaryNo() {
		return mercenaryNo;
	}
	public void setMercenaryNo(int mercenaryNo) {
		this.mercenaryNo = mercenaryNo;
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
	public String getMercenaryRequestContent() {
		return mercenaryRequestContent;
	}
	public String getMercenaryRequestContentBr() {
		return mercenaryRequestContent.replaceAll("\r\n", "<br>");
	}
	public void setMercenaryRequestContent(String mercenaryRequestContent) {
		this.mercenaryRequestContent = mercenaryRequestContent;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMercenaryRequestDate() {
		return mercenaryRequestDate;
	}
	public void setMercenaryRequestDate(String mercenaryRequestDate) {
		this.mercenaryRequestDate = mercenaryRequestDate;
	}
	public String getMercenaryRequestResult() {
		return mercenaryRequestResult;
	}
	public void setMercenaryRequestResult(String mercenaryRequestResult) {
		this.mercenaryRequestResult = mercenaryRequestResult;
	}
	
	
}
