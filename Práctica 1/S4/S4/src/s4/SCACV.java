
package s4;

import static s4.Cliente.salpicadero;

import java.awt.Color;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SCACV extends javax.swing.JApplet {

    GUISalpicadero salpicadero;
    /**
     * Initializes the SCACV SCACV
     */
    
    public GestorFiltros gestor;
    protected CuentaKilometros cKilometros;
    protected Velocimetro velocimetro;
    protected CuentaRevoluciones cRevoluciones;
    
    long tinicio = 0, tactual = 0, tanterior = 0;
    private final double radio = 0.15;
    
    private boolean scacvActivado;
    private double velocidadAlmacenada;
    
    
    
    @Override
    public void init() {
        
        this.cKilometros = new CuentaKilometros();
        this.velocimetro = new Velocimetro();
        this.cRevoluciones = new CuentaRevoluciones();
        this.tinicio =  System.currentTimeMillis();
        
        this.estado.setText("APAGADO");
        this.estado.setForeground(Color.RED);
        this.Arrancar.setForeground(Color.GREEN);
        
        this.Acelerador.setEnabled(false);
        this.Freno.setEnabled(false);
        
        this.Velocidad.setText(String.valueOf(0.0));
        this.Revoluciones.setText(String.valueOf(0.0));
        this.Distancia.setText(String.valueOf(0.0));
            
            
        this.main(new String[0]);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SCACV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SCACV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SCACV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SCACV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the SCACV */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUISalpicadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUISalpicadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUISalpicadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUISalpicadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUISalpicadero().setVisible(true);
            }
        });
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
    
    

    
    
    
    
    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Salpicadero = new javax.swing.JPanel();
        Salpicadero1 = new javax.swing.JLabel();
        Velocimetro = new javax.swing.JLabel();
        Velocidad = new javax.swing.JTextField();
        Cuentakilómetros = new javax.swing.JLabel();
        Distancia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Revoluciones = new javax.swing.JTextField();
        Mandos = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        Arrancar = new javax.swing.JToggleButton();
        Acelerador = new javax.swing.JToggleButton();
        Freno = new javax.swing.JToggleButton();
        PararSCACV = new javax.swing.JToggleButton();
        AceleradorSCACV = new javax.swing.JToggleButton();
        MantenerSCACV = new javax.swing.JToggleButton();
        ReiniciarSCACV = new javax.swing.JToggleButton();

        Salpicadero1.setText("Salpicadero");

        Velocimetro.setText("Velocímetro");

        Velocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocidadActionPerformed(evt);
            }
        });

        Cuentakilómetros.setText("Cuentakilómetros");

        jLabel1.setText("Cuentarevoluciones");

        Mandos.setText("Mandos");

        estado.setText("Estado");

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

        PararSCACV.setText("Parar");

        AceleradorSCACV.setText("Acelerar");

        MantenerSCACV.setText("Mantener");

        ReiniciarSCACV.setText("Reiniciar");

        javax.swing.GroupLayout SalpicaderoLayout = new javax.swing.GroupLayout(Salpicadero);
        Salpicadero.setLayout(SalpicaderoLayout);
        SalpicaderoLayout.setHorizontalGroup(
            SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalpicaderoLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SalpicaderoLayout.createSequentialGroup()
                        .addComponent(Velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234)
                        .addComponent(estado))
                    .addGroup(SalpicaderoLayout.createSequentialGroup()
                        .addComponent(Velocimetro)
                        .addGap(263, 263, 263)
                        .addComponent(Mandos))
                    .addGroup(SalpicaderoLayout.createSequentialGroup()
                        .addComponent(Cuentakilómetros)
                        .addGap(189, 189, 189)
                        .addComponent(Arrancar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Acelerador, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Freno, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Distancia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(SalpicaderoLayout.createSequentialGroup()
                        .addComponent(Revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(PararSCACV)
                        .addGap(115, 115, 115)
                        .addComponent(MantenerSCACV)
                        .addContainerGap(154, Short.MAX_VALUE))))
            .addGroup(SalpicaderoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(Salpicadero1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalpicaderoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AceleradorSCACV)
                    .addComponent(ReiniciarSCACV))
                .addGap(264, 264, 264))
        );
        SalpicaderoLayout.setVerticalGroup(
            SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalpicaderoLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(Salpicadero1)
                .addGap(31, 31, 31)
                .addGroup(SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Velocimetro)
                    .addComponent(Mandos))
                .addGap(18, 18, 18)
                .addGroup(SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cuentakilómetros)
                    .addComponent(Arrancar)
                    .addComponent(Acelerador)
                    .addComponent(Freno))
                .addGap(20, 20, 20)
                .addComponent(Distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalpicaderoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalpicaderoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(AceleradorSCACV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SalpicaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PararSCACV)
                            .addComponent(MantenerSCACV))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReiniciarSCACV)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Salpicadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Salpicadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                        Logger.getLogger(GUISalpicadero.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(GUISalpicadero.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JToggleButton AceleradorSCACV;
    private javax.swing.JToggleButton Arrancar;
    private javax.swing.JLabel Cuentakilómetros;
    private javax.swing.JTextField Distancia;
    private javax.swing.JToggleButton Freno;
    private javax.swing.JLabel Mandos;
    private javax.swing.JToggleButton MantenerSCACV;
    private javax.swing.JToggleButton PararSCACV;
    private javax.swing.JToggleButton ReiniciarSCACV;
    private javax.swing.JTextField Revoluciones;
    private javax.swing.JPanel Salpicadero;
    private javax.swing.JLabel Salpicadero1;
    private javax.swing.JTextField Velocidad;
    private javax.swing.JLabel Velocimetro;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
