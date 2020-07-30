package com.ITAcademy.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="player")
public class Player {
	
	//Atributos de entidad player
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Busca ultimo valor e incrementa el id
	private Long id;
	@Column(name = "name" )
	private String name;
	@Column(name = "date")
	private Date date;
	@Column(name ="points")
	private int points;
	@Column(name ="ranking")
	private int ranking;
	@Column(name="totalgames")
	private int totalgames;
	@Column(name="wingames")
	private int wingames;
	@Column(name="average")
	private double average;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Game> game;
	
	//Constructores
	
	public Player(){
		
	}

	/**
	 * @param id
	 * @para name
	 * @param date
	 */

	public Long getid() {
		return id;
	}

	public Player(Long id, String name, Date date, int points, int ranking, int totalgames, int wingames,
			double average, List<Game> game) {
		//super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.points = points;
		this.ranking = ranking;
		this.totalgames = totalgames;
		this.wingames = wingames;
		this.average = average;
		this.game = game;
	}

	//Getters y Setters
	
	public void setid(Long id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setdate(Date date) {
		this.date = date;
	}
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Game")
	public List<Game> getGame() {
		return game;
	}

	public void setGame(List<Game> game) {
		this.game = game;
	}

	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getTotalgames() {
		return totalgames;
	}

	public void setTotalgames(int totalgames) {
		this.totalgames = totalgames;
	}

	public int getWingames() {
		return wingames;
	}

	public void setWingames(int wingames) {
		this.wingames = wingames;
	}
	
	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	//impresión de datos por consola
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", date=" + date + ", points=" + points + ", ranking=" + ranking
				+ ", totalgames=" + totalgames + ", wingames=" + wingames + ", average=" + average + ", game=" + game
				+ "]";
	}

	
	}

	
	
	

	
	
	

	
	
