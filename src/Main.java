/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago Moura
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        Interface frame = new Interface(tab);
        frame.setVisible(true);

        tab.reiniciarJogo();
        
    }
}
