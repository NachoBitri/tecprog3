class NoEsDirectorio extends  ExcepcionArbolFicheros {

	String errConcreto;

	public NoEsDirectorio (String errConcreto){
		this.errConcreto=errConcreto;
	}

	public String toString(){
		return errConcreto+
				"el tipo de dato requerido por la función es un directorio "
				+"o enlace a este.\n"
				+"Sentimos las molestias. Para más información consulte "
				+ "con los desarrolladores.\n";
	}
}