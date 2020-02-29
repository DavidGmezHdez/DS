#ifndef COMPONENTEEQUIPO_H
#define COMPONENTEEQUIPO_H

#include <iostream>
#include <string>
#include "VisitanteEquipo.h"
#include "Cliente.h"

using namespace std;
class ComponenteEquipo{
    protected:
        string nombre;
        float precio;
    public:
        ComponenteEquipo(){};
        ComponenteEquipo(string n, float p);
        float getPrecio();
        std::string getNombre();
        virtual void aceptar(VisitanteEquipo visitante, Cliente cliente);

    
};

#endif

