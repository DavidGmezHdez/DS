package s1;
public abstract class Bicicleta {
    private int id;
    
    Bicicleta(int id){
        this.id = id;
    }
    
    int getID(){
        return this.id;
    }
    
    @Override
    public String toString(){
        return "Bicicleta numero " + id + "\n";
    }
}