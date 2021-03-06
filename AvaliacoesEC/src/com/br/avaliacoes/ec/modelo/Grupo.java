package com.br.avaliacoes.ec.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo extends BancoEntity<Integer>implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupo;
	//fetch=FetchType.LAZY, (removi para poder puxar a lista de avaliações sobre esse grupo
	@OneToMany(mappedBy = "grupoAvaliado")
	Set<Avaliacoes> listaAvaliacoes;
	
	private String escola;
	private String professor;
	private String serie;
	
	@Enumerated(EnumType.STRING)
	private Regiao regiao;
	
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	@Override
	public Integer getChave() {
		// TODO Auto-generated method stub
		return this.idGrupo;
	}
	public Set<Avaliacoes> getListaAvaliacoes() {
		return listaAvaliacoes;
	}
	public void setListaAvaliacoes(Set<Avaliacoes> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}

}
