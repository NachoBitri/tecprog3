class ExcepcionArbolFicheros extends Exception{
	String nombre;
	public String toString();
}
class NoExisteExcepcion extends ExcepcionArbolFicheros{
	public NoExisteExcepcion(String nomnbre){
		this.nombre = nombre;
	}
	public String toString(){
		return "No se encuentra o no existe " + nombre + "\n";
	}
}
class NombreIncorrectoExcepcion extends ExcepcionArbolFicheros {
	public NombreIncorrectoExcepcion(String nomnbre){
		this.nombre = nombre;
	}
	public String toString(){
		return "Se ha intentado crear algo con este nombre " + nombre +
					"que es invalido \n";
	}
}
class YaExisteExcepcion extends ExcepcionArbolFicheros {
	public YaExisteExcepcion(String nomnbre){
		this.nombre = nombre;
	}
	public String toString(){
		return "Ya existe algo dento del directorio con este nombre"
					+ nombre + "\n";
	}
}
