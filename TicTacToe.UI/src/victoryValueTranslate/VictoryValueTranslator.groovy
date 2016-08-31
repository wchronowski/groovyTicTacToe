package victoryValueTranslate
import gameStatus.CheckGame
import gameValues.VictoryValue

class VictoryValueTranslator {
	static getWinner(endGameBoard) {
		switch(CheckGame.currentGameStatus(endGameBoard)) {
			case VictoryValue.X:
				"\nAi Won\n"
				break
			case VictoryValue.O:
				"\nHuman Won\n"
				break
			case VictoryValue.TIE:
				"\nTie\n"
				break
			default:
				"\nGame On-Going\n"
		}
	}
}
