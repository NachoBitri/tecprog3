#ifndef PRACTICA4_H
#define PRACTICA4_H

#include <iostream>

using namespace std;
class Transportar {
    double volumen;
    string nombre;
public:
	Transportar();
};
//probando push

class Generico : public Transportar{
public:
	Generico();
};

class Toxico : public Transportar {
public:
	Toxico();
};

class SerVivo : public Transportar {
public:
	SerVivo();
};

class Producto : public Generico {
public:
	Producto(double volumen, String nombre) : volumen(volumen), nombre(nombre) {}
};

class Guardar {
    double capacidad;
public:
	Guardar();
};

class Camion : public Guardar {
public:
	Camion(int capacidad) : capacidad(capacidad) {}
};

template<class T>
class Contenedor : public Guardar, public Generico {
public:
	Contenedor();
};

#endif //PRACTICA4_H
