//
// Diseñado por Pedro Ramoneda Franco y Osmar de la Fuente Maicas a día 27/4/17.
//

#ifndef PRACTICA4_H
#define PRACTICA4_H

#include <iostream>

using namespace std;
class Transportable {
    double volumen;
    string nombre;
public:
};


class Generico : public Transportable{
public:
};

class Toxico : public Transportable {
public:
};

class SerVivo : public Transportable {
public:
};
class Producto : public Generico {
public:
};
class Guardable {
private:
    double capacidad;
public:
};

class Camion : public Guardable {
public:
};

template<class T>
class Contenedor : public Guardable, public Generico {
public:
};

#endif //PRACTICA4_H
