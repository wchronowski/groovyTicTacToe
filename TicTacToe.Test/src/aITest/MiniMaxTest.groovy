package aITest
import org.junit.Test
import board.TicTacToeBoard
import gameStatus.CheckGame
import aI.MiniMax
import gameValues.*
import boardTranslate.*

public class MiniMaxTest {

	@Test
	void Take_Winning_Move() {
		def exampleTicTacToeBoard = [[ BoardValue.O, BoardValue.NONE, BoardValue.NONE ],
									 [ BoardValue.X, BoardValue.X, BoardValue.NONE ],
									 [ BoardValue.O, BoardValue.NONE, BoardValue.O ]]
		
		def correctEndBoard = [[ BoardValue.O, BoardValue.NONE, BoardValue.NONE ],
							   [ BoardValue.X, BoardValue.X, BoardValue.X ],
							   [ BoardValue.O, BoardValue.NONE, BoardValue.O ]]
		
		def ai = new MiniMax();
		def aiEditBoard = ai.MakeMove(new TicTacToeBoard(exampleTicTacToeBoard))
		for(row in 0..2) {
			for(column in 0..2) {
				assert aiEditBoard.gameBoard[row][column] == correctEndBoard[row][column]
			}
		}
	}
	
	@Test
	void Play_Every_Possabile_Game() {
		def startingBoard = new TicTacToeBoard()
		def ai = new MiniMax();
		for(humanRowStart in 0..2) {
			for(humanColumnStart in 0..2) {
				nextMove(startingBoard, humanRowStart, humanColumnStart, ai)
			}
		}
	}
	
	private nextMove(currentBoard, humanChoosenRow, humanChoosenColumn, aiBot) {
		def boardWithMoves = currentBoard.setBoardPositon(humanChoosenRow, humanChoosenColumn, BoardValue.O)
		if(!boardWithMoves)
			return
		if(gameOver(boardWithMoves)) {
			testHumanDidNotWin(boardWithMoves)
			return
		}
		boardWithMoves = aiBot.MakeMove(boardWithMoves)
		if(gameOver(boardWithMoves)) {
			testHumanDidNotWin(boardWithMoves)
			return
		}
		for(nextHumanChoosenRow in 0..2) {
			for(nextHumanChoosenColumn in 0..2) {
				nextMove(boardWithMoves, nextHumanChoosenRow, nextHumanChoosenColumn, aiBot)
			}
		}
	}

	private gameOver(currentBoard) {
		!CheckGame.currentGameStatus(currentBoard).is(VictoryValue.ONGOING)
	}


	private testHumanDidNotWin(ticTacToeBoard) {
		assert CheckGame.currentGameStatus(ticTacToeBoard) != VictoryValue.O
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X || VictoryValue.TIE
	}
}
