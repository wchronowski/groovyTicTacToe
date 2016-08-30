package aI
import board.TicTacToeBoard
import gameValues.*
import gameStatus.CheckGame
import gameValues.VictoryValue


class MiniMax {
	final HIGHEST_WINNING_SCORE = 10
	final LOWEST_LOSING_SCORE = -10
	final TIE = 0
	public MakeMove(TicTacToeBoard ticTacToeBoard) {
		def score = [[null, null, null], [null, null, null], [null, null, null]]
		for(row in 0..2) {
			for(column in 0..2) {
				score[row][column] = getMinScore(ticTacToeBoard.setBoardPositon(row, column, BoardValue.X), 0)
			}
		}
		return aiPick(score, ticTacToeBoard)
	}
	
	private aiPick(score, TicTacToeBoard ticTacToeBoard) {
		def maxScore = LOWEST_LOSING_SCORE
		def maxColumn = -1
		def maxRow = -1
		for(row in 0..2) {
			for(column in 0..2) {
				if(score[row][column]) {
					if(maxScore <= score[row][column] && score[row][column] != null) {
						maxScore = score[row][column]
						maxColumn = column
						maxRow = row
					}
				}
			}
		}
		return ticTacToeBoard.setBoardPositon(maxRow, maxColumn, BoardValue.X)
	}
	
	private getMaxScore(TicTacToeBoard ticTacToeBoard, depth) {
		if(!ticTacToeBoard)
			return null
		def currentGameScore = CheckGame.currentGameStatus(ticTacToeBoard)
		if(!currentGameScore.is(VictoryValue.ONGOING)) {
			return gameScore(currentGameScore) - depth
		}
		def score = [[null, null, null], [null, null, null], [null, null, null]]
		for(row in 0..2) {
			for(column in 0..2) {
				score[row][column] = getMinScore(ticTacToeBoard.setBoardPositon(row, column, BoardValue.X), depth + 1)
			}
		}
		return findMax(score)
	}
	
	private findMax(score) {
		def maxScore = LOWEST_LOSING_SCORE
		for(row in 0..2) {
			for(column in 0..2) {
				if(score[row][column] != null) {
					maxScore = maxScore <= score[row][column] ? score[row][column] : maxScore
				}
			}
		}
		return maxScore
	}
	
	private getMinScore(TicTacToeBoard ticTacToeBoard, depth) {
		if(!ticTacToeBoard)
			return null
		def currentGameScore = CheckGame.currentGameStatus(ticTacToeBoard)
		if(!currentGameScore.is(VictoryValue.ONGOING)) {
			return gameScore(currentGameScore) + depth
		}
		def score = [[null, null, null], [null, null, null], [null, null, null]]
		for(row in 0..2) {
			for(column in 0..2) {
				score[row][column] = getMaxScore(ticTacToeBoard.setBoardPositon(row, column, BoardValue.O), depth + 1)
			}
		}
		return findMini(score)
	}
	
	private findMini(score) {
		def minScore = HIGHEST_WINNING_SCORE
		for(row in 0..2) {
			for(column in 0..2) {
				if(score[row][column] != null) {
					minScore = minScore >= score[row][column] ? score[row][column] : minScore
				}
			}
		}
		return minScore
	}
	
	private gameScore(currentGameScore) {
		if(currentGameScore.is(VictoryValue.O))
			return LOWEST_LOSING_SCORE
		else if(currentGameScore.is(VictoryValue.X))
			return HIGHEST_WINNING_SCORE
		else
			return TIE
	}
}
