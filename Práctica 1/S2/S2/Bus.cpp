#include "Bus.h"

Bus::Bus(string nom, float p){
    this->nombre = nom;
    this->precio = p;
}

void Bus::aceptar(VisitanteEquipo visitante, Cliente cliente){
    visitante.visitarBus(this,cliente);
}