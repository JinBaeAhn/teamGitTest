package semi.team.baro.history.model.vo;

import java.util.ArrayList;

import semi.team.baro.blacklist.model.vo.Blacklist;
import semi.team.baro.board.model.vo.Board;
import semi.team.baro.matching.model.vo.Matching;
import semi.team.baro.mercenary.model.vo.Mercenary;
import semi.team.baro.mercenary.model.vo.MercenaryRequest;

public class HistoryPageData {
	private ArrayList<Matching> mchList;
	private ArrayList<Mercenary> mcList;
	private ArrayList<MercenaryRequest> mcReqList;
	private ArrayList<Board> boardList;
	private ArrayList<Blacklist> blaList;
	private String pageNavi;
	private int start;
	public HistoryPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryPageData(ArrayList<Matching> mchList, ArrayList<Mercenary> mcList,
			ArrayList<MercenaryRequest> mcReqList, ArrayList<Board> boardList, ArrayList<Blacklist> blaList,
			String pageNavi, int start) {
		super();
		this.mchList = mchList;
		this.mcList = mcList;
		this.mcReqList = mcReqList;
		this.boardList = boardList;
		this.blaList = blaList;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<Matching> getMchList() {
		return mchList;
	}
	public void setMchList(ArrayList<Matching> mchList) {
		this.mchList = mchList;
	}
	public ArrayList<Mercenary> getMcList() {
		return mcList;
	}
	public void setMcList(ArrayList<Mercenary> mcList) {
		this.mcList = mcList;
	}
	public ArrayList<MercenaryRequest> getMcReqList() {
		return mcReqList;
	}
	public void setMcReqList(ArrayList<MercenaryRequest> mcReqList) {
		this.mcReqList = mcReqList;
	}
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}
	public ArrayList<Blacklist> getBlaList() {
		return blaList;
	}
	public void setBlaList(ArrayList<Blacklist> blaList) {
		this.blaList = blaList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
}
