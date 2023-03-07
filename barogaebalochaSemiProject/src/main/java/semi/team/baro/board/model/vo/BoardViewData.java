package semi.team.baro.board.model.vo;

import java.util.ArrayList;

public class BoardViewData {
	private Board board;
	private ArrayList<BoardComment> boardCommentList;
	private ArrayList<BoardComment> boardReCommentList;
	public BoardViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardViewData(Board board, ArrayList<BoardComment> boardCommentList,
			ArrayList<BoardComment> boardReCommentList) {
		super();
		this.board = board;
		this.boardCommentList = boardCommentList;
		this.boardReCommentList = boardReCommentList;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public ArrayList<BoardComment> getBoardCommentList() {
		return boardCommentList;
	}
	public void setBoardCommentList(ArrayList<BoardComment> boardCommentList) {
		this.boardCommentList = boardCommentList;
	}
	public ArrayList<BoardComment> getBoardReCommentList() {
		return boardReCommentList;
	}
	public void setBoardReCommentList(ArrayList<BoardComment> boardReCommentList) {
		this.boardReCommentList = boardReCommentList;
	}
	
}
