package com.java.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class OnlineTestClass extends JFrame implements ActionListener {
	JLabel l;
	JRadioButton but[] = new JRadioButton[5];
	JButton b1, b2;
	ButtonGroup bg;
	int count = 0, curr = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	
	OnlineTestClass(String s) {
		super(s);
		
		l = new JLabel();
		add(l);
		bg = new ButtonGroup();
		for(int i=0; i<5; i++) {
			but[i] = new JRadioButton();
			add(but[i]);
			bg.add(but[i]);
		}
		b1 = new JButton("Next");
		b2 = new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		set();
		l.setBounds(30,40,450,20);
		but[0].setBounds(50,80,100,20);
		but[1].setBounds(50,110,100,20);
		but[2].setBounds(50,140,100,20);
		but[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			if(check()) {
				count++;
			}
			curr++;
			set();
			if(curr == 9) {
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		
		if(e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x] = curr;
			x++;
			curr++;
			set();
			if(curr == 9) {
				b2.setText("Result");
			}
			setVisible(false);
			setVisible(true);
		}
		
		for(int i=0, y=1; i<x; i++,y++) {
			if(e.getActionCommand().equals("Bookmark")) {
				if(check()) {
					count++;
				}
				now = curr;
				curr = m[y];
				set();
				((JButton)e.getSource()).setEnabled(false);
				curr = now;
			}
		}
		
		if(e.getActionCommand().equals("Result")) {
			if(check()) count++;
			curr++;
			JOptionPane.showMessageDialog(this, "correct answer = " + count);
			System.exit(0);
		}
	}
	
	void set() {
		but[4].setSelected(true);
		if(curr == 0) {
			l.setText("Q 1: Which one among these is not a Primitive Data type?");
			but[0].setText("int");
			but[1].setText("Float");
			but[2].setText("boolean");
			but[3].setText("char");
		}
		
		if(curr == 1) {
			l.setText("Q 2: Which of the follwing is Parent class of all classes?");
			but[0].setText("Swing");
			but[1].setText("Applet");
			but[2].setText("ActionEventListener");
			but[3].setText("Object");
		}
		
		if(curr == 2) {
			l.setText("Q 3: Select the valid statement to declare and initialize an array?");
			but[0].setText("int[] arr = {}");
			but[1].setText("int[] arr = {1,2,3}");
			but[2].setText("int []arr = (1,2,3)");
			but[3].setText("int[][] arr = {1,2,3}");
		}
		
		if(curr == 3) {
			l.setText("Q 4: Data Structure that follows insertion order?");
			but[0].setText("ArrayList");
			but[1].setText("Set");
			but[2].setText("Queue");
			but[3].setText("Map");
		}
		
		if(curr == 4) {
			l.setText("Q 5: Which of the following can be accessed with in the same package?");
			but[0].setText("Private");
			but[1].setText("Public");
			but[2].setText("Default");
			but[3].setText("Protected");
		}
		
		if(curr == 5) {
			l.setText("Q 6: Exception created by try block is caught in which block?");
			but[0].setText("final");
			but[1].setText("throw");
			but[2].setText("catch");
			but[3].setText("none");
		}
		
		if(curr == 6) {
			l.setText("Q 7: Find out the output of the following code. \n"
					+ "int Integer = 24; \n"
					+ "char String = 'I'; \n"
					+ "System.out.print(Integer); \n"
					+ "System.out.print(String); \n");
			but[0].setText("Compile error");
			but[1].setText("Throws exception");
			but[2].setText("I");
			but[3].setText("24 I");
		 }
		
		if(curr == 7) {
			l.setText("Q 8: Select the valid statement.");
			but[0].setText("char[] ch = new char()");
			but[1].setText("char[] ch = new char[5]");
			but[2].setText("char[] ch = new char()");
			but[3].setText("char[] ch = new char[]");
		}
		
		if(curr == 8) {
			l.setText("Q 9: When is the object created with new keyword?");
			but[0].setText("At run time");
			but[1].setText("At compile time");
			but[2].setText("Depends on the code");
			but[3].setText("None");
		}
		
		if(curr == 9) {
			l.setText("Q 10: In which of the following is toString() method defined?");
			but[0].setText("java.lang.Object");
			but[1].setText("java.lang.String");
			but[2].setText("java.lang.util");
			but[3].setText("None");
		}
		
		l.setBounds(30,40,450,20);
		for(int i=0,j=0; i<=90; i+=30, j++) {
			but[j].setBounds(50,80+i,200,20);
		}

	}
	
	boolean check() {
		if(curr == 0) {
			return (but[1].isSelected());
		}
		if(curr == 1) {
			return (but[3].isSelected());
		}
		if(curr == 2) {
			return (but[1].isSelected());
		}
		if(curr == 3) {
			return (but[0].isSelected());
		}
		if(curr == 4) {
			return (but[3].isSelected());
		}
		if(curr == 5) {
			return (but[2].isSelected());
		}
		if(curr == 6) {
			return (but[0].isSelected());
		}
		if(curr == 7) {
			return (but[1].isSelected());
		}
		if(curr == 8) {
			return (but[1].isSelected());
		}
		if(curr == 9) {
			return (but[2].isSelected());
		}
		return false;
	}
	
	public static void main(String[] args) {
		new OnlineTestClass("Online Text of Java");
	}
	
}
