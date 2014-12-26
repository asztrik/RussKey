package russkey;

public class CodeWordSelector {
	private CodeWord cw;
	private CodeWordCoder cwc;
	
	/*
	 * Initialization round
	 */
	public void initCodeWordSelector() {
		cw = new CodeWord();
		cw.initCodeWord(10);
	}
	
	public CodeWord getCodeWord() {
		return cw;
	}
	
	/*
	 * Shift given char up/down
	 *    dir_up:
	 *         true -- Up
	 *         false -- Down
	 */
	public String rollChar(int char_num, boolean dir_up) {
		if(dir_up) {
			return cw.shiftUpChar_n(char_num);
		} else {
			return cw.shiftDownChar_n(char_num);
		}
	}
	
	/*
	 * Apply selection mask on CodeWord --> meaning only the 'TRUE' marked chars are going to be in the CodeWord to be coded
	 */
	public String selectChars(boolean[] mask) {
		return cw.applyMask(mask);
	}
	
	/*
	 * Do the conversion
	 */
	public String convertWord() {
		//cwc = new CodeWordCoder();
		//cwc.setInputWord(cw);
		//cwc.convert();
		//cw = cwc.getOutputWord();
		return cw.getCodeWord();
	}
	
	public void wordToClipboard() {
		// MAGIC cw --> clipboard
	}

}
