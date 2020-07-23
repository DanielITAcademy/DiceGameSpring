package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.Player;
import service.PlayerServiceImpl;

@RestController
@RequestMapping("/api")
public class PlayerController {

	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	@GetMapping("/players")
	public List<Player>listPlayer(){
		return playerServiceImpl.listPlayer();
	}

	@PostMapping("/players")
	public Player savePlayer(@RequestBody Player player) {
		return playerServiceImpl.savePlayer(player);
}
	
	@GetMapping("/players/{id}")
	public Player playerXID(@PathVariable(name = "id")Long id) {
		Player player_xid = new Player();
		player_xid = playerServiceImpl.playerXID(id);
		System.out.println("Player XID: "+ player_xid);
		return player_xid;
	}
	
	@PutMapping("players/{id}")
	public Player updatePlayer(@PathVariable(name="id")Long id,@RequestBody Player player) {
		Player player_selected = new Player();
		Player player_updated = new Player();
		
		player_selected = playerServiceImpl.playerXID(id);
		
		player_selected.setNamePlayer(player.getNamePlayer());
		player_selected.setDateOfRegister(player.getDateOfRegister());
		
		player_updated = playerServiceImpl.updatePlayer(player_selected);
		
		System.out.println("Player update is: " + player_updated);
		
		return player_updated;
		
	}
	
	@DeleteMapping("/players/{id}")
	public void eliminatePlayer(@PathVariable(name="id")Long id) {
		playerServiceImpl.eliminatePlayer(id);
	}
	
}