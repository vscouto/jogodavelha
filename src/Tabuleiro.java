
public class Tabuleiro {
	
	/*********************************************************
 	 *     0   1   2
	 *  0 ___|___|___
	 *  1 ___|___|___
	 *  2    |   |   
	 *  
	 **********************************************************/
	private Marcador[][] tabuleiro = new Marcador[3][3];
	
	public boolean efetuaJogada(Marcador marcador, Coordenada coordenada) {
		
		if (tabuleiro[coordenada.getLinha()][coordenada.getColuna()] == null) {
			tabuleiro[coordenada.getLinha()][coordenada.getColuna()] = marcador;
			return true;
		} 
		return false;		
	}
	
	public void imprimeTabuleiro() {
		String valor = "";
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				valor = "_";
				
				if (tabuleiro[l][c] != null) {
					valor += tabuleiro[l][c].getValor();
				}
				
				if (c == 1) {
					System.out.print("|_" + valor + "_|");
				} else {
					System.out.print("_" + valor + "_" );
				}
			}	
		}
		System.out.println();
	}
        
        public Marcador getMarcadorTabuleiro(Coordenada coordenada){
            if(tabuleiro[coordenada.getLinha()][coordenada.getColuna()]== null){
                return new Marcador();
            }else return tabuleiro[coordenada.getLinha()][coordenada.getColuna()];
        }

}
