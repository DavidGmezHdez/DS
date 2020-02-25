#ifndef DISCO_H
#define DISCO_H


#include <iostream>
#include <string>
#include "VisitanteEquipo.h"

using namespace std;

class Disco : ComponenteEquipo{
    public:
        void aceptar(VisitanteEquipo visitante);
    
};

#endif /* DISCO_H */

