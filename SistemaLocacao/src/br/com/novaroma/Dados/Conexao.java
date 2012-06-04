package br.com.novaroma.Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexao {

	private static String driver;
	private static String url;
	private static String usuario;
	private static String senha;
	private static ResourceBundle config;
	private static Connection connection;
	
	static {
		
		config = ResourceBundle.getBundle("br.com.novaroma.Dados.baseDados");
		driver = config.getString("driver");
		url = config.getString("url");
		usuario = config.getString("usuario");
		senha = config.getString("senha");
		
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e){
			System.out.println("Não foi possível encontrar o driver!");
		} catch (SQLException e){
			System.out.println("Verificar se o serviço esta ativo.");
		}
	}
	
	public static PreparedStatement getStatement(String sql) {
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(sql);			
		} catch (SQLException e){
			System.out.println("Não foi possível pegar uma conexão");
		}
		
		return ps;
	}
}