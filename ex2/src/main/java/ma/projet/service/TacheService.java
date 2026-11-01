package ma.projet.service;
import ma.projet.classes.*; import ma.projet.util.HibernateUtil; import java.util.*; import java.time.LocalDate;
public class TacheService extends AbstractService<Tache>{public TacheService(){super(Tache.class);} protected int id(Tache t){return t.getId();}
 public List<Tache> prixSuperieurA1000(){try(var s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("from Tache t where t.prix > 1000",Tache.class).list();}}
 public List<Tache> entreDates(LocalDate debut,LocalDate fin){try(var s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("from Tache t where t.dateDebut >= :d and t.dateFin <= :f",Tache.class).setParameter("d",debut).setParameter("f",fin).list();}}
}
