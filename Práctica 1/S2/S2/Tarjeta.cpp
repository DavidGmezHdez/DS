#include "Tarjeta.h"

Tarjeta::Tarjeta(string nom, float p){
    this->nombre = nom;
    this->precio = precio;
}

Tarjeta::aceptar(VisitanteEquipo visitante, Cliente cliente){
    visitante.visitarTarjeta(this,cliente);
}