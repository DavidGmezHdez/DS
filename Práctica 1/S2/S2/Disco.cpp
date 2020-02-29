#include "Disco.h"

Disco::Disco(string nom, float p){
    this->nombre = nom;
    this->precio = p;
}

void Disco::aceptar(VisitanteEquipo visitante, Cliente cliente){
    visitante.visitarDisco(this,cliente);
}

