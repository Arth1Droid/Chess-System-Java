package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();	
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		//Above piece
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		//Below piece
		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}	
		//Left piece
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		//Right piece
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}	
		//Nw piece
		p.setValues(position.getRow() + 1 , position.getColumn() + 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		//NE piece
		p.setValues(position.getRow() + 2 , position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		//SW piece
		p.setValues(position.getRow() + 2 , position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		//SE piece
		p.setValues(position.getRow() + 1 , position.getColumn() - 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		
		return matriz;
	}
	
	@Override
	public String toString() {
		return "N";
	}
	
	

}
