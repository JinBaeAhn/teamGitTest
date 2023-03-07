package semi.team.baro.member.model.vo;

public class AdminComment {
	private int acNo;
	private String acWriter;
	private String acContent;
	private String acDate;
	private int adminRef;
	private int acRef;
	public AdminComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminComment(int acNo, String acWriter, String acContent, String acDate, int adminRef, int acRef) {
		super();
		this.acNo = acNo;
		this.acWriter = acWriter;
		this.acContent = acContent;
		this.acDate = acDate;
		this.adminRef = adminRef;
		this.acRef = acRef;
	}
	public int getAcNo() {
		return acNo;
	}
	public void setAcNo(int acNo) {
		this.acNo = acNo;
	}
	public String getAcWriter() {
		return acWriter;
	}
	public void setAcWriter(String acWriter) {
		this.acWriter = acWriter;
	}
	public String getAcContent() {
		return acContent;
	}
	public void setAcContent(String acContent) {
		this.acContent = acContent;
	}
	public String getAcDate() {
		return acDate;
	}
	public void setAcDate(String acDate) {
		this.acDate = acDate;
	}
	public int getAdminRef() {
		return adminRef;
	}
	public void setAdminRef(int adminRef) {
		this.adminRef = adminRef;
	}
	public int getAcRef() {
		return acRef;
	}
	public void setAcRef(int acRef) {
		this.acRef = acRef;
	}
}
