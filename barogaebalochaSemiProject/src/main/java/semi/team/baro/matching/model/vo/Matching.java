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
	private int reservationNo;
	
	private int matchingNo;
	private int matchingRequestStatus;
	
	public Matching() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Matching(int matchingBoardNo, int memberNo, String matchingBoardTitle, String matchingBoardContent,
			String regDate, int readCount, int matchingStatus, int groundNo, int reservationNo, int matchingNo,
			int matchingRequestStatus) {
		super();
		this.matchingBoardNo = matchingBoardNo;
		this.memberNo = memberNo;
		this.matchingBoardTitle = matchingBoardTitle;
		this.matchingBoardContent = matchingBoardContent;
		this.regDate = regDate;
		this.readCount = readCount;
		this.matchingStatus = matchingStatus;
		this.groundNo = groundNo;
		this.reservationNo = reservationNo;
		this.matchingNo = matchingNo;
		this.matchingRequestStatus = matchingRequestStatus;
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
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
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
	
	
}
