package org.rodrigoramalho.snakegame.model;

import org.rodrigoramalho.util.ValidacaoUtil;



public class Snake {
	
	private Integer comprimento;
	private Posicao posicao;

	public Snake(){
	}
	
	public Snake(String coordenadas){
		String[] args = coordenadas.split(" ");
		
		this.comprimento  = new Integer(args[0]);
		getPosicao().setX(new Integer(args[1])); 
		getPosicao().setY(new Integer(args[2]));
		getPosicao().setDirecao(Direcao.valueOf(args[3]));
		
		if (ValidacaoUtil.isMenorQueZero(getComprimento(), getPosicao().getX(), getPosicao().getY())){
			throw new IllegalArgumentException("Use apenas valores > 0");
		}
	}

	public void virarEsquerda(){
		if (getPosicao().getDirecao() != Direcao.LESTE){
			getPosicao().setDirecao(Direcao.OESTE);
		}
	}
	
	public Integer getComprimento() {
		return comprimento;
	}

	public void setComprimento(Integer comprimento) {
		this.comprimento = comprimento;
	}

	public Posicao getPosicao() {
		if (posicao == null) {
			posicao = new Posicao();
		}

		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
}
