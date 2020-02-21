package s1;
public class Proyecto {
    
    private static Cliente cliente = new Cliente();
    
    public static void correrCarreras(){
        for(int i=0;i<cliente.getCarreras().size();i++){
            cliente.getCarreras().get(i).start();
        }
        try {
            Thread.sleep(100);
         } catch (Exception e) {
            System.out.println(e);
         }
    }
    
    public static void obtenerRankings(){
        for(int i=0;i<cliente.getCarreras().size();i++){
            cliente.getCarreras().get(i).mostrarRanking();
        }
    }
    
    public static void main(String[] args) {
        cliente.gestionar();
        cliente.getCarreras().get(0).mostrarBicicletas();
        correrCarreras();
        obtenerRankings();      
    }
}
