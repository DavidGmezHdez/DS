package s1;

import java.util.ArrayList;

public class factoriaCarretera extends factoriaCarrerayBicicleta {

	public carreraCarretera crearCarrera(ArrayList<Bicicleta> bicicletas) {
		carreraCarretera carrera = new carreraCarretera(bicicletas);
                return carrera;
	}

	public bicicletaCarretera crearBicicleta(int id) {
		bicicletaCarretera bicicleta = new bicicletaCarretera(id);
                return bicicleta;
	}
}