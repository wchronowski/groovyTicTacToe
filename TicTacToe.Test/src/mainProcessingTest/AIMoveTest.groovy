package mainProcessingTest;
import board.TicTacToeBoard
import aI.MiniMax
import gameValues.BoardValue
import entryPoint.MainProcessing
import org.junit.Test;

public class AIMoveTest {
	
	@Test
	void AI_Makes_Move() {
		def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.X, BoardValue.O ],
		                             [ BoardValue.O, BoardValue.O, BoardValue.X ],
		                             [ BoardValue.X, BoardValue.O, BoardValue.NONE ]]
		
		def correctTicTacToeBoard = [[ BoardValue.X, BoardValue.X, BoardValue.O ],
									 [ BoardValue.O, BoardValue.O, BoardValue.X ],
									 [ BoardValue.X, BoardValue.O, BoardValue.X ]]
		
		def newGame = MainProcessing.aIMakesMove(new TicTacToeBoard(exampleTicTacToeBoard), new MiniMax())
		for(row in 0..2) {
			for(column in 0..2) {
				assert newGame.gameBoard[row][column] == correctTicTacToeBoard[row][column]
			}
		}
	}
	
	@Test
	void AI_Cant_Make_Move_Game_Over() {
		def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.X, BoardValue.O ],
									 [ BoardValue.O, BoardValue.O, BoardValue.X ],
									 [ BoardValue.O, BoardValue.O, BoardValue.X ]]
		
		def newGame = MainProcessing.aIMakesMove(new TicTacToeBoard(exampleTicTacToeBoard), new MiniMax())
		for(row in 0..2) {
			for(column in 0..2) {
				assert newGame.gameBoard[row][column] == exampleTicTacToeBoard[row][column]
			}
		}
	}
}
