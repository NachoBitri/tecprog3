class Archivo extends Nodo {
	public int tamanyo;

	public Archivo(String nombre,int t){
		setNombre(nombre);
		tamanyo=t;
	}
	public void setTamanyo(int t){
		tamanyo=t;
	}
	int getTamanyo(){
		return tamanyo;
	}
	Nodo getNodo(){
		return this;
	}
}
