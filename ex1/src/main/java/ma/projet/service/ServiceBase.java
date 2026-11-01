package ma.projet.service;
import ma.projet.dao.IDao; import ma.projet.util.HibernateUtil; import org.hibernate.Session; import org.hibernate.Transaction; import java.util.List;
abstract class ServiceBase<T> implements IDao<T> {
 private final Class<T> type; ServiceBase(Class<T> type){this.type=type;}
 public void create(T e){run(s->{s.persist(e);return null;});} public T findById(Long id){return run(s->s.get(type,id));}
 public List<T> findAll(){return run(s->s.createQuery("from "+type.getSimpleName(),type).list());}
 public void update(T e){run(s->{s.merge(e);return null;});} public void delete(T e){run(s->{s.remove(s.contains(e)?e:s.merge(e));return null;});}
 private <R> R run(java.util.function.Function<Session,R> action){Transaction tx=null;try(Session s=HibernateUtil.getSessionFactory().openSession()){tx=s.beginTransaction();R result=action.apply(s);tx.commit();return result;}catch(RuntimeException ex){if(tx!=null&&tx.isActive())tx.rollback();throw ex;}}
}
