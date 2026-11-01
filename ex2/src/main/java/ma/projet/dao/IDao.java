package ma.projet.dao;
import java.util.List;
public interface IDao<T> { void create(T x); T findById(int id); List<T> findAll(); void update(T x); void delete(T x); }
