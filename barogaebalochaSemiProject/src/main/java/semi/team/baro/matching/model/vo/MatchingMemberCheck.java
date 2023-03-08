package semi.team.baro.matching.model.vo;

public class MatchingMemberCheck {
	private Matching mc;
	private int memberCheck;
	
	public MatchingMemberCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatchingMemberCheck(Matching mc, int memberCheck) {
		super();
		this.mc = mc;
		this.memberCheck = memberCheck;
	}
	public Matching getMc() {
		return mc;
	}
	public void setMc(Matching mc) {
		this.mc = mc;
	}
	public int getMemberCheck() {
		return memberCheck;
	}
	public void setMemberCheck(int memberCheck) {
		this.memberCheck = memberCheck;
	}
	
	
}
