#include "Tarjeta.h"
#include "VisitanteEquipo.h"
#include "VisitantePrecio.h"
#include "VisitantePrecioDetallado.h"

Tarjeta::Tarjeta(string nom, float p){
    this->nombre = nom;
    this->precio = precio;
}

void Tarjeta::aceptar(VisitanteEquipo &visitante, Cliente &cliente){
    visitante.visitarTarjeta(this,cliente);
}