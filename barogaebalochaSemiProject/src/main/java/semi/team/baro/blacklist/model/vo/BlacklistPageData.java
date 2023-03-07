package semi.team.baro.blacklist.model.vo;

import java.util.ArrayList;

public class BlacklistPageData {
	private ArrayList<Blacklist> list;
	private String pageNavi;
	private int start;
	public ArrayList<Blacklist> getList() {
		return list;
	}
	public void setList(ArrayList<Blacklist> list) {
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
	public BlacklistPageData(ArrayList<Blacklist> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public BlacklistPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
}
