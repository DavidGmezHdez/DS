#ifndef VISITANTEPRECIODETALLADO_H
#define VISITANTEPRECIODETALLADO_H

#include <iostream>
#include <string>
#include <vector>
#include "VisitanteEquipo.h"

using namespace std;

class VisitantePrecioDetallado : public VisitanteEquipo
{
    private:
        vector<pair<string,float>> equipos;
    public:
        VisitantePrecioDetallado();
        void visitarDisco(Disco *d, Cliente cliente);
        void visitarTarjeta(Tarjeta *t, Cliente cliente);
        void visitarBus(Bus *b, Cliente cliente);
        void restaurar();
        void mostrarResultados();

};

#endif /* VISITANTEPRECIODETALLADO_H */

