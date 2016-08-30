package boardTest
import org.junit.Test
import board.TicTacToeBoard
import gameValues.BoardValue

public class TicTacToeBoardTest {
	
	@Test
	void Make_New_Empty_Class(){
		def ticTacToeBoard = new TicTacToeBoard()
		for(boardRow in ticTacToeBoard.gameBoard)
			for(boardRowValue in boardRow)
				assert boardRowValue == BoardValue.NONE
	}
	
	@Test
	void Make_New_Board_From_Array() {
		def exampleTicTacToeBoard = [[ BoardValue.X, BoardValue.O, BoardValue.X ],
									 [ BoardValue.O, BoardValue.X, BoardValue.O ],
									 [ BoardValue.O, BoardValue.X, BoardValue.O ]]
		def ticTacToeBoard = new TicTacToeBoard(exampleTicTacToeBoard)
		
		for(row in 0..< exampleTicTacToeBoard.size())
			for(col in 0..< exampleTicTacToeBoard[row].size())
				assert ticTacToeBoard.gameBoard[row][col] == exampleTicTacToeBoard[row][col]
		
	}
	
	@Test
	void Make_New_Board_From_Another_Board() {
		def ticTacToeBoard = new TicTacToeBoard()
		ticTacToeBoard.gameBoard[1][0] = BoardValue.O
		def newticTacToeBoard = new TicTacToeBoard(ticTacToeBoard)
		assert  ticTacToeBoard.gameBoard[1][0] ==  BoardValue.O
	}
	
	@Test
	void Edit_TicTacToeBoard(){
		def ticTacToeBoard = new TicTacToeBoard()
		for(boardRow in ticTacToeBoard.gameBoard)
			for(boardRowValue in boardRow)
				assert boardRowValue == BoardValue.NONE
		
		def newBoard = ticTacToeBoard.setBoardPositon(1,1, BoardValue.X)
		assert  newBoard.gameBoard[1][1] ==  BoardValue.X
	}
	
	@Test
	void Cant_Override_Value_On_TicTacToeBoard(){
		def ticTacToeBoard = new TicTacToeBoard()
		for(boardRow in ticTacToeBoard.gameBoard)
			for(boardRowValue in boardRow)
				assert boardRowValue == BoardValue.NONE
		
		def newBoard = ticTacToeBoard.setBoardPositon(1,1, BoardValue.X)
		assert  newBoard.gameBoard[1][1] ==  BoardValue.X
		
		def editNewBoard = newBoard.setBoardPositon(1,1, BoardValue.O)
		assert editNewBoard == null
	}
	
	@Test
	void Get_TicTacToeBoardValue() {
		def ticTacToeBoard = new TicTacToeBoard()
		ticTacToeBoard.gameBoard[1][0] = BoardValue.O
		assert  ticTacToeBoard.getBoardPositon(1, 0) ==  BoardValue.O
	}
}
