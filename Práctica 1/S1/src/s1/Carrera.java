
package s1;
import java.util.ArrayList;
import java.util.Collections;
    public abstract class Carrera extends Thread {
            protected ArrayList<Bicicleta> bicicletas;
            private int codigoCarrera;
            
            Carrera(int codigo){
                this.codigoCarrera = codigo;
                bicicletas = new ArrayList<>();
            }
            
            public ArrayList<Bicicleta> getBicicletas(){
                return this.bicicletas;
            }
            
            public void añadirParticipantes(ArrayList<Bicicleta> bicicletas){
                this.bicicletas = bicicletas;
            }
            
            public int getCodigo(){
                return codigoCarrera;
            }
            
            public void mostrarBicicletas(){
                for(int i=0;i<this.bicicletas.size();i++){
                    System.out.println(this.bicicletas.get(i).toString());
                }
            }
            
            public void mostrarRanking(){
                System.out.println("La carrera ha acabado, el resultado ha sido el siguiente: ");
                for(int i=1;i<=this.bicicletas.size();i++){
                    System.out.println("Carrera " + this.codigoCarrera + ".Puesto " + i + ".- Bicicleta " + this.bicicletas.get(i).getID());
                }
            }
            
            public abstract void run();


    }