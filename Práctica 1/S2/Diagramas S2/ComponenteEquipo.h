#ifndef COMPONENTEEQUIPO_H
#define COMPONENTEEQUIPO_H

class ComponenteEquipo {

private:
	String nombre;
	float precio;

public:
	virtual void aceptar(VisitanteEquipo visitante) = 0;
};

#endif
