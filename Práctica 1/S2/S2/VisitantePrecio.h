#ifndef VISITANTEPRECIO_H
#define VISITANTEPRECIO_H

#include <iostream>
#include <string>
#include "VisitanteEquipo.h"

using namespace std;

class VisitantePrecio : public VisitanteEquipo
{
    public:
        VisitantePrecio();
        void visitarDisco(Disco *d, Cliente cliente);
        void visitarTarjeta(Tarjeta *t, Cliente cliente);
        void visitarBus(Bus *b, Cliente cliente);
        inline void restaurar(){precioTotal = 0;};
};

#endif /* VISITANTEPRECIO_H */

