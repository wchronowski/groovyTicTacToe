package aITest
import org.junit.Test
import board.TicTacToeBoard
import gameStatus.CheckGame
import aI.MiniMax
import gameValues.*

public class MiniMaxTest {

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
		if(gameOver(boardWithMoves)) {
			testHumanDidNotWin(boardWithMoves)
			return
		}
		boardWithMoves = aiBot.MakeMove(boardWithMoves)
		if(gameOver(boardWithMoves)) {
			testHumanDidNotWin(boardWithMoves)
			return
		}
		def nextHumanChoosenRow, nextHumanChoosenColumn
		(nextHumanChoosenRow, nextHumanChoosenColumn) = pickNextMove(boardWithMoves, humanChoosenRow, humanChoosenColumn)
		nextMove(boardWithMoves, nextHumanChoosenRow, nextHumanChoosenColumn, aiBot)
	}

	private pickNextMove(TicTacToeBoard currentBoard, humanChoosenRow, humanChoosenColumn) {
		def possibleRowPick = humanChoosenRow
		def possibleColumnPick = humanChoosenColumn
		while( !(currentBoard.setBoardPositon(possibleRowPick, possibleColumnPick, BoardValue.O)) ) {
			(possibleRowPick, possibleColumnPick) = setRowAndColumn(possibleRowPick, possibleColumnPick)
		}
		[possibleRowPick, possibleColumnPick]
	}

	private setRowAndColumn(humanChoosenRow, humanChoosenColumn) {
		def possibleRowPick = humanChoosenRow
		def possibleColumnPick = humanChoosenColumn
		possibleColumnPick++;
		if(possibleColumnPick + 1 > 2 && possibleRowPick + 1 > 2) {
			return [0, 0]
		}
		if(possibleColumnPick > 2) {
			possibleColumnPick = 0;
			possibleRowPick++;
		}
		if(possibleRowPick > 2) {
			possibleRowPick = 0;
			possibleColumnPick++;
		}
		[possibleRowPick, possibleColumnPick]}

	private gameOver(currentBoard) {
		!CheckGame.currentGameStatus(currentBoard).is(VictoryValue.ONGOING)
	}


	private testHumanDidNotWin(ticTacToeBoard) {
		assert CheckGame.currentGameStatus(ticTacToeBoard) != VictoryValue.O
		assert CheckGame.currentGameStatus(ticTacToeBoard) == VictoryValue.X || VictoryValue.TIE
	}
}