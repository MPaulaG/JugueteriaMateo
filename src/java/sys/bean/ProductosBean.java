package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sys.dao.ProductosDAO;
import sys.impl.ProductosDAOImpl;
import sys.modelo.Productos;

@ManagedBean
@Named(value = "productosBean")
@ViewScoped
public class ProductosBean {

    private Productos productos = null;
    private List<Productos> producto = null;

    public ProductosBean() {
    }

    public List<Productos> getProducto() {
        ProductosDAO datos = new ProductosDAOImpl();
        this.producto = datos.select();
        return producto;
    }

    public void prepareProductos() {
        this.productos = new Productos();
    }

    public void insertProductos() {
        ProductosDAO datos = new ProductosDAOImpl();
        datos.insert(productos);
    }

    public void updateProductos() {
        ProductosDAO datos = new ProductosDAOImpl();
        datos.update(productos);
        this.productos = new Productos();
    }

    public void deleteProductos() {
        ProductosDAO datos = new ProductosDAOImpl();
        datos.delete(productos);
        this.productos = new Productos();
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public void setProducto(List<Productos> producto) {
        this.producto = producto;
    }

}
