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
    public:
        virtual void visitarDisco(Disco *d, Cliente cliente);
        virtual void visitarTarjeta(Tarjeta *t, Cliente cliente);
        virtual void visitarBus(Bus *b, Cliente cliente);
        ~VisitanteEquipo();
};

#endif /* VISITANTEEQUIPO_H */

