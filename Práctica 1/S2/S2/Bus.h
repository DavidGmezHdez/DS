#ifndef BUS_H
#define BUS_H

#include <iostream>
#include <string>
#include "VisitanteEquipo.h"
#include "String.h"
#include "ComponenteEquipo.h"

using namespace std;

class Bus : public ComponenteEquipo{
    public:
        Bus(){};
        Bus(string nom, float p);
        void aceptar(VisitanteEquipo visitante, Cliente cliente);
};


#endif /* BUS_H */

