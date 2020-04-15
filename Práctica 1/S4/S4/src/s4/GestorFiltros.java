package s4;

public class GestorFiltros extends Thread {
    public CadenaFiltros cadena;
    public SCACV salpicadero;
    
    GestorFiltros(SCACV salp){
        this.cadena =  new CadenaFiltros();
        this.salpicadero = salp;
    }
    
    public void llamadaFiltros(EstadoMotor estado){
        double revoluciones =  this.salpicadero.getRevoluciones();
        revoluciones = this.cadena.ejecutar(revoluciones, estado);
        this.salpicadero.ejecutar(revoluciones, estado);
    }
    
    public void run(){
        this.llamadaFiltros(EstadoMotor.APAGADO);
        this.salpicadero.setRevoluciones(0);
        this.salpicadero.setDistancia(0);
    }
}
