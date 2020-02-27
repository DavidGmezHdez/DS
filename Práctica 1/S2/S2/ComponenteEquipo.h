#ifndef COMPONENTEEQUIPO_H
#define COMPONENTEEQUIPO_H

#include <iostream>
#include <string>
#include "VisitanteEquipo.h"

using namespace std;

class ComponenteEquipo{
    private:
        String nombre;
        float precio;
    public:
        virtual void aceptar(VisitanteEquipo visitante);
    
};

#endif

