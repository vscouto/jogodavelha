import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Principal extends JFrame {
	
	private JButton botaoTabuleiroComum = new JButton("Tabuleiro comum");
	private JButton botaoTabuleiro3d = new JButton("Tabuleiro 3D");
	
	public Principal(String string, JFrame frameInterface, JFrame frameInterface3d){
		this.botaoTabuleiroComum.addActionListener(new AbreJanela(frameInterface));
		this.botaoTabuleiro3d.addActionListener(new AbreJanela(frameInterface3d));
		
		this.setLayout(new FlowLayout());
		this.add(botaoTabuleiroComum);
		this.add(botaoTabuleiro3d);
		
	}
	
	private class AbreJanela implements ActionListener {

		private JFrame frame;
		
		AbreJanela(JFrame frame){
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent e) {
			this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			// Centraliza a janela
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.frame.setLocation(dim.width/2-this.frame.getSize().width/2, dim.height/2-this.frame.getSize().height/2);
			
			this.frame.setVisible(true);
		}
		
	}


}
