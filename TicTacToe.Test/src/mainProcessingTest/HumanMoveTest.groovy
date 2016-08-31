package mainProcessingTest;

import aI.MiniMax
import board.TicTacToeBoard
import gameValues.BoardValue
import entryPoint.MainProcessing
import org.junit.Test

public class HumanMoveTest {

		@Test
		void Human_Pick_A_Correct_Value_To_Move() {
			def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
										 [ BoardValue.O, BoardValue.X, BoardValue.O ],
										 [ BoardValue.O, BoardValue.NONE, BoardValue.NONE ]]
			def correctTicTacToeBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
										 [ BoardValue.O, BoardValue.X, BoardValue.O ],
										 [ BoardValue.O, BoardValue.X, BoardValue.O ]]
			
			def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
			
			def newGame = MainProcessing.setHumanAndAiMove(2, 2, ticTacToeBoard, new MiniMax())
			for(row in 0..2) {
				for(column in 0..2) {
					assert newGame.gameBoard[row][column] == correctTicTacToeBoard[row][column]
				}
			}
		}
		
		@Test
		void Human_Pick_A_Incorrect_Value_To_Move() {
			def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
										 [ BoardValue.O, BoardValue.X, BoardValue.O ],
										 [ BoardValue.O, BoardValue.NONE, BoardValue.NONE ]]
			
			def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
			
			def newGame = MainProcessing.setHumanAndAiMove(0, 0, ticTacToeBoard, new MiniMax())
			for(row in 0..2) {
				for(column in 0..2) {
					assert newGame.gameBoard[row][column] == exampleTicTacToeBoard[row][column]
				}
			}
		}
		
		@Test
		void Pass_Null_Row_Column_To_Move() {
			def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
										 [ BoardValue.O, BoardValue.X, BoardValue.O ],
										 [ BoardValue.O, BoardValue.NONE, BoardValue.NONE ]]
			
			def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
			
			def newGame = MainProcessing.setHumanAndAiMove(null, null, ticTacToeBoard, new MiniMax())
			for(row in 0..2) {
				for(column in 0..2) {
					assert newGame.gameBoard[row][column] == exampleTicTacToeBoard[row][column]
				}
			}
		}
		
		@Test
		void Pass_Null_Row_To_Move() {
			def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
										 [ BoardValue.O, BoardValue.X, BoardValue.O ],
										 [ BoardValue.O, BoardValue.NONE, BoardValue.NONE ]]
			
			def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
			
			def newGame = MainProcessing.setHumanAndAiMove(null, 1, ticTacToeBoard, new MiniMax())
			for(row in 0..2) {
				for(column in 0..2) {
					assert newGame.gameBoard[row][column] == exampleTicTacToeBoard[row][column]
				}
			}
		}
		
		@Test
		void Pass_Null_Column_To_Move() {
			def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
										 [ BoardValue.O, BoardValue.X, BoardValue.O ],
										 [ BoardValue.O, BoardValue.NONE, BoardValue.NONE ]]
			
			def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
			
			def newGame = MainProcessing.setHumanAndAiMove(1, null, ticTacToeBoard, new MiniMax())
			for(row in 0..2) {
				for(column in 0..2) {
					assert newGame.gameBoard[row][column] == exampleTicTacToeBoard[row][column]
				}
			}
		}
}
