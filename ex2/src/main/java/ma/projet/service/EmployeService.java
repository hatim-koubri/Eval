package ma.projet.service;
import ma.projet.classes.*; import ma.projet.util.HibernateUtil; import java.util.*; import java.time.LocalDate;
public class EmployeService extends AbstractService<Employe>{public EmployeService(){super(Employe.class);} protected int id(Employe e){return e.getId();}
 public List<EmployeTache> tachesRealisees(int id){try(var s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("select et from EmployeTache et join fetch et.tache where et.employe.id=:id",EmployeTache.class).setParameter("id",id).list();}}
 public List<Projet> projetsGeres(int id){try(var s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("from Projet p where p.chefProjet.id=:id",Projet.class).setParameter("id",id).list();}}
}
