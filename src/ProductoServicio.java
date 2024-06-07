import java.util.ArrayList;

public class ProductoServicio {
    ArrayList<Producto> listaProductos;

    public ProductoServicio() {
        listaProductos = new ArrayList<Producto>();
    }

    public void listarProductos() {
        for (Producto producto : listaProductos) {
            producto.mostrarProducto();
        }
    }

    public boolean validarProductoEditar(int indexProducto, String codigoProducto) {
        // Lo ajustamos para que sea un indice de la lista de productos
        indexProducto--;
        if(indexProducto < 0 || indexProducto>= listaProductos.size()) {
            System.out.println("Indice de producto ingresado no es valido");
            return false;
        }

        // Valida si indice corresponde a codigo de producto
        if(!listaProductos.get(indexProducto).getCodigo().equals(codigoProducto)) {
            System.out.println(indexProducto);
            System.out.println(codigoProducto);
            System.out.println("El indice de producto y el codigo ingresado no corresponden");
            return false;
        }

        return true;
    }

    public void mostrarProductoEditar(int indexProducto) {
        // Lo ajustamos para que sea un indice de la lista de productos
        indexProducto--;

        Producto producto = listaProductos.get(indexProducto);
        System.out.println("1.-El nombre del articulo actual es: " + producto.getArticulo());
        System.out.println("2.-El código del producto: " + producto.getCodigo());
        System.out.println("3.-El color del producto: " + producto.getColor());
        System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
        System.out.println("5.-La marca del producto: " + producto.getMarca());
        System.out.println("6.-El precio del producto: " + producto.getPrecio());
        System.out.println("7.-La talla del producto: " + producto.getTalla());
    }

    public void modificarProducto(int indexProducto, int indexCampo, String nuevoValorCampo) {

        indexProducto--;
        if (indexCampo == 1) {
            listaProductos.get(indexProducto).setArticulo(nuevoValorCampo);
        } else if (indexCampo==2) {
            listaProductos.get(indexProducto).setCodigo(nuevoValorCampo);
        } else if (indexCampo==3) {
            listaProductos.get(indexProducto).setColor(nuevoValorCampo);
        } else if (indexCampo==4) {
            listaProductos.get(indexProducto).setDescripcion(nuevoValorCampo);
        } else if (indexCampo==5) {
            listaProductos.get(indexProducto).setMarca(nuevoValorCampo);
        } else if (indexCampo==6) {
            listaProductos.get(indexProducto).setPrecio(nuevoValorCampo);
        } else if (indexCampo==7) {
            listaProductos.get(indexProducto).setTalla(nuevoValorCampo);
        } else {
            System.out.println("campo invalido");
            return;
        }
        System.out.println("----------------------------");

    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void cargarDatos(String pathDirectorio){
        ArrayList<Producto> newLista = ArchivoServicio.cargarDatos(pathDirectorio);

        if (newLista == null) {
            System.out.println("Error al cargar datos desde el archivo");
            return;
        }

        this.listaProductos = newLista;
        System.out.println();
        System.out.println(this.listaProductos);
        System.out.println();
        System.out.println("Datos cargados correctamente en la lista");

    }

}
