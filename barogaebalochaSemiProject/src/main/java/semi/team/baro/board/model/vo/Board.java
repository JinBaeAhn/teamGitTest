package semi.team.baro.board.model.vo;

public class Board {
	private int photoNo;
	private int memberNo;
	private String photoTitle;
	private String photoContent;
	private int readCount;
	private String regDate;

	private String filename;
	private String filepath;
	
	private String memberId;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int photoNo, int memberNo, String photoTitle, String photoContent, int readCount, String filename,
			String filepath) {
		super();
		this.photoNo = photoNo;
		this.memberNo = memberNo;
		this.photoTitle = photoTitle;
		this.photoContent = photoContent;
		this.readCount = readCount;
		this.filename = filename;
		this.filepath = filepath;
	}
	public Board(int photoNo, String photoTitle, String photoContent, int readCount, String regDate, String memberId) {
		super();
		this.photoNo = photoNo;
		this.photoTitle = photoTitle;
		this.photoContent = photoContent;
		this.readCount = readCount;
		this.regDate = regDate;
		this.memberId = memberId;
	}
	public Board(int photoNo, String photoTitle, String photoContent, String filename, String filepath) {
		super();
		this.photoNo = photoNo;
		this.photoTitle = photoTitle;
		this.photoContent = photoContent;
		this.filename = filename;
		this.filepath = filepath;
	}
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getPhotoTitle() {
		return photoTitle;
	}
	public void setPhotoTitle(String photoTitle) {
		this.photoTitle = photoTitle;
	}
	public String getPhotoContent() {
		return photoContent;
	}
	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}