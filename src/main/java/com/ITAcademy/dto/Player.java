package com.ITAcademy.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	
	//Atributos de entidad player
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Busca ultimo valor e incrementa el id
	private Long idPlayer;
	@Column(name = "namePlayer" )
	private String namePlayer;
	@Column(name = "dateOfRegister")
	private Date dateOfRegister;
	
	@OneToMany
	@JoinColumn(name="idPlayer")
	private List<Game> game;
	
	//Constructores
	public Player(){
		
	}

	/**
	 * @param idPlayer
	 * @para namePlayer
	 * @param dateOfRegister
	 */

	public Player(Long idPlayer, String namePlayer, Date dateOfRegister, List<Game> game) {
		//super();
		this.idPlayer = idPlayer;
		this.namePlayer = namePlayer;
		this.dateOfRegister = dateOfRegister;
		this.game = game;
	}

	//Getters y Setters
	
	/**
	 * @return the id
	 */
	public Long getIdPlayer() {
		return idPlayer;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
	/**
	 * @return the namePlayer
	 */
	public String getNamePlayer() {
		return namePlayer;
	}

	/**
	 * @param nombre the namePlayer to set
	 */
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public Date getDateOfRegister() {
		return dateOfRegister;
	}
	/**
	 * @param date the dateOfRegister to set
	 */
	public void setDateOfRegister(Date dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}

	/**
	 * @return the Game
	 */
	public List<Game> getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(List<Game> game) {
		this.game = game;
	}

	
	//Metodo impresion de datos por consola
	

	@Override
	public String toString() {
		return "Player [idPlayer=" + idPlayer + ", namePlayer=" + namePlayer + ", dateOfRegister=" + dateOfRegister + "]";
	}
}
	
	
