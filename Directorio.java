/*
 * Nombre: 	Miguel Bentué Blanco (719378)
 * 			Ignacio Bitrián Arcas(717901)
 * Coms: Archivo Archivo.java perteneciente a la 3a practica de TecProg
 */
import java.util.*;
class Directorio  extends Nodo{
	//Atrubutos
	private LinkedList<Nodo> contenido;
	//Constructores
	public Directorio(){}
	public Directorio(String n){
		setNombre(n); contenido = new LinkedList<Nodo>();
	}
	
	/*
	 * Funcion existeNodo
	 */
	public boolean existeNodo(String s) {
		Nodo result=null;
		for ( Nodo d : contenido) {
			if(s.compareTo(d.getNombre())==0){
				result = d;
			}
		}
		if (result!=null) return true;
		else return false;
	}
	/*
	 * Funcion find 
	 */
	public Nodo find(String s) throws ExcepcionArbolFicheros{
		Nodo result = null;
		for ( Nodo d : contenido) {
			if(s.compareTo(d.getNombre())==0){
				result = d;
			}
		}
		if (result == null){
			throw new NoExisteExcepcion(s);
		}
		return result;
	}

	/*
	 * Funcion ls, lista el contenido 
	 */
	public void ls(){
		for (Nodo n : contenido) System.out.println(n.getNombre());
	}
	/*
	 * Funcion add, añade al contenido 
	 */
	public void add(Nodo n){
		contenido.add(n);
	}

	/*
	 * Funcion getTamanyo 
	 */
	public int getTamanyo(){
		int tot=0;
		for (Nodo n: contenido)	tot += n.getTamanyo();
		return tot;
	}

	/*
	 * Funcion rm, borra el nodo 
	 */
	public void rm(Nodo n){
		contenido.remove(n);
	}
}
