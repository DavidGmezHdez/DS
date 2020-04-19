package s4;
public class CuentaRevoluciones {
    private double revoluciones;
    private double cambioAceite;
    private double cambioFrenos;
    private double revisionGeneral;
    
    CuentaRevoluciones(){
        revoluciones = 0;
    }
    
    public double getRevoluciones(){
        return revoluciones;
    }
    
    public void setRevoluciones(double r){
        this.revoluciones = r;
        if(revoluciones < 0)
            revoluciones = 0;
        
    }
    
    public double getCambioAceite(){
        return cambioAceite;
    }
    
    public double getCambioFrenos(){
        return cambioFrenos;
    }
    
    public double getRevisionGeneral(){
        return revisionGeneral;
    }
    
    public void resetCambioAceite(){
        cambioAceite=0;
    }
    public void resetCambioFrenos(){
        cambioFrenos=0;
    }
    public void resetRevisionGeneral(){
        revisionGeneral=0;
    }   
    
    public void setRevolucionesAlmacenada(double r){
        this.cambioAceite = this.cambioAceite + r;
        this.cambioFrenos = this.cambioFrenos + r;
        this.revisionGeneral = this.revisionGeneral + r;
    }
}
