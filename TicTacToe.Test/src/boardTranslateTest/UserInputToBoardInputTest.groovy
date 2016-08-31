package boardTranslateTest
import boardTranslate.UserInputToBoardInput
import org.junit.Test

class UserInputToBoardInputTest {
	
	@Test
	void User_Inputs_1() {
		def (row, column) = UserInputToBoardInput.convert("1")
		assert row == 0
		assert column == 0
	}
	
	@Test
	void User_Inputs_2() {
		def (row, column) = UserInputToBoardInput.convert("2")
		assert row == 0
		assert column == 1
	}
	
	@Test
	void User_Inputs_3() {
		def (row, column) = UserInputToBoardInput.convert("3")
		assert row == 0
		assert column == 2
	}
	
	@Test
	void User_Inputs_4() {
		def (row, column) = UserInputToBoardInput.convert("4")
		assert row == 1
		assert column == 0
	}
	
	@Test
	void User_Inputs_5() {
		def (row, column) = UserInputToBoardInput.convert("5")
		assert row == 1
		assert column == 1
	}
	
	@Test
	void User_Inputs_6() {
		def (row, column) = UserInputToBoardInput.convert("6")
		assert row == 1
		assert column == 2
	}
	
	@Test
	void User_Inputs_7() {
		def (row, column) = UserInputToBoardInput.convert("7")
		assert row == 2
		assert column == 0
	}
	
	@Test
	void User_Inputs_8() {
		def (row, column) = UserInputToBoardInput.convert("8")
		assert row == 2
		assert column == 1
	}
	
	@Test
	void User_Inputs_9() {
		def (row, column) = UserInputToBoardInput.convert("9")
		assert row == 2
		assert column == 2
	}
	
	@Test
	void User_Inputs_None_Number() {
		def (row, column) = UserInputToBoardInput.convert("e")
		assert row == null
		assert column == null
	}
	
	@Test
	void User_Inputs_0() {
		def (row, column) = UserInputToBoardInput.convert("0")
		assert row == null
		assert column == null
	}
	
	@Test
	void User_Inputs_10() {
		def (row, column) = UserInputToBoardInput.convert("10")
		assert row == null
		assert column == null
	}
}
