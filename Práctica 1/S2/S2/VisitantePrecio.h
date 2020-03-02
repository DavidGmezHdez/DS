#ifndef VISITANTEPRECIO_H
#define VISITANTEPRECIO_H

#include <iostream>
#include <string>
#include "VisitanteEquipo.h"

using namespace std;

class VisitantePrecio : VisitanteEquipo{
    protected:
        float precioTotal;
    public:
        VisitantePrecio();
        void visitarDisco(Disco *d, Cliente cliente);
        void visitarTarjeta(Tarjeta *t, Cliente cliente);
        void visitarBus(Bus *b, Cliente cliente);
        inline float getPrecioTotal(){return precioTotal;};
};

#endif /* VISITANTEPRECIO_H */

