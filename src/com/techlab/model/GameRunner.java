package com.techlab.model;

import java.util.List;
import java.util.Scanner;

import com.techlab.presentation.Console;


public class GameRunner {
	private static Game game;
	static int trueTurnNumber = 0;
	static int turnNumber = 0;
	int choice;
	static boolean winFlag;
	static GameState status;
	static int winnerNumber;
	Scanner sc;

	public GameRunner(Game game, int turnNumber, Scanner sc) {
		GameRunner.game = game;
		GameRunner.turnNumber = turnNumber;
		status = GameState.RUNNING;
		this.sc = sc;
	}

	public void start() {
		List<Player> players = game.getPlayerlist();
		boolean winFlag;
		while (status == GameState.RUNNING) {
			trueTurnNumber = turnNumber % players.size();
			this.choice = Console.runConsole(this, sc);
			try {
				game.play(choice, players.get(trueTurnNumber).getpMark());
			} catch (CellIsAlreadyMarked e) {
				System.out.println(e.getMessage());
				continue;
			}
			turnNumber++;

			for (int i = 0; i < game.getBoard().getSize(); i++) {
				winFlag = ResultAnalyser.checkColumn(game.getBoard(), i);
				if (winFlag) {
					winnerNumber = trueTurnNumber;
					status = GameState.FINISHED;
					break;
				}
				if (turnNumber == game.getBoard().getSize() * game.getBoard().getSize()) {
					status = GameState.DRAW;
					break;
				}
				winFlag = ResultAnalyser.checkRow(game.getBoard(), i);
				if (winFlag) {
					winnerNumber = trueTurnNumber;
					status = GameState.FINISHED;
					break;
				}
				if (turnNumber == game.getBoard().getSize() * game.getBoard().getSize()) {
					status = GameState.DRAW;
					break;
				}
			}
			winFlag = ResultAnalyser.checkDiagonal(game.getBoard());

			if (winFlag) {
				winnerNumber = trueTurnNumber;
				status = GameState.FINISHED;
				break;
			}
			if (turnNumber == game.getBoard().getSize() * game.getBoard().getSize()) {
				status = GameState.DRAW;
				break;
			}
		}

	}

	public Game getGame() {
		return game;
	}

	public int getTrueTurnNumber() {
		return trueTurnNumber;
	}

	public GameState getStatus() {
		return status;
	}

	public int getWinnerNumber() {
		return winnerNumber;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public static void endGame() {
		if (winFlag) {
			winnerNumber = trueTurnNumber;
			status = GameState.FINISHED;
		}
		if (turnNumber == game.getBoard().getSize() * game.getBoard().getSize()) {
			status = GameState.DRAW;
		}
	}
}
