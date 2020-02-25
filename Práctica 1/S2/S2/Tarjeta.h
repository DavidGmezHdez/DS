#ifndef TARJETA_H
#define TARJETA_H

#include <iostream>
#include <string>

#include "VisitanteEquipo.h"

using namespace std;

class Tarjeta : ComponenteEquipo{
    public:
        void aceptar(VisitanteEquipo visitante);
    
};


#endif /* TARJETA_H */

