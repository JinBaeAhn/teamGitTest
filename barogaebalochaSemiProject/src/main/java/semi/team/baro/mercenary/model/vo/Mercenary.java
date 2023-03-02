package semi.team.baro.mercenary.model.vo;

public class Mercenary {
	private int mercenaryNo; //게시글번호
	private int memberNo; //회원번호(작성자)
	private String location; //지역
	private String groundName; //구장이름
	private String gameDate; //게임날짜
	private String gameTime; //게임시간
	private String mercenaryContent; //게시글내용
	private int readCount; //조회수
	private String regDate; //작성일
	private int mercenaryWhether; //용병모집상태(0:모집중 / 1:모집완료)
	private int mercenaryPay; //참가비
	private int level; //실력
	public Mercenary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mercenary(int mercenaryNo, int memberNo, String location, String groundName, String gameDate,
			String gameTime, String mercenaryContent, int readCount, String regDate, int mercenaryWhether,
			int mercenaryPay, int level) {
		super();
		this.mercenaryNo = mercenaryNo;
		this.memberNo = memberNo;
		this.location = location;
		this.groundName = groundName;
		this.gameDate = gameDate;
		this.gameTime = gameTime;
		this.mercenaryContent = mercenaryContent;
		this.readCount = readCount;
		this.regDate = regDate;
		this.mercenaryWhether = mercenaryWhether;
		this.mercenaryPay = mercenaryPay;
		this.level = level;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getGameTime() {
		return gameTime;
	}
	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}
	public String getMercenaryContent() {
		return mercenaryContent;
	}
	public void setMercenaryContent(String mercenaryContent) {
		this.mercenaryContent = mercenaryContent;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getMercenaryWhether() {
		return mercenaryWhether;
	}
	public void setMercenaryWhether(int mercenaryWhether) {
		this.mercenaryWhether = mercenaryWhether;
	}
	public int getMercenaryPay() {
		return mercenaryPay;
	}
	public void setMercenaryPay(int mercenaryPay) {
		this.mercenaryPay = mercenaryPay;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
