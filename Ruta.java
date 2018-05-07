import java.util.*;


class Ruta{
	private LinkedList<Nodo> relativa;
	public Ruta() {}
	public Ruta(Directorio r) throws ExcepcionArbolFicheros{
		if(r.getNombre().equals("")){
			relativa= new LinkedList<Nodo>();
			relativa.add(r);
		}
		else{
			throw new NoExiste("La raiz del árbol ha de ser nula.");
		}
	}
	/*
	* 	STR pwd(): Devuelve la ruta completa, con todos los nombres de los directorios 
	*	desde la raíz hasta el directorio actual concatenados y separados por el 
	*	separador “/”.
	*/
	public String pwd(){
		String path = "";
		for (Nodo d : relativa) {
			path=path+d.getNombre()+"/";
		}
		return result;
	}
	/*
	*	void ls(): Muestra por pantalla los nombres de todos los ficheros, directorios
	* 	y enlaces contenidos en la ruta actual, cada uno de ellos en una línea diferente
	*	, sin ningún dato más.
	*/
	public void ls() throws ExcepcionArbolFicheros{
		if((relativa.getLast() instanceof Enlace)&&(( (Enlace) relativa.getLast()).getContenido() instanceof Archivo)){
			throw new NoEsDirectorio("Tipo de dato introducido erroneo.");
		}
		else{
			 ((Directorio) relativa.getLast()).ls();
		}
	}
	/*
	*	void cd(STR path): cambia la ruta a otro directorio (path), pasándole el 
	*	nombre del directorio al que quiere cambiar. Hay tres casos especiales: 
	*	“.” se refiere al directorio actual, “..” se refiere al directorio anterior
	*	 en el árbol de directorios y “/” se refiere a la raíz del árbol de directorios.
	*	 También se le puede pasar como parámetro una ruta reltiva.
	*/
	public void cd(String path) throws ExcepcionArbolFicheros{
		else if(!path.equals(".")){
			String[] result = path.split("/");
			for (String s : result) {
				if(s.equals("..") && relativa.size() > 1){
					relativa.removeLast();
				}
				else{
					Nodo n = ((Directorio) relativa.getLast()).find(s);
					if(n instanceof Archivo){
						throw new NoEsDirectorio("Tipo de dato introducido erroneo: ");
					}
					else if(n instanceof Enlace && ((Enlace) n).getContenido() instanceof Archivo){
						if(((Enlace) relativa.getLast()).getContenido() instanceof Archivo){
							throw new NoEsDirectorio("Tipo de dato introducido erroneo: ");
						}
					}
					else{
						relativa.add(n);
					}
				}
			}
		}
	}
	/*
	*	void stat(STR element): Muestra por pantalla un número que es el tamaño del archivo,
	*	 directorio o enlace dentro de la ruta actual identificado por la cadena de texto 
	*	que se le pasa como parámetro. También se le puede pasar una ruta relativa.
	*/
	public void stat(String element) throws ExcepcionArbolFicheros{
		if(element.equals(".")){
			System.out.println(((Directorio) relativa.getLast()).tamanyo());
		}
		else{
			LinkedList<Nodo> copiaRelativa = (LinkedList<Nodo>)relativa.clone();
			String[] result = element.split("/");
			int i=1;
			for (String s : result) {
				if(s.equals("..") && copiaRelativa.size() > 1){
						copiaRelativa.removeLast();
				}
				else{
					if(((Directorio) copiaRelativa.getLast()).existeNodo(s)){
						Nodo n = ((Directorio) copiaRelativa.getLast()).find(s);
						if(n instanceof Enlace && ((Enlace) n).getContenido() instanceof Directorio){
							throw new BucleInfinito();
						}
						else if(i >= result.length){
							System.out.println(((Directorio) copiaRelativa.getLast()).find(s).tamanyo());
						}
						else if(n instanceof Archivo){
							throw new NoExisteExcepcion(s);
						}
						else if(n instanceof Enlace && ((Enlace) n).getContenido() instanceof Archivo){
							if(((Enlace) copiaRelativa.getLast()).getContenido() instanceof Archivo){
								throw new NoEsDirectorio("Tipo de dato introducido erroneo: ");
							}
						}
						else{
							copiaRelativa.add(n);
						}
					}
					else{
						throw new NoExisteExcepcion(s);
					}
				}
				i++;
			}
		}
	}
	/*
	*	void vim(STR file, int size): Cambia el tamaño de un archivo dentro de la ruta actual 
	*	(no se le puede pasar como parámetro una ruta completa). Si el archivo no existe 
	*	dentro de la ruta actual, se crea automáticamente con el nombre y tamaño espeficados.
	*	Si el archivo referenciado por “file” es en realidad un enlace a un archivo,
	*	también cambia su tamaño.
	*/
	public void vim(String file,int size) throws ExcepcionArbolFicheros{
		if (((Directorio) relativa.getLast()).existeNodo(file)){
			Nodo n=((Directorio) relativa.getLast()).find(file);
			if(n instanceof Directorio){
				throw new EsDirectorioExcepcion(file);
			}
			else if(n instanceof Archivo){
				((Archivo) n).setTamanyo(size);
			}
			else if(n instanceof Enlace){
				((Enlace) n).setTamanyo(size);
			}
		}
		else{
			Archivo a = new Archivo(file,size);
	    	((Directorio) relativa.getLast()).add(a);
	    }
	}
	/*
	*	void mkdir(STR dir): Crea un directorio dentro de la ruta actual. No se le puede 
	+	pasar como parámetro una ruta completa.
	*/
	public void mkdir(String dir) throws ExcepcionArbolFicheros{
		if(((Directorio) relativa.getLast()).existeNodo(dir)){
			throw new YaExiste(dir);
		}
		else{
			Directorio d = new Directorio(dir);
			((Directorio) relativa.getLast()).add(d);
		}
	}
	/*
	*	Nodo find(String path): Devuelve el nodo que está indicado en la ruta path.
	*   La ruta path estará formada por directorios o enlaces a directorios separados 
	*   por "/" y el ultimo elemento de la ruta puede ser cualquier tipo de nodo.
	*/
	private Nodo find(String path) throws ExcepcionArbolFicheros{
		Nodo resultado=null;
		if((resultado=relativa.getFirst()) instanceof Archivo){
			throw new NoEsDirectorio("No se puede realizar esta operacion sobre un Archivo.");
		}
		else if((resultado instanceof Enlace && ((Enlace) resultado).getContenido() instanceof Archivo )){
			throw new NoEsDirectorio("No se puede realizar esta operacion sobre un Archivo.");
		}
		else{
			String[] result = path.split("/");
			for (String s : result) {
				resultado=((Directorio) resultado).find(s);
			}
		}
		return resultado;
	}
	/*
	*	void ln(STR orig, STR dest): Crea un enlace simbólico de nombre “dest” a que
	*	enlaza el elemento identificado mediante el nombre “orig”. “dest” no puede 
	*	contener una ruta completa, pero “orig” sí, de tal modo que pueden crearse
	*	enlaces simbólicos entre elementos dentro de diferentes posiciones del 
	*	árbol de directorios.
	*/
	public void ln(String dest,String orig) throws ExcepcionArbolFicheros{
		if(orig.equals(".")){
			Enlace e= new Enlace(dest,(Directorio) relativa.getLast());
			((Directorio) relativa.getLast()).add(e);
		}
		else{
			String[] result = orig.split("/");
			LinkedList<Nodo> copiaRelativa= (LinkedList<Nodo>)relativa.clone();
			int i=1;
			for (String s : result) {
				if(s.equals("..") && copiaRelativa.size() > 2){
						relativa.removeLast();
				}
				else{
					Nodo d = ((Directorio) relativa.getLast()).find(s);
					if(i >= result.length){
						Enlace e= new Enlace(dest,d);
						((Directorio) copiaRelativa.getLast()).add(e);
					}
					else{
						relativa.add(d);
					}
				}
				i++;
			}
			relativa=copiaRelativa;
		}
	}
	/*
	*	void ln(STR orig, STR dest): Crea un enlace simbólico de nombre “dest” a
	*	que enlaza el elemento identificado mediante el nombre “orig”. “dest”
	*	no puede contener una ruta relativa, pero “orig” sí, de tal modo que 
	*	pueden crearse enlaces simbólicos entre elementos dentro de diferentes 
	*	posiciones del árbol de directorios.
	*/
	public void rm(String e) throws ExcepcionArbolFicheros{
		if(((Directorio) relativa.getLast()).existeNodo(e)){
			((Directorio) relativa.getLast()).rm(((Directorio) relativa.getLast()).find(e));
		}
		else{
			throw new NoExiste("Error con el archivo, enlace o directorio "+e+": ");
		}
	}
}