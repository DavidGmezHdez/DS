#ifndef TARJETA_H
#define TARJETA_H

#include <iostream>
#include <string>
#include "ComponenteEquipo.h"

using namespace std;

class Tarjeta : public ComponenteEquipo{
    public:
        Tarjeta(){};
        Tarjeta(string nom, float p);
        void aceptar(VisitanteEquipo &visitante, Cliente &cliente);
    
};


#endif /* TARJETA_H */

