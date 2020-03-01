
#ifndef CLIENTE_H
#define CLIENTE_H

#include <iostream>
#include <string>
#include "String.h"

using namespace std;

class Cliente{
    protected:
        string nombre;
        float descuento;
    public:
        Cliente(){};
        Cliente(string nom, float d);
        inline float getDescuento(){return descuento;};
        inline string getNombre(){return nombre;};
};

#endif /* CLIENTE_H */

