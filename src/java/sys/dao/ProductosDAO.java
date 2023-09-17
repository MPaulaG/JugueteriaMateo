package sys.dao;

import java.util.List;
import sys.modelo.Productos;

public interface ProductosDAO {

    public List<Productos> select();

    public void insert(Productos productos);

    public void update(Productos productos);

    public void delete(Productos productos);

}
