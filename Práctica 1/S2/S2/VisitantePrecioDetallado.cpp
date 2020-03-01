#include "VisitantePrecioDetallado.h"

using namespace std;

VisitantePrecioDetallado::VisitantePrecioDetallado(){
    this->restaurar();
}

void VisitantePrecioDetallado::visitarDisco(Disco *d, Cliente cliente){
    this->equipos.push_back(pair<string,float>(d->getNombre(),d->getPrecio()*cliente.getDescuento()));
}

void VisitantePrecioDetallado::visitarTarjeta(Tarjeta *t, Cliente cliente){
    this->equipos.push_back(pair<string,float>(t->getNombre(),t->getPrecio()*cliente.getDescuento()));
}

void VisitantePrecioDetallado::visitarBus(Bus *b, Cliente cliente){
    this->equipos.push_back(pair<string,float>(b->getNombre(),b->getPrecio()*cliente.getDescuento()));
}

void VisitantePrecioDetallado::restaurar(){
    this->equipos.clear();
}