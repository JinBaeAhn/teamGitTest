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
	
	private int parking;
	private int shower;
	private int ball;
	private int uniform;
	private int shoes;
	private int water;
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(int groundNo, String groundName, int groundPrice, String groundLat, String groundLng,
			String groundContent, String filePath, String groundLocation, int parking, int shower, int ball,
			int uniform, int shoes, int water) {
		super();
		this.groundNo = groundNo;
		this.groundName = groundName;
		this.groundPrice = groundPrice;
		this.groundLat = groundLat;
		this.groundLng = groundLng;
		this.groundContent = groundContent;
		this.filePath = filePath;
		this.groundLocation = groundLocation;
		this.setParking(parking);
		this.setShower(shower);
		this.setBall(ball);
		this.setUniform(uniform);
		this.setShoes(shoes);
		this.setWater(water);
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

	public int getParking() {
		return parking;
	}

	public void setParking(int parking) {
		this.parking = parking;
	}

	public int getShower() {
		return shower;
	}

	public void setShower(int shower) {
		this.shower = shower;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getUniform() {
		return uniform;
	}

	public void setUniform(int uniform) {
		this.uniform = uniform;
	}

	public int getShoes() {
		return shoes;
	}

	public void setShoes(int shoes) {
		this.shoes = shoes;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	
	
}
