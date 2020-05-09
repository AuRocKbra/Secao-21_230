package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection conecxao=null;
	
	public static Connection getConection() {
		if(conecxao==null) {
			try {
				Properties propriedades = loadProperties();
				String url = propriedades.getProperty("dburl");
				conecxao=DriverManager.getConnection(url,propriedades);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return 	conecxao;
	}
	
	public static Properties loadProperties() {
		try(FileInputStream arquivo = new FileInputStream("db.properties")){
			Properties propriedades = new Properties();
			propriedades.load(arquivo);
			return propriedades;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeConection() {
		if(conecxao!=null) {
			try {
				conecxao.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
