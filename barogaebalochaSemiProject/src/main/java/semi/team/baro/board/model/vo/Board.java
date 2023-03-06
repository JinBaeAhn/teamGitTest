package semi.team.baro.board.model.vo;

public class Board {
	private int photoNo;
	private int memberNo;
	private String photoTitle;
	private String photoContent;
	private int readCount;
	private String filename;
	private String filepath;
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
	public Board(int memberNo, String photoTitle, String photoContent, int readCount) {
		super();
		this.memberNo = memberNo;
		this.photoTitle = photoTitle;
		this.photoContent = photoContent;
		this.readCount = readCount;
	}
	protected int getPhotoNo() {
		return photoNo;
	}
	protected void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	protected int getMemberNo() {
		return memberNo;
	}
	protected void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	protected String getPhotoTitle() {
		return photoTitle;
	}
	protected void setPhotoTitle(String photoTitle) {
		this.photoTitle = photoTitle;
	}
	protected String getPhotoContent() {
		return photoContent;
	}
	protected void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}
	protected int getReadCount() {
		return readCount;
	}
	protected void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	protected String getFilename() {
		return filename;
	}
	protected void setFilename(String filename) {
		this.filename = filename;
	}
	protected String getFilepath() {
		return filepath;
	}
	protected void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}