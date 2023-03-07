package semi.team.baro.matching.model.vo;

public class Matching {
	private int matchingBoardNo;
	private int memberNo;
	private String matchingBoardTitle;
	private String matchingBoardContent;
	private String regDate;
	private int readCount;
	private int matchingStatus;
	private int groundNo;
	private String groundLocation;
	private int reservationNo;
	private String groundName;
	private int groundPrice;
	
	private int matchingNo;
	private int matchingRequestStatus;
	
	private int reservationTime;
	private String reservationDate;
	private int reservationStatus;
	
	public Matching() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matching(int matchingBoardNo, int memberNo, String matchingBoardTitle, String matchingBoardContent,
			String regDate, int readCount, int matchingStatus, int groundNo, String groundLocation, int reservationNo,
			String groundName, int groundPrice, int matchingNo, int matchingRequestStatus, int reservationTime,
			String reservationDate, int reservationStatus) {
		super();
		this.matchingBoardNo = matchingBoardNo;
		this.memberNo = memberNo;
		this.matchingBoardTitle = matchingBoardTitle;
		this.matchingBoardContent = matchingBoardContent;
		this.regDate = regDate;
		this.readCount = readCount;
		this.matchingStatus = matchingStatus;
		this.groundNo = groundNo;
		this.groundLocation = groundLocation;
		this.reservationNo = reservationNo;
		this.groundName = groundName;
		this.groundPrice = groundPrice;
		this.matchingNo = matchingNo;
		this.matchingRequestStatus = matchingRequestStatus;
		this.reservationTime = reservationTime;
		this.reservationDate = reservationDate;
		this.reservationStatus = reservationStatus;
	}

	public int getMatchingBoardNo() {
		return matchingBoardNo;
	}

	public void setMatchingBoardNo(int matchingBoardNo) {
		this.matchingBoardNo = matchingBoardNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMatchingBoardTitle() {
		return matchingBoardTitle;
	}

	public void setMatchingBoardTitle(String matchingBoardTitle) {
		this.matchingBoardTitle = matchingBoardTitle;
	}

	public String getMatchingBoardContent() {
		return matchingBoardContent;
	}

	public void setMatchingBoardContent(String matchingBoardContent) {
		this.matchingBoardContent = matchingBoardContent;
	}
	
	public String getMatchingBoardContentBr() {
		return matchingBoardContent.replaceAll("\r\n", "<br>");
	}
	

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getMatchingStatus() {
		return matchingStatus;
	}

	public void setMatchingStatus(int matchingStatus) {
		this.matchingStatus = matchingStatus;
	}

	public int getGroundNo() {
		return groundNo;
	}

	public void setGroundNo(int groundNo) {
		this.groundNo = groundNo;
	}

	public String getGroundLocation() {
		return groundLocation;
	}

	public void setGroundLocation(String groundLocation) {
		this.groundLocation = groundLocation;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public int getGroundPrice() {
		return groundPrice;
	}

	public void setGroundPrice(int groundPrice) {
		this.groundPrice = groundPrice;
	}

	public int getMatchingNo() {
		return matchingNo;
	}

	public void setMatchingNo(int matchingNo) {
		this.matchingNo = matchingNo;
	}

	public int getMatchingRequestStatus() {
		return matchingRequestStatus;
	}

	public void setMatchingRequestStatus(int matchingRequestStatus) {
		this.matchingRequestStatus = matchingRequestStatus;
	}

	public int getReservationTime() {
		return reservationTime;
	}
	public String getReservationShowTime() {
		return reservationTime+" : 00 ~ "+(reservationTime+2)+" : 00";
	}
	public void setReservationTime(int reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

}