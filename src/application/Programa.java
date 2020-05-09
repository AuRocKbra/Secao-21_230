package application;

import java.sql.Connection;

import db.DB;

public class Programa {

	public static void main(String[] args) {
		
		Connection conexao = DB.getConection();
		System.out.println("Conexão aberta em "+conexao.toString());
		DB.closeConection();
	}

}
