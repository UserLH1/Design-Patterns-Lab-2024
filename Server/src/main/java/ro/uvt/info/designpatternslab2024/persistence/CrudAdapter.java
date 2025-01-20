package ro.uvt.info.designpatternslab2024.persistence;

import java.util.List;
import java.util.Optional;

public interface CrudAdapter<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    boolean existsById(ID id);
}
