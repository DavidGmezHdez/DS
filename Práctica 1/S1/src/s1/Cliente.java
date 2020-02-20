
package s1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {
   ArrayList<Bicicleta> bicicletas;
   Carrera carrea;
   factoriaCarrerayBicicleta factoria;
   boolean factoriasCreadas, tipoFactoria; //false -> montaña, true -> carretera
   private Scanner in;
   
   Cliente(){
    bicicletas = new ArrayList<>();
    in = new Scanner(System.in);
    factoriasCreadas = false;
   }
   

   int leeEntero (int max, String msg1, String msg2) {
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

    int menu (String titulo, ArrayList<String> lista) {
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
  
    public  void gestionar() {
        int opcion = -1;

        ArrayList<String> opciones = new ArrayList<> 
        (Arrays.asList("Terminar","Construir factoria montaña","Construir factoria carretera","Crear bicicleta montaña","Crear bicicleta carretera",
                "Crear carrera montaña", "Crear carrera carretera"));
        
       while(opcion!=0){
           if(!this.factoriasCreadas){
            opciones = new ArrayList<> 
            (Arrays.asList("Terminar","Construir factoria montaña","Construir factoria carretera"));
            opcion = this.menu("¿Qué tipo de factoria deseas construir?", opciones);
            switch(opcion){
                case 1:
                    factoria = new factoriaMontana();
                    this.tipoFactoria = false;
                    this.factoriasCreadas = true;
                    System.out.println("Factoría de montaña creada");
                break;
                case 2:
                    factoria = new factoriaCarretera();
                    this.tipoFactoria = true;
                    this.factoriasCreadas = true;
                    System.out.println("Factoría de carretera creada");
            }
           }
           else{
                if(this.factoriasCreadas && !this.tipoFactoria){
                 opciones = new ArrayList<> 
                 (Arrays.asList("Terminar","Crear bicicleta montaña","Crear carrera montaña"));
                 opcion = this.menu("¿Qué deseas hacer?", opciones);
                }
                else if(this.factoriasCreadas && this.tipoFactoria){
                    opciones = new ArrayList<> 
                    (Arrays.asList("Terminar","Crear bicicleta carretera","Crear carrera carretera"));
                    opcion = this.menu("¿Qué deseas hacer?", opciones);
                }
                switch(opcion){
                    case 1:
                        System.out.println("¿Qué id deseas ponerle a la bicicleta?");
                        int id = in.nextInt();
                        
                        if(this.bicicletas.isEmpty()){
                            Bicicleta bici = factoria.crearBicicleta(id);
                            this.bicicletas.add(bici);
                            System.out.println("Bicicleta con ID " + id + " añadida");
                        }
                        else{
                            boolean existe = false;
                            for(int i=0;i<this.bicicletas.size() && !existe;i++){
                                if(id == this.bicicletas.get(i).getID()){
                                    System.out.println("Error: ya hay una bicicleta con ese ID");
                                    existe = true;
                                }
                                else{
                                    Bicicleta bici = factoria.crearBicicleta(id);
                                    this.bicicletas.add(bici);
                                    System.out.println("Bicicleta con ID " + id + " añadida");
                                    existe = false;
                                }
                            }
                        }
                    break;
                    case 2:
                        if(this.bicicletas.size()>0){
                            this.carrea = this.factoria.crearCarrera(this.bicicletas);
                            System.out.println("Carrera creada, mostrando bicicletas");
                            this.carrea.mostrarBicicletas();
                        }
                        else
                            System.out.println("Necesitas crear al menos una bicicleta");
                    break;
                }         
            } 
        }    
    }
}