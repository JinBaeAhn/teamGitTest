package semi.team.baro.mercenary.model.service;

import semi.team.baro.mercenary.model.dao.MercenaryDao;
import semi.team.baro.mercenary.model.vo.Mercenary;

public class MercenaryService {
	private MercenaryDao dao;

	public MercenaryService() {
		super();
		dao = new MercenaryDao();
	}

	public int mercenaryInsert(Mercenary m) {
		
		return 0;
	}
	
}
