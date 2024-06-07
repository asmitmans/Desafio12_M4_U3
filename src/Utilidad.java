public class Utilidad {

    public static void limpiarPantalla() {
        //  NOTA: Este metodo funcina al ejecutar la app en una terminal real
        //  $ java src/Main.java
        //  no funiona a traves del output de un IDE
        try {
            if (System.getProperty("os.name").contains("Linux")) {
                // Limpia la consola en Linux/Unix
                // Clear the console screen
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else {
                // Limpia la consola en otros sistemas operativos
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
