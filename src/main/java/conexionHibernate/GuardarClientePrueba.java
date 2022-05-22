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
			Clientes cliente1 = new Clientes("Juan", "Dominguez", "siempreViva");
			miSession.beginTransaction();
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro incertado de forma exitosa en la BBDD");
			miSession.close();
		} finally {
			miFactory.close();
		}
	}

}
