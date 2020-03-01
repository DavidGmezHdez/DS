#include "Disco.h"
#include "VisitanteEquipo.h"
#include "VisitantePrecio.h"
#include "VisitantePrecioDetallado.h"

Disco::Disco(string nom, float p){
    this->nombre = nom;
    this->precio = p;
}

void Disco::aceptar(VisitanteEquipo &visitante, Cliente &cliente){
    visitante.visitarDisco(this,cliente);
}

