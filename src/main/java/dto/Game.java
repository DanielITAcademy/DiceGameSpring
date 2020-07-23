package dto;

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
	@Column(name = "diceOne")
	private int diceOne;
	@Column(name = "diceTwo")
	private int diceTwo;
	@Column(name = "score")
	private int score;
	
	@ManyToOne
	@JoinColumn(name = "id_player")
	private Player player;
	
	//Constructores
	public Game() {
		
	}
	/**
	 * @param id
	 * @param diceOne
	 * @param diceTwo
	 * @param score
	 * @param player
	 
	 */

	public Game(Long id, int diceOne, int diceTwo, int score, Player player) {
		//super();
		this.id = id;
		this.diceOne = diceOne;
		this.diceTwo = diceTwo;
		this.score = score;
		this.player = player;
	}
	//Getters y Setters
			/**
			 * @return the id
			 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getDiceOne() {
		return diceOne;
	}
	public void setDiceOne(int diceOne) {
		this.diceOne = diceOne;
	}
	public int getDiceTwo() {
		return diceTwo;
	}
	public void setDiceTwo(int diceTwo) {
		this.diceTwo = diceTwo;
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
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Game [id=" + id + ", diceOne=" + diceOne + ", diceTwo=" + diceTwo + ", score=" + score + ", player="
				+ player + "]";
	}
	
}
