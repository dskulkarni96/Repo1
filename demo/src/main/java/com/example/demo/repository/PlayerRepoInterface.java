package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Player;

public interface PlayerRepoInterface extends JpaRepository<Player, Integer> {

//	List<Player> getPlayersInfo();
//
//	List<Player> savePlayersInfo(Player player);
//
//	void updatePlayerInfo();
//
//	void deletePlayerDataById(int playerId);

}
