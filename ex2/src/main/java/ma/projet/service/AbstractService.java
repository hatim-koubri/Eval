package ma.projet.service;
import ma.projet.dao.IDao; import ma.projet.util.HibernateUtil; import org.hibernate.Session; import org.hibernate.Transaction; import java.util.List;
public abstract class AbstractService<T> implements IDao<T> {
 private final Class<T> type; protected AbstractService(Class<T> type){this.type=type;}
 protected abstract int id(T x);
 public void create(T x){run(s->s.persist(x));} public T findById(int id){try(Session s=HibernateUtil.getSessionFactory().openSession()){return s.get(type,id);}}
 public List<T> findAll(){try(Session s=HibernateUtil.getSessionFactory().openSession()){return s.createQuery("from "+type.getSimpleName(),type).list();}}
 public void update(T x){run(s->s.merge(x));} public void delete(T x){run(s->s.remove(s.contains(x)?x:s.merge(x)));}
 private void run(java.util.function.Consumer<Session> action){Transaction t=null;try(Session s=HibernateUtil.getSessionFactory().openSession()){t=s.beginTransaction();action.accept(s);t.commit();}catch(RuntimeException e){if(t!=null)t.rollback();throw e;}}
}
