package semi.team.baro.location.model.vo;

import java.util.ArrayList;

public class LocationPageData {
	private ArrayList<Location> list;
	private String pageNavi;
	private int start;
	
	public LocationPageData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationPageData(ArrayList<Location> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}

	public ArrayList<Location> getList() {
		return list;
	}

	public void setList(ArrayList<Location> list) {
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
