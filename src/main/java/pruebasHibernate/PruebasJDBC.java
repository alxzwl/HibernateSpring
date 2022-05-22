package pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {
	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/pruebasHibernate?useSSL=false";
		String usuario = "root";
		String contra = "root";

		try {
			System.out.println("Intentando conectar con la BBDD: " + jdbcUrl);
			Connection conexion = DriverManager.getConnection(jdbcUrl, usuario, contra);
			System.out.println("Conexion Exitosa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}