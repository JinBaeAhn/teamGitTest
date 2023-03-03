package semi.team.baro.notice.model.vo;

public class Notice {
	private int noticeNo;
	private int memberNo;
	private String noticeCategory;
	private String noticeTitle;
	private String noticeContent;
	private int readCount;
	private String regDate;
	
	private String memberId;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int noticeNo, String noticeCategory, String noticeTitle, String noticeContent,int readCount,
			String regDate, String memberId) {
		super();
		this.noticeNo = noticeNo;
		this.noticeCategory = noticeCategory;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.readCount = readCount;
		this.regDate = regDate;
		this.memberId = memberId;
	}
	public Notice(int noticeNo, int memberNo, String noticeCategory, String noticeTitle, String noticeContent,
			int readCount, String regDate) {
		super();
		this.noticeNo = noticeNo;
		this.memberNo = memberNo;
		this.noticeCategory = noticeCategory;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.readCount = readCount;
		this.regDate = regDate;
	}
	public Notice(int memberNo, String noticeCategory, String noticeTitle, String noticeContent) {
		super();
		this.memberNo = memberNo;
		this.noticeCategory = noticeCategory;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}