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
        
        this.Velocidad.setText(String.valueOf(0.0));
        this.Revoluciones.setText(String.valueOf(0.0));
        this.Distancia.setText(String.valueOf(0.0));
        
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
        Velocimetro = new javax.swing.JLabel();
        Velocidad = new javax.swing.JTextField();
        Cuentakilómetros = new javax.swing.JLabel();
        Distancia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Revoluciones = new javax.swing.JTextField();
        Mandos = new javax.swing.JLabel();
        Arrancar = new javax.swing.JToggleButton();
        Acelerador = new javax.swing.JToggleButton();
        Freno = new javax.swing.JToggleButton();
        estado = new javax.swing.JLabel();

        Salpicadero.setText("Salpicadero");

        Velocimetro.setText("Velocímetro");

        Velocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocidadActionPerformed(evt);
            }
        });

        Cuentakilómetros.setText("Cuentakilómetros");

        jLabel1.setText("Cuentarevoluciones");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(Salpicadero))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Velocimetro)
                                .addComponent(Cuentakilómetros)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(Distancia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Mandos)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Arrancar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Acelerador, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Freno, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(estado)
                        .addGap(226, 226, 226))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Salpicadero)
                            .addComponent(Mandos))
                        .addGap(28, 28, 28)
                        .addComponent(Velocimetro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Arrancar)
                            .addComponent(Acelerador)
                            .addComponent(Freno))))
                .addGap(28, 28, 28)
                .addComponent(Cuentakilómetros)
                .addGap(18, 18, 18)
                .addComponent(Distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(Revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void VelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VelocidadActionPerformed

    }//GEN-LAST:event_VelocidadActionPerformed

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
                    gestor.llamadaFiltros(EstadoMotor.CONSTANTE);

                    double velocidad = Math.round(velocimetro.getVelocidad()* 100.0)/100.0;
                    Velocidad.setText(String.valueOf(velocidad));
                    Velocidad.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    Revoluciones.setText(String.valueOf(revoluciones));
                    Revoluciones.repaint();

                    double distancia = Math.round(cKilometros.getDistancia()*100.0)/100.0;
                    Distancia.setText(String.valueOf(distancia));
                    Distancia.repaint();
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
                    Velocidad.setText(String.valueOf(velocidad));
                    Velocidad.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    Revoluciones.setText(String.valueOf(revoluciones));
                    Revoluciones.repaint();

                    double distancia = Math.round(cKilometros.getDistancia()*100.0)/100.0;
                    Distancia.setText(String.valueOf(distancia));
                    Distancia.repaint();

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
                    Velocidad.setText(String.valueOf(velocidad));
                    Velocidad.repaint();

                    double revoluciones = Math.round(cRevoluciones.getRevoluciones()*100.0)/100.0;
                    Revoluciones.setText(String.valueOf(revoluciones));
                    Revoluciones.repaint();

                    double distancia = Math.round(cKilometros.getDistancia()*100.0)/100.0;
                    Distancia.setText(String.valueOf(distancia));
                    Distancia.repaint();

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
    private javax.swing.JLabel Cuentakilómetros;
    private javax.swing.JTextField Distancia;
    private javax.swing.JToggleButton Freno;
    private javax.swing.JLabel Mandos;
    private javax.swing.JTextField Revoluciones;
    private javax.swing.JLabel Salpicadero;
    private javax.swing.JTextField Velocidad;
    private javax.swing.JLabel Velocimetro;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
