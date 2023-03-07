package semi.team.baro.member.model.vo;

import java.util.ArrayList;

public class AdminPageData {
	private ArrayList<Member> list;
	private String pageNavi;
	private int start;
	public ArrayList<Member> getList(){
		return list;
	}
	public void setList(ArrayList<Member> list) {
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
	public AdminPageData(ArrayList<Member> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public AdminPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
}
