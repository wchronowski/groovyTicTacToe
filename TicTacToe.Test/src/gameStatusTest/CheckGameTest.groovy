package gameStatusTest
import org.junit.Test
import gameValues.*
import gameStatus.CheckGame
import board.TicTacToeBoard

public class CheckGameTest {

	@Test
	void New_Board_No_Winner() {
		def ticTacToeBoard = new TicTacToeBoard()
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.ONGOING 
	}
	
	@Test
	void Tie_Game() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.O, BoardValue.X ],
							 [ BoardValue.O, BoardValue.X, BoardValue.O ],
							 [ BoardValue.O, BoardValue.X, BoardValue.O ]])

		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.TIE
	}
	
	@Test
	void Row_One_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.O, BoardValue.O, BoardValue.O ],
							 [ BoardValue.X, BoardValue.NONE, BoardValue.X ],
							 [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O 
	}
	
	@Test
	void Row_Two_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.NONE, BoardValue.X ],
			[ BoardValue.O, BoardValue.O, BoardValue.O ],
			[ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O
	}
	
	@Test
	void Row_Three_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.NONE, BoardValue.X ],
							 [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ],
							 [ BoardValue.O, BoardValue.O, BoardValue.O ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O
	}
	
	@Test
	void Row_One_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.X, BoardValue.X ],
							 [ BoardValue.O, BoardValue.NONE, BoardValue.O ],
							 [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}
	
	@Test
	void Row_Two_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.O, BoardValue.NONE, BoardValue.O ],
			[ BoardValue.X, BoardValue.X, BoardValue.X ],
			[ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}
	
	@Test
	void Row_Three_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.O, BoardValue.NONE, BoardValue.O ],
							 [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ],
							 [ BoardValue.X, BoardValue.X, BoardValue.X ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}

	@Test
	void Col_One_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.O, BoardValue.X, BoardValue.NONE ],
							 [ BoardValue.O, BoardValue.NONE, BoardValue.X ],
							 [ BoardValue.O, BoardValue.NONE, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O
	}
	
	@Test
	void Col_Two_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.O, BoardValue.NONE ],
							 [ BoardValue.NONE, BoardValue.O, BoardValue.X ],
							 [ BoardValue.NONE, BoardValue.O, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O
	}
	
	@Test
	void Col_Three_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.X, BoardValue.O ],
							 [ BoardValue.NONE, BoardValue.X, BoardValue.O ],
							 [ BoardValue.NONE, BoardValue.NONE, BoardValue.O ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O
	}
	
	@Test
	void Col_One_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.O, BoardValue.NONE ],
							 [ BoardValue.X, BoardValue.NONE, BoardValue.O ],
							 [ BoardValue.X, BoardValue.NONE, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}
	
	@Test
	void Col_Two_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.O, BoardValue.X, BoardValue.NONE ],
							 [ BoardValue.NONE, BoardValue.X, BoardValue.O ],
							 [ BoardValue.NONE, BoardValue.X, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}
	
	@Test
	void Col_Three_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.O, BoardValue.O, BoardValue.X ],
							 [ BoardValue.NONE, BoardValue.O, BoardValue.X ],
							 [ BoardValue.NONE, BoardValue.NONE, BoardValue.X ]])	
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}
	
	@Test
	void Diagonal_Left_To_Right_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.X, BoardValue.O, BoardValue.NONE ],
							 [ BoardValue.NONE, BoardValue.X, BoardValue.NONE ],
							 [ BoardValue.NONE, BoardValue.O, BoardValue.X ]])		
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}
	
	@Test
	void Diagonal_Right_To_Left_X_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.NONE, BoardValue.O, BoardValue.X ],
							 [ BoardValue.NONE, BoardValue.X, BoardValue.NONE ],
							 [ BoardValue.X, BoardValue.O, BoardValue.NONE ]])
				
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X
	}
	
	@Test
	void Diagonal_Left_To_Right_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.O, BoardValue.X, BoardValue.NONE ],
							 [ BoardValue.NONE, BoardValue.O, BoardValue.NONE ],
							 [ BoardValue.NONE, BoardValue.X, BoardValue.O ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O
	}
	
	@Test
	void Diagonal_Right_To_Left_O_Winner() {
		def ticTacToeBoard = new TicTacToeBoard([[ BoardValue.NONE, BoardValue.X, BoardValue.O ],
							 [ BoardValue.NONE, BoardValue.O, BoardValue.NONE ],
							 [ BoardValue.O, BoardValue.X, BoardValue.NONE ]])
		
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.O
	}
}
