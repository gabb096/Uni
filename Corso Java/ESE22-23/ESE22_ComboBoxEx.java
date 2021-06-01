/*Creare una classe ComboboxEx che estenda JFrame.
Il frame deve contenere un JPanel che a sua volta deve contenere:
un JCombobox (con due elementi String: "JButton" e "JLabel"), 
un JTextField (con testo iniziale pari a "Testo") ed un JButton (con testo "Aggiungi").
Quando l'utente clicca sul JButton, deve essere aggiunto un nuovo componente al pannello, 
di tipo JLabel se nel combobox è selezionato "JLabel" oppure JButton (con testo "Stampa") 
se nel combobox è selezionato "JButton". 
Il testo delle JLabel aggiunte deve essere pari al valore del JTextField NEL MOMENTO 
in cui vengono aggiunte. I JButton aggiunti devono avere un ascoltatore che, una volta premuti,
 stampi a schermo il valore che aveva il JTextField NEL MOMENTO in cui sono stati creati.
Ricordatevi del metodo validate()
Numero di classi e variabili membro a scelta.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ESE22_ComboBoxEx extends JFrame //ESE 22
{
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	String [] arr = {"JButton" , "JLabel"};
	JTextField text = new JTextField("Testo");
	JButton btn = new JButton("Aggiungi");
	JComboBox coBox = new JComboBox(arr);
	
	public ESE22_ComboBoxEx()
	{
		text.setPreferredSize(new Dimension(100,20));
		this.setLayout(new FlowLayout());
		panel.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		this.add(panel);
		panel.setBackground(new Color(255, 204, 0));
		this.add(panel2);
		panel.add(coBox);
		panel.add(text);
		panel.add(btn);
		
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(coBox.getSelectedIndex()==0) 
				{
					JButton bt = new JButton(text.getText());
					bt.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e) 
						{
							text.setText(bt.getText());	
						}
					});
					panel2.add(bt);
					validate();
				}
				if(coBox.getSelectedIndex()==1) 
				{
					JLabel label = new JLabel(text.getText());
					panel2.add(label);
					validate();
				}
			}
		});
		
	}
	
	public static void main(String [] args) 
	{
		ESE22_ComboBoxEx c = new ESE22_ComboBoxEx();
		c.setVisible(true);
		c.setSize(400, 300);
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
