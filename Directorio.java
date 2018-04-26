
import java.util.*;


class Directorio extends Nodo{
		//-----Atributos de Directorio-----
		int size;
		LinkedList<Nodo> hijitos = new LinkedList<Nodo>();

		//-----Constructor de Directorio-----
		//Constructor de Directorio dado un nombreDirectorio
		public Directorio (String nombreDirectorio){
			//COMPROBAR QUE nombreDirectorio es CORRECTO
			nombreNodo = nombreDirectorio;
			size=0;
		}

		//-----Métodos de Directorio-----
		//Añade a la lista de nodos del Directorio el nuevo nodo
		public boolean addNodo(Nodo NodoAnyadir){
			return hijitos.add(NodoAnyadir);
		}

		//Devuelve el valor de size calculado según el contenido de la lista de Nodos
		public int getSize(){
			size=0;
			//Iteramos la lista
			for(Iterator i = hijitos.iterator();i.hasNext();){

				Nodo aux= (Nodo) i.next();
				size= size+aux.getSize();
			}
			return size;
		}

		//Lista el contenido de la lista de Nodos de Directorio
		public String listarDirectorio (){
			String listado="";
			for(Iterator i = hijitos.iterator();i.hasNext();){

				Nodo aux = (Nodo) i.next();
				listado = listado+aux.getNombre()+"\n";
			}
			return listado;

		}
		public boolean buscarNodo(String buscado){
				boolean esta = false;
				for(Nodo i : hijitos){
						if(buscado.equals(i.getNombre()) ) {
							esta=true;
							break;
						}
					}
				
				return esta;
		}


		public Nodo cogerNodo(String buscado){
				for(Nodo i : hijitos){
						if(buscado.equals(i.getNombre()) ) {
							return i;
						
						}
				}
				
				return this;
		
		}
		//Devuelve cierto si existe un Directorio con nombre buscado en Directorio
		public boolean buscarDirectorio(String buscado) {
			boolean esta = false;
			for(Iterator i = hijitos.iterator(); i.hasNext() & !esta;){

				Nodo aux = (Nodo) i.next();
				if (aux instanceof Directorio) { //Si aux es directorio
					esta = buscado.equals(aux.getNombre());
					
				}

			}
			return esta;
		}
		public Directorio cogerDirectorio(String buscado){
			boolean esta = false;
			for(Iterator i = hijitos.iterator(); i.hasNext() & !esta;){
				Nodo aux = (Nodo) i.next();
				if (aux instanceof Directorio) { //Si aux es directorio
					esta = buscado.equals(aux.getNombre());
					if(esta){
						return (Directorio) aux;
					}
				}

			}
			return  (Directorio) hijitos.getLast();
		}

		Nodo getNode(){
			return this;
		}
		public int tamElemento(String buscado) {
			Nodo elemento = null;
			boolean esta = false;
			for(Nodo e:hijitos){
				if(buscado.equals(e.getNombre())){
					esta = true;
					elemento = e;
					break;
				}	
			}
			return elemento.getSize();
		}
}