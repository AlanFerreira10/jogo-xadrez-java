package tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas< 1 || colunas<1) {
			throw new TabuleiroException("Erro ao criar o tabuleiro: é necessário que haja pelo menos 1 linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if(!existePosicao(linha, coluna)) {
			throw new TabuleiroException("Posição inválida para o tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if(!existePosicao(posicao)) {
			throw new TabuleiroException("Posição inválida para o tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocaPeca(Peca peca, Posicao posicao) {
		if(existePosicao(posicao)) {
			throw new TabuleiroException("Já existe uma peça na posicão " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean existePosicao(int linha, int coluna) {
		return linhas >=0 && linha < linhas && coluna >=0 && coluna < colunas;  
	}
	
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temUmaPeca (Posicao posicao) {
		return peca(posicao) != null;
	}
}
