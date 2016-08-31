package victoryValueTranslateTest
import org.junit.Test
import board.TicTacToeBoard
import victoryValueTranslate.VictoryValueTranslator
import gameValues.BoardValue

class VictoryValueTranslatorTest {

	@Test
	void Translate_X_Into_Vicotry_For_AI() {
		def gameBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
						 [ BoardValue.O, BoardValue.X, BoardValue.O ],
						 [ BoardValue.O, BoardValue.NONE, BoardValue.X ]]
		def endGameBoard = new TicTacToeBoard(gameBoard)
		
		assert VictoryValueTranslator.getWinner(endGameBoard) == "\nAi Won\n"
		
	}
	
	@Test
	void Translate_O_Into_Vicotry_For_Human() {
		def gameBoard = [[ BoardValue.O, BoardValue.O, BoardValue.X ],
						 [ BoardValue.O, BoardValue.X, BoardValue.O ],
						 [ BoardValue.O, BoardValue.NONE, BoardValue.X ]]
		def endGameBoard = new TicTacToeBoard(gameBoard)
		
		assert VictoryValueTranslator.getWinner(endGameBoard) == "\nHuman Won\n"
		
	}
	
	@Test
	void Translate_Tie_Into_Vicotry_For_Tie() {
		def gameBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
						 [ BoardValue.O, BoardValue.X, BoardValue.O ],
						 [ BoardValue.O, BoardValue.X, BoardValue.O ]]
		def endGameBoard = new TicTacToeBoard(gameBoard)
		
		assert VictoryValueTranslator.getWinner(endGameBoard) == "\nTie\n"
		
	}
	
	@Test
	void Translate_Ongoing_Into_Vicotry_For_Ongoing() {
		def gameBoard = [[ BoardValue.NONE, BoardValue.O, BoardValue.X ],
						 [ BoardValue.O, BoardValue.X, BoardValue.O ],
						 [ BoardValue.O, BoardValue.X, BoardValue.O ]]
		def endGameBoard = new TicTacToeBoard(gameBoard)
		
		assert VictoryValueTranslator.getWinner(endGameBoard) == "\nGame On-Going\n"
		
	}
	
}
