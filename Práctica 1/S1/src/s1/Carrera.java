
package s1;
import java.util.ArrayList;
import java.util.Collections;
    public abstract class Carrera extends Thread {
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
            
            public void mostrarRanking(){
                for(int i=1;i<=this.bicicletas.size();i++){
                    System.out.println(i+ ".- Bicicleta " + this.bicicletas.get(i).getID());
                }
            }
            
            public void correrCarrera(){
                run();
                Collections.shuffle(bicicletas);
                
                this.mostrarRanking();
            }

    }