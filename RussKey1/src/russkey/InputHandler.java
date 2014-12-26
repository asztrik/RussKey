package russkey;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class InputHandler {
	private CodeWordSelector cws = new CodeWordSelector();
	private CodeWordSelectorState cwss;
	private char in;
	private boolean[] mask = new boolean[10];
	private String resultWord = new String();
	
	/*
	 * Get Result Word for copying
	 */
	public String getResultWord() {
		return resultWord;
	}
    /*
     * First time run init function
     */
	public String initSM() {
		this.cwss = CodeWordSelectorState.INPUT;
		this.cws.initCodeWordSelector();
		return cws.convertWord();
	}
	
	/*
	 * General inputhandler
	 */
	public String setInputChar(int c) {
		in = (char) c;
		stateMachine(in);
		return cws.convertWord();
	}
	
	public boolean[] selectInputChar(int kc) {
		in = (char) kc;
		stateMachine(in);
		return mask;
	}
	
	public CodeWordSelectorState getInputHandlerState() {
		return cwss;
	}
	
	
	/*
	 * Function for state machine --> processing the inputs form AppFrame
	 */
	public void stateMachine(char in) {
		switch(cwss) {
			case INPUT:
				switch(in) { 
				case 'a': 
					cws.rollChar(0, true);
					break;
				case 'A': 
					cws.rollChar(0, false);
					break;
				case 's': 
					cws.rollChar(1, true);
					break;
				case 'S': 
					cws.rollChar(1, false);
					break;
				case 'd': 
					cws.rollChar(2, true);
					break;
				case 'D': 
					cws.rollChar(2, false);
					break;
				case 'f': 
					cws.rollChar(3, true);
					break;
				case 'F': 
					cws.rollChar(3, false);
					break;
				case 'g': 
					cws.rollChar(4, true);
					break;
				case 'G': 
					cws.rollChar(4, false);
					break;
				case 'h': 
					cws.rollChar(5, true);
					break;
				case 'H': 
					cws.rollChar(5, false);
					break;
				case 'j': 
					cws.rollChar(6, true);
					break;
				case 'J': 
					cws.rollChar(6, false);
					break;
				case 'k': 
					cws.rollChar(7, true);
					break;
				case 'K': 
					cws.rollChar(7, false);
					break;
				case 'l': 
					cws.rollChar(8, true);
					break;
				case 'L': 
					cws.rollChar(8, false);
					break;
				case 'é': 
					cws.rollChar(9, true);
					break;
				case 'É': 
					cws.rollChar(9, false);
					break;
				default:
					break;
				}
				break;
			case SELECT:
				switch(in) {
				case 'a': 
					if(mask[0])
						mask[0] = false;
					else
						mask[0] = true;
					break;
				case 's': 
					if(mask[1])
						mask[1] = false;
					else
						mask[1] = true;
					break;
				case 'd': 
					if(mask[2])
						mask[2] = false;
					else
						mask[2] = true;
					break;
				case 'f': 
					if(mask[3])
						mask[3] = false;
					else
						mask[3] = true;
					break;
				case 'g': 
					if(mask[4])
						mask[4] = false;
					else
						mask[4] = true;
					break;
				case 'h': 
					if(mask[5])
						mask[5] = false;
					else
						mask[5] = true;
					break;
				case 'j': 
					if(mask[6])
						mask[6] = false;
					else
						mask[6] = true;
					break;
				case 'k': 
					if(mask[7])
						mask[7] = false;
					else
						mask[7] = true;
					break;
				case 'l': 
					if(mask[8])
						mask[8] = false;
					else
						mask[8] = true;
					break;
				case 'é': 
					if(mask[9])
						mask[9] = false;
					else
						mask[9] = true;
					break;					
				default:
					break;
				}
				break;
			case SEND:
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				StringSelection strSel = new StringSelection(resultWord.trim());
				clipboard.setContents(strSel, null);
				break;
			default:
				
				break;
		}
	}

	public String changeState() {
		switch(cwss) {
		case INPUT:
			cwss = CodeWordSelectorState.SELECT;
			return "Select chars to copy";
		case SELECT:
			resultWord = cws.selectChars(mask);
			cwss = CodeWordSelectorState.SEND;
			return "Copy selected chars";
		case SEND:
			cwss = CodeWordSelectorState.INPUT;
			initSM();
			return "INPUT";
		default:
			return "???";
	}
		
	}


	
	
	
}
