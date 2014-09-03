
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


public class PanelTabuleiro extends JPanel {	
	private static final long serialVersionUID = 1L;

	private JButton [] botoestabuleiro1;	
	private Tabuleiro tabuleiro;
	
	public PanelTabuleiro(Tabuleiro tab) {
		tabuleiro = tab;
        botoestabuleiro1 = new JButton[9];
        
        this.setLayout(new GridLayout(3,3));
        
        //tabuleiro.setPanelTabuleiro(this);        
        
        for (int k=0;k<9;k++){
        	this.add(botoestabuleiro1[k] = new Botoes (k,tabuleiro));
            //Layout dos botoes
            botoestabuleiro1[k].setBackground(Color.LIGHT_GRAY);
            botoestabuleiro1[k].setFont(new Font("Arial", Font.ITALIC, 40));
            botoestabuleiro1[k].setForeground(Color.white);
            botoestabuleiro1[k].addMouseListener(new Acao());
            botoestabuleiro1[k].setText("");
        }
        
        //Adicionar bordas nos botoes
        botoestabuleiro1[0].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
        botoestabuleiro1[1].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
        botoestabuleiro1[2].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK));
        botoestabuleiro1[3].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
        botoestabuleiro1[4].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
        botoestabuleiro1[5].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK));
        botoestabuleiro1[6].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
        botoestabuleiro1[7].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
        botoestabuleiro1[8].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
	}
	
	
	public void atualizaTela(){
        for(int k = 0; k<9;k++){
            botoestabuleiro1[k].setText(tabuleiro.getMarcadorTabuleiro(new Coordenada(k)).getValor());
        }
        //this.invalidate();
    }
	
	public class Acao implements MouseInputListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			atualizaTela();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			for(int k = 0; k<9;k++){
				if(botoestabuleiro1[k].equals(arg0.getSource())){
					//Altera a cor quando o mouse e posto no botao
					//botoestabuleiro1[k].setBackground(Color.getHSBColor(0.0f, 0.0f, 0.10f));
					botoestabuleiro1[k].setBackground(Color.DARK_GRAY);
				}
	        }
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			for(int k = 0; k<9;k++){
				if(botoestabuleiro1[k].equals(arg0.getSource())){
					//Altera a cor quando o mouse sai do botao
					//botoestabuleiro1[k].setBackground(Color.getHSBColor(0.0f, 0.0f, 0.0f));
					botoestabuleiro1[k].setBackground(Color.LIGHT_GRAY);
				}
	        }
		}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}

		@Override
		public void mouseDragged(MouseEvent arg0) {}

		@Override
		public void mouseMoved(MouseEvent arg0) {}
    	
    }
}
	

