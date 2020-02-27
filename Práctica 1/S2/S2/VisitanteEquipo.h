

#ifndef VISITANTEEQUIPO_H
#define VISITANTEEQUIPO_H

#include <iostream>
#include <string>
#include "ComponenteEquipo.h"

using namespace std;

class VisitanteEquipo{
    public:
        virtual void visitarDisco(Disco d);
        virtual void visitarTarjeta(Tarjeta t);
        virtual void visitarBus(Bus b);
};

#endif /* VISITANTEEQUIPO_H */

