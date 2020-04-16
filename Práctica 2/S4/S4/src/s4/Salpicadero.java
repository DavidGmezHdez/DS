package s4;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Salpicadero extends javax.swing.JPanel {

    public GestorFiltros gestor;
    protected CuentaKilometros cKilometros;
    protected Velocimetro velocimetro;
    protected CuentaRevoluciones cRevoluciones;
    
    long tinicio = 0, tactual = 0, tanterior = 0;
    private final double radio = 0.15;
    
    
    public Salpicadero() {
        this.cKilometros = new CuentaKilometros();
        this.velocimetro = new Velocimetro();
        this.cRevoluciones = new CuentaRevoluciones();
        this.tinicio =  System.currentTimeMillis();
        this.gestor = new GestorFiltros(this);
        
        initComponents();
        
        this.estado.setText("APAGADO");
        this.estado.setForeground(Color.RED);
        this.Arrancar.setForeground(Color.GREEN);
        
        this.Acelerador.setEnabled(false);
        this.Freno.setEnabled(false);
        
        this.cuentaKilometrosRadial.setValue(0.0);
        CuentaRevolucionesRadial.setValue(0.0);

        
    }
    
    public void ejecutar(double revoluciones, EstadoMotor estadoMotor){
        
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
        estado = new javax.swing.JLabel();
        cuentaKilometrosRadial = new eu.hansolo.steelseries.gauges.Radial3Lcd();
        radial1Square1 = new eu.hansolo.steelseries.gauges.Radial1Square();
        CuentaRevolucionesRadial = new eu.hansolo.steelseries.gauges.Radial3Lcd();

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

        estado.setText("Estado");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(Salpicadero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 440, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Mandos)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(estado)
                        .addGap(226, 226, 226))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cuentaKilometrosRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radial1Square1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Arrancar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Acelerador, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Freno, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CuentaRevolucionesRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Arrancar)
                                    .addComponent(Acelerador)
                                    .addComponent(Freno))
                                .addGap(89, 89, 89)
                                .addComponent(CuentaRevolucionesRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(radial1Square1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Salpicadero)
                            .addComponent(Mandos))
                        .addGap(151, 151, 151)
                        .addComponent(cuentaKilometrosRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ArrancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArrancarActionPerformed
        if(this.Arrancar.isSelected()){
            if(this.gestor.getState() == Thread.State.RUNNABLE)
                this.gestor.start();

            this.estado.setText("ENCENDIDO");
            this.estado.setForeground(Color.GREEN);

            this.Arrancar.setText("APAGAR");
            this.Arrancar.setForeground(Color.RED);

            this.Acelerador.setEnabled(true);
            this.Freno.setEnabled(true);

        }
        else{
            this.estado.setText("APAGADO");
            this.estado.setForeground(Color.RED);

            this.Arrancar.setText("ENCENDER");
            this.Arrancar.setForeground(Color.GREEN);

            this.Acelerador.setEnabled(false);
            this.Freno.setEnabled(false);

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
                    gestor.llamadaFiltros(EstadoMotor.ENCENDIDO);

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
                while(Arrancar.isSelected() &&Freno.isSelected()){
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Acelerador;
    private javax.swing.JToggleButton Arrancar;
    private eu.hansolo.steelseries.gauges.Radial3Lcd CuentaRevolucionesRadial;
    private javax.swing.JToggleButton Freno;
    private javax.swing.JLabel Mandos;
    private javax.swing.JLabel Salpicadero;
    private eu.hansolo.steelseries.gauges.Radial3Lcd cuentaKilometrosRadial;
    private javax.swing.JLabel estado;
    private eu.hansolo.steelseries.gauges.Radial1Square radial1Square1;
    // End of variables declaration//GEN-END:variables
}
