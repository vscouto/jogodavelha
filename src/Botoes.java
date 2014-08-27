/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Thiago Moura
 */
public class Botoes extends JButton implements ActionListener{
    private int indice;
    private Tabuleiro tabuleiro;

    public Botoes (int ind, Tabuleiro tab) {
        indice = ind;
        tabuleiro = tab;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(tabuleiro.efetuaJogada(new MarcadorX(), new Coordenada(indice))){
            this.setText(new MarcadorX().getValor());
        }
    }

}
