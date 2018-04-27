/*
 * Nombre: 	Miguel Bentué Blanco (719378)
 * 			Ignacio Bitrián Arcas(717901)
 * Coms: Archivo Nodo.java perteneciente a la 3a practica de TecProg
 */
abstract class Nodo{
	//Atributos
	private String nombre;
	//Funciones
	//setters
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	//getters
	public String getNombre(){
		return nombre;
	}

	abstract public int getTamanyo();
}
