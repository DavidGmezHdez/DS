package s4;
public class FiltroRepercutirRozamiento implements Filtro {
    FiltroRepercutirRozamiento(){};
    
    @Override
    public double ejecturar(double revoluciones,EstadoMotor estadoMotor){
        if(estadoMotor == EstadoMotor.ACELERANDO && revoluciones > 0)
            return revoluciones -= revoluciones*0.02; //2% de rozamiento
        else
            return revoluciones;
    }
    
}
