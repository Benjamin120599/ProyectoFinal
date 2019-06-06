package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.ConexionBD;
import Modelo.Huesped;
import Modelo.Usuario;

public class HuespedDAO {
	
	ConexionBD conexion = new ConexionBD();
	
	// métodos que permiten realizar las ALtas, Bajas, Cambios y Consultas	
	public boolean agregarHuesped(Huesped obj) {
		String sql3 = "INSERT INTO Huesped VALUES('"+obj.getIdHuesped()+"', '"+obj.getNombre()+"', '"+obj.getApellidoP()+"', '"+obj.getApellidoM()+"', '"+obj.getFechaNac()+"', '"+obj.getTelefono()+"')";
		return conexion.ejecutarInstruccion(sql3);
	}
		
	public boolean eliminarHuesped(String id) {
		String sql = "DELETE FROM Huesped WHERE ID_Huesped = '"+id+"';";
		return conexion.ejecutarInstruccion(sql);
	}
		
	public boolean modificarHuesped(Huesped a1) {
		String sql = "UPDATE Huesped SET ID_Huesped='"+a1.getIdHuesped()+"', Nombre='"+a1.getNombre()+"', ApellidoP='"+a1.getApellidoP()+"', ApellidoM='"+a1.getApellidoM()+"', FechaNac="+a1.getFechaNac()+", Telefono="+a1.getTelefono()+"' WHERE ID_Huesped='"+a1.getIdHuesped()+"'";
		return conexion.ejecutarInstruccion(sql);
	}
		
	// ==================================== BUSCAR UN REGISTRO ====================================
	public Huesped buscarHuesped(String dato, String campo) {
		Huesped huesped = new Huesped();
		String sql = "SELECT * FROM Huesped WHERE "+campo+" = '"+dato+"';";
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		try {
			rs.last();
			huesped.setIdHuesped(rs.getString(1));
			huesped.setNombre(rs.getString(2));
			huesped.setApellidoP(rs.getString(3));
			huesped.setApellidoM(rs.getString(4));
			huesped.setFechaNac(rs.getString(5));
			huesped.setTelefono(rs.getString(6));
		} catch (SQLException e) {
			return null;
		}
		return huesped;
	}
	
	// ==================================== BUSCAR MULTIPLES REGISTRO ====================================
	
	public ArrayList<Huesped> buscarHuespedes(String filtro, String campo) {
		ArrayList<Huesped> listaHuespedes = new ArrayList<Huesped>();
		
		String sql = "SELECT * FROM Huesped WHERE "+campo+" ='"+filtro+"';";
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		try {
			rs.first();
			while(!rs.isAfterLast()) {
				Huesped huesped = new Huesped();
				huesped.setIdHuesped(rs.getString(1));
				huesped.setNombre(rs.getString(2));
				huesped.setApellidoP(rs.getString(3));
				huesped.setApellidoM(rs.getString(4));
				huesped.setFechaNac(rs.getString(5));
				huesped.setTelefono(rs.getString(6));			
				rs.next();
				listaHuespedes.add(huesped);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaHuespedes; 
	}	

	// ==================================================================================================
	
	public Usuario buscarUsuario(String user) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM Usuario WHERE Usuario = '"+user+"';";
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		try {
			rs.last();
			usuario.setUsuario(rs.getString(1));
			usuario.setPassword(rs.getString(2));
		} catch (SQLException e) {
			return null;
		}
		return usuario;
	}

}
