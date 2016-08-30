package boardTranslateTest
import board.TicTacToeBoard
import boardTranslate.BoardTranslator
import gameValues.BoardValue
import org.junit.Test

class BoardTranslatorTest {

	@Test
	void New_Board_To_String() {
		def exampleString = "-----------\n| 1 | 2 | 3 |\n-----------\n| 4 | 5 | 6 |\n-----------\n| 7 | 8 | 9 |\n-----------\n"
		def board = new TicTacToeBoard()
		def boardAsString =  BoardTranslator.translateToString(board)
		assert exampleString == boardAsString
	}
	
	@Test
	void Board_To_String() {
		def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.X, BoardValue.NONE ],
									 [ BoardValue.NONE, BoardValue.O, BoardValue.NONE ],
									 [ BoardValue.O, BoardValue.NONE, BoardValue.NONE ]]
		def exampleString = "-----------\n| X | X | 3 |\n-----------\n| 4 | O | 6 |\n-----------\n| O | 8 | 9 |\n-----------\n"
		def board = new TicTacToeBoard(exampleTicTacToeBoard)
		def boardAsString =  BoardTranslator.translateToString(board)
		assert exampleString == boardAsString
	}
	
}
