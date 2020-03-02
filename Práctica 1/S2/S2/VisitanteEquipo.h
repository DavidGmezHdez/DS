#ifndef VISITANTEEQUIPO_H
#define VISITANTEEQUIPO_H

#include <iostream>
#include <string>
#include "Equipo.h"
#include "Bus.h"
#include "Disco.h"
#include "Tarjeta.h"

using namespace std;

class VisitanteEquipo{
    protected:
        float precioTotal;
    public:
        virtual void visitarDisco(Disco *d, Cliente cliente) = 0;
        virtual void visitarTarjeta(Tarjeta *t, Cliente cliente) = 0;
        virtual void visitarBus(Bus *b, Cliente cliente) = 0;
        inline float getPrecioTotal(){return precioTotal;};
};

#endif /* VISITANTEEQUIPO_H */

