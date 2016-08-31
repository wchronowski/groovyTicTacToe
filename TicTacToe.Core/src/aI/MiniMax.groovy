package aI
import board.TicTacToeBoard
import gameValues.*
import gameStatus.CheckGame
import gameValues.VictoryValue

enum ScoreSearchInformation {
	SCORE, ROW_COLUMN
}

enum MiniOrMax {
	MINI, MAX
}

class MiniMax {
	final HIGHEST_WINNING_SCORE = 10
	final LOWEST_LOSING_SCORE = -10
	final TIE = 0
	final COMPARE_FOR_MIN = {currentScore, newScore -> currentScore >= newScore}
	final COMPARE_FOR_MAX = {currentScore, newScore -> currentScore <= newScore}
	
	public makeMove(TicTacToeBoard ticTacToeBoard) {
		def score = [[null, null, null], [null, null, null], [null, null, null]]
		for(row in 0..2) {
			for(column in 0..2) {
				score[row][column] = processMiniMax(ticTacToeBoard.setBoardPositon(row, column, BoardValue.X), 1, MiniOrMax.MINI)
			}
		}
		aiPick(score, ticTacToeBoard)
	}
	
	private aiPick(score, TicTacToeBoard ticTacToeBoard) {
		def maxRow, maxColumn
		(maxRow, maxColumn) = findScoreInformationWithCompare(score, LOWEST_LOSING_SCORE, COMPARE_FOR_MAX, ScoreSearchInformation.ROW_COLUMN)
		ticTacToeBoard.setBoardPositon(maxRow, maxColumn, BoardValue.X)
	}
	
	private findScoreInformationWithCompare(scores, startingScore, compareFn, scoreSearchInformation) {
		def score = startingScore
		def scoreRow = -1
		def scoreColumn = -1
		for(row in 0..2) {
			for(column in 0..2) {
				(score, scoreRow, scoreColumn) =  setScoreRowAndColumn(score, scoreRow, scoreColumn, scores, row, column, compareFn)
			}
		}
		scoreSearchInformation == ScoreSearchInformation.SCORE ? score : [scoreRow, scoreColumn]
	}
	
	private setScoreRowAndColumn(score, scoreRow, scoreColumn, scores, row, column, compareFn) {
		if(scores[row][column] == null) {
			return [score, scoreRow, scoreColumn]
		}
		if(compareFn(score, scores[row][column]))
			return [scores[row][column], row, column]
		else
			return [score, scoreRow, scoreColumn]
	}
	
	private processMiniMax(TicTacToeBoard ticTacToeBoard, depth, miniOrMax) {
		if(!ticTacToeBoard)
			return null
		def currentGameScore = CheckGame.currentGameStatus(ticTacToeBoard)
		if(!currentGameScore.is(VictoryValue.ONGOING)) {
			return gameScore(currentGameScore, depth, miniOrMax)
		}
		def scores = scoreEachMove(ticTacToeBoard, depth, miniOrMax)
		def (startingScore, compare) = miniOrMax == MiniOrMax.MAX ? [LOWEST_LOSING_SCORE, COMPARE_FOR_MAX] 
									                   			  : [HIGHEST_WINNING_SCORE, COMPARE_FOR_MIN]
		findScoreInformationWithCompare(scores, startingScore, compare, ScoreSearchInformation.SCORE)
	}
	
	private scoreEachMove(TicTacToeBoard ticTacToeBoard, depth, miniOrMax) {
		def scores = [[null, null, null], [null, null, null], [null, null, null]]
		for(row in 0..2) {
			for(column in 0..2) {
				scores[row][column] = miniOrMax == MiniOrMax.MAX ?
					processMiniMax(ticTacToeBoard.setBoardPositon(row, column, BoardValue.X), depth + 1, MiniOrMax.MINI) :
					processMiniMax(ticTacToeBoard.setBoardPositon(row, column, BoardValue.O), depth + 1, MiniOrMax.MAX)
			}
		}
		scores
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
