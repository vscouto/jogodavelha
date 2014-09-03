import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Controlador {
		
	private List<Tabuleiro> tabuleiros;
	private int jogadas = 0;
	private int nrTabuleiros = 0;
	private boolean jogoContraPC = true;
	private boolean tabuleiro3d = true;
	
	public Controlador() {
		tabuleiros = new ArrayList<Tabuleiro>();
		tabuleiros.add(new Tabuleiro(this));
		tabuleiros.add(new Tabuleiro(this));
		tabuleiros.add(new Tabuleiro(this));
	}
	
	public void iniciarJogo() {
		if (jogadas > 0) {			
			JOptionPane.showMessageDialog(null, "Novo jogo iniciado");
		}
		
		if (tabuleiro3d) {
			nrTabuleiros = 3;
		} else {
			nrTabuleiros = 1; 
		}
		
		jogadas = 0;
		
		for (int t = 0; t < nrTabuleiros; t++) {			
			tabuleiros.get(t).reiniciarJogo();
		}
	}	
	

	public boolean getTabuleiro3d() {
		return tabuleiro3d;
	}

	public void setTabuleiro3d(boolean tabuleiro3d) {
		this.tabuleiro3d = tabuleiro3d;
	}
	
	public void setJogoContraPC(boolean valor) {
		this.jogoContraPC = valor;
	}
	
	public boolean getjogoContraPC() {
		return this.jogoContraPC;
	}
	
	public PanelTabuleiro getPanelTabuleiro(int indice) {
		if (indice < tabuleiros.size())
			return tabuleiros.get(indice).getPanelTabuleiros() ;
		return null;
	}
	
	public boolean efetuaJogada(int tabuleiro, Coordenada coordenada) {		 
		return this.tabuleiros.get(tabuleiro).efetuaJogada(coordenada, this.getMarcadorJogadorAtivo());		
	}
	
	public void finalizaJogada() {
		jogadas++;
		if (verificaVitoria()) {
			iniciarJogo();
		}		
		efetuaJogadaPC();		
	}	
		
	public Marcador getMarcadorJogadorAtivo() {
		if (jogadas%2 == 0) {
			return new MarcadorX();
		}
		return new MarcadorO();
	}
	
	/*public void reiniciarJogo() {
		for (int t = 0; t < 3; t++) {
			tabuleiros.get(t).reiniciarJogo();
		}
		
		jogadas = 0;
		
		JOptionPane.showMessageDialog(null, "Novo jogo iniciado");		
	}*/
	
	private void efetuaJogadaPC(){
		if ((jogoContraPC) && (jogadas%2 != 0)) {
			new Computador().efetuaJogada(this);
			for (Tabuleiro tabuleiro : tabuleiros) {
				tabuleiro.atualizaTabuleiro();
			}
            this.finalizaJogada();
		}
	}
	
	@SuppressWarnings("unused")
	private	boolean verificaVitoria() {		
		for (Tabuleiro tabuleiro : tabuleiros) {			
			if (tabuleiro.verificaVitoria(new MarcadorX())) {
				JOptionPane.showMessageDialog(null, "Jogador 'X' Ganhou no tabuleiro " + (tabuleiros.indexOf(tabuleiro) + 1));
				return true;				
			} else if (tabuleiro.verificaVitoria(new MarcadorO())) {
				JOptionPane.showMessageDialog(null, "Jogador 'O' Ganhou no tabuleiro " + (tabuleiros.indexOf(tabuleiro) + 1));
				return true;				
			} 
		}				
		
		if (tabuleiro3d) {
			if (verificaVitoria3d(new MarcadorX())) {
				JOptionPane.showMessageDialog(null, "Jogador 'X' Ganhou no tabuleiro 3d ");
				return true;
			} else if (verificaVitoria3d(new MarcadorO())) {
				JOptionPane.showMessageDialog(null, "Jogador 'O' Ganhou no tabuleiro 3d ");
				return true;
			}
		}
		
		boolean fimJogo = false;
		for (int t = 0; t < nrTabuleiros; t++) {			
			fimJogo = fimJogo && tabuleiros.get(t).verificaFimJogo();
		}
		
		if (fimJogo) {
			JOptionPane.showMessageDialog(null, "O jogo terminou empatado!!");
			return true;
		}
		
		return false;	
	}
	
	private boolean verificaVitoria3d(Marcador marcador) {
		boolean resultado = false;
		
		resultado = verificaColunas3d(marcador);
		
		if (!resultado) {
			resultado = verificaLinhas3d(marcador);
		}
		
		if (!resultado) {
			resultado = verificaDiagonaPrincipal3d(marcador);
		}
		
		if (!resultado) {
			resultado = verificaDiagonalSecundaria3d(marcador);
		}
		
		if (!resultado) {
			resultado = verificaPosicaoIgaul3d(marcador);
		}
		
		return resultado;
	}
	
	private boolean verificaColunas3d(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
		for (int c = 0; c < 3; c++) {
			resultado = false;
			for (int l = 0; l < 3; l++) {
				
				marcadorTabuleiro = this.tabuleiros.get(l).getMarcadorTabuleiro(new Coordenada(l,c));
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
	
	private boolean verificaLinhas3d(Marcador marcador) {	
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
		// Verifica linhas
		for (int l = 0; l < 3; l++) {
			resultado = false;			
			for (int c = 0; c < 3; c++) {
				marcadorTabuleiro = this.tabuleiros.get(c).getMarcadorTabuleiro(new Coordenada(l,c));
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

	private boolean verificaDiagonaPrincipal3d(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
		for (int i = 0; i < 3; i++){
			marcadorTabuleiro = this.tabuleiros.get(i).getMarcadorTabuleiro(new Coordenada(i,i));
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
	
	private boolean verificaDiagonalSecundaria3d(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		int c = 3;
		// Diagonal secundaria 
		for (int l = 0; l < 3; l++){
			c = c - 1;
			marcadorTabuleiro = this.tabuleiros.get(l).getMarcadorTabuleiro(new Coordenada(l,c));
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
	
	private boolean verificaPosicaoIgaul3d(Marcador marcador) {
		Marcador marcadorTabuleiro;
		boolean resultado = false;
		
		for (int c = 0; c < 3; c++) {
			resultado = false;
			for (int l = 0; l < 3; l++) {				
				for (int t = 0; t < nrTabuleiros; t++) {
					marcadorTabuleiro = this.tabuleiros.get(t).getMarcadorTabuleiro(new Coordenada(l,c));
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
		}
		return resultado;
	}
}
