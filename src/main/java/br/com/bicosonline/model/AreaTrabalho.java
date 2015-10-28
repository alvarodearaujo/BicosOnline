package br.com.bicosonline.model;

public enum AreaTrabalho {

	Pedreiro(1),
	Marceneiro(2),
	Carpinteiro(3),
	Diarista(4),
	Motorista(5),
	Eletricista(6),
	Bábá(7),
	Outros(8); 
	
	private int valor;
	
	AreaTrabalho(int valorOpcao){ 
		valor = valorOpcao; 
	} 
	
	public int getValor(){ 
		return valor; 
	}

}
