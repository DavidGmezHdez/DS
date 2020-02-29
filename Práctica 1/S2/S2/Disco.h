#ifndef DISCO_H
#define DISCO_H


#include <iostream>
#include <string>
#include "VisitanteEquipo.h"
#include "String.h"
#include "ComponenteEquipo.h"

using namespace std;

class Disco : public ComponenteEquipo{
    public:
        Disco(){};
        Disco(string nom, float p);
        void aceptar(VisitanteEquipo visitante, Cliente cliente);
};

#endif /* DISCO_H */

