package s4;
public class Cliente  {
    public static GestorFiltros gestorFiltros;
    
    public static void main(String[] args) {
        /*gestorFiltros =  new GestorFiltros();
        ((Thread)gestorFiltros).start();*/
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
