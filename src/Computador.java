import java.util.*;

public class Computador {
	private static int SORT_TABULEIRO = 3;
	private static int SORT_COORDENADA = 9;
	
	public void efetuaJogada(Controlador controlador){
		int tabuleiro;
		Coordenada coordenada;
		do {
			if (controlador.getTabuleiro3d()) {
				tabuleiro = sorteia(SORT_TABULEIRO);
			} else {
				tabuleiro = 0;
			}
			coordenada = new Coordenada(sorteia(SORT_COORDENADA));
			
		}  while(!controlador.efetuaJogada(tabuleiro, coordenada));	
	}
		
	private int sorteia(int limite) {
		Random r = new Random();		
		return (int) (r.nextDouble() * (limite-0));
	}	
}
