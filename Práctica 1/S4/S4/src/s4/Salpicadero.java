package s4;
public class Salpicadero {
    protected CuentaKilometros cKilometros;
    protected Velocimetro velocimetro;
    protected CuentaRevoluciones cRevoluciones;
    
    long tinicio, tactual, tanterior;
    private final double radio = 0.15;
    
    Salpicadero(){
        this.cKilometros = new CuentaKilometros();
        this.velocimetro = new Velocimetro();
        this.cRevoluciones = new CuentaRevoluciones();
        this.tinicio =  System.currentTimeMillis();
        this.tactual = 0;
        this.tanterior = 0;
    }
    
    public void ejecutar(double revoluciones, EstadoMotor estadoMotor){
        if(estadoMotor == EstadoMotor.ACELERANDO || estadoMotor == EstadoMotor.FRENANDO){
            this.tanterior = this.tactual;
            this.tactual = System.currentTimeMillis();
            this.cRevoluciones.setRevoluciones(revoluciones);
            this.velocimetro.setVelocidad(2*Math.PI*radio*this.cRevoluciones.getRevoluciones()*((double)(60.0/1000.0)));
            this.cKilometros.setDistancia(this.velocimetro.getVelocidad() * ((this.tactual-this.tanterior)/360000.0));
            System.out.println("El resultado de la simulación ha sido de " + (this.tactual-this.tanterior) + " milisegundos");
        }
        else if(estadoMotor == EstadoMotor.APAGADO){
            estadoMotor = EstadoMotor.ENCENDIDO;
            this.tactual = System.currentTimeMillis();
            this.setRevoluciones(0);
            
        }
        
        else if(estadoMotor == EstadoMotor.ENCENDIDO){
            estadoMotor = EstadoMotor.APAGADO;
            this.setRevoluciones(0);
            this.setVelocidad(0);
        }
    }
    
    
    public double getVelocidad(){
        return this.velocimetro.getVelocidad();
    }
    
    public double getDistancia(){
        return this.cKilometros.getDistancia();
    }
    
    public double getRevoluciones(){
        return this.cRevoluciones.getRevoluciones();
    }
    
    public void setVelocidad(double v){
        this.velocimetro.setVelocidad(v);
    }
    
    public void setDistancia(double d){
        this.cKilometros.setDistancia(d);
    }
    
    public void setRevoluciones(double r){
        this.cRevoluciones.setRevoluciones(r);
    }
    
    public long getSimulacion(){
        return this.tactual - this.tanterior;
    }
}
