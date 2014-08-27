
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        
        tab.setInterface(this);
        
        paineltabuleiro1.setLayout(new GridLayout(3,3));
        for (int k=0;k<9;k++){
            paineltabuleiro1.add(botoestabuleiro1[k] = new Botoes (k,tabuleiro));
        }
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
}
