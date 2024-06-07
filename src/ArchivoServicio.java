import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoServicio {

    public static ArrayList<Producto> cargarDatos(String pathDirectorio) {

        // Comprobaciones de directorio y archivo
        File directorio = new File(pathDirectorio);
        if (!directorio.exists()) {
            System.out.println("El directorio ingresado no existe");
            return null;
        }

        File archivo = new File(directorio.getAbsolutePath()+"/"+"ProductosImportados.csv");
        if(!archivo.exists()) {
            System.out.println("No se encuntra el archivo ProductosImportados.csv en el directorio ingresado");
            return null;
        }

        // Lectura de datos desde archivo
        ArrayList<Producto> listaProductos = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            String[] arrLinea;
            while ((linea = br.readLine()) != null) {
                arrLinea = linea.split(",");
                if(arrLinea.length==7) {
                    listaProductos.add(new Producto(arrLinea[0],arrLinea[1],arrLinea[2],arrLinea[3],
                            arrLinea[4],arrLinea[5],arrLinea[6]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listaProductos;
    }


}
