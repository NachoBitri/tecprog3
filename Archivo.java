class Archivo extends Nodo {
	public int tamanyo;

	public Archivo(String str,int t){
		setNombre(s);
		tamanyo=t;
	}
	public void setTamanyo(int t){
		tamanyo=t;
	}
	int getTamanyo(){
		return tamanyo;
	}
	Nodo getNode(){
		return this;
	}
}
