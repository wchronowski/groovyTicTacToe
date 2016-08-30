package boardTranslate

class UserInputToBoardInput {
	static covert(userInput) {
		if(!userInput.isInteger())
			return [null, null]
		def cleanUserInput = userInput.toInteger()
		if(cleanUserInput < 1 ||cleanUserInput > 9)
			return [null, null]
		[(normalize(cleanUserInput)/ 3) as Integer, normalize(cleanUserInput) % 3]
	}
	
	static normalize(userInput) {
		userInput - 1
	}
}
