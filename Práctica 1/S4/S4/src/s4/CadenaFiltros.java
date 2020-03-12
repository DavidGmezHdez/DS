
package s4;

import java.util.ArrayList;

public class CadenaFiltros {
    private ArrayList<Filtro> filtros = new ArrayList<>();
    
    CadenaFiltros(){
        filtros.clear();
        filtros.add(new FiltroCalcularVelocidad());
        filtros.add(new FiltroRepercutirRozamiento());
    }
    
    double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        for(Filtro f: filtros){
            revoluciones = f.ejecturar(revoluciones, estadoMotor);
        }
        return revoluciones;
    }
    
}
