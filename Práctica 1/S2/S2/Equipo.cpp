#include "Equipo.h"

Equipo::Equipo(Bus bs, Tarjeta tar, Disco disc){
    this->b = bs;
    this->t = tar;
    this->d = disc;
}

void Equipo::aceptar(VisitanteEquipo visitante, Cliente cliente){
    this->b.aceptar(visitante,cliente);
    this->t.aceptar(visitante,cliente);
    this->d.aceptar(visitante,cliente);
}