
package s4;

import javax.swing.JApplet;
import static s4.Cliente.salpicadero;

public class applet extends JApplet {

    public void init() {
        salpicadero =  new GUISalpicadero();
        salpicadero.main(new String[0]);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
