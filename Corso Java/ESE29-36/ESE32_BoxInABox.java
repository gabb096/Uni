/*Creare una classe BoxInABox che estenda JFrame.
Il frame deve avere come layout manager un BoxLayout verticale.
Il primo elemento del frame dovrà essere un JPanel h_box1 a sua volta avente 
come layout manager un BoxLayout orizzontale.
Il secondo elemento del frame dovrà essere un JPanel h_box2 a sua volta avente 
come layout manager un BoxLayout orizzontale.
Il terzo elemento del frame dovrà essere un JTextField.
h_box1 dovrà avere come elementi un bottone e due labels. h_box2 dovrà avere 
come elementi una label ed un bottone.
Basatevi sulla seguente immagine per avere riferimenti su testi e posizioni.*/

import java.awt.Dimension;

import javax.swing.*;

public class ESE32_BoxInABox extends JFrame
{

	JPanel h_box1, h_box2 , panel;
	JTextField tf;
	BoxLayout hbl, vbl;
	JButton btnA, btnB;
	JLabel l1, l2, l3;
	
	
	public ESE32_BoxInABox() 
	{
		super("BoxInABox");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(250 , 150);
		hbl = new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS);
		vbl = new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS);
		tf = new JTextField("TESTOOOOOOOO");
		this.getContentPane().setLayout(vbl);
		h_box1 = new JPanel();
		h_box2 = new JPanel();
		btnA = new JButton("Bottone A");
		btnB = new JButton("Bottone B");
		l1 = new JLabel("Label 1");
		l2 = new JLabel("Label 2");
		l3 = new JLabel("Label 3");
		h_box1.setLayout(new BoxLayout(h_box1, BoxLayout.LINE_AXIS));
		h_box1.add(btnA);
		h_box1.add( Box.createHorizontalGlue());
		h_box1.add(l1);
		h_box1.add( Box.createHorizontalGlue());
		h_box1.add(l2);
		add( Box.createVerticalGlue());
		h_box2.setLayout(new BoxLayout(h_box2, BoxLayout.LINE_AXIS));
		h_box2.add(l3);
		h_box2.add(btnB);
		add(h_box1);
		add(h_box2);
		panel = new JPanel();
		tf.setPreferredSize(new Dimension(100,20));
		panel.add(tf);
		add(panel);
		validate();
	}
	
	public static void main(String [] args) 
	{
		ESE32_BoxInABox b = new ESE32_BoxInABox();
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
 }
