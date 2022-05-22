package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardarClientePrueba {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			Clientes cliente1 = new Clientes("Sandra", "Delgado", "Golla");
			miSession.beginTransaction();
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro incertado de forma exitosa en la BBDD");
			miSession.beginTransaction();

			System.out.println("Lectura del registro con Id: " + cliente1.getId());

			Clientes clienteInsertado = miSession.get(Clientes.class, cliente1.getId());
			System.out.println("Registro: " + clienteInsertado);
			miSession.getTransaction().commit();
			System.out.println("Terminado!");

			System.out.println("Id: " + cliente1.getId());
			System.out.println("Nombre: " + cliente1.getNombre());
			System.out.println("Apellidos: " + cliente1.getApellidos());
			System.out.println("Direccion: " + cliente1.getDireccion());

			miSession.close();
		} finally {
			miFactory.close();
		}
	}

}
