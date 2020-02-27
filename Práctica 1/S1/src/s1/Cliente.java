
package s1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Cliente {
   ArrayList<Bicicleta> bicicletas;
   ArrayList<Carrera> carreras;
   factoriaCarrerayBicicleta factoria;
   boolean factoriasCreadas, tipoFactoria; //false -> montaña, true -> carretera
   private Scanner in;
   int codigo;
   
   Cliente(){
    bicicletas = new ArrayList<>();
    in = new Scanner(System.in);
    factoriasCreadas = false;
    carreras = new ArrayList<>();
    codigo = 0;
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
    
    public ArrayList<Carrera> getCarreras(){
        return this.carreras;
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
                    factoria = (factoriaCarrerayBicicleta) new factoriaMontana();
                    this.tipoFactoria = false;
                    this.factoriasCreadas = true;
                    System.out.println("Factoría de montaña creada");
                break;
                case 2:
                    factoria = (factoriaCarrerayBicicleta) new factoriaCarretera();
                    this.tipoFactoria = true;
                    this.factoriasCreadas = true;
                    System.out.println("Factoría de carretera creada");
            }
           }
           else{
                if(this.factoriasCreadas && !this.tipoFactoria){
                 opciones = new ArrayList<> 
                 (Arrays.asList("Terminar","Generar Participantes","Crear carrera montaña"));
                 opcion = this.menu("¿Qué deseas hacer?", opciones);
                }
                else if(this.factoriasCreadas && this.tipoFactoria){
                    opciones = new ArrayList<> 
                    (Arrays.asList("Terminar","Generar Participantes","Crear carrera carretera"));
                    opcion = this.menu("¿Qué deseas hacer?", opciones);
                }
                switch(opcion){
                    case 1:
                        this.bicicletas = generarParticipantes();
                        System.out.println("Participantes apuntados");
                    break;
                    case 2:
                        if(this.bicicletas.size()>0){
                            this.carreras.add(this.factoria.crearCarrera(codigo));
                            this.carreras.get(codigo).añadirParticipantes(bicicletas);
                            System.out.println("Carrera creada");
                            codigo++;

                            this.factoriasCreadas = false;                              //Ya has creado una carrera, volvemos al principio del menu
                        }
                        else
                            System.out.println("Necesitas crear al menos una bicicleta");
                    break;
                }         
            } 
        }    
    }
    
    public ArrayList<Bicicleta> generarParticipantes(){
        ArrayList<Bicicleta> bicis = new ArrayList();
        Random rand = new Random();
        int nparticipantes = rand.nextInt(10) + 10;

        for(int i=1;i<=nparticipantes;i++){
            bicis.add(this.factoria.crearBicicleta(i));
        }
        return bicis;
    }
}