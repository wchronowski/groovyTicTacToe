package mainProcessingTest
import board.TicTacToeBoard
import gameValues.BoardValue
import entryPoint.MainProcessing
import org.junit.Test;

class SetBoardTest {
	@Test
	void Set_New_Board_Sucessfuly(){
		def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.NONE, BoardValue.NONE ],
									 [ BoardValue.NONE, BoardValue.O, BoardValue.NONE ],
									 [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]]
		def correctBoard = [[ BoardValue.X, BoardValue.O, BoardValue.NONE ],
							[ BoardValue.NONE, BoardValue.O, BoardValue.NONE ],
							[ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]]
		def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
		def newBoard, isSucessful
		(newBoard, isSucessful) = MainProcessing.setBoard(0, 1, ticTacToeBoard)
		assert isSucessful == true
		for(row in 0..2) {
			for(column in 0..2) {
				assert newBoard.gameBoard[row][column] == correctBoard[row][column]
			}
		}
	}
	
	@Test
	void Set_New_Board_UnSucessfuly(){
		def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.NONE, BoardValue.NONE ],
									 [ BoardValue.NONE, BoardValue.O, BoardValue.NONE ],
									 [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]]
		def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
		def newBoard, isSucessful
		(newBoard, isSucessful) = MainProcessing.setBoard(0, 0, ticTacToeBoard)
		assert isSucessful == false
		for(row in 0..2) {
			for(column in 0..2) {
				assert newBoard.gameBoard[row][column] == exampleTicTacToeBoard[row][column]
			}
		}
	}
}
