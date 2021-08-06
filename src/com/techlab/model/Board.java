package com.techlab.model;

import java.util.ArrayList;

public class Board {
	private int size;
	public ArrayList<Cell> boardMatrix = new ArrayList<Cell>();

	public Board(int size) {
		this.size = size;
		this.boardMatrix = new ArrayList<Cell>();
		for (int i = 0; i <= (size * size); i++) {
			this.boardMatrix.add(new Cell());
		}
	}

	public static int getIndex(int x, int y, int size) {
		return (y - 1) * size + x - 1;
	}

	public Cell getCell(int index) {
		return this.boardMatrix.get(index);
	}

	public int getSize() {
		return this.size;
	}

	public void setCell(Mark mark, int index) throws CellIsAlreadyMarked {
		this.boardMatrix.get(index).setMark(mark);
	}
}
