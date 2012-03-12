package org.rodrigoramalho.snakegame.model;


public enum Direcao {
	
	NORTE,SUL,LESTE,OESTE;

	
	public static Direcao direcaoSeguinte(Direcao actualFacing){
		
		switch (actualFacing) {
			case NORTE:
				return LESTE;
			case LESTE:
				return SUL;
			case SUL:
				return OESTE;
			case OESTE:
				return NORTE;
			}

		return null;
	}
	
	public static Direcao direcaoAnterior(Direcao actualFacing){
		
		switch (actualFacing) {
			case NORTE:
				return OESTE;
			case OESTE:
				return SUL;
			case SUL:
				return LESTE;
			case LESTE:
				return NORTE;
			}

		return null;
	}

}
