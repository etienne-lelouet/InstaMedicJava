package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VueInters extends JPanel implements ActionListener
{
	public VueInters()
	{
		this.setBounds(20,70,960,590);
		this.setLayout(null);
		this.setBackground(new Color(242,242,242));
		
		this.setVisible(false);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}