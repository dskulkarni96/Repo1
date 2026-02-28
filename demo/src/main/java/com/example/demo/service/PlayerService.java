package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepoInterface;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService implements PlayerServiceInterface{
	
	@Autowired
	PlayerRepoInterface playerRepoInterface;

@Transactional
public List getPlayersInfo() {
		// TODO Auto-generated method stub
		return  playerRepoInterface.findAll();
	}

	@Transactional
	public Player savePlayersInfo(Player player) {
		// TODO Auto-generated method stub
		if(player.getEmpName().isEmpty()|| player.getEmpName().length()==0) {
			throw new IllegalArgumentException();
		}if(player.getEmpName()== null) {
			throw new NullPointerException();
		}
		return  playerRepoInterface.save(player);
	}
//
//	@Override
//	public void updatePlayerInfo() {
//		// TODO Auto-generated method stub
//		playerRepoInterface.save();
//	}

	@Transactional
	public Optional<Player> findById(int playerId)    {
		// TODO Auto-generated method stub
		Optional<Player> player = playerRepoInterface.findById(playerId);
		return player;
	}


	
	@Transactional
	public void deletePlayerDataById(int playerId) {
		// TODO Auto-generated method stub
		playerRepoInterface.deleteById(playerId);
		
	}


	
		
	}


