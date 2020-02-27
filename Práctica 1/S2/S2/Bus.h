#ifndef BUS_H
#define BUS_H

#include <iostream>
#include <string>
#include "VisitanteEquipo.h"

using namespace std;

class Bus : ComponenteEquipo{
    public:
        void aceptar(VisitanteEquipo visitante);
    
};


#endif /* BUS_H */

