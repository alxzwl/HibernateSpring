package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			// Consulta de actualizacion por Id
			/*
			 * int clienteId = 2; miSession.beginTransaction();
			 * 
			 * Clientes miCliente = miSession.get(Clientes.class, clienteId);
			 * miCliente.setNombre("Tommi");
			 * 
			 * miSession.getTransaction().commit();
			 * System.out.println("Registro actualizado de forma exitosa en la BBDD");
			 */

			// Consulta de actualizacion con el operador like
			/*
			 * miSession.beginTransaction(); miSession.
			 * createQuery("update Clientes set apellidos='Ramirez' where apellidos like 'D%'"
			 * ).executeUpdate();
			 */

			// Consulta de eliminacion con el operador like
			miSession.beginTransaction();
			miSession.createQuery("delete Clientes where direccion='Golla'").executeUpdate();

			miSession.getTransaction().commit();
			System.out.println("Registro eliminado de forma exitosa en la BBDD");

			miSession.close();
		} finally {
			miFactory.close();
		}
	}

}
