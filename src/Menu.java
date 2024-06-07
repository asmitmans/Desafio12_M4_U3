import java.util.Scanner;

public class Menu {
    Scanner scanner;
    ProductoServicio productoServicio;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.productoServicio = new ProductoServicio();
    }

    public void start() {

        int command = 0;
        do {
            printMenu();
            command = leerCommandInt();
            limpiarPantalla();

            if (command == 1) {
                listarProductos();
            } else if (command == 2) {
                editarDatos();
            } else if (command == 3) {
                impotarDatos();
            } else if (command == 4) {
                System.out.println("Abandonando el sistema de clientes...");
            } else {
                System.out.println("Comando Inválido");
            }
        } while (command!=4);
        System.out.println("Acaba de salir del sistema");

    }

    public void limpiarPantalla() {
        Utilidad.limpiarPantalla();
    }

    public void printMenu() {
        System.out.println("1 Listar Producto");
        System.out.println("2 Editar Datos");
        System.out.println("3 Importar Datos");
        System.out.println("4 Salir");
        System.out.println("Ingrese una opción:");
    }

    public int leerCommandInt() {
        return Integer.valueOf(this.scanner.nextLine());
    }

    public void listarProductos() {
        if(productoServicio.listaProductos.isEmpty()) {
            System.out.println("La lista de productos esta vacia");
            return;
        }
        this.productoServicio.listarProductos();
    }

    public void impotarDatos() {
        System.out.println("Cargar Datos");
        System.out.println("Ingresa la ruta en donde se encuentra el archivo ProductosImportados.csv:");
        System.out.println("Ruta por defecto: 'src'");
        String pathArchivo = scanner.nextLine();
        productoServicio.cargarDatos(pathArchivo);
    }

    public void editarDatos() {

        System.out.println("Editar Producto");
        if(productoServicio.listaProductos.isEmpty()) {
            System.out.println("La lista de productos esta vacia");
            return;
        }

        System.out.println("Ingrese el número del producto que desea editar: ");
        int indexProducto = Integer.valueOf(scanner.nextLine());
        System.out.println("Ingrese código del producto: ");
        String codigoProducto = scanner.nextLine();
        if (!productoServicio.validarProductoEditar(indexProducto,codigoProducto)) {
            return;
        }

        productoServicio.mostrarProductoEditar(indexProducto);
        System.out.println("Ingrese la opción a editar de los datos del producto:");
        int indexCampo = Integer.valueOf(scanner.nextLine());

        String mensaje="Ingrese ";
        if (indexCampo == 1) {
            mensaje+="el nuevo nombre ";
        } else if (indexCampo==2) {
            mensaje+="el nuevo codigo ";
        } else if (indexCampo==3) {
            mensaje+="el nuevo color ";
        } else if (indexCampo==4) {
            mensaje+="la nueva descripcion ";
        } else if (indexCampo==5) {
            mensaje+="la nueva marca ";
        } else if (indexCampo==6) {
            mensaje+="el nuevo precio ";
        } else if (indexCampo==7) {
            mensaje+="la nueva talla ";
        } else {
            System.out.println("opcion invalida");
            return;
        }
        mensaje+="del producto";
        System.out.println(mensaje);

        String nuevoValorCampo = scanner.nextLine();
        productoServicio.modificarProducto(indexProducto, indexCampo, nuevoValorCampo);

    }


}
