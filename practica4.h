#ifndef PRACTICA4_H
#define PRACTICA4_H

#include <iostream>

using namespace std;
class Transportable {
    double vol;
    string name;
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
    double capacity;
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
