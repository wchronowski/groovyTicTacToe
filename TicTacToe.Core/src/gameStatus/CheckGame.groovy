package gameStatus
import gameValues.*

class CheckGame {
	
	static currentGameStatus(ticTacToeBoard) {
		if(checkForVictory(BoardValue.X, ticTacToeBoard))
			VictoryValue.X
		else if(checkForVictory(BoardValue.O, ticTacToeBoard))
			VictoryValue.O
		else if(checkForTie(ticTacToeBoard))
			VictoryValue.TIE
		else
			VictoryValue.ONGOING
	}
	
	private static checkForVictory(boradValue, ticTacToeBoard) {
		rowVictory(boradValue, ticTacToeBoard) || 
		columnVictory(boradValue, ticTacToeBoard) ||
		diagonalVictory(boradValue, ticTacToeBoard)
	}
	
	private static checkForTie(ticTacToeBoard) {
		for(boardRowValues in ticTacToeBoard.gameBoard) {
			for(boardValue in boardRowValues)
				if(boardValue.is(BoardValue.NONE))
					return false
		}
		true
	}
	
	private static diagonalVictory(boradValue, ticTacToeBoard) {
		checkForDiagonalVictory(0, 1, 2, boradValue, ticTacToeBoard) || 
		checkForDiagonalVictory(2, 1, 0, boradValue, ticTacToeBoard)
	}
	
	private static checkForDiagonalVictory(startIndex, middleIndex, endIndex, boradValue, ticTacToeBoard) {
		getBoardPostion(ticTacToeBoard, 0, startIndex).is(boradValue) &&
		getBoardPostion(ticTacToeBoard, 1, middleIndex).is(boradValue) &&
		getBoardPostion(ticTacToeBoard, 2, endIndex).is(boradValue)
	}
	
	private static columnVictory(boradValue, ticTacToeBoard) {
		checkForColumnVictory(boradValue, 0, ticTacToeBoard) ||
		checkForColumnVictory(boradValue, 1, ticTacToeBoard) ||
		checkForColumnVictory(boradValue, 2, ticTacToeBoard)
	}
	
	private static checkForColumnVictory (boradValue, columnIndex, ticTacToeBoard) {
		getBoardPostion(ticTacToeBoard, 0, columnIndex).is(boradValue) &&
		getBoardPostion(ticTacToeBoard, 1, columnIndex).is(boradValue) &&
		getBoardPostion(ticTacToeBoard, 2, columnIndex).is(boradValue)
	}
	
	private static rowVictory(boradValue, ticTacToeBoard) {
		checkForRowVictory(boradValue, 0, ticTacToeBoard) ||
		checkForRowVictory(boradValue, 1, ticTacToeBoard) ||
		checkForRowVictory(boradValue, 2, ticTacToeBoard)
	}
	
	private static checkForRowVictory(boradValue, rowIndex, ticTacToeBoard) {
		getBoardPostion(ticTacToeBoard, rowIndex , 0).is(boradValue) &&
		getBoardPostion(ticTacToeBoard, rowIndex, 1).is(boradValue) &&
		getBoardPostion(ticTacToeBoard, rowIndex, 2).is(boradValue)
	}
	
	private static getBoardPostion(ticTacToeBoard, row, column) {
		ticTacToeBoard.getBoardPositon(row, column)
	}
	
}
