package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame1 extends JFrame{
	JLabel label1, label2 ;
	JTextField username;
	JPasswordField password;
	JButton login;
	
	MyFrame1(){
		setBounds(350,100,700,500);
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		Container c = getContentPane();
		c.setLayout(null);
		
		label1 = new JLabel("Username: ");
		label1.setBounds(100,50,150,100);
		label1.setFont(new Font("Arial", Font.PLAIN, 25));
		c.add(label1);
		
		label2 = new JLabel("Password: ");
		label2.setBounds(100,150,150,100);
		label2.setFont(new Font("Arial", Font.PLAIN, 25));
		c.add(label2);
		
		username = new JTextField();
		username.setBounds(300,85,180,35);
		username.setFont(new Font("Arial", Font.PLAIN, 20));
		username.setHorizontalAlignment(JTextField.CENTER);
		c.add(username);
		
		password = new JPasswordField();
		password.setBounds(300,185,180,35);
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setHorizontalAlignment(JPasswordField.CENTER);
		password.setEchoChar('*');
		c.add(password);

		login = new JButton("Login");
		login.setBounds(250,290,150,50);
		login.setFont(new Font("Arial", Font.PLAIN, 25));
		c.add(login);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new secondFrame();
			}
		});
//		set();
		setVisible(true);
	}
}
class secondFrame extends JFrame implements ActionListener{
	int current = 0;
	int count = 0;
	JLabel ques;
	JButton submit;
	JRadioButton[] r = new JRadioButton[4];
	ButtonGroup bg;
	
	public secondFrame() {
		setBounds(350,100,700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c1 = this.getContentPane();
		c1.setLayout(null);
		
		ques = new JLabel();
		ques.setBounds(50,50,700,100);
		ques.setFont(new Font("Arial", Font.PLAIN, 20));
		c1.add(ques);
		
		bg = new ButtonGroup();
		for(int i=0; i<4; i++) {
			r[i] = new JRadioButton();
			r[i].setFont(new Font("Arial", Font.PLAIN, 18));
			c1.add(r[i]);
			bg.add(r[i]);
		}
		r[0].setBounds(50,150,300,20);
		r[1].setBounds(50,200,300,20);
		r[2].setBounds(50,250,300,20);
		r[3].setBounds(50,300,300,20);
		
		submit = new JButton("Submit");
		submit.setBounds(280,360,100,35);
		submit.setFont(new Font("Arial", Font.PLAIN, 20));
		c1.add(submit);
		submit.addActionListener(this);
		
		setVisible(true);
		set();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) { 
			if(check()) {
				count++;
			}
			current++;
			set();
			if(current == 4) {
				submit.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Result")) {
			if(check()) {
				count++;
			}
			current++;
			JOptionPane.showMessageDialog(ques, "Your score : " + count + " out of 5");
			System.exit(0);
		}
	}
	public void set() {
//		r[3].setSelected(false);
		if(current == 0) {
			ques.setText("Ques1: Number of primitive datatypes in java are? ");
			r[0].setText("6");
			r[1].setText("7");
			r[2].setText("8");
			r[3].setText("9");
		}
		if(current == 1) {
			ques.setText("Ques2: What is size of float and double in java? ");
			r[0].setText("32 and 64");
			r[1].setText("32 and 32");
			r[2].setText("64 and 64");
			r[3].setText("64 and 32");
		}
		if(current == 2) {
			ques.setText("Ques3: Array in java are? ");
			r[0].setText("Object references");
			r[1].setText("Objects");
			r[2].setText("Primitive Data Type");
			r[3].setText("None");
		}
		if(current == 3) {
			ques.setText("Ques4: In which of the following is toString() method defined?");
			r[0].setText("java.lang.Object");
			r[1].setText("java.lang.String");
			r[2].setText("java.lang.util");
			r[3].setText("None");
		}
		if(current == 4) {
			ques.setText("Ques5: compareTo() returns");
			r[0].setText("True");
			r[1].setText("False");
			r[2].setText("An int value");
			r[3].setText("None");
		}
	}
	public boolean check() {
		if(current == 0) {
			return r[2].isSelected();
		}
		if(current == 1) {
			return r[0].isSelected();
		}
		if(current == 2) {
			return r[1].isSelected();
		}
		if(current == 3) {
			return r[0].isSelected();
		}
		if(current == 4) {
			return r[2].isSelected();
		}
		return false;
	}
}

public class Task2_OnlineExamination {
	public static void main(String[] args) {
		new MyFrame1();
		
	}


}
