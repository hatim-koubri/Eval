package ma.projet.dao; import java.util.*; public interface IDao<T>{T create(T x); T update(T x); void delete(T x); Optional<T> findById(Long id); List<T> findAll();}
