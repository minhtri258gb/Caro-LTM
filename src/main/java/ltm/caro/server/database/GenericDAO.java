package ltm.caro.server.database;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface GenericDAO<ID extends Serializable,T >
{
    List<T> findAll();
    T update(T entity);
    T save(T entity);
    T findById(ID var1);
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, String whereClause);
    Integer delete(List<ID> ids);
    T findEqualUnique(String property, Object value);
}
