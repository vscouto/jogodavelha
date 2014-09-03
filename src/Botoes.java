

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Thiago Moura
 * 
 */
public class Botoes extends JButton implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private int indice;
    private Tabuleiro tabuleiro;

    public Botoes (int ind, Tabuleiro tab) {
        indice = ind;
        tabuleiro = tab;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    	
    	if(tabuleiro.efetuaJogada(new Coordenada(indice), tabuleiro.getMarcadorJogadorAtivo())){            
    		tabuleiro.atualizaTabuleiro();
            tabuleiro.finalizaJogada();
            
            //this.setText(tabuleiro.getMarcadorTabuleiro(new Coordenada(indice)).getValor());
            /*if (tabuleiro.verificaVitoria(new MarcadorX())) {
            	JOptionPane.showMessageDialog(null, "Jogador X Ganhou");
            	tabuleiro.reiniciarJogo();
            } else if (tabuleiro.verificaVitoria(new MarcadorO())) {
            	JOptionPane.showMessageDialog(null, "Jogador O Ganhou");
            	tabuleiro.reiniciarJogo();
            } else if (tabuleiro.verificaFimJogo()) {
            	JOptionPane.showMessageDialog(null, "Empate");
            	tabuleiro.reiniciarJogo();
            }*/
            
        }
    }

}
