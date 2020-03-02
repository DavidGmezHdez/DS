#include <cstdlib>
#include <iostream>
#include "Cliente.h"
#include "VisitantePrecio.h"
#include "VisitantePrecioDetallado.h"
#include "Equipo.h"
#include <vector>

using namespace std;


void resultados(Equipo *e,Cliente c, VisitantePrecio vp, VisitantePrecioDetallado vd){
    e->aceptar(vp,c);
    e->aceptar(vd,c);
    
    cout<<"El precio total del VisitantePrecio es de "<<vp.getPrecioTotal()<<" euros"<<endl;
    vd.mostrarResultados();
    
    vp.restaurar();
    vd.restaurar();
    
}

int main(int argc, char** argv) {
    Bus *bus1 = new Bus("Bus de datos 1",25.5);
    Bus *bus2 = new Bus("Bus de datos 2",30.5);
    
    Disco *disco1 = new Disco("Disco de datos 1",75.5);
    Disco *disco2 = new Disco("Disco de datos 2",80.5);
    
    Tarjeta *tarjeta1 = new Tarjeta("Tarjeta de Red 1", 50.5);
    Tarjeta *tarjeta2 = new Tarjeta("Tarjeta de Red 2",60.9);
    
    Equipo *equipo1 = new Equipo(bus1,disco1,tarjeta1);
    Equipo *equipo2 = new Equipo(bus2,disco2,tarjeta2);
    
    Cliente cliente = Cliente("Cliente",1);
    Cliente estudiante = Cliente("Estudiante",0.90);
    Cliente mayorista = Cliente("Mayorista",0.85);
    
    VisitantePrecio vp = VisitantePrecio();
    VisitantePrecioDetallado vd = VisitantePrecioDetallado();
    
    cout<<"VISITA DE UN CLIENTE NORMAL"<<endl;
    cout<<endl<<"Primer Equipo"<<endl;
    resultados(equipo1,cliente,vp,vd);        
    
    cout<<endl<<"Segundo Equipo"<<endl;
    resultados(equipo2,cliente,vp,vd); 
    
    cout<<endl<<"VISITA DE UN CLIENTE ESTUDIANTE"<<endl;
    cout<<endl<<"Primer Equipo"<<endl;
    resultados(equipo1,estudiante,vp,vd);        
    
    cout<<endl<<"Segundo Equipo"<<endl;
    resultados(equipo2,estudiante,vp,vd); 
    
    cout<<endl<<"VISITA DE UN CLIENTE MAYORISTA"<<endl;
    cout<<endl<<"Primer Equipo"<<endl;
    resultados(equipo1,mayorista,vp,vd);        
    
    cout<<endl<<"Segundo Equipo"<<endl;
    resultados(equipo2,mayorista,vp,vd); 
    
    
}
