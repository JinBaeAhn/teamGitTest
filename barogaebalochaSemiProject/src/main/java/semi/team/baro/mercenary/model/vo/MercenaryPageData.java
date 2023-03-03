package semi.team.baro.mercenary.model.vo;

import java.util.ArrayList;

public class MercenaryPageData {
	private ArrayList<Mercenary> list;
	private String pageNavi;
	private int start;
	public MercenaryPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MercenaryPageData(ArrayList<Mercenary> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<Mercenary> getList() {
		return list;
	}
	public void setList(ArrayList<Mercenary> list) {
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
