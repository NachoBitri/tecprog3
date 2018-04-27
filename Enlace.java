
class Enlace extends Directorio{
	public Enlace(){

	}
	private Nodo contenido;
	public Enlace(String s,Nodo n){
		setNombre(s);
		contenido= n;
	}

	public Nodo getContenido(){
		return this.contenido;
	}

	/*
	*	Nodo find(String s): En el caso de que no sea un directorio o enlace a directorio 
	* 	devolverá un error.
	*	Si no hay ningún problema devolverá el Nodo de nombre s en el caso de que esté en el directorio
	*	en caso contrario dará un aviso.
	*/
	public Nodo find(String s){
		return ((Directorio) contenido).find(s);
	}
	public String ls(){
		return ((Directorio) contenido).ls();
	}
	public void add(Nodo n){
		((Directorio) contenido).add(n);
	}
	public void rm(Nodo nodo){
		((Directorio) contenido).rm(nodo);
	}
	public void setTamanho(int t) throws ExcepcionArbolFicheros{
		((Archivo) contenido).setTamanho(t);
	}
	public int tamanho(){
		return contenido.tamanho();
	}
}
