package semi.team.baro.member.model.service;

import semi.team.baro.member.model.dao.MemberDao;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}
	

}
