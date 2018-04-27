class NoExiste extends  ExcepcionArbolFicheros {

	String errConcreto;

	public NoExiste (String errConcreto){
		this.errConcreto=errConcreto;

	}

	public String toString(){
		return errConcreto+
				"no se encuentran uno o varios datos referenciados.\n"
				+"Sentimos las molestias. Para más información consulte "
				+ "con los desarrolladores.\n";
	}

}
