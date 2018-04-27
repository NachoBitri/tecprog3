/*
 * Nombre: 	Miguel Bentué Blanco (719378)
 * 			Ignacio Bitrián Arcas(717901)
 * Coms: Archivo Archivo.java perteneciente a la 3a practica de TecProg
 */
class Archivo extends Nodo{	
	//Atributos
	private int tamanyo;
	//Constructores
	public Archivo(){}

	public Archivo(String n,int t){
		tamanyo=t; setNombre(n);
	}
	//Funciones
	//setters
	public void setTamanyo(int t){
		this.tamanyo=t;
	}
	//getters
	public  int getTamanyo(){
		return this.tamanyo;
	}
}

