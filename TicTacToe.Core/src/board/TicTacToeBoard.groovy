package board
import gameValues.BoardValue

class TicTacToeBoard {

	def gameBoard
	
	TicTacToeBoard() {
		this.gameBoard = [[ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ],
				          [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ],
						  [ BoardValue.NONE, BoardValue.NONE, BoardValue.NONE ]]
	}
	
	TicTacToeBoard(TicTacToeBoard game) {
		this.copyArray(game.gameBoard)
	}
	
	TicTacToeBoard(gameBoard) {
		this.copyArray(gameBoard)
	}
	
	TicTacToeBoard setBoardPositon(rowIndex, columnIndex, newBoardValue) {
		def newBoard = new TicTacToeBoard(this)
		newBoard.gameBoard[rowIndex][columnIndex] = newBoardValue
		newBoard
	}
	
	BoardValue getBoardPositon(rowIndex, columnIndex) {
		return this.gameBoard[rowIndex][columnIndex]
	}
	
	private void copyArray(gameBoard) {
		this.gameBoard = new BoardValue[gameBoard.size()][gameBoard[0].size()]
		for(row in 0..< gameBoard.size())
			for(col in 0..< gameBoard[row].size())
				this.gameBoard[row][col] = gameBoard[row][col]
	}
	
}
