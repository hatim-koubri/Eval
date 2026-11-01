package ma.projet.util;
import org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration;
public final class HibernateUtil {
 private static final SessionFactory FACTORY=new Configuration().configure().buildSessionFactory();
 private HibernateUtil(){} public static SessionFactory getSessionFactory(){return FACTORY;} public static void shutdown(){FACTORY.close();}
}
