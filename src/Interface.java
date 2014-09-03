import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago Moura
 */
public class Interface extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel paineltabuleiro1;
    JButton [] botoestabuleiro1;
    
    Tabuleiro tabuleiro;
    public Interface(Tabuleiro tab){
        tabuleiro = tab;
        botoestabuleiro1 = new JButton[9];
        paineltabuleiro1 = new JPanel();
        
        //tab.setInterface(this);
        
        paineltabuleiro1.setLayout(new GridLayout(3,3));
        for (int k=0;k<9;k++){
            paineltabuleiro1.add(botoestabuleiro1[k] = new Botoes (k,tabuleiro));
            //Layout dos botoes
            botoestabuleiro1[k].setBackground(Color.BLACK);
            botoestabuleiro1[k].setFont(new Font("Arial", Font.ITALIC, 40));
            botoestabuleiro1[k].setForeground(Color.white);
            botoestabuleiro1[k].addMouseListener(new Acao());
        }
        //Adicionar bordas nos botoes
        botoestabuleiro1[0].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.white));
        botoestabuleiro1[1].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.white));
        botoestabuleiro1[2].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.white));
        botoestabuleiro1[3].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.white));
        botoestabuleiro1[4].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.white));
        botoestabuleiro1[5].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.white));
        botoestabuleiro1[6].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.white));
        botoestabuleiro1[7].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.white));
        botoestabuleiro1[8].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        this.getContentPane().add(BorderLayout.CENTER,paineltabuleiro1);
        
        this.setSize(300, 300);
        this.setTitle("Jogo Da Velha 3D");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
    
    public void atualizaTela(){
        for(int k = 0; k<9;k++){
            botoestabuleiro1[k].setText(tabuleiro.getMarcadorTabuleiro(new Coordenada(k)).getValor());
        }
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
					botoestabuleiro1[k].setBackground(Color.getHSBColor(0.0f, 0.0f, 0.10f));
				}
	        }
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			for(int k = 0; k<9;k++){
				if(botoestabuleiro1[k].equals(arg0.getSource())){
					//Altera a cor quando o mouse sai do botao
					botoestabuleiro1[k].setBackground(Color.getHSBColor(0.0f, 0.0f, 0.0f));
				}
	        }
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
