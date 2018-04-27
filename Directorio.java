import java.util.*;
class Directorio  extends Nodo{
	private LinkedList<Nodo> contenido;
	public Directorio(){}

	public Directorio(String n){
		setNombre(n);
		contenido = new LinkedList<Nodo>();
	}
	
	/*
	*	Nodo find(String s): En el caso de que no sea un directorio o enlace a directorio 
	* 	devolverá un error.
	*	Si no hay ningún problema devolverá el Nodo de nombre s en el caso de que esté en el directorio
	*	en caso contrario dará un aviso.
	*/
	public boolean existeDir(String s) {
		Nodo resultado=null;
		for ( Nodo d : contenido) {
			if(s.compareTo(d.getNombre())==0){
				resultado = d;
			}
		}
		if (resultado==null){
			return false;
		}
		else{
			return true;
		}
	}

	public Nodo find(String s) throws ExcepcionArbolFicheros{
		Nodo resultado=null;
		for ( Nodo d : contenido) {
			if(s.compareTo(d.getNombre())==0){
				resultado = d;
			}
		}
		if (resultado==null){
			throw new NoExiste("Error en la ruta /"+s+": ");
		}
		return resultado;
	}

	//lista el contenido del directorio
	public void ls(){
		for (Nodo n : contenido) {
			System.out.println(n.getNombre());
		}
	}

	//Añade n al directorio
	public void add(Nodo n){
		contenido.add(n);
	}

	// Devuelve el tamaño del directorio
	public int tamanyo(){
		int total=0;
		for (Nodo n: contenido) {
			total=total+n.getTamanyo();
		}
		return total;
	}

	//borra el nodo n
	public void rm(Nodo n){
			contenido.remove(n);
	}
	
}