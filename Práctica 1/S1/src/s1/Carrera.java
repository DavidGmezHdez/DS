
package s1;
import java.util.ArrayList;
    public abstract class Carrera {
            private ArrayList<Bicicleta> bicicletas;
            
            Carrera(ArrayList<Bicicleta> bicis){
                this.bicicletas = bicis;
            }
            
            public ArrayList<Bicicleta> getBicicletas(){
                return this.bicicletas;
            }
            
            public void mostrarBicicletas(){
                for(Bicicleta b:this.bicicletas){
                    System.out.println("Bicicleta numero " + b.getID());
                }
            }

    }