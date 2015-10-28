package br.com.bicosonline.model;

public enum Sexo {

	Masculino(1), Feminino(2), Outros(3);
	
	private int valor;
	
	Sexo(int valorOpcao){ 
		valor = valorOpcao; 
	} 
	
	public int getValor(){ 
		return valor; 
	}

}
