package conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			// Comienza la sesion
			miSession.beginTransaction();

			// Realiza la consulta a clientes
			List<Clientes> losClientes = miSession.createQuery("FROM Clientes").getResultList();

			// Mostrar los clientes
			for (Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}

			// Consulta a los Diaz
			losClientes = miSession.createQuery("FROM Clientes cl WHERE cl.apellidos='Diaz'").getResultList();
			for (Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}

			// Consulta a los que viven en Golla
			losClientes = miSession.createQuery("FROM Clientes cl WHERE cl.direccion='Golla'").getResultList();
			for (Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}

			// Realizar un commit a BBDD
			miSession.getTransaction().commit();

			// Cerrar la Sesion
			miSession.close();

		} finally {
			miFactory.close();
		}
	}

}
