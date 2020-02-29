#include "ComponenteEquipo.h"

ComponenteEquipo::ComponenteEquipo(string n, float p){
    this->nombre = n;
    this->precio = p;
}

string ComponenteEquipo::getNombre(){
    return this->nombre;
}

float ComponenteEquipo::getPrecio(){
    return this->precio;
}