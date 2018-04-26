class Enlace extends Nodo
{
	private Nodo destino;
	public Enlace(String nombre, Nodo destiny) {
		destino = destiny;
		setNombre(nombre);
	}
	int getTamanyo(){
		return destino.getTamanyo();
	}
	Nodo getNodo(){
		return destino.getNodo();
	}
}
