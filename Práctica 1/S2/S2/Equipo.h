
#ifndef EQUIPO_H
#define EQUIPO_H

#include <iostream>
#include <string>
#include "Cliente.h"
#include "Bus.h"
#include "Disco.h"
#include "Tarjeta.h"

class Equipo{
    protected:
        Bus b;
        Tarjeta t;
        Disco d;
    public:
        Equipo(){};
        Equipo(Bus bs, Tarjeta tar, Disco disc);
        void aceptar(VisitanteEquipo visitante, Cliente cliente);
};

#endif /* EQUIPO_H */

