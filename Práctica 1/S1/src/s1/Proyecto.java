
package s1;
import java.util.Scanner;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Arrays;

public class Proyecto {
   static ArrayList<Bicicleta> bicicletas = new ArrayList<>();
   static Carrera carrea;
   static ArrayList<factoriaCarrerayBicicleta> factorias = new ArrayList<>();
   static private Scanner in = new Scanner(System.in);
   

    static int leeEntero (int max, String msg1, String msg2) {
      Boolean ok;
      String cadena;
      int numero = -1;
      do {
        System.out.print (msg1);
        cadena = in.nextLine();
        try {  
          numero = Integer.parseInt(cadena);
          ok = true;
        } catch (NumberFormatException e) { // No se ha introducido un entero
          System.out.println (msg2);
          ok = false;  
        }
        if (ok && (numero < 0 || numero >= max)) {
          System.out.println (msg2);
          ok = false;
        }
      } while (!ok);

      return numero;
    }

    static int menu (String titulo, ArrayList<String> lista) {
      String tab = "  ";
      int opcion;
      System.out.println (titulo);
      for (int i = 0; i < lista.size(); i++) {
        System.out.println (tab+i+"-"+lista.get(i));
      }

      opcion = leeEntero(lista.size(),
                            "\n"+tab+"Elige una opción: ",
                            tab+"Valor erróneo");
      return opcion;
    }
  
    public static void main(String[] args) {
        int opcion = -1;

        ArrayList<String> opciones = new ArrayList<> 
        (Arrays.asList("Terminar","Construir factoria montaña","Construir factoria carretera","Crear bicicleta montaña","Crear bicicleta carretera",
                "Crear carrera montaña", "Crear carrera carretera"));
        
        while(opcion!=0){
            
            opcion = menu("¿Qué opción quieres llevar a cabo?",opciones);
            switch(opcion){
                case 1:
                    factoriaMontana fac = new factoriaMontana();
                    factorias.add(fac);
                    factorias.toString();
                break;
            } 
        }    
    }
}