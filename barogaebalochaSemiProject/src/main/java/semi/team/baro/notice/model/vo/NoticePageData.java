package semi.team.baro.notice.model.vo;

import java.util.ArrayList;

public class NoticePageData {
	private ArrayList<Notice> noticeList;
	private String pageNavigation;
	private int numberOfPage;
	private int start;
	public NoticePageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticePageData(ArrayList<Notice> noticeList, String pageNavigation, int numberOfPage, int start) {
		super();
		this.noticeList = noticeList;
		this.pageNavigation = pageNavigation;
		this.numberOfPage = numberOfPage;
		this.start = start;
	}
	public NoticePageData(ArrayList<Notice> noticeList, String pageNavigation, int start) {
		super();
		this.noticeList = noticeList;
		this.pageNavigation = pageNavigation;
		this.start = start;
	}
	public ArrayList<Notice> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(ArrayList<Notice> noticeList) {
		this.noticeList = noticeList;
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
