package semi.team.baro.location.model.vo;

public class Location {
	private int groundNo;
	private String groundName;
	private int groundPrice;
	private String groundLat;
	private String groundLng;
	private String groundContent;
	private String filePath;
	private String groundLocation;

	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(int groundNo, String groundName, int groundPrice, String groundLat, String groundLng,
			String groundContent, String filePath, String groundLocation) {
		super();
		this.groundNo = groundNo;
		this.groundName = groundName;
		this.groundPrice = groundPrice;
		this.groundLat = groundLat;
		this.groundLng = groundLng;
		this.groundContent = groundContent;
		this.filePath = filePath;
		this.groundLocation = groundLocation;
	}

	public int getGroundNo() {
		return groundNo;
	}

	public void setGroundNo(int groundNo) {
		this.groundNo = groundNo;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public int getGroundPrice() {
		return groundPrice;
	}

	public void setGroundPrice(int groundPrice) {
		this.groundPrice = groundPrice;
	}

	public String getGroundLat() {
		return groundLat;
	}

	public void setGroundLat(String groundLat) {
		this.groundLat = groundLat;
	}

	public String getGroundLng() {
		return groundLng;
	}

	public void setGroundLng(String groundLng) {
		this.groundLng = groundLng;
	}

	public String getGroundContent() {
		return groundContent;
	}
	public String getGroundContentBr() {
		return groundContent.replaceAll("\r\n", "<br>");
	}

	public void setGroundContent(String groundContent) {
		this.groundContent = groundContent;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getGroundLocation() {
		return groundLocation;
	}

	public void setGroundLocation(String groundLocation) {
		this.groundLocation = groundLocation;
	}

	
	
}
