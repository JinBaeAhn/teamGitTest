package semi.team.baro.matching.model.vo;

import java.util.ArrayList;

public class MatchingPageData {
	private ArrayList<Matching> list;
	private String pageNavi;
	private int start;
	
	public MatchingPageData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchingPageData(ArrayList<Matching> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}

	public ArrayList<Matching> getList() {
		return list;
	}

	public void setList(ArrayList<Matching> list) {
		this.list = list;
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
