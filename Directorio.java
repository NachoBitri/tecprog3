import java.util.*;
class Directorio  extends Nodo{
	private LinkedList<Nodo> contenido;
	public Directorio(){

	}
	public Directorio(String n){
		setNombre(n);
		contenido= new LinkedList<Nodo>();
	}
	
	/*
	*	Nodo find(String s): En el caso de que no sea un directorio o enlace a directorio 
	* 	devolverá un error.
	*	Si no hay ningún problema devolverá el Nodo de nombre s en el caso de que esté en el directorio
	*	en caso contrario dará un aviso.
	*/
	public Nodo find(String s){
		Nodo resultado=null;
		for ( Nodo d : contenido) {
			if(s.compareTo(d.getNombre())==0){
				resultado = d;
			}
		}
		return resultado;
	}
	/*
	*	void add(Nodo n): Añade a contenido el nodo n
	*/
	public void ls(){
		for (Nodo n : contenido) {
			System.out.println(n.getNombre());
		}
	}
	/*
	*	void add(Nodo n): Añade a contenido el nodo n
	*/
	public void add(Nodo n){
		contenido.add(n);
	}
	/*
	*	void rm(Nodo n): Elimina de contenido el nodo n
	*/
	public void rm(Nodo n){
			contenido.remove(n);
	}
	public int tamanho(){
		int sumatotal=0;
		for (Nodo d : contenido) {
			sumatotal=sumatotal+d.tamanho();
		}
		return sumatotal;
	}
}