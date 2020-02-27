#ifndef VISITANTEPRECIODETALLADO_H
#define VISITANTEPRECIODETALLADO_H

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

#endif /* VISITANTEPRECIODETALLADO_H */

