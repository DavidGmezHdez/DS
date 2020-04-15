
package s4;

import java.util.ArrayList;

public class CadenaFiltros {
    private ArrayList<Filtro> filtros = new ArrayList<>();
    
    CadenaFiltros(){
        filtros.clear();
        filtros.add(new FiltroCalcularVelocidad());
        filtros.add(new FiltroRepercutirRozamiento());
    }
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        for(int i=0;i<filtros.size();i++){
            revoluciones = filtros.get(i).ejecturar(revoluciones, estadoMotor);
        }
        return revoluciones;
    }
    
}
