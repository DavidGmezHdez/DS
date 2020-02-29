#include "VisitantePrecioDetallado.h"

VisitantePrecioDetallado::VisitantePrecioDetallado(){
    this->restaurar();
}

void VisitantePrecioDetallado::visitarDisco(Disco d, Cliente cliente){
    this->equipos.push_back(d.getNombre(),d.getPrecio()*cliente.getDescuento());
}

void VisitantePrecioDetallado::visitarTarjeta(Tarjeta t, Cliente cliente){
    this->equipos.push_back(t.getNombre(),t.getPrecio()*cliente.getDescuento());
}

void VisitantePrecioDetallado::visitarBus(Bus b, Cliente cliente){
    this->equipos.push_back(b.getNombre(),b.getPrecio()*cliente.getDescuento());
}

void VisitantePrecioDetallado::restaurar(){
    this->equipos.clear();
}