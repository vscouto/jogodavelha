
public class Coordenada {
	private int linha = 0;
	private int coluna = 0;
	
	/*********************************************************
	 * 
	 * Indices
	 * 
 	 *     0   1   2
	 *  0 _0_|_1_|_2_
	 *  1 _3_|_4_|_5_
	 *  2  6 | 7 | 8 
	 *  
	 **********************************************************/
	
	public Coordenada(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public Coordenada(int indice) {
		this.linha = indice/3;
		this.coluna = indice-(this.linha*3);
	}

	public int getLinha() {
		return linha;
	}


	public int getColuna() {
		return coluna;
	}
	
	public boolean equals(Coordenada coordenada) {
		return (this.linha == coordenada.linha && this.coluna == coordenada.coluna);
	}
	
	public int getIndicePosicao() {
		return (this.linha * 3) + this.coluna;
	}

}
