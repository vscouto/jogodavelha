import javax.swing.JFrame;


public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tabuleiro tab = new Tabuleiro();
		Interface interfacecomum = new Interface(tab);
		Interface3d interface3d = new Interface3d();
		
		Principal janela = new Principal("Opcoes", interfacecomum, interface3d);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
	}

}
