import java.util.*;

public class Computador {
	
	private int linha, coluna;
	private Coordenada coordenada;
	
	public void sorteiaCoordenada(){
		Random sorteio = new Random();
		
		linha = sorteio.nextInt(3);
		coluna = sorteio.nextInt(3);
		
		coordenada = new Coordenada (linha,coluna);
		
		//teste
		
	}
	
	
}
