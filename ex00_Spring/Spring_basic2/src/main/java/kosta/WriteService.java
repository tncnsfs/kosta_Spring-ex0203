package kosta;

import javax.inject.Inject;

public class WriteService implements Service {
	@Inject
	private Dao dao;

	public WriteService() {
	}
	
	public WriteService(Dao dao) {
		super();
		this.dao = dao;
	}

	
	public Dao getDao() {
		return dao;
	}
	
/*	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}*/

	@Override
	public void insert() {
		System.out.println("WriteService insert()호출"); 
		dao.insertBoard();
	}

}
