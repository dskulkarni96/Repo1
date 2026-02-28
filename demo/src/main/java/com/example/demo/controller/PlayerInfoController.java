package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.entity.Player;
import com.example.demo.service.PlayerServiceInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")

public class PlayerInfoController {
	
	@Autowired
	PlayerServiceInterface playerServiceInterface;

    public PlayerServiceInterface getPlayerServiceInterface() {
		return playerServiceInterface;
	}

	public void setPlayerServiceInterface(PlayerServiceInterface playerServiceInterface) {
		this.playerServiceInterface = playerServiceInterface;
	}

	
	@GetMapping("/getPlayerInfo")
	public ResponseEntity<List<Player>> getPlayerInfo() throws Exception {
		
		List<Player> players = playerServiceInterface.getPlayersInfo();
		return new ResponseEntity<>(players, HttpStatus.ACCEPTED);
		//System.out.println("Player info printed");
	}
	
	@PostMapping("/savePlayersInfo")
	public ResponseEntity<Player> savePlayerInfo(@RequestBody Player player)
	{
		Player players = playerServiceInterface.savePlayersInfo(player);
		return new ResponseEntity<>(players, HttpStatus.ACCEPTED);

		//System.out.println("Player info saved");
	}
	
	@DeleteMapping("/deletePlayer/{playerId}")
	public ResponseEntity deletePlayerDataById(@PathVariable int playerId) 
	{		
		playerServiceInterface.deletePlayerDataById(playerId);
	return new ResponseEntity<>("Deleted Successflly", HttpStatus.ACCEPTED);
		//System.out.println("Player info deleted");
	}
	
//	@PutMapping("/updatePlayersInfo")
//       public void updatePlayerInfo() 
//	{
//		playerServiceInterface.updatePlayerInfo();
//		System.out.println("Player info updated");
//	}
	
	@GetMapping("/getPlayerById/{playerId}")
	public ResponseEntity getById(@PathVariable int playerId) throws NullPointerException
{
		Optional<Player> player =  playerServiceInterface.findById(playerId);
		
		return new ResponseEntity<>(player,HttpStatus.ACCEPTED);
	}

}
