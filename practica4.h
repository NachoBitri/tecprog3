#pragma once
#include <iostream>

using namespace std;
/*
 * Clase Transportable
 */
class Transportable {
private: //atributos
  double volumen;
  string nombre;
public:
  //constructor
  Transportable(double vol, string nom){
    this->volumen = vol;
    this->nombre = nom;
  	cout << "Se ha creado un " << this->nombre;
  }
  //getters
  double getVolumen() {
      return this->volumen;
  }
  void getVolumen2(){
    cout <<"con capacidad " <<getVolumen()<<".\n";
  }
  string getNombre() const{
    return this->nombre;
  }
};

/*
 * Clase Generico
 */
class Generico : public Transportable{
public:
  //constructor
  Generico(double vol, string nom) : Transportable(vol, nom){}
};
/*
 * Clase Toxico
 */
class Toxico : public Transportable {
public:
  //constructor
  Toxico(double vol, string nom) : Transportable(vol, nom) {
  	cout <<",un TOXICO "; getVolumen2();
  }
};
/*
 * Clase SerVivo
 */
class SerVivo : public Transportable {
public:
  //constructor
  SerVivo(double vol, string nom) : Transportable(vol, nom) {
  	cout <<",un SER VIVO "; getVolumen2();
  }
};
/*
 * Clase Producto
 */
class Producto : public Generico {
public:
  //constructor
  Producto(double vol, string nom) : Generico(vol, nom){
  	cout <<",un PRODUCTO "; getVolumen2();
  }
};
/*
 * Clase Guardable
 */
class Guardable {
private: //atributos
  double capacidad;
public:
  //constructor
  Guardable(double cap) : capacidad(cap) {}
  double getCapacidad() {
      return this->capacidad;
  }
  //funciones
  void actualizarCapacidad(double vol) {
    this->capacidad -= vol;
  }
  template<typename T>
  bool guardar(T elemento) {
    if (elemento.getVolumen()  > getCapacidad() ) { //si no cabe
      return false;                                 //devuelve false
    }else{ //si cabe, actualiza la capidad e informa por pantalla
      actualizarCapacidad(elemento.getVolumen());
      cout<<"Guardado elemento de cap. "<<elemento.getVolumen() <<". ";
      cout<<"Capacidad disponible: "<<getCapacidad()<<".\n";
      return true; // y devuelve true
    }
  }
};
/*
 * Clase Camion
 */
class Camion : public Guardable {
public:
  //constructor
  Camion(double cap) : Guardable(cap) {
    cout<<"Se ha creado un CAMION con capacidad " << cap << ". \n";
  }
  //funciones
  bool guardar(Generico elemento) {
    cout << "CAMION: ";
    return Guardable::guardar(elemento);
  }
};
/*
 * Clase Contenedor
 */
template<class T>
class Contenedor : public Guardable, public Generico {
public:
  //constructor
  Contenedor(double cap) : Guardable(cap), Generico(cap,"") {
  	cout<< "CONTENEDOR con capacidad " << cap << ". \n";
  }
  //funciones
  bool guardar(T elemento) {
    cout << "CONTENEDOR: ";
    return Guardable::guardar(elemento);
  }
};