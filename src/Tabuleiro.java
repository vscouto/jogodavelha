
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
		
		if (this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()] == null) {
			this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()] = marcador;
			return true;
		} 
		return false;		
	}
	
	public Marcador getMarcadorTabuleiro(Coordenada coordenada){
		if(tabuleiro[coordenada.getLinha()][coordenada.getColuna()]== null){
			return new Marcador();
		}else return tabuleiro[coordenada.getLinha()][coordenada.getColuna()];
	}	
	
	public void limparTabuleiro() {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				this.tabuleiro[l][c] = null;
			}			
		}
	}
	
	public boolean verificaVitoria(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
		// Verifica colunas
		for (int c = 0; c < 3; c++) {
			resultado = false;
			for (int l = 0; l < 3; l++) {
				
				marcadorTabuleiro = this.tabuleiro[l][c];
				if (marcadorTabuleiro == null) {
					resultado = false;
					break;
				} 
				
				resultado = marcadorTabuleiro.equals(marcador);
				
				if (!resultado) {
					break;
				}
			}
			
			if (resultado) {
				return resultado;
			}			
		}
		
		 
		if (!resultado) {			
			// Verifica linhas
			for (int l = 0; l < 3; l++) {
				resultado = false;			
				for (int c = 0; c < 3; c++) {
					marcadorTabuleiro = this.tabuleiro[l][c];
					if (marcadorTabuleiro == null) {
						resultado = false;
						break;
					} 
					
					resultado = marcadorTabuleiro.equals(marcador);
					
					
				}
				
				if (resultado) {
					return resultado;
				}			
			}			
		}
		
		if (!resultado) {
			resultado = verificaDiagonaPrimaria(marcador);
		}
		
		if (!resultado) {
			resultado = verificaDiagonalSecundaria(marcador);
		}
		
		return resultado;
		
		
		
		/*if (!resultado) {
			
			// Diagonal principal 
			for (int i = 0; i < 3; i++){
				marcadorTabuleiro = this.tabuleiro[i][i];
				if (marcadorTabuleiro == null) {
					resultado = false;
					break;
				} 
				
				resultado = marcadorTabuleiro.equals(marcador);
				
				if (!resultado) {
					break;
				}
			}
			
			if (resultado) {
				return resultado;
			}			
		}*/
		
		
		

		/*if (!resultado) {
			int c = 3;
			// Diagonal secundaria 
			for (int l = 0; l < 3; l++){
				c = c - 1;
				marcadorTabuleiro = this.tabuleiro[l][c];
				if (marcadorTabuleiro == null) {
					resultado = false;
					break;
				} 
				
				resultado = marcadorTabuleiro.equals(marcador);
				
				if (!resultado) {
					break;
				}
			}
			
			if (resultado) {
				return resultado;
			}			
		}*/
		
	
	}
		
	private boolean verificaDiagonaPrimaria(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
		for (int i = 0; i < 3; i++){
			marcadorTabuleiro = this.tabuleiro[i][i];
			if (marcadorTabuleiro == null) {
				return false;
			} 
			
			resultado = marcadorTabuleiro.equals(marcador);
			
			if (!resultado) {
				return false;
			}
		}
		
		
		return resultado;		
	}
	
	private boolean verificaDiagonalSecundaria(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		int c = 3;
		// Diagonal secundaria 
		for (int l = 0; l < 3; l++){
			c = c - 1;
			marcadorTabuleiro = this.tabuleiro[l][c];
			if (marcadorTabuleiro == null) {
				return false;				
			} 
			
			resultado = marcadorTabuleiro.equals(marcador);
			
			if (!resultado) {
				return false;
			}
		}	
		
		return resultado;
	}
	
	public void imprimeTabuleiro() {
		String valor = "";
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				valor = "_";
				
				if (this.tabuleiro[l][c] != null) {
					valor = this.tabuleiro[l][c].getValor();
				}
				
				if (c == 1) {
					System.out.print("|_" + valor + "_|");
				} else {
					System.out.print("_" + valor + "_" );
				}
			}	
			System.out.println();
		}
		System.out.println();
		
		if (this.verificaVitoria(new MarcadorX())) {
			System.out.println("Jogador X Ganhou!");
		} else if (this.verificaVitoria(new MarcadorO())) {
			System.out.println("Jogador O Ganhou!");
		}
		
		System.out.println();
	}
}
