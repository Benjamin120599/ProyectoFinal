package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Conexion.ConexionBD;

public class ConexionBD {

	private static ConexionBD miConexion;
	private Connection conexion;
	private Statement stm;
	private PreparedStatement preparedStatement; 
	ResultSet rs = null;
	
	
	public static ConexionBD getConexionBD() {
		if(miConexion == null) {
			miConexion = new ConexionBD();
		}
		return miConexion;
	}
	
	private ConexionBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost/BD_HUESPED?serverTimezone=UTC";
			conexion = DriverManager.getConnection(url, "root", "password");
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontró el controlador.");
		} catch (SQLException e) {
			System.out.println("No se pudo conectar al servidor.");
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public void cerrarConexion() {
		try {
			stm.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean ejecutarInstruccion(String sql) {
		try {
			//stm = conexion.prepareStatement(sql);
			preparedStatement = conexion.prepareStatement(sql);
			int ejecucion;
			ejecucion = preparedStatement.executeUpdate(sql);
			return ejecucion == 1?true:false;
		} catch (SQLException e) {
			System.out.println("No se pudo ejecutar la instrucción SQL");
			return false;
		}
	}
	
	// Otro método para SQL (CONSULTAS)
	public ResultSet ejecutarConsultaRegistros(String sql) {
		
		try {
			stm = conexion.createStatement();
			//preparedStatement = conexion.prepareStatement(sql);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("No se pudo ejecutar la consulta SQL");
		}
		return rs;
	}
	
	public static void main(String[] args) {
		new ConexionBD();
	}
	
	
}
