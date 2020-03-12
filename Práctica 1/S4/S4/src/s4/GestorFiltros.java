package s4;

public class GestorFiltros extends Thread {
    public CadenaFiltros cadena;
    public Salpicadero salpicadero;
    
    GestorFiltros(){
        this.cadena =  new CadenaFiltros();
        this.salpicadero = new Salpicadero();
    }
    
    public void llamadaFiltros(EstadoMotor estado){
        double revoluciones =  this.salpicadero.getRevoluciones();
        revoluciones = this.cadena.ejecutar(revoluciones, estado);
        this.salpicadero.ejecutar(revoluciones, estado);
    }
    
    public void run(){
        this.llamadaFiltros(EstadoMotor.APAGADO);
        this.salpicadero.setRevoluciones(1000);
        System.out.println("Acelerando");
        
        try{
            Thread.sleep(60);
        }catch(InterruptedException e){}
        
        this.llamadaFiltros(EstadoMotor.ACELERANDO);
        System.out.println("Acelerando");
        System.out.println("Valor de la velocidad " + this.salpicadero.getVelocidad() + " Km/h");
        System.out.println("Valor de las revoluciones " + this.salpicadero.getRevoluciones() + " RPM");
        System.out.println("Valor de la distancia " + this.salpicadero.getDistancia() + " Km");
        
        
        //PROCESO DE ACELERACION
        try{
            Thread.sleep(60);
        }catch(InterruptedException e){}
        
        this.llamadaFiltros(EstadoMotor.ACELERANDO);
        System.out.println("Acelerando");
        System.out.println("Valor de la velocidad " + this.salpicadero.getVelocidad() + " Km/h");
        System.out.println("Valor de las revoluciones " + this.salpicadero.getRevoluciones() + " RPM");
        System.out.println("Valor de la distancia " + this.salpicadero.getDistancia() + " Km");
        
        try{
            Thread.sleep(60);
        }catch(InterruptedException e){}
        
        this.llamadaFiltros(EstadoMotor.ACELERANDO);
        System.out.println("Acelerando");
        System.out.println("Valor de la velocidad " + this.salpicadero.getVelocidad() + " Km/h");
        System.out.println("Valor de las revoluciones " + this.salpicadero.getRevoluciones() + " RPM");
        System.out.println("Valor de la distancia " + this.salpicadero.getDistancia() + " Km");
        
        
        //PROCESO DE FRENO
        
        try{
            Thread.sleep(60);
        }catch(InterruptedException e){}
        
        this.llamadaFiltros(EstadoMotor.FRENANDO);
        System.out.println("Frenando");
        System.out.println("Valor de la velocidad " + this.salpicadero.getVelocidad() + " Km/h");
        System.out.println("Valor de las revoluciones " + this.salpicadero.getRevoluciones() + " RPM");
        System.out.println("Valor de la distancia " + this.salpicadero.getDistancia() + " Km");
        
        
        try{
            Thread.sleep(60);
        }catch(InterruptedException e){}
        
        this.llamadaFiltros(EstadoMotor.FRENANDO);
        System.out.println("Frenando");
        System.out.println("Valor de la velocidad " + this.salpicadero.getVelocidad() + " Km/h");
        System.out.println("Valor de las revoluciones " + this.salpicadero.getRevoluciones() + " RPM");
        System.out.println("Valor de la distancia " + this.salpicadero.getDistancia() + " Km");
        
        
        
        //APAGAMOS EL COCHE
        try{
            Thread.sleep(60);
        }catch(InterruptedException e){}
       
        this.llamadaFiltros(EstadoMotor.ENCENDIDO);
        System.out.println("El resultado de la simulacion FINAL ha sido de " + this.salpicadero.getSimulacion() + " milisegundos");
        System.out.println("Valor de la velocidad " + this.salpicadero.getVelocidad() + " Km/h");
        System.out.println("Valor de las revoluciones " + this.salpicadero.getRevoluciones() + " RPM");
        System.out.println("Valor de la distancia " + this.salpicadero.getDistancia() + " Km");
        
        
    }
}
