package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

public class MainApp {
	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc  = new Scanner(System.in);
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source  = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch(ChessException ex) {
				System.out.println(ex.getMessage());
				sc.nextLine();
				}
			catch(InputMismatchException ex) {
				System.out.println(ex.getMessage());
				sc.nextLine();
			}
		}
	}

}
