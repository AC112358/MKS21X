import javax.swing.*;
import java.awt.*;
import java.util.event.*;
public class TempWindow extends JFrame{
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
	b = new JButton("C to F");
    }

}
