package s4;
public class FiltroRepercutirRozamiento implements Filtro {
    FiltroRepercutirRozamiento(){};
    
    @Override
    public double ejecturar(double revoluciones,EstadoMotor estadoMotor){
        double revol = revoluciones;
        if((estadoMotor == EstadoMotor.ENCENDIDO) && revoluciones > 0)
            revol -= revol*0.5;
        if(revol < 1)
            revol = 0;
        
        return revol;
    }
    
}
