package russkey;


/*
 * RussKey uses a primitive State-Machine to determine what to do with the incoming keystrokes
 * 
 * INPUT means: select the chars to be coded using asdfghjkl...
 * SELECT means: select the chars to be sent to encoder
 * SEND meand: encoding, sending encoded word to the clipboard
 * 
 * State changes: ENTER strictly INPUT --> SELECT --> SEND --> INPUT --> ...
 * 
 * Additional states:
 * 
 * TBD
 * 
 */
public enum CodeWordSelectorState {
	INPUT, SELECT, SEND
}
