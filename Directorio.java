
import java.util.*;


class Directorio extends Nodo{

		LinkedList<Nodo> contenido = new LinkedList<Nodo>();
		int size;

		//Constructor
		public Directorio (String nomDir){
			//COMPROBAR QUE nomDir es CORRECTO
			size=0;
			name = nomDir;
		}

		//-----Métodos de Directorio-----
		//Añade a la lista de nodos del Directorio el nuevo nodo
		public boolean addNodo(Nodo NodoAnyadir){
			return contenido.add(NodoAnyadir);
		}

		//Devuelve el valor de size calculado según el contenido de la lista de Nodos
		public int getSize(){

			size=0;
			Iterator i = contenido.iterator();
			while(i.hasNext()){

				Nodo aux = (Nodo) i.next();
				size= size+aux.getSize();
			}

			return size;
		}

		//Lista el contenido de la lista de Nodos de Directorio
		public String listarDirectorio (){
			String listado="";
			Iterator i = contenido.iterator();

			while(i.hasNext()){
				Nodo aux = (Nodo) i.next();
				listado = listado+aux.getName()+"\n";
			}

			return listado;

		}


		//Devuelve el Directorio con nombre buscado en Directorio
		// Si no existe lanza una excepcion
		public Directorio cogerDirectorio(String buscado) throws Exception{
			boolean existe = false;
			Iterator i = contenido.iterator();

			while(i.hasNext() & !existe){
				
				Nodo aux = (Nodo) i.next();
				if (aux instanceof Directorio) { //Si aux es directorio
					existe = buscado.equals(aux.getName());
					if(existe){
						return (Directorio) aux;
					}
				}

			}
			return  (Directorio) contenido.getLast();
		}

		//Devuelve el Directorio con nombre buscado en Directorio
		// Si no existe lanza una excepcion
		public boolean buscarDirectorio(String buscado) {
			boolean existe = false;
			Iterator i = contenido.iterator();
			while(i.hasNext() & !existe){

				Nodo aux = (Nodo) i.next();
				if (aux instanceof Directorio) { //Si aux es directorio
					existe = buscado.equals(aux.getName());
					
				}

			}
			return existe;
		}

		public Directorio cogerDirectorio(String buscado){
			boolean existe = false;
			Iterator i = contenido.iterator();

			while(i.hasNext() & !existe){
				Nodo aux = (Nodo) i.next();
				if (aux instanceof Directorio) { //Si aux es directorio
					existe = buscado.equals(aux.getName());
					if(existe){
						return (Directorio) aux;
					}
				}

			}
			return  (Directorio) contenido.getLast();
		}

		Nodo getNode(){
			return this;
		}

		public boolean buscarNodo(String buscado){
				boolean existe = false;
				for(Nodo i : contenido){
						if(buscado.equals(i.getName()) ) {
							existe=true;
							break;
						}
					}
				
				return existe;
		}


		public Nodo cogerNodo(String buscado){
				for(Nodo i : contenido){
						if(buscado.equals(i.getName()) ) {
							return i;
						}
				}
				return this;
		}

		public int tamElemento(String buscado) {
			boolean existe = false;
			Nodo elemento = null;

			for(Nodo e:contenido){
				if(buscado.equals(e.getName())){
					existe = true;
					elemento = e;
					break;
				}	
			}

			return elemento.getSize();
		}
}