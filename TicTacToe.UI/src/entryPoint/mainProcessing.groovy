package entryPoint
import aI.MiniMax
import board.TicTacToeBoard
import boardTranslate.*
import gameValues.*
import gameStatus.CheckGame

class mainProcessing {

	static main(args) {
		def game = new TicTacToeBoard()
		def ai = new MiniMax()
		while(!(CheckGame.currentGameStatus(game) != VictoryValue.ONGOING)) {
			println BoardTranslator.translateToString(game)
			println "Pick Value: "
			def (chosenRow, chosenColumn) = UserInputToBoardInput.covert(System.in.newReader().readLine())
			game = game.setBoardPositon(chosenRow, chosenColumn, BoardValue.O)
			if(!(CheckGame.currentGameStatus(game) != VictoryValue.ONGOING))
			game = ai.MakeMove(game)
		}
		println(CheckGame.currentGameStatus(game))
		println BoardTranslator.translateToString(game)
	}

}
