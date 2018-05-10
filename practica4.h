#ifndef PRACTICA4_H
#define PRACTICA4_H

#include <iostream>

using namespace std;
/*
 * La clase Transportar se usa para como clase padre para
 * representar aquellos elementos que pueden ser transportados
 */
class Transportar {
private:
    double volumen;
    string nombre;
public:
	Transportar(double vol, string nom){
		this->volumen = vol;
		this->nombre = nombre;
	}
	double getVolumen(){
		return this->volumen;
	}
	void setVolumen(double vol){
		this->volumen = vol;
	}
};
//probando push

class Generico : public Transportar{
public:
	Generico(double volumen, string nombre):
	 		Transportar(volumen,nombre) {}
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
	Producto(double volumen, string nombre) : 
		Generico(volumen, nombre) {}
};

class Guardar {
private:
    double capacidad;
public:
	Guardar(double cap) : capacidad(cap);
	double getCapacidad(){
		return this->capacidad;
	}
	void setCapacidad(){
		this->capacidad = cap;
	}
};

class Camion : public Guardar {
public:
	Camion(double cap) : Guardar(capacidad) {}
};

template<class T>
class Contenedor : public Guardar, public Generico {
public:
	Contenedor();
};

#endif //PRACTICA4_H
