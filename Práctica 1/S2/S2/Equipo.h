
#ifndef EQUIPO_H
#define EQUIPO_H

#include <iostream>
#include <string>
#include "Cliente.h"
#include "Bus.h"
#include "Disco.h"
#include "Tarjeta.h"
#include "VisitanteEquipo.h"

class Equipo{
    protected:
        Bus *b;
        Disco *d;
        Tarjeta *t;
    public:
        Equipo(){};
        Equipo(Bus *bs,Disco *disc, Tarjeta *tar);
        void aceptar(VisitanteEquipo& visitante, Cliente cliente);
};

#endif /* EQUIPO_H */

