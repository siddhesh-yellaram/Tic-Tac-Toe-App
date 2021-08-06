package com.techlab.presentation;

import java.util.Scanner;

import com.techlab.model.Board;
import com.techlab.model.GameRunner;

public class Console {
	public static int runConsole(GameRunner g, Scanner sc) {
		int choice;
		System.out.println("\nTurn of player: " + g.getTrueTurnNumber());
		System.out.println("");
		System.out.println("Enter your choice: ");
		int size = g.getGame().getBoard().getSize();
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				System.out.print(g.getGame().getBoard().getCell(Board.getIndex(j, i, size)).getMark() + " ");
			}
			System.out.println("");
		}
		System.out.println("\nEnter the index to be marked: ");
		choice = sc.nextInt() - 1;
		return choice;
	}
}
