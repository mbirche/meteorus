package com.mbf.meteorus.model;

public class Nave {

	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getVida() {
		return vida;
	}
	public void setVida(Integer vida) {
		this.vida = vida;
	}
	public Integer getArmadura() {
		return armadura;
	}
	public void setArmadura(Integer armadura) {
		this.armadura = armadura;
	}
	public Integer getCusto() {
		return custo;
	}
	public void setCusto(Integer custo) {
		this.custo = custo;
	}
	public Integer getIniciativa() {
		return iniciativa;
	}
	public void setIniciativa(Integer iniciativa) {
		this.iniciativa = iniciativa;
	}
	public Integer getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}
	private Integer vida;
	private Integer armadura;
	private Integer custo;
	private Integer iniciativa;
	private Integer velocidade;
}
