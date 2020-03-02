#include "VisitantePrecioDetallado.h"
#include "VisitanteEquipo.h"

using namespace std;

VisitantePrecioDetallado::VisitantePrecioDetallado(){
    this->restaurar();
}

void VisitantePrecioDetallado::visitarBus(Bus *b, Cliente cliente){
    this->equipos.push_back(pair<string,float>(b->getNombre(),b->getPrecio()*cliente.getDescuento()));
    this->precioTotal += b->getPrecio()*cliente.getDescuento();
}

void VisitantePrecioDetallado::visitarDisco(Disco *d, Cliente cliente){
    this->equipos.push_back(pair<string,float>(d->getNombre(),d->getPrecio()*cliente.getDescuento()));
    this->precioTotal += d->getPrecio()*cliente.getDescuento();
}

void VisitantePrecioDetallado::visitarTarjeta(Tarjeta *t, Cliente cliente){
    this->equipos.push_back(pair<string,float>(t->getNombre(),t->getPrecio()*cliente.getDescuento()));
    this->precioTotal += t->getPrecio()*cliente.getDescuento();
}

void VisitantePrecioDetallado::restaurar(){
    this->equipos.clear();
    this->precioTotal = 0;
}

void VisitantePrecioDetallado::mostrarResultados(){
    cout<<"El equipo tiene las siguientes componentes: "<<endl;
    cout<<"Un bus de datos con nombre "<<equipos[0].first<<" y precio "<<equipos[0].second<<endl;
    cout<<"Un disco de datos con nombre "<<equipos[1].first<<" y precio "<<equipos[1].second<<endl;
    cout<<"Una tarjeta de red con nombre "<<equipos[2].first<<" y precio "<<equipos[2].second<<endl;
    cout<<"El precio total de todo esto es de "<<this->getPrecioTotal()<<"euros"<<endl;
}