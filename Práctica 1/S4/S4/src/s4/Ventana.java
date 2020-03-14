
package s4;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
    public Ventana(){
        this.setSize(500, 700);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setTitle("Salpicadero");
        
        this.setLocationRelativeTo(null);
        
        this.iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        panel.setBackground(Color.yellow);
        JPanel salpicadero = new JPanel();
        
        
        this.getContentPane().add(panel);
        
        JLabel salpicadero = new JLabel("Salpicadero");
        panel.add(salpicadero);
        salpicadero.setBounds(20, 20, 80, 30);
        salpicadero.setOpaque(true);
        salpicadero.setBackground(Color.BLUE);
        
        JLabel vel = new JLabel("Velocimetro");
        panel.add(vel);
        vel.setBounds(40, 60, 80, 30);
        vel.setOpaque(true);
        vel.setBackground(Color.BLUE);
        
        JLabel vel = new JLabel("Velocimetro");
        panel.add(vel);
        vel.setBounds(40, 60, 80, 30);
        vel.setOpaque(true);
        vel.setBackground(Color.BLUE);
        
    }
}
