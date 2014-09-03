import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel painel;	
	private JPanel painelConfiguracoes;
	private Controlador controlador;
	
	
	public Tela() {
		controlador = new Controlador(); 
		painelConfiguracoes = new JPanel();
		painelConfiguracoes.setLayout(new FlowLayout());
				
		painelConfiguracoes.add(radioButtonNumeroTabuleiros());
		painelConfiguracoes.add(radioButtonJogoVsMaquina());
		
		iniciarTela(); 
	}
	
	public void iniciarTela() {
		int nrTabuleiros;
		this.getContentPane().removeAll();
		//this.getContentPane().repaint();
		
		painel = new JPanel();
		controlador.iniciarJogo();
		
		if (controlador.getTabuleiro3d()) {
			painel.setLayout(new GridLayout(4,1));
		} else {
			painel.setLayout(new GridLayout(2,1));
		}
		
		this.getContentPane().add(BorderLayout.CENTER,painel);
		
		
		if (controlador.getTabuleiro3d()) {
			this.setSize(230, 800);
			this.setTitle("Jogo Da Velha 3D");
			nrTabuleiros = 3;
		} else {
			this.setSize(300, 300);
			this.setTitle("Jogo Da Velha");
			nrTabuleiros = 1;
		}	    		
	    
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    painel.add(painelConfiguracoes); 
   
	    for (int t = 0; t < nrTabuleiros; t++) {
	    	painel.add(controlador.getPanelTabuleiro(t));
		}	    
	    
	}
	
	private JPanel radioButtonJogoVsMaquina() {
		JRadioButton simButton1 = new JRadioButton("P1 vs P2", false);
		JRadioButton naoButton1 = new JRadioButton("Vs PC", true);
		simButton1.addActionListener(new SelecionaModoJogo(false));
		naoButton1.addActionListener(new SelecionaModoJogo(true));

		ButtonGroup bgroup1 = new ButtonGroup();
		bgroup1.add(simButton1);
		bgroup1.add(naoButton1);
		

		JPanel radioPanel1 = new JPanel();
		radioPanel1.setLayout(new GridLayout(3, 1));
		radioPanel1.add(simButton1);
		radioPanel1.add(naoButton1);

		radioPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Modo Jogo"));
		
		return radioPanel1; 
	}
	
	private class SelecionaModoJogo implements ActionListener {
		private boolean modoJogoVsPc; 	
		
		
		SelecionaModoJogo(boolean vsPc) {
			modoJogoVsPc = vsPc;			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			controlador.setJogoContraPC(modoJogoVsPc);
	
		}
		
	}
	
	private JPanel radioButtonNumeroTabuleiros() {
		JRadioButton simButton = new JRadioButton("Jogo Normal"  , false);
		JRadioButton naoButton = new JRadioButton("3 Tabuleiros"   , true);
		simButton.addActionListener(new SelecionaTabuleiro3d(this, false));
		naoButton.addActionListener(new SelecionaTabuleiro3d(this, true));
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(simButton);
		bgroup.add(naoButton);

		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(3, 1));
		radioPanel.add(simButton);
		radioPanel.add(naoButton);

		radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Tipo de tabuleiro"));
		
		return radioPanel; 
	}
	
	private class SelecionaTabuleiro3d implements ActionListener {
		private boolean tabuleiro3d; 	
		private Tela tela1;
		
		SelecionaTabuleiro3d(Tela tela, boolean tabuleiro3d) {
			this.tabuleiro3d = tabuleiro3d;			
			this.tela1 = tela;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			controlador.setTabuleiro3d(tabuleiro3d);
			this.tela1.iniciarTela();
		}
		
	}
	
}
