package model;

public abstract class ChessPiece {
	
	private char color;
	private char piece;
	
	public String toString() {
		return "" + piece + color;
	}
	
}
