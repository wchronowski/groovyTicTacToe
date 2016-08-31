package entryPoint
import aI.MiniMax
import board.TicTacToeBoard
import boardTranslate.*
import gameValues.*
import gameStatus.CheckGame
import victoryValueTranslate.VictoryValueTranslator

class MainProcessing {

	static main(args) {
		def game = new TicTacToeBoard()
		def ai = new MiniMax()
		while(!(CheckGame.currentGameStatus(game) != VictoryValue.ONGOING)) {
			println BoardTranslator.translateToString(game)
			println "Pick Value: "
			def (chosenRow, chosenColumn) = UserInputToBoardInput.convert(System.in.newReader().readLine())
			game = setHumanAndAiMove(chosenRow, chosenColumn, game, ai)
		}
		println VictoryValueTranslator.getWinner(game)
		println BoardTranslator.translateToString(game)
	}
	
	static setBoard(chosenRow, chosenColumn, game) {
		def newGameBoard = game.setBoardPositon(chosenRow, chosenColumn, BoardValue.O)
		if(newGameBoard)
			[newGameBoard, true]
		else
			[game, false]
	}
	
	static aIMakesMove(game, ai) {
		if(CheckGame.currentGameStatus(game) == VictoryValue.ONGOING)
			ai.MakeMove(game)
		else
			game
	}
	
	static setHumanAndAiMove(chosenRow, chosenColumn, game, ai) {
		if(chosenRow == null || chosenColumn == null)
			return game
		def madeSucssfulMove, newGame
		(newGame, madeSucssfulMove) = setBoard(chosenRow, chosenColumn, game)
		if(madeSucssfulMove)
			aIMakesMove(newGame, ai)
		else
			game
	}

}
