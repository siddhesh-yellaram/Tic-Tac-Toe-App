package com.techlab.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlab.model.Board;
import com.techlab.model.Game;
import com.techlab.model.GameRunner;
import com.techlab.model.GameState;
import com.techlab.model.Mark;
import com.techlab.model.Player;

public class GameRunConsole {
	public static void main(String[] args) {
		Player p1 = new Player("p1", Mark.O);
		Player p2 = new Player("p2", Mark.X);
		List<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);

		Board board = new Board(3);

		Game game = new Game(board, players, GameState.RUNNING);
		Scanner sc = new Scanner(System.in);
		GameRunner gameInstance = new GameRunner(game, 0, sc);

		gameInstance.start();
		
		if (gameInstance.getStatus() == GameState.DRAW)
			System.out.println("\nIt's A Draw");
		if (gameInstance.getStatus() == GameState.FINISHED)
			System.out.println("\nWinner is Player " + gameInstance.getWinnerNumber());
	}
}
