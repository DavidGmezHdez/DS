package s1;

import java.util.ArrayList;

public class factoriaCarretera extends factoriaCarrerayBicicleta {

	public carreraCarretera crearCarrera(int codigo) {
		carreraCarretera carrera = new carreraCarretera(codigo);
                return carrera;
	}

	public bicicletaCarretera crearBicicleta(int id) {
		bicicletaCarretera bicicleta = new bicicletaCarretera(id);
                return bicicleta;
	}
}