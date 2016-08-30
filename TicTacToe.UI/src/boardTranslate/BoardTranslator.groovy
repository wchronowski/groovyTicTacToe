package boardTranslate
import board.TicTacToeBoard
import gameValues.BoardValue

class BoardTranslator {
	static translateToString(TicTacToeBoard board) {
		def convertedBoard = "-----------\n"
		for(row in 0..2) {
			convertedBoard += "|"
			for(column in 0..2) {
				convertedBoard += " " + translateBoardValueToString(board.gameBoard, row, column) + " |"
			}
			convertedBoard += "\n-----------\n"
		}
		convertedBoard
	}
	
	static translateBoardValueToString(board, row, column) {
		switch(board[row][column]) {
			case BoardValue.X:
				"X"
				break
			case BoardValue.O:
				"O"
				break
			default:
				row * 3 + column + 1	 
		}
	}
}
