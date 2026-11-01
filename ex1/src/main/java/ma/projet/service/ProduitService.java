package ma.projet.service;
import ma.projet.classes.*; import org.hibernate.Session; import ma.projet.util.HibernateUtil; import java.util.*;
public class ProduitService extends ServiceBase<Produit> {
 public ProduitService(){super(Produit.class);}
 public List<Produit> parCategorie(Long id){try(Session s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("from Produit p where p.categorie.id=:id order by p.reference",Produit.class).setParameter("id",id).list();}}
 public List<Object[]> lignesParCommande(Long id){try(Session s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("select l.produit.reference,l.produit.prix,l.quantite from LigneCommandeProduit l where l.commande.id=:id order by l.id",Object[].class).setParameter("id",id).list();}}
 public List<Produit> commandesEntre(java.time.LocalDate debut,java.time.LocalDate fin){try(Session s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("select distinct l.produit from LigneCommandeProduit l where l.commande.date between :d and :f",Produit.class).setParameter("d",debut).setParameter("f",fin).list();}}
 public List<Produit> parCommande(Long id){try(Session s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("select l.produit from LigneCommandeProduit l where l.commande.id=:id",Produit.class).setParameter("id",id).list();}}
 public List<Produit> prixSuperieurA(float prix){try(Session s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("from Produit p where p.prix>:prix order by p.prix desc",Produit.class).setParameter("prix",prix).list();}}
}
