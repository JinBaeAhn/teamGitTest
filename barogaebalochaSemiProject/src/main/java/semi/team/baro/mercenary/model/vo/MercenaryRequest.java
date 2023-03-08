package semi.team.baro.mercenary.model.vo;

public class MercenaryRequest {
	//용병모집글번호, 지역, 구장이름, 경기시간, 모집상태, 신청결과, 신청내용, 작성일
	private int mercenaryRequestNo;
	private int mercenaryNo;
	private int memberNo;
	private String memberId;
	private String mercenaryRequestContent;
	private int level;
	private String mercenaryRequestDate;
	private String mercenaryRequestResult;
	private String gameLocation;
	private String groundName;
	private String gameDate;
	private int gameTime;
	private int mercenaryWhether;
	private String memberFilepath;
	
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
	public String getGameLocation() {
		return gameLocation;
	}
	public void setGameLocation(String gameLocation) {
		this.gameLocation = gameLocation;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public int getGameTime() {
		return gameTime;
	}
	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}
	public String getGameShowTime() {
		return gameTime+" : 00 ~ "+(gameTime+2)+" : 00";
	}
	public int getMercenaryWhether() {
		return mercenaryWhether;
	}
	public void setMercenaryWhether(int mercenaryWhether) {
		this.mercenaryWhether = mercenaryWhether;
	}
	public String getMemberFilepath() {
		return memberFilepath;
	}
	public void setMemberFilepath(String memberFilepath) {
		this.memberFilepath = memberFilepath;
	}
	
}
