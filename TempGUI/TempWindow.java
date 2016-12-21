import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TempWindow extends JFrame implements ActionListener{
 private Container pane;
 private JButton toF, toC;
 private JLabel ans;
 private JTextField temp;
    public TempWindow(){
	this.setTitle("Temperature conversion");
	this.setSize(600, 400);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	toF = new JButton("C to F");
	toF.setActionCommand("CF");
	toF.addActionListener(this);
	toC = new JButton("F to C");
	toC.setActionCommand("FC");
	toC.addActionListener(this);
	ans = new JLabel();
	temp = new JTextField(12);
	pane.add(temp);
	pane.add(toF);
	pane.add(toC);
	pane.add(ans);
    }
    public void actionPerformed(ActionEvent e){
	try{
	switch(e.getActionCommand()){
	case "CF":
	    ans.setText(""+TempConvert.CtoF(Double.parseDouble(temp.getText())));
	    break;
	case "FC":
	    ans.setText(""+TempConvert.FtoC(Double.parseDouble(temp.getText())));
	    break;
	}
	}
	catch(NumberFormatException b){
	    ans.setText("Invalid input");
	}
    }
    
    public static void main(String[] args){
	TempWindow w = new TempWindow();
	w.setVisible(true);
    }

}
