#ifndef VISITANTEEQUIPO_H
#define VISITANTEEQUIPO_H

class VisitanteEquipo {


public:
	virtual void visitarDisco(Disco d) = 0;

	virtual void visitarTarjeta(Tarjeta t) = 0;

	virtual void visitarTarjeta(Bus b) = 0;
};

#endif
