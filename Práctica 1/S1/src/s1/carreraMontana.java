package s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class carreraMontana extends Carrera {
    
    carreraMontana(int codigo){
        super(codigo);
    }
    
    public void run(){
        
        System.out.println("Comienza la carrera de Montaña");
        Collections.shuffle(this.bicicletas); //Desordenamos los participantes, para simular que están compitiendo
        
        int abandonos = (int) ((int)this.bicicletas.size() * 0.2);
        
        System.out.println("Se han retirado " + abandonos + " ciclistas.");
        
        for(int i=0;i<abandonos;i++){
            Random rand = new Random();
            int caido = rand.nextInt(this.bicicletas.size());
            System.out.println("El participante " + this.bicicletas.get(caido).getID() + " se ha retirado");
            this.bicicletas.remove(caido);
        }
        
        
    }
}