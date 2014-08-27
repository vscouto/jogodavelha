
public class Marcador {
	protected String valor = " ";

	public String getValor() {
		return valor;		
	}
	
	public boolean equals(Marcador marcador) {
		return (marcador.getValor() == this.valor);
	}
}
