abstract class Nodo {
	
	private String name;

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	abstract Nodo getNodo();
	abstract  int getTamanyo(); 
}
