package com.techlab.model;

import java.util.List;

public class Game {
	private Board board;
	private List<Player> playerlist;
	private GameState status;
	
	public GameState getStatus() {
		return status;
	}

	public void setStatus(GameState status) {
		this.status = status;
	}

	public Board getBoard() {
		return board;
	}

	public List<Player> getPlayerlist() {
		return playerlist;
	}

	public Game(Board board, List<Player> playerlist, GameState status) {
		this.board=board;
		this.playerlist=playerlist;
		this.status=status;
	}
	
	public void play(int index, Mark mark) throws CellIsAlreadyMarked {
		this.board.setCell(mark, index);
	}
}
