package ma.projet.util;
import ma.projet.classes.*; import org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration;
public final class HibernateUtil {
 private static final SessionFactory FACTORY=new Configuration().configure().addAnnotatedClass(Categorie.class).addAnnotatedClass(Produit.class).addAnnotatedClass(Commande.class).addAnnotatedClass(LigneCommandeProduit.class).buildSessionFactory();
 private HibernateUtil(){} public static SessionFactory getSessionFactory(){return FACTORY;} public static void shutdown(){FACTORY.close();}
}
