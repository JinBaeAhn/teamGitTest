package semi.team.baro.board.model.vo;

public class BoardComment {
	private int boardCommentNo;
	private int boardCommentReference;
	private int boardCommentWriter;
	private String boardCommentContent;
	private String boardCommentDate;
	private int boardCommentSelfReference;
	private String MemberId;
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public BoardComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardComment(int boardCommentNo, int boardCommentReference, int boardCommentWriter,
			String boardCommentContent, String boardCommentDate, int boardCommentSelfReference) {
		super();
		this.boardCommentNo = boardCommentNo;
		this.boardCommentReference = boardCommentReference;
		this.boardCommentWriter = boardCommentWriter;
		this.boardCommentContent = boardCommentContent;
		this.boardCommentDate = boardCommentDate;
		this.boardCommentSelfReference = boardCommentSelfReference;
	}

	public BoardComment(int boardCommentNo, int boardCommentReference, int boardCommentWriter,
			String boardCommentContent, int boardCommentSelfReference) {
		super();
		this.boardCommentNo = boardCommentNo;
		this.boardCommentReference = boardCommentReference;
		this.boardCommentWriter = boardCommentWriter;
		this.boardCommentContent = boardCommentContent;
		this.boardCommentSelfReference = boardCommentSelfReference;
	}
	public BoardComment(int boardCommentReference, int boardCommentWriter, String boardCommentContent,
			int boardCommentSelfReference) {
		super();
		this.boardCommentReference = boardCommentReference;
		this.boardCommentWriter = boardCommentWriter;
		this.boardCommentContent = boardCommentContent;
		this.boardCommentSelfReference = boardCommentSelfReference;
	}
	public BoardComment(int boardCommentNo, String boardCommentContent) {
		super();
		this.boardCommentNo = boardCommentNo;
		this.boardCommentContent = boardCommentContent;
	}
	
	public BoardComment(int boardCommentReference, int boardCommentWriter, String boardCommentContent) {
		super();
		this.boardCommentReference = boardCommentReference;
		this.boardCommentWriter = boardCommentWriter;
		this.boardCommentContent = boardCommentContent;
	}
	public int getBoardCommentNo() {
		return boardCommentNo;
	}
	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}
	public int getBoardCommentReference() {
		return boardCommentReference;
	}
	public void setBoardCommentReference(int boardCommentReference) {
		this.boardCommentReference = boardCommentReference;
	}
	public int getBoardCommentWriter() {
		return boardCommentWriter;
	}
	public void setBoardCommentWriter(int boardCommentWriter) {
		this.boardCommentWriter = boardCommentWriter;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public String getBoardCommentDate() {
		return boardCommentDate;
	}
	public void setBoardCommentDate(String boardCommentDate) {
		this.boardCommentDate = boardCommentDate;
	}
	public int getBoardCommentSelfReference() {
		return boardCommentSelfReference;
	}
	public void setBoardCommentSelfReference(int boardCommentSelfReference) {
		this.boardCommentSelfReference = boardCommentSelfReference;
	}
	
	
}
