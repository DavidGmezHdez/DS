package s1;

import java.util.ArrayList;

public class factoriaMontana implements factoriaCarrerayBicicleta {

	public carreraMontana crearCarrera(int codigo) {
            carreraMontana carrera = new carreraMontana(codigo);
            return carrera;
	}

	public bicicletaMontana crearBicicleta(int id) {
            bicicletaMontana bicicleta = new bicicletaMontana(id);
            return bicicleta;
	}
}