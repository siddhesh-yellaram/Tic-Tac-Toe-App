package com.techlab.model;

public class ResultAnalyser {
	public static boolean checkDiagonal(Board board) {
		int size = board.getSize();
		int diagon1 = 0;
		int diagon2 = 0;
		for(int i = 0; i < size; i++) {
			if(board.getCell(i*(size+1)).getMark()==Mark.O)
				diagon1++;
			if(board.getCell(i*(size+1)).getMark()==Mark.X)
				diagon1--;
			if(board.getCell((size-1)*2).getMark()==Mark.O)
				diagon2++;
			if(board.getCell((size-1)*2).getMark()==Mark.X)
				diagon2--;
		}
		if(Math.abs(diagon1)==size)
			return true;
		else {
			if(Math.abs(diagon2)==size)
				return true;
			else
				return false;
		}
			
	}
	
	public static boolean checkRow(Board board, int row) {
		int size = board.getSize();
		int line = 0;
		for(int i = 0; i < size; i++) {
			if(board.getCell(size*row+i).getMark()==Mark.O)
				line++;
			if(board.getCell(size*row+i).getMark()==Mark.X)
				line--;
		}
		if(Math.abs(line)==size)
			return true;
		else
			return false;
	}
	
	public static boolean checkColumn(Board board, int column) {
		int size = board.getSize();
		int line = 0;
		for(int i = 0; i < size; i++) {
			if(board.getCell(i*size+column).getMark()==Mark.O)
				line++;
			if(board.getCell(i*size+column).getMark()==Mark.X)
				line--;
		}
		if(Math.abs(line)==size)
			return true;
		else
			return false;
	}
	
}
