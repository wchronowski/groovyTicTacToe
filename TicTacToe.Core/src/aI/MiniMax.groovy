package aI
import board.TicTacToeBoard
import gameValues.*
import gameStatus.CheckGame
import gameValues.VictoryValue

enum MiniOrMax {
	MINI, MAX
}

class MiniMax {
	final HIGHEST_WINNING_SCORE = 10
	final LOWEST_LOSING_SCORE = -10
	final TIE = 0
	final COMPARE_FOR_MIN = {currentScore, score -> currentScore >= score ? score : currentScore}
	final COMPARE_FOR_MAX = {currentScore, score -> currentScore <= score ? score : currentScore}
	
	public MakeMove(TicTacToeBoard ticTacToeBoard) {
		def score = [[null, null, null], [null, null, null], [null, null, null]]
		for(row in 0..2) {
			for(column in 0..2) {
				score[row][column] = processMiniMax(ticTacToeBoard.setBoardPositon(row, column, BoardValue.X), 1, MiniOrMax.MINI)
			}
		}
		aiPick(score, ticTacToeBoard)
	}
	
	private aiPick(score, TicTacToeBoard ticTacToeBoard) {
		def maxScore = LOWEST_LOSING_SCORE
		def maxColumn = -1
		def maxRow = -1
		for(row in 0..2) {
			for(column in 0..2) {
				if(score[row][column] != null && maxScore <= score[row][column]) {
					maxScore = score[row][column]
					maxColumn = column
					maxRow = row
				}
			}
		}
		ticTacToeBoard.setBoardPositon(maxRow, maxColumn, BoardValue.X)
	}
	
	private findScoreWithCompare(scores, startingScore, compareFn) {
		def score = startingScore
		for(row in 0..2) {
			for(column in 0..2) {
				if(scores[row][column] != null) {
					score = compareFn(score, scores[row][column])
				}
			}
		}
		score
	}
	
	private processMiniMax(TicTacToeBoard ticTacToeBoard, depth, miniOrMax) {
		if(!ticTacToeBoard)
			return null
		def currentGameScore = CheckGame.currentGameStatus(ticTacToeBoard)
		if(!currentGameScore.is(VictoryValue.ONGOING)) {
			return gameScore(currentGameScore, depth, miniOrMax)
		}
		def scores = [[null, null, null], [null, null, null], [null, null, null]]
		for(row in 0..2) {
			for(column in 0..2) {
				scores[row][column] = miniOrMax == MiniOrMax.MAX ?
					processMiniMax(ticTacToeBoard.setBoardPositon(row, column, BoardValue.X), depth + 1, MiniOrMax.MINI) :
					processMiniMax(ticTacToeBoard.setBoardPositon(row, column, BoardValue.O), depth + 1, MiniOrMax.MAX)
			}
		}
		def (startingScore, compare) = miniOrMax == MiniOrMax.MAX ? [LOWEST_LOSING_SCORE, COMPARE_FOR_MAX] 
									                   			  : [HIGHEST_WINNING_SCORE, COMPARE_FOR_MIN]
		findScoreWithCompare(scores, startingScore, compare)
	}
	
	private gameScore(currentGameScore, depth, miniOrMax) {
		def score = TIE
		if(currentGameScore.is(VictoryValue.O))
			score = LOWEST_LOSING_SCORE
		else if(currentGameScore.is(VictoryValue.X))
			score = HIGHEST_WINNING_SCORE
		miniOrMax == MiniOrMax.MAX ? score - depth : score + depth 
	}
}
