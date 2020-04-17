package s4;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Salpicadero extends javax.swing.JPanel {

    public GestorFiltros gestor;
    protected CuentaKilometros cKilometros;
    protected Velocimetro velocimetro;
    protected CuentaRevoluciones cRevoluciones;
    private EstadoVehiculo estadovehi;
    
    double vel = 0;
    double velalmacenada = 0;
    
    
    
    long tinicio = 0, tactual = 0, tanterior = 0;
    private final double radio = 0.15;
    
    
    public Salpicadero() {
        this.cKilometros = new CuentaKilometros();
        this.velocimetro = new Velocimetro();
        this.cRevoluciones = new CuentaRevoluciones();
        this.tinicio =  System.currentTimeMillis();
        this.gestor = new GestorFiltros(this);
        
        initComponents();
        
        this.estadoMotor.setText("APAGADO");
        this.estadoMotor.setForeground(Color.RED);
        this.Arrancar.setForeground(Color.GREEN);
        
        this.Acelerador.setEnabled(false);
        this.Freno.setEnabled(false);
        
        this.cuentaKilometrosRadial.setValue(0.0);
        CuentaRevolucionesRadial.setValue(0.0);

        
    }
    
    public void ejecutar(double revoluciones, EstadoMotor estadoMotor){
        System.out.println(estadoMotor);
        System.out.println(this.velocimetro.getVelocidad());
        System.out.println(this.velocimetro.getVelocidadAlmacenada());
        System.out.println(this.cRevoluciones.getRevoluciones());
        System.out.println(this.cRevoluciones.getRevolucionesAlmacenadas());
        switch(estadoMotor){
            case ACELERANDO:
                this.tanterior = this.tactual;
                this.tactual = System.currentTimeMillis();
                this.cRevoluciones.setRevoluciones(revoluciones);
                this.velocimetro.setVelocidad(2*Math.PI*radio*this.cRevoluciones.getRevoluciones()*((double)(60.0/1000.0)));
                this.cKilometros.setDistancia(this.velocimetro.getVelocidad() * (this.tactual - this.tanterior)/3600000);
                
            case FRENANDO:
                this.tanterior = this.tactual;
                this.tactual = System.currentTimeMillis();
                this.cRevoluciones.setRevoluciones(revoluciones);

                this.velocimetro.setVelocidad((-1) * 2*Math.PI*radio*this.cRevoluciones.getRevoluciones()*((double)(60.0/1000.0)));
                this.cKilometros.setDistancia(this.velocimetro.getVelocidad() * (this.tactual-this.tanterior)/3600000);
                
            case CONSTANTE:
                this.tanterior = this.tactual;
                this.tactual = System.currentTimeMillis();
                this.cRevoluciones.setRevoluciones(revoluciones);
                this.velocimetro.setVelocidad(2*Math.PI*radio*this.cRevoluciones.getRevoluciones()*((double)(60.0/1000.0)));
                this.cKilometros.setDistancia(this.velocimetro.getVelocidad() * (this.tactual - this.tanterior)/3600000);
                
                
            
                
            default:
                this.tactual = System.currentTimeMillis();
        };
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
        radial1Square1 = new eu.hansolo.steelseries.gauges.Radial1Square();
        CuentaRevolucionesRadial = new eu.hansolo.steelseries.gauges.Radial3Lcd();
        MantenerSCACV = new javax.swing.JToggleButton();
        ReiniciarSCACV = new javax.swing.JToggleButton();
        ApagarSCACV = new javax.swing.JToggleButton();
        estadoVehiculo = new javax.swing.JLabel();

        Salpicadero.setText("Salpicadero");

        Mandos.setText("Mandos");

        Arrancar.setText("ENCENDER");
        Arrancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrancarActionPerformed(evt);
            }
        });

        Acelerador.setText("ACELERAR");
        Acelerador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceleradorActionPerformed(evt);
            }
        });

        Freno.setText("FRENO");
        Freno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrenoActionPerformed(evt);
            }
        });

        estadoMotor.setText("Estado");

        cuentaKilometrosRadial.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.RED);
        cuentaKilometrosRadial.setTitle("Velocímetro");
        cuentaKilometrosRadial.setUnitString("km/h");

        radial1Square1.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.RED);
        radial1Square1.setTitle("Gasolina");
        radial1Square1.setUnitString("Litros");

        CuentaRevolucionesRadial.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.RED);
        CuentaRevolucionesRadial.setMaxValue(5000.0);
        CuentaRevolucionesRadial.setTitle("CuentaRevoluciones");
        CuentaRevolucionesRadial.setUnitString("RPM");

        MantenerSCACV.setText("Mantener");
        MantenerSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MantenerSCACVActionPerformed(evt);
            }
        });

        ReiniciarSCACV.setText("Reiniciar");
        ReiniciarSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarSCACVActionPerformed(evt);
            }
        });

        ApagarSCACV.setText("Parar");
        ApagarSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarSCACVActionPerformed(evt);
            }
        });

        estadoVehiculo.setText("Vehiculo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(Salpicadero)
                .addGap(304, 789, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cuentaKilometrosRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radial1Square1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CuentaRevolucionesRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Freno, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(MantenerSCACV)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ReiniciarSCACV)))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(Acelerador, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(ApagarSCACV)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(Arrancar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(estadoMotor)
                                .addGap(106, 106, 106)
                                .addComponent(estadoVehiculo)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Mandos)
                                .addGap(156, 156, 156))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(Mandos)
                        .addGap(5, 5, 5)
                        .addComponent(estadoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Arrancar)
                        .addGap(30, 30, 30)
                        .addComponent(CuentaRevolucionesRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(estadoVehiculo)
                        .addGap(18, 18, 18)
                        .addComponent(Freno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Acelerador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MantenerSCACV)
                            .addComponent(ReiniciarSCACV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ApagarSCACV))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(radial1Square1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Salpicadero)
                        .addGap(151, 151, 151)
                        .addComponent(cuentaKilometrosRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
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
            this.Freno.setEnabled(true);
            ApagarSCACV.setEnabled(false);
            

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
            

            this.Acelerador.setSelected(false);
            this.Acelerador.setText("ACELERAR");
            this.Acelerador.setForeground(Color.BLACK);

            this.Freno.setSelected(false);
            this.Freno.setText("FRENAR");
            this.Freno.setForeground(Color.BLACK);
            
        }

        new Thread(){
            public void run(){
                while(Arrancar.isSelected()){
                    //gestor.llamadaFiltros(EstadoMotor.ENCENDIDO);

                    double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    cuentaKilometrosRadial.setValue(velocidad);
                    cuentaKilometrosRadial.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    CuentaRevolucionesRadial.setValue(revoluciones);
                    CuentaRevolucionesRadial.repaint();

                    double distancia = Math.round(cKilometros.getDistancia()*100.0)/100.0;
                    
                }
            }
        }.start();

    }//GEN-LAST:event_ArrancarActionPerformed

    private void AceleradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceleradorActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && Acelerador.isSelected()){
                    Freno.setEnabled(false);
                    Acelerador.setText("Soltar Acelerador");
                    Acelerador.setForeground(Color.RED);
                    gestor.llamadaFiltros(EstadoMotor.ACELERANDO);
                    
                    MantenerSCACV.setEnabled(true);
                    ReiniciarSCACV.setEnabled(true);
                    ApagarSCACV.setEnabled(true);

                    double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    cuentaKilometrosRadial.setValue(velocidad);
                    cuentaKilometrosRadial.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    CuentaRevolucionesRadial.setValue(revoluciones);
                    CuentaRevolucionesRadial.repaint();

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
                while(Arrancar.isSelected() && MantenerSCACV.isSelected()){
                   
                    Acelerador.setSelected(false);
                    Acelerador.setEnabled(false);
                    gestor.llamadaFiltros(EstadoMotor.CONSTANTE);

                    

                    double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    velocimetro.setVelocidadAlmacenada(velocidad);
                    cuentaKilometrosRadial.setValue(velocidad);
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
                }
            }
        }.start();
        
        
        
    }//GEN-LAST:event_MantenerSCACVActionPerformed

    private void ReiniciarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarSCACVActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && ReiniciarSCACV.isSelected()){
                   
                    if(velocimetro.getVelocidad() < velocimetro.getVelocidadAlmacenada()){
                        Acelerador.setSelected(false);
                        Acelerador.setEnabled(false);
                        gestor.llamadaFiltros(EstadoMotor.ACELERANDO);
                    }
                    else if (velocimetro.getVelocidad() > velocimetro.getVelocidadAlmacenada()){
                        Acelerador.setSelected(false);
                        Acelerador.setEnabled(false);
                        gestor.llamadaFiltros(EstadoMotor.FRENANDO);
                    }
                    else if (velocimetro.getVelocidad() == velocimetro.getVelocidadAlmacenada()){
                        gestor.llamadaFiltros(EstadoMotor.CONSTANTE);
                        Acelerador.setEnabled(true);
                    }

                    if(ReiniciarSCACV.isSelected() && Freno.isSelected())
                        ApagarSCACV.setSelected(true);
                    else
                        ApagarSCACV.setSelected(false);
                  

                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(!ReiniciarSCACV.isSelected() && Arrancar.isSelected()){
                    Acelerador.setEnabled(true);
                }

            }
        }.start();
        
        
        
    }//GEN-LAST:event_ReiniciarSCACVActionPerformed

    private void ApagarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarSCACVActionPerformed
        new Thread(){
            public void run(){
                while(Arrancar.isSelected() && ApagarSCACV.isSelected()){
                    
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
                
                if(!ReiniciarSCACV.isSelected() && Arrancar.isSelected()){
                    Acelerador.setEnabled(true);
                }

            }
        }.start();
        
        
        
        
    }//GEN-LAST:event_ApagarSCACVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Acelerador;
    private javax.swing.JToggleButton ApagarSCACV;
    private javax.swing.JToggleButton Arrancar;
    private eu.hansolo.steelseries.gauges.Radial3Lcd CuentaRevolucionesRadial;
    private javax.swing.JToggleButton Freno;
    private javax.swing.JLabel Mandos;
    private javax.swing.JToggleButton MantenerSCACV;
    private javax.swing.JToggleButton ReiniciarSCACV;
    private javax.swing.JLabel Salpicadero;
    private eu.hansolo.steelseries.gauges.Radial3Lcd cuentaKilometrosRadial;
    private javax.swing.JLabel estadoMotor;
    private javax.swing.JLabel estadoVehiculo;
    private eu.hansolo.steelseries.gauges.Radial1Square radial1Square1;
    // End of variables declaration//GEN-END:variables
}
