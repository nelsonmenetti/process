import com.br.jty.process.entity.dao.DAO;


public class main {

	
	public static void main (String args[]){
		DAO<com.br.jty.process.entity.execution.Process> processDao = new DAO<com.br.jty.process.entity.execution.Process>();
		processDao.save(new com.br.jty.process.entity.execution.Process());
		
	}
}
