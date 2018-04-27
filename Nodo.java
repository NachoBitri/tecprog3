
//package practica3TP;

abstract class Nodo{
	private String nombre;

	public String getNombre(){
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	*	Nodo int tamanho(): Devuelve el tamaño del nodo.
	*/
	abstract public int tamanho();
}
