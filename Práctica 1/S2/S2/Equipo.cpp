#include "Equipo.h"

Equipo::Equipo(Bus *bs,Disco *disc, Tarjeta *tar){
    this->b = bs;
    this->d = disc;
    this->t = tar;
}

void Equipo::aceptar(VisitanteEquipo& visitante, Cliente cliente){
    this->b->aceptar(visitante,cliente);
    this->d->aceptar(visitante,cliente);
    this->t->aceptar(visitante,cliente);
}