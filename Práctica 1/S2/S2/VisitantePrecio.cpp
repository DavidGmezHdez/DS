#include "VisitantePrecio.h"

VisitantePrecio::VisitantePrecio(){
    this->precioTotal = 0;
}

void VisitantePrecio::visitarDisco(Disco *d, Cliente cliente){
    this->precioTotal += d->getPrecio() * cliente.getDescuento();
}

void VisitantePrecio::visitarTarjeta(Tarjeta *t, Cliente cliente){
    this->precioTotal += t->getPrecio() * cliente.getDescuento();
}

void VisitantePrecio::visitarBus(Bus *b, Cliente cliente){
    this->precioTotal += b->getPrecio() * cliente.getDescuento();
}
