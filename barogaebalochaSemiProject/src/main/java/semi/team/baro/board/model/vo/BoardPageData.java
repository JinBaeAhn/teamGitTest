package semi.team.baro.board.model.vo;

import java.util.ArrayList;

public class BoardPageData {
	private ArrayList<Board> boardList;
	private String pageNavigation;
	private int numberOfPage;
	private int start;
	public BoardPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardPageData(ArrayList<Board> boardList, String pageNavigation, int numberOfPage, int start) {
		super();
		this.boardList = boardList;
		this.pageNavigation = pageNavigation;
		this.numberOfPage = numberOfPage;
		this.start = start;
	}
	public BoardPageData(ArrayList<Board> boardList, String pageNavigation, int start) {
		super();
		this.boardList = boardList;
		this.pageNavigation = pageNavigation;
		this.start = start;
	}
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}
	public String getPageNavigation() {
		return pageNavigation;
	}
	public void setPageNavigation(String pageNavigation) {
		this.pageNavigation = pageNavigation;
	}
	public int getNumberOfPage() {
		return numberOfPage;
	}
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
}
