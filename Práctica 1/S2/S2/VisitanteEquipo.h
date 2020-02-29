

#ifndef VISITANTEEQUIPO_H
#define VISITANTEEQUIPO_H

#include <iostream>
#include <string>
#include "ComponenteEquipo.h"
#include "Bus.h"
#include "Disco.h"
#include "Tarjeta.h"

using namespace std;

class VisitanteEquipo{
    protected:
        float precioTotal;
    public:
        virtual void visitarDisco(Disco d, Cliente cliente);
        virtual void visitarTarjeta(Tarjeta t, Cliente cliente);
        virtual void visitarBus(Bus b, Cliente cliente);
};

#endif /* VISITANTEEQUIPO_H */

