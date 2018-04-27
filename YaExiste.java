class YaExiste extends  ExcepcionArbolFicheros {

	String name;

	public YaExiste (String name){
		this.name=name;
	}

	public String toString(){
		return "Ya hay un directorio con el nombre: "
				+name+". Por favor, introduzca otro nombre distinto.\n"
				+"Sentimos las molestias. Para más información consulte "
				+ "con los desarrolladores.\n";
	}
}