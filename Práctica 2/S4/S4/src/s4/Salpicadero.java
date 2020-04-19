package s4;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Salpicadero extends javax.swing.JPanel {

    public GestorFiltros gestor;
    protected CuentaKilometros cKilometros;
    protected Velocimetro velocimetro;
    protected CuentaRevoluciones cRevoluciones;
    
    double vel = 0;
    double velalmacenada = 0;
    protected double gasolina = Math.random()*35 + 65;
    double cambioAceite = 5 * (Math.pow(10, 6));
    double cambioFrenos = Math.pow(10, 8);
    double revisionGeneral = Math.pow(10, 9);
    
    
    long tinicio = 0, tactual = 0, tanterior = 0;
    private final double radio = 0.15;
    
    
    public Salpicadero() {
        this.cKilometros = new CuentaKilometros();
        this.velocimetro = new Velocimetro();
        this.cRevoluciones = new CuentaRevoluciones();
        this.tinicio =  System.currentTimeMillis();
        this.gestor = new GestorFiltros(this);
        
        initComponents();
        
        this.FlechaApuntadoraAcelerar.setVisible(false);
        this.FlechaApuntadoraMantener.setVisible(false);
        this.FlechaApuntadoraReiniciar.setVisible(false);
        this.FlechaApuntadoraParar.setVisible(false);
        
        this.estadoMotor.setText("APAGADO");
        this.estadoMotor.setForeground(Color.RED);
        this.Arrancar.setForeground(Color.GREEN);
        
        this.Acelerador.setEnabled(false);
        this.Freno.setEnabled(false);
        this.MantenerSCACV.setEnabled(false);
        this.ReiniciarSCACV.setEnabled(false);
        this.ApagarSCACV.setEnabled(false);
        
        this.CambioAceite.setEnabled(false);
        this.CambioFrenos.setEnabled(false);
        this.RevisionGeneral.setEnabled(false);
        
        
        
        this.cuentaKilometrosRadial.setValue(0.0);
        this.CuentaRevolucionesRadial.setValue(0.0);
        this.Gasolina.setValue(this.gasolina);

    }
    
    public void ejecutar(double revoluciones, EstadoMotor estadoMotor){


        
        if(this.cRevoluciones.getCambioAceite() > cambioAceite){
            this.AvisoAceite.setText("¡Deberias cambiar el aceite!");
        }
        if(this.cRevoluciones.getCambioFrenos() > cambioFrenos){
            this.AvisoFrenos.setText("¡Deberias cambiar las pastillas de frenos!");
        }
        if(this.cRevoluciones.getRevisionGeneral() > revisionGeneral){
            this.AvisoGeneral.setText("¡Deberias hacer una revisión general!");
        }
        
        this.tanterior = this.tactual;
        this.tactual = System.currentTimeMillis();
        this.cRevoluciones.setRevoluciones(revoluciones);
        this.cRevoluciones.setRevolucionesAlmacenada(this.cRevoluciones.getRevoluciones());
        
        double velocidad = 2 * Math.PI*radio*this.cRevoluciones.getRevoluciones()*((double)(60.0/1000.0));
        
        
        if(velocidad > 100)
            velocidad = 100;

        
        switch(estadoMotor){
            
            case ACELERANDO:
                this.velocimetro.setVelocidad(velocidad);
                break;
             
            case ANDANDO:
                this.velocimetro.setVelocidad(velocidad);
                break;

            case FRENANDO:
                this.velocimetro.setVelocidad(velocidad);
                break;

            case CONSTANTE:
                this.velocimetro.setVelocidad(velocidad);
                break;

            default:
                this.tactual = System.currentTimeMillis();
                     
        }
        this.cKilometros.setDistancia(this.velocimetro.getVelocidad() * (this.tactual - this.tanterior)/3600000);
        
        this.gasolina = this.gasolina - (this.cRevoluciones.getRevoluciones() * this.cRevoluciones.getRevoluciones() * 5 * Math.pow(10, -10));
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Salpicadero = new javax.swing.JLabel();
        Mandos = new javax.swing.JLabel();
        Arrancar = new javax.swing.JToggleButton();
        Acelerador = new javax.swing.JToggleButton();
        Freno = new javax.swing.JToggleButton();
        estadoMotor = new javax.swing.JLabel();
        cuentaKilometrosRadial = new eu.hansolo.steelseries.gauges.Radial3Lcd();
        Gasolina = new eu.hansolo.steelseries.gauges.Radial1Square();
        CuentaRevolucionesRadial = new eu.hansolo.steelseries.gauges.Radial3Lcd();
        MantenerSCACV = new javax.swing.JToggleButton();
        ReiniciarSCACV = new javax.swing.JToggleButton();
        ApagarSCACV = new javax.swing.JToggleButton();
        estadoVehiculo = new javax.swing.JLabel();
        CambioAceite = new javax.swing.JButton();
        CambioFrenos = new javax.swing.JButton();
        RevisionGeneral = new javax.swing.JButton();
        AvisoAceite = new javax.swing.JLabel();
        AvisoFrenos = new javax.swing.JLabel();
        AvisoGeneral = new javax.swing.JLabel();
        LabbelVelocidadAlmacenada = new javax.swing.JLabel();
        VelocidadDisplay = new eu.hansolo.steelseries.gauges.DisplayCircular();
        FlechaApuntadoraAcelerar = new javax.swing.JLabel();
        FlechaApuntadoraReiniciar = new javax.swing.JLabel();
        FlechaApuntadoraMantener = new javax.swing.JLabel();
        FlechaApuntadoraParar = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salpicadero.setText("Salpicadero");
        add(Salpicadero, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        Mandos.setText("Mandos");
        add(Mandos, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 63, -1, -1));

        Arrancar.setText("ENCENDER");
        Arrancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrancarActionPerformed(evt);
            }
        });
        add(Arrancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 156, -1, -1));

        Acelerador.setText("ACELERAR");
        Acelerador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceleradorActionPerformed(evt);
            }
        });
        add(Acelerador, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 157, -1));

        Freno.setText("FRENO");
        Freno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrenoActionPerformed(evt);
            }
        });
        add(Freno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 156, 95, -1));

        estadoMotor.setText("Estado");
        add(estadoMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 114, -1, 24));

        cuentaKilometrosRadial.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.RED);
        cuentaKilometrosRadial.setTitle("Velocímetro");
        cuentaKilometrosRadial.setUnitString("km/h");
        add(cuentaKilometrosRadial, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 201, -1, -1));

        Gasolina.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.RED);
        Gasolina.setTitle("Gasolina");
        Gasolina.setUnitString("Litros");
        add(Gasolina, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 12, 169, 171));

        CuentaRevolucionesRadial.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.RED);
        CuentaRevolucionesRadial.setMaxValue(5000.0);
        CuentaRevolucionesRadial.setTitle("CuentaRevoluciones");
        CuentaRevolucionesRadial.setUnitString("RPM");
        add(CuentaRevolucionesRadial, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 201, -1, -1));

        MantenerSCACV.setText("Mantener");
        MantenerSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MantenerSCACVActionPerformed(evt);
            }
        });
        add(MantenerSCACV, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, -1, -1));

        ReiniciarSCACV.setText("Reiniciar");
        ReiniciarSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarSCACVActionPerformed(evt);
            }
        });
        add(ReiniciarSCACV, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, -1, -1));

        ApagarSCACV.setText("Parar");
        ApagarSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarSCACVActionPerformed(evt);
            }
        });
        add(ApagarSCACV, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        estadoVehiculo.setText("Vehiculo");
        add(estadoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 118, -1, -1));

        CambioAceite.setText("Cambiar Aceite");
        CambioAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambioAceiteActionPerformed(evt);
            }
        });
        add(CambioAceite, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, -1, -1));

        CambioFrenos.setText("Cambiar Pastillas de Frenos");
        CambioFrenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambioFrenosActionPerformed(evt);
            }
        });
        add(CambioFrenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        RevisionGeneral.setText("Revisión General");
        RevisionGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevisionGeneralActionPerformed(evt);
            }
        });
        add(RevisionGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, -1, -1));
        add(AvisoAceite, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 110, 20));
        add(AvisoFrenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 90, 20));
        add(AvisoGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 120, 20));

        LabbelVelocidadAlmacenada.setText("Velocidad Almacenada");
        add(LabbelVelocidadAlmacenada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        VelocidadDisplay.setUnitString("km/h");
        add(VelocidadDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        FlechaApuntadoraAcelerar.setText("---->");
        add(FlechaApuntadoraAcelerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, -1, 30));

        FlechaApuntadoraReiniciar.setText("---->");
        add(FlechaApuntadoraReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, -1, 30));

        FlechaApuntadoraMantener.setText("---->");
        add(FlechaApuntadoraMantener, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, -1, 30));

        FlechaApuntadoraParar.setText("<----");
        add(FlechaApuntadoraParar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ArrancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArrancarActionPerformed
        if(this.Arrancar.isSelected()){
            if(this.gestor.getState() == Thread.State.RUNNABLE)
                this.gestor.start();

            
            this.estadoMotor.setText("ENCENDIDO");
            this.estadoMotor.setForeground(Color.GREEN);

            this.Arrancar.setText("APAGAR");
            this.Arrancar.setForeground(Color.RED);

            this.Acelerador.setEnabled(true);
            
            if(this.velocimetro.getVelocidad()>0){
                this.Freno.setEnabled(true);
            }
            ApagarSCACV.setEnabled(true);
            
            this.CambioAceite.setEnabled(false);
            this.CambioFrenos.setEnabled(false);
            this.RevisionGeneral.setEnabled(false);
           
        }
        else{
            this.estadoMotor.setText("APAGADO");
            this.estadoMotor.setForeground(Color.RED);

            this.Arrancar.setText("ENCENDER");
            this.Arrancar.setForeground(Color.GREEN);

            this.Acelerador.setEnabled(false);
            this.Freno.setEnabled(false);
            
            this.MantenerSCACV.setEnabled(false);
            this.ReiniciarSCACV.setEnabled(false);
            this.ApagarSCACV.setEnabled(false);
            
            this.velalmacenada = 0.0;
            

            this.Acelerador.setSelected(false);
            this.Acelerador.setText("ACELERAR");
            this.Acelerador.setForeground(Color.BLACK);

            this.Freno.setSelected(false);
            this.Freno.setText("FRENAR");
            this.Freno.setForeground(Color.BLACK);
            
            this.FlechaApuntadoraAcelerar.setVisible(false);
            this.FlechaApuntadoraMantener.setVisible(false);
            this.FlechaApuntadoraReiniciar.setVisible(false);
            this.FlechaApuntadoraParar.setVisible(false);
            
            if(this.velocimetro.getVelocidad()==0){
                if(this.cRevoluciones.getCambioAceite() > 0){
                    this.CambioAceite.setEnabled(true);
                }
                if(this.cRevoluciones.getCambioFrenos() > 0){
                    this.CambioFrenos.setEnabled(true);
                }
                if(this.cRevoluciones.getRevisionGeneral() > 0){
                    this.RevisionGeneral.setEnabled(true);
                }
            }
        }
            
        new Thread(){
            public void run(){
                while(Arrancar.isSelected()){
                   
                    if(!Acelerador.isSelected() && !Freno.isSelected() && !MantenerSCACV.isSelected() && !ReiniciarSCACV.isSelected()){
                        
                        gestor.llamadaFiltros(EstadoMotor.ANDANDO);

                        double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                        
                        cuentaKilometrosRadial.setValue(velocidad);
                        cuentaKilometrosRadial.repaint();


                        double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                        CuentaRevolucionesRadial.setValue(revoluciones);
                        CuentaRevolucionesRadial.repaint();

                        Gasolina.setValue(gasolina);
                        Gasolina.repaint();
                        
                    }

                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException ex){
                        Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();            

    }//GEN-LAST:event_ArrancarActionPerformed

    private void AceleradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceleradorActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && Acelerador.isSelected()){
                    FlechaApuntadoraAcelerar.setVisible(true);
                    Freno.setEnabled(false);
                    Acelerador.setText("Soltar Acelerador");
                    Acelerador.setForeground(Color.RED);
                    gestor.llamadaFiltros(EstadoMotor.ACELERANDO);
                    
                    
                    if(!ApagarSCACV.isSelected()){
                        MantenerSCACV.setEnabled(true);
                        ReiniciarSCACV.setEnabled(true);
                    }
                    else{
                        MantenerSCACV.setEnabled(false);
                        ReiniciarSCACV.setEnabled(false);
                    }


                    double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    cuentaKilometrosRadial.setValue(velocidad);
                    cuentaKilometrosRadial.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    CuentaRevolucionesRadial.setValue(revoluciones);
                    CuentaRevolucionesRadial.repaint();
                    
                    Gasolina.setValue(gasolina);
                    Gasolina.repaint();

                    double distancia = Math.round(cKilometros.getDistancia()*100.0)/100.0;


                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(!Acelerador.isSelected() && Arrancar.isSelected()){
                    Freno.setEnabled(true);
                    Acelerador.setText("ACELERAR");
                    Acelerador.setForeground(Color.BLACK);
                    FlechaApuntadoraAcelerar.setVisible(false);
                }
                
            }
        }.start();
    }//GEN-LAST:event_AceleradorActionPerformed

    private void FrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrenoActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && Freno.isSelected()){
                    Acelerador.setEnabled(false);
                    Freno.setText("Soltar Freno");
                    Freno.setForeground(Color.RED);
                    

                    gestor.llamadaFiltros(EstadoMotor.FRENANDO);

                    double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    
                    cuentaKilometrosRadial.setValue(velocidad);
                    cuentaKilometrosRadial.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    
                    CuentaRevolucionesRadial.setValue(revoluciones);
                    CuentaRevolucionesRadial.repaint();

                    double distancia = Math.round(cKilometros.getDistancia()*100.0)/100.0;
                    
                    
                    if(MantenerSCACV.isSelected()){
                        MantenerSCACV.setSelected(false);
                        ApagarSCACV.setSelected(true);
                    }
                    
                    else if(ReiniciarSCACV.isSelected()){
                        ReiniciarSCACV.setSelected(false);
                        ApagarSCACV.setSelected(true);
                    }
                        
                        
                    


                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if(!Freno.isSelected() && Arrancar.isSelected()){
                    Acelerador.setEnabled(true);
                    Freno.setText("FRENAR");
                    Freno.setForeground(Color.BLACK);
                }
            }
        }.start();
 
    }//GEN-LAST:event_FrenoActionPerformed

    private void MantenerSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MantenerSCACVActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && MantenerSCACV.isSelected() && !ApagarSCACV.isSelected()){
                    FlechaApuntadoraMantener.setVisible(true);
                    Acelerador.setSelected(false);
                    Acelerador.setEnabled(false);
                    gestor.llamadaFiltros(EstadoMotor.CONSTANTE);

                    velalmacenada = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    VelocidadDisplay.setValue(velalmacenada);
                    velocimetro.setVelocidadAlmacenada(velalmacenada);
                    
                    cuentaKilometrosRadial.setValue(velalmacenada);
                    cuentaKilometrosRadial.repaint();
                    

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    cRevoluciones.setRevolucionesAlmacenada(revoluciones);
                    CuentaRevolucionesRadial.setValue(revoluciones);
                    CuentaRevolucionesRadial.repaint();

                    double distancia = Math.round(cKilometros.getDistancia()*100.0)/100.0;
                    
                    if(MantenerSCACV.isSelected() && Freno.isSelected())
                        ApagarSCACV.setSelected(true);
                    else
                        ApagarSCACV.setSelected(false);


                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if(!MantenerSCACV.isSelected() && Arrancar.isSelected()){
                    Acelerador.setEnabled(true);
                    Acelerador.setText("ACELERAR");
                    Acelerador.setForeground(Color.BLACK);
                    FlechaApuntadoraMantener.setVisible(false);
                }
            }
        }.start();
        
        
        
    }//GEN-LAST:event_MantenerSCACVActionPerformed

    private void ReiniciarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarSCACVActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && ReiniciarSCACV.isSelected()){
                    
                    if(!ApagarSCACV.isSelected()){
                    FlechaApuntadoraReiniciar.setVisible(true);
                    if(velocimetro.getVelocidad() < velalmacenada){
                        Acelerador.setSelected(false);
                        Acelerador.setEnabled(false);
                        gestor.llamadaFiltros(EstadoMotor.ACELERANDO);
                    }
                    else if (velocimetro.getVelocidad() > velalmacenada){
                        Acelerador.setSelected(false);
                        Acelerador.setEnabled(false);
                        gestor.llamadaFiltros(EstadoMotor.FRENANDO);
                    }
                    else if (velocimetro.getVelocidad() == velalmacenada){
                        gestor.llamadaFiltros(EstadoMotor.CONSTANTE);
                        Acelerador.setEnabled(true);
                        MantenerSCACV.setSelected(true);
                    }
                    
                    double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    if( velocidad < velalmacenada+7 && velocidad > velalmacenada-7){
                        velocidad = velalmacenada;
                    }
                    cuentaKilometrosRadial.setValue(velocidad);
                    cuentaKilometrosRadial.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    CuentaRevolucionesRadial.setValue(revoluciones);
                    CuentaRevolucionesRadial.repaint();


                    if(ReiniciarSCACV.isSelected() && Freno.isSelected())
                        ApagarSCACV.setSelected(true);
                    else
                        ApagarSCACV.setSelected(false);
                  
}
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(!ReiniciarSCACV.isSelected() && Arrancar.isSelected()){
                    Acelerador.setEnabled(true);
                    FlechaApuntadoraReiniciar.setVisible(false);
                }

            }
        }.start();
        
        
        
    }//GEN-LAST:event_ReiniciarSCACVActionPerformed

    private void ApagarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarSCACVActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && ApagarSCACV.isSelected()){
                    
                    FlechaApuntadoraParar.setVisible(true);
                    MantenerSCACV.setEnabled(false);
                    MantenerSCACV.setSelected(false);
                    ReiniciarSCACV.setSelected(false);
                    ReiniciarSCACV.setEnabled(false);
                    gestor.llamadaFiltros(EstadoMotor.CONSTANTE);
                  
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(!ApagarSCACV.isSelected() && Arrancar.isSelected()){
                    Acelerador.setEnabled(true);
                    ReiniciarSCACV.setEnabled(true);
                    MantenerSCACV.setEnabled(true);
                    FlechaApuntadoraParar.setVisible(false);
                }

            }
        }.start();
        
        
        
        
    }//GEN-LAST:event_ApagarSCACVActionPerformed

    private void CambioAceiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambioAceiteActionPerformed
        cRevoluciones.resetCambioAceite();
        this.CambioAceite.setEnabled(false);
    }//GEN-LAST:event_CambioAceiteActionPerformed

    private void CambioFrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambioFrenosActionPerformed
        cRevoluciones.resetCambioFrenos();
        this.CambioFrenos.setEnabled(false);
    }//GEN-LAST:event_CambioFrenosActionPerformed

    private void RevisionGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevisionGeneralActionPerformed
        cRevoluciones.resetRevisionGeneral();
        this.RevisionGeneral.setEnabled(false);
    }//GEN-LAST:event_RevisionGeneralActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Acelerador;
    private javax.swing.JToggleButton ApagarSCACV;
    private javax.swing.JToggleButton Arrancar;
    private javax.swing.JLabel AvisoAceite;
    private javax.swing.JLabel AvisoFrenos;
    private javax.swing.JLabel AvisoGeneral;
    private javax.swing.JButton CambioAceite;
    private javax.swing.JButton CambioFrenos;
    private eu.hansolo.steelseries.gauges.Radial3Lcd CuentaRevolucionesRadial;
    private javax.swing.JLabel FlechaApuntadoraAcelerar;
    private javax.swing.JLabel FlechaApuntadoraMantener;
    private javax.swing.JLabel FlechaApuntadoraParar;
    private javax.swing.JLabel FlechaApuntadoraReiniciar;
    private javax.swing.JToggleButton Freno;
    private eu.hansolo.steelseries.gauges.Radial1Square Gasolina;
    private javax.swing.JLabel LabbelVelocidadAlmacenada;
    private javax.swing.JLabel Mandos;
    private javax.swing.JToggleButton MantenerSCACV;
    private javax.swing.JToggleButton ReiniciarSCACV;
    private javax.swing.JButton RevisionGeneral;
    private javax.swing.JLabel Salpicadero;
    private eu.hansolo.steelseries.gauges.DisplayCircular VelocidadDisplay;
    private eu.hansolo.steelseries.gauges.Radial3Lcd cuentaKilometrosRadial;
    private javax.swing.JLabel estadoMotor;
    private javax.swing.JLabel estadoVehiculo;
    // End of variables declaration//GEN-END:variables
}
