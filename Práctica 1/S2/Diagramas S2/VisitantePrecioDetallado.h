#ifndef VISITANTEPRECIODETALLADO_H
#define VISITANTEPRECIODETALLADO_H

class VisitantePrecioDetallado : VisitanteEquipo {


public:
	void visitarDisco(Disco d);

	void visitarTarjeta(Tarjeta t);

	void visitarBus(Bus b);
};

#endif
