

public class Tabuleiro {
	
	/*********************************************************
 	 *     0   1   2
	 *  0 ___|___|___
	 *  1 ___|___|___
	 *  2    |   |   
	 *  
	 **********************************************************/
	private Marcador[][] tabuleiro;
	private	PanelTabuleiro panelTabuleiro;
	private	Controlador controlador;
	
	public Tabuleiro(Controlador contralador) {
		this.tabuleiro = new Marcador[3][3];
		this.panelTabuleiro = new PanelTabuleiro(this);
		this.controlador = contralador;
	}	
	
	public PanelTabuleiro getPanelTabuleiros() {
		return this.panelTabuleiro;
	}
	
	public void atualizaTabuleiro() {
		this.panelTabuleiro.atualizaTela();
	}
	
	public Marcador getMarcadorJogadorAtivo() {
		return controlador.getMarcadorJogadorAtivo();
	}
	
	public boolean efetuaJogada(Coordenada coordenada, Marcador marcador) {
		 
		if (this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()] == null) {
			this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()] = marcador;						
			return true;
		} 
		return false;		
	}
	
	/*private void efetuaJogadaMaquina(){
		int indice = 0;
		Random r = new Random();
		
		if (jogoContraMaquina) {
			do {
				indice = (int) (r.nextDouble() * (9-0));
			}  while(!efetuaJogada(new Coordenada(indice)));
		}
	}*/
	
	public Marcador getMarcadorTabuleiro(Coordenada coordenada){
		if(tabuleiro[coordenada.getLinha()][coordenada.getColuna()]== null) {
			return new Marcador();
		} else { 
			return this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()];
		}
	}	
	
	public boolean verificaFimJogo() {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				if (this.tabuleiro[l][c] != null) {
					return false;
				}
			}			
		}
		return true;
	}
	
	public void reiniciarJogo() {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				this.tabuleiro[l][c] = null;
			}			
		}
		this.atualizaTabuleiro();
		/*if (JOptionPane.showConfirmDialog(null, "Deseja jogar contra a o computador?", "Escolha Adiversario", JOptionPane.YES_NO_OPTION) == 0) {
			jogoContraMaquina = true;
		} else {
			jogoContraMaquina = false;
		}*/
		
	}
	
	public void finalizaJogada() {
		this.controlador.finalizaJogada();
	}
	
	public boolean verificaVitoria(Marcador marcador) {
		boolean resultado = false;
		
		resultado = verificaColunas(marcador);
		
		if (!resultado) {
			resultado = verificaLinhas(marcador);
		}
		
		if (!resultado) {
			resultado = verificaDiagonaPrincipal(marcador);
		}
		
		if (!resultado) {
			resultado = verificaDiagonalSecundaria(marcador);
		}
		
		return resultado;
	}
	
	private boolean verificaColunas(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
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
		return resultado;
	}
	
	private boolean verificaLinhas(Marcador marcador) {	
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
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
				
				if (!resultado) {
					break;
				}
			}
			
			if (resultado) {
				return resultado;
			}			
		}
		return resultado;
	}
		
	private boolean verificaDiagonaPrincipal(Marcador marcador) {
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

	
	/*public boolean efetuaJogada(Coordenada coordenada) {
		 
		if (this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()] == null) {
			if (jogadas%2 == 0) {
				this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()] = new MarcadorX();
				jogadas++;
				if (!verificaFimJogo()) {
					efetuaJogadaMaquina();
				}
			} else {
				this.tabuleiro[coordenada.getLinha()][coordenada.getColuna()] = new MarcadorO();
				jogadas++;
			}
			return true;
		} 
		return false;		
	}*/
}

