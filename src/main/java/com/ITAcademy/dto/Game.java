package com.ITAcademy.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	
	//Atributos de la entidad game
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Busca último valor e incrementa id última
	private Long id;
	@Column(name = "one")
	private int one;
	@Column(name = "two")
	private int two;
	@Column(name = "score")
	private int score;
	
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	//Constructores
	public Game() {
		
	}
	/**
	 * @param id
	 * @param one
	 * @param two
	 * @param score
	 * @param player
	 
	 */

	public Game(Long id, int one, int two, int score, Player player) {
		//super();
		this.id = id;
		this.one = one;
		this.two = two;
		this.score = score;
		this.player = player;
	}
	//Getters y Setters
			
	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public int getone() {
		return one;
	}
	public void setone(int one) {
		this.one = one;
	}
	public int gettwo() {
		return two;
	}
	public void settwo(int two) {
		this.two = two;
	}
	public int getScore() {
		
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	//impresión de datos por consola
	@Override
	public String toString() {
		return "Game [id=" + id + ", one=" + one + ", two=" + two + ", score=" + score + ", player=" + player + "]";
	}
	
}
