package s4;
public class FiltroCalcularVelocidad implements Filtro {
    FiltroCalcularVelocidad(){};
    
    @Override
    public double ejecturar(double revoluciones,EstadoMotor estadoMotor){
        if(estadoMotor == EstadoMotor.ACELERANDO && revoluciones < 5000)
            return revoluciones += 100;
        else if (estadoMotor == EstadoMotor.FRENANDO && revoluciones > 0)
            return revoluciones -= 100;
        else
            return revoluciones;
    }
    
}
