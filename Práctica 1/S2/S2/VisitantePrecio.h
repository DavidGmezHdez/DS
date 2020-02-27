#ifndef VISITANTEPRECIO_H
#define VISITANTEPRECIO_H

#include <iostream>
#include <string>
#include "ComponenteEquipo.h"

using namespace std;

class VisitantePrecio : VisitanteEquipo{
    public:
        void visitarDisco(Disco d);
        void visitarTarjeta(Tarjeta t);
        void visitarBus(Bus b);
};

#endif /* VISITANTEPRECIO_H */

