package PJDataAccess;
import java.util.List;

public interface PJIDAO <T> {

    public boolean PJCreate(T entity)     throws Exception;
    public List<T> PJReadAll()            throws Exception;
    public boolean PJUpdate(T entity)     throws Exception;
    public boolean PJDelete(int id)       throws Exception;
    
    public T PJReadBy(Integer id)         throws Exception;
}

