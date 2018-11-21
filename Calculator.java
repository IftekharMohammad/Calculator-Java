import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	private JLabel display;
	private JButton equal, clear,plus,minus,mult,div,point;
	private JButton button[] = new JButton[10];
	private JPanel panel;
	private static double var1,var2,result;
	private static char mark;
	public Calculator(){
		super("Calculator");
		this.setSize(450,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		display = new JLabel();
		display.setBounds(20,10,400,50);
		display.setBackground(Color.WHITE);
		display.setOpaque(true);
		panel.add(display);

		int col =0; int row =0;int y=0;
		for(int i=9;i>=0;i--){
			button[9-i] = new JButton(""+i);
			if(row%3==0)
				y+=80;
			button[9-i].setBounds(20+(col%3*(70+20)),y,70,70);
			button[9-i].setBackground(Color.BLACK);
			button[9-i].setForeground(Color.WHITE);
			button[9-i].setFont(new Font("Times New Roman", Font.BOLD, 18));
			button[9-i].addActionListener(this);
			panel.add(button[9-i]);
			row++;
			col++;
		}
		point = new JButton(".");
		point.setBounds(110,320,70,70);
		point.setBackground(Color.BLACK);
		point.setForeground(Color.WHITE);
		point.setFont(new Font("Times New Roman", Font.BOLD, 18));
		point.addActionListener(this);
		panel.add(point);
		
		equal = new JButton("=");
		equal.setBounds(200,320,70,70);
		equal.setBackground(Color.BLACK);
		equal.setForeground(Color.WHITE);
		equal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		equal.addActionListener(this);
		panel.add(equal);
		
		clear = new JButton("C");
		clear.setBounds(290,80,120,52);
		clear.setBackground(Color.RED);
		clear.setForeground(Color.BLACK);
		clear.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clear.addActionListener(this);
		panel.add(clear);
		
		plus = new JButton("+");
		plus.setBounds(290,142,120,52);
		plus.setBackground(Color.GREEN);
		plus.setForeground(Color.BLACK);
		plus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		plus.addActionListener(this);
		panel.add(plus);

		minus = new JButton("-");
		minus.setBounds(290,204,120,52);
		minus.setBackground(Color.GREEN);
		minus.setForeground(Color.BLACK);
		minus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		minus.addActionListener(this);
		panel.add(minus);

		mult = new JButton("*");
		mult.setBounds(290,266,120,52);
		mult.setBackground(Color.GREEN);
		mult.setForeground(Color.BLACK);
		mult.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mult.addActionListener(this);
		panel.add(mult);

		div = new JButton("/");
		div.setBounds(290,328,120,52);
		div.setBackground(Color.GREEN);
		div.setForeground(Color.BLACK);
		div.setFont(new Font("Times New Roman", Font.BOLD, 18));
		div.addActionListener(this);
		panel.add(div);
		
		this.add(panel);
	}

	public double calc(){
		System.out.println(""+var1+mark+var2);
		switch(mark){  
    		case '+': result = var1+var2;break;  
    		case '-': result = var1-var2;break;  
    		case '*': result = var1*var2;break;
    		case '/': result = var1/var2;break;  
    		default:;  
    	}
    	return result;
	}

	public void actionPerformed(ActionEvent ae){
		String elementText = ae.getActionCommand();
		for(int i =0;i<10;i++){
			if(elementText == button[i].getText()){
				display.setText(button[i].getText());
			}
		}
		if(elementText == point.getText()){
			if(display.getText().indexOf('.')==(-1))
				display.setText(display.getText()+".");
		}
		else if(elementText == equal.getText()){
			if(var1==0.0){
				var1 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2==0.0){
				var2 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2!=0.0){
				var1 = calc();
				var2 = Double.parseDouble(display.getText());
			}
			display.setText(""+calc());
			var1 = 0;
    		var2 = 0;
			result = 0;
			mark = '0';
		}
		else if(elementText == clear.getText()){
			display.setText("");
		}
		else if(elementText == plus.getText()){
			mark = elementText.charAt(0);
			if(var1==0.0){
				var1 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2==0.0){
				var2 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2!=0.0){
				var1 = calc();
				var2 = Double.parseDouble(display.getText());
			}
			display.setText("");
		}
		else if(elementText == minus.getText()){
			mark = elementText.charAt(0);
			if(var1==0.0){
				var1 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2==0.0){
				var2 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2!=0.0){
				var1 = calc();
				var2 = Double.parseDouble(display.getText());
			}
			display.setText("");
		}
		else if(elementText == mult.getText()){
			mark = elementText.charAt(0);
			if(var1==0.0){
				var1 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2==0.0){
				var2 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2!=0.0){
				var1 = calc();
				var2 = Double.parseDouble(display.getText());
			}
			display.setText("");
		}
		else if(elementText == div.getText()){
			mark = elementText.charAt(0);
			if(var1==0.0){
				var1 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2==0.0){
				var2 = Double.parseDouble(display.getText());
			}else if(var1!=0.0 && var2!=0.0){
				var1 = calc();
				var2 = Double.parseDouble(display.getText());
			}
			display.setText("");
		}
	}
}