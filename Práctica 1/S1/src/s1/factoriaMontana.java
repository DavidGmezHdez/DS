package s1;

import java.util.ArrayList;

public class factoriaMontana extends factoriaCarrerayBicicleta {

	public carreraMontana crearCarrera(ArrayList<Bicicleta> bicicletas) {
            carreraMontana carrera = new carreraMontana(bicicletas);
            return carrera;
	}

	public bicicletaMontana crearBicicleta(int id) {
            bicicletaMontana bicicleta = new bicicletaMontana(id);
            return bicicleta;
	}
}