package russkey;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;  

public class AppFrame implements KeyListener {

	
	static String disp_cw = "Hit SPACE!";
	static String disp_st = ":)";
	static boolean[] disp_sel = new boolean[10];
	static InputHandler ihdlr = new InputHandler();

	JFrame frame = new JFrame("RussKey zer0");
	Container pane = new Container();
	FlowLayout lout = new FlowLayout();
    JLabel l0 = new JLabel(disp_cw.substring(0, 1));
    JLabel l1 = new JLabel(disp_cw.substring(1, 2));
    JLabel l2 = new JLabel(disp_cw.substring(2, 3));
    JLabel l3 = new JLabel(disp_cw.substring(3, 4));
    JLabel l4 = new JLabel(disp_cw.substring(4, 5));
    JLabel l5 = new JLabel(disp_cw.substring(5, 6));
    JLabel l6 = new JLabel(disp_cw.substring(6, 7));
    JLabel l7 = new JLabel(disp_cw.substring(7, 8));
    JLabel l8 = new JLabel(disp_cw.substring(8, 9));
    JLabel l9 = new JLabel(disp_cw.substring(9, 10));
    JLabel st = new JLabel(disp_st);
	
	public void frameInit() {
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.addKeyListener(this);
	    pane = frame.getContentPane();
	    pane.setLayout(lout);
	    for(int i = 0;i<10;i++) {
	    	disp_sel[i] = false;
	    }
	}
    
	Font selected_font = new Font("Arial", Font.BOLD, 28);
    Font nonselected_font = new Font("Arial", Font.PLAIN, 28);     
	
	
	
    public void createAndShowGUI() {
  
        

        l0.setText(disp_cw.substring(0, 1));
    	if(disp_sel[0])
    		l0.setFont(selected_font);
    	else
    		l0.setFont(nonselected_font);
    	pane.add(l0);
        l1.setText(disp_cw.substring(1, 2));
    	if(disp_sel[1])
    		l1.setFont(selected_font);
    	else
    		l1.setFont(nonselected_font);
	    	pane.add(l1);
	    l2.setText(disp_cw.substring(2, 3));
    	if(disp_sel[2])
    		l2.setFont(selected_font);
    	else
    		l2.setFont(nonselected_font);
	    	pane.add(l2);
	    l3.setText(disp_cw.substring(3, 4));
    	if(disp_sel[3])
    		l3.setFont(selected_font);
    	else
    		l3.setFont(nonselected_font);
	    	pane.add(l3);
	    l4.setText(disp_cw.substring(4, 5));
    	if(disp_sel[4])
    		l4.setFont(selected_font);
    	else
    		l4.setFont(nonselected_font);
	    	pane.add(l4);
		l5.setText(disp_cw.substring(5, 6));
    	if(disp_sel[5])
    		l5.setFont(selected_font);
    	else
    		l5.setFont(nonselected_font);
	    	pane.add(l5);
		l6.setText(disp_cw.substring(6, 7));
    	if(disp_sel[6])
    		l6.setFont(selected_font);
    	else
    		l6.setFont(nonselected_font);
	    	pane.add(l6);
		l7.setText(disp_cw.substring(7, 8));
    	if(disp_sel[7])
    		l7.setFont(selected_font);
    	else
    		l7.setFont(nonselected_font);
	    	pane.add(l7);
		l8.setText(disp_cw.substring(8, 9));
    	if(disp_sel[8])
    		l8.setFont(selected_font);
    	else
    		l8.setFont(nonselected_font);
	    	pane.add(l8);
		l9.setText(disp_cw.substring(9, 10));
    	if(disp_sel[9])
    		l9.setFont(selected_font);
    	else
    		l9.setFont(nonselected_font);
	    	pane.add(l9);
	    	
	    st.setText(disp_st);
	    pane.add(st);
 

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
 }  
    
    
 

    
	 public void startAppFrame() {
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	frameInit();
	            createAndShowGUI();
	        }
	    });   
	 }
    
    
	@Override
	public void keyPressed(KeyEvent arg0) {
		int kc = arg0.getKeyChar();
		switch(kc) {
		case 27:
			frame.dispose();
			System.exit(0);
		case 32: 
			System.out.println(kc);
			disp_cw = ihdlr.initSM();
			disp_st = "INPUT";
			break;
		case 10:
			System.out.println("tíz");
			disp_st = ihdlr.changeState();
		    for(int i = 0;i<10;i++) {
		    	disp_sel[i] = false;
		    }
		default:
			if (ihdlr.getInputHandlerState() == CodeWordSelectorState.SELECT) {
			disp_sel = ihdlr.selectInputChar(kc);
			} else {
			System.out.println(kc);
			disp_cw = ihdlr.setInputChar(kc);
			}
			break;
		}
		refresh();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void refresh() {
		System.out.println(disp_cw);
		System.out.println(disp_sel[0]);
		createAndShowGUI();
	}
	
}