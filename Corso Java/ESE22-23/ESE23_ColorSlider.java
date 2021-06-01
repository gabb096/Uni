/*
 Creare una classe ColorSlider che estenda JFrame.
Il frame deve contenere un Jpanel, che a sua volta deve contenere:
tre JSlider con valori che variano tra 0 e 255, ciascuno preceduto da una JLabel 
con testo (in ordine) "R", "G" e "B";
una JList ( che contenga le seguenti stringhe 
"Nero", "Ciano", "Grigio", "Verde", "Magenta", "Giallo" )
 che faccia selezionare un solo elemento alla volta;
un JButton con testo "Applica";
un JTextField con testo di partenza "Color Slider Exercise".
La classe deve avere anche un array di oggetti Color 
(che contenga in ordine: Color.BLACK, Color.CYAN. Color.GRAY, Color.GREEN, Color.MAGENTA, Color.YELLOW ).
Quando l'utente seleziona un elemento della lista, i valori dei tre JSliders 
devono cambiare per rappresentare i valori dei corrispettivi canali RGB del colore selezionato 
(andando a prendere tali valori dai colori dell'array)
TIP: per come sono scritti i due array, l'indice di una stringa col nome di un 
colore corrisponde all'indice dello stesso colore presente nell'array dei colori.
TIP2: per prendere i valori RGB di un oggetto di tipo Color, utilizzate i suoi metodi getRed(), 
getBlue() e getGreen().
Quando l'utente clicca sul bottone, il colore dello sfondo dello JTextField 
deve diventare di un nuovo colore che abbia i valori RGB rappresentati dai tre JSlider.
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ESE23_ColorSlider extends JFrame //ESE23
{

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel rLabel,gLabel,bLabel;
	JSlider rSlider, gSlider,bSlider;
	JList list;
	JButton btn;
	JTextField textf;
	Color [] colors = {Color.BLACK, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.YELLOW}; 
	String [] jlist = {"Nero", "Ciano", "Grigio", "Verde", "Magenta", "Giallo"};
	
	public ESE23_ColorSlider() 
	{
		this.setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		rLabel = new JLabel("R");
		rSlider = new JSlider(0,255,127);
		gLabel = new JLabel("G");
		gSlider = new JSlider(0,255,127);
		bLabel = new JLabel("B");
		bSlider = new JSlider(0,255,127);
		btn = new JButton("Applica");
		textf = new JTextField("Color Slider Exercise",20);
		list = new JList(jlist);
		list.setPreferredSize(new Dimension(100,110));
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.add(panel1);
		this.add(panel2);
		panel1.add(list);
		panel1.add(btn);
		panel1.add(textf);
		panel2.add(rLabel);
		panel2.add(rSlider);
		panel2.add(gLabel);
		panel2.add(gSlider);
		panel2.add(bLabel);
		panel2.add(bSlider);
		
		
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int a = list.getSelectedIndex();
				
				int r =colors[a].getRed();
				rSlider.setValue(r);
				int g = colors[a].getGreen();
				gSlider.setValue(g);
				int b = colors[a].getBlue();
				bSlider.setValue(b);
				textf.setBackground(new Color(r,g,b));
			}
		});
		
		
		validate();
	}
	
	public static void main(String [] args) 
	{
		ESE23_ColorSlider c = new ESE23_ColorSlider();
		c.setVisible(true);
		c.setSize(700, 350);
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
