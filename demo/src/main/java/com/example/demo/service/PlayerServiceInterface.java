package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Player;

public interface PlayerServiceInterface {

	List<Player> getPlayersInfo();

	Player savePlayersInfo(Player player);

//	void updatePlayerInfo();

	void deletePlayerDataById(int playerId);
	
	Optional<Player> findById(int playerId);
	
	
	

}
