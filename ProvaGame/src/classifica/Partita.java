package classifica;

import java.io.Serializable;
import java.util.Objects;

public class Partita implements Serializable{
	private long tempo;
	private String nome;
	
	public Partita() {
		tempo=0;
		nome="null";
	}
	
	public Partita(String nome, long tempo) {
		if(nome!=null) this.nome=nome;
		if(tempo>=0)this.tempo=tempo;
	}
	
	public Partita(Partita p) {
		if (p==null) {
			tempo=0;
			nome="null";
		}else {
			tempo=p.tempo;
			nome=p.nome;
		}
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partita other = (Partita) obj;
		return Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(tempo) == Double.doubleToLongBits(other.tempo);
	}

	@Override
	public String toString() {
		return "Partita [tempo=" + tempo + ", nome=" + nome + "]";
	}
	
	
}
