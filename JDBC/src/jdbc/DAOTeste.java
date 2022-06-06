package jdbc;

public class DAOTeste {
	
	public static void main(String[] args) {
			
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALEUS (?)";
		dao.incluir(sql, "João da Silva");
		dao.incluir(sql, "Ana Julia");
		dao.incluir(sql, "Djalma Pereira");
		
	
	
	}
}
