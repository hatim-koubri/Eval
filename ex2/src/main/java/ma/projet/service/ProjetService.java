package ma.projet.service;
import ma.projet.classes.*; import ma.projet.util.HibernateUtil; import java.util.*; import java.time.LocalDate;
public class ProjetService extends AbstractService<Projet>{public ProjetService(){super(Projet.class);} protected int id(Projet p){return p.getId();}
 public List<Tache> tachesPlanifiees(int id){try(var s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("from Tache t where t.projet.id=:id",Tache.class).setParameter("id",id).list();}}
 public List<EmployeTache> tachesReelles(int id){try(var s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("select et from EmployeTache et join fetch et.tache where et.tache.projet.id=:id",EmployeTache.class).setParameter("id",id).list();}}
}
