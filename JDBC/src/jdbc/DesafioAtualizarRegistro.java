package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioAtualizarRegistro {
	
	public static void main(String[] args) throws SQLException{
		Scanner entrada = new Scanner(System.in);
		
		
		System.out.println("Informe o ID: ");
		int codigo = entrada.nextInt();
		
		String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "Update pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, codigo);
		ResultSet resultado = stmt.executeQuery();
		
		if(resultado.next()) {
			Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));
			System.out.println("O nome atual é " + p.getNome());
			entrada.nextLine();
		
		System.out.println("Informe Um Novo Nome Para o Registro: ");
		String nome = entrada.nextLine();
	
		stmt.close();
		
		stmt = conexao.prepareStatement(updateSQL);
		stmt.setString(1, nome);
		stmt.setInt(2, codigo);
		stmt.execute();
		
		System.out.println("Pessoa Alterada Com Sucesso");
	} else {
		System.out.println("Pessoa Não Encontrada");	 
	}
		conexao.close();
		entrada.close();
	}


}
