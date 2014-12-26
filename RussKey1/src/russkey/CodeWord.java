package russkey;

public class CodeWord {
	private String cw;
	private int len;
	
	/*
	 * Set Word length, alphabet, binding with code range
	 */
	public void initCodeWord(int initlen) {
		this.len = initlen;
		cw = new String("aaaaaaaaaa");
		for(int i=0; i<this.len; i++) {
			setCodeWord_n(i, '\u0430');
		}
	}
		
	/*
	 * Return CodeWord length
	 */
	public int getLen() {
		return len;
	}
	
	/*
	 * Set char @ given place
	 */
	public void setCodeWord_n(int char_num, char c) {
		StringBuilder tmp = new StringBuilder(cw);
		tmp.setCharAt(char_num, c);
		cw = tmp.toString();
	}
	
	/*
	 * Get char from a given place
	 */
	public char getCodeWord_n(int char_num) {
		return cw.charAt(char_num);
	}
	
	/*
	 * Get the whole word
	 */
	public String getCodeWord() {
		return cw;
	}
	
	/*
	 * Set the whole word to init
	 */
	public void resetCodeWord() {
		initCodeWord(len);
	}
	
	/*
	 * Roll a char @ a given place up (meaning backwards in the abc)
	 */
	public String shiftUpChar_n(int char_num) {
		int charcode = getCodeWord_n(char_num);
		if(charcode<1102)
			charcode++;
		else
			charcode=1071;
		setCodeWord_n(char_num, (char) charcode);
		return cw;
	}
	
	/*
	 * Roll a char @ a given place down (meaning forward in the abc)
	 */
	public String shiftDownChar_n(int char_num) {
		int charcode = getCodeWord_n(char_num);
		if(charcode>1071)
			charcode--;
		else
			charcode=1102;
		setCodeWord_n(char_num, (char) charcode);
		return cw;
	}
	
	
	/*
	 * Apply selection mask on the string
	 */
	public String applyMask(boolean[] mask) {
		StringBuilder tmp = new StringBuilder();
		int tmp_l = 0;
		for(int i = 0;i<len;i++) {
			if(mask[i]) {
				tmp.append(cw.charAt(i));
				tmp_l++;
			}
		}
		
		for(int i=tmp_l;i<len;i++) {
			tmp.append(' ');
		}
		
		cw = tmp.toString();
		return cw;
	}

	
	
}
