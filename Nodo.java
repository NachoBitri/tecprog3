abstract class Nodo 
{
	private String nombre;

	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	abstract Nodo getNodo();
	abstract  int getTamanyo(); 
}
