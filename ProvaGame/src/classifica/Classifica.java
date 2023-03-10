package classifica;
import java.io.*;

public class Classifica implements Serializable {
	private Nodo head;
	private int n;
	private final int MAXELEM=101; ///numero massimo degli elementi tenuti in classifica

	public Classifica() {
		head=null;
		n=0;
	}

	public void eliminaInTesta() {
		if (head==null) return;// lista vuota
		head = head.getLink();
		n--;
	}

	public void eliminaInCoda() {
		Nodo ps=head, pp=head;
		if (pp==null) return; // lista vuota
		while(ps.getLink() != null) {
			pp = ps;
			ps = ps.getLink();
		}
		if (pp==head) eliminaInTesta();
		else {
			pp.setLink(null);
			n--;
		}
	}

	public void add(Partita p) { ///append in ordine di tempo (dal min al max)
		n++;

		Nodo app = new Nodo(p,null);

		if (head == null || p.getTempo() < head.getInfo().getTempo()) { ///se head==null o p.tempo<head.tempo append all'inizio
			app.setLink(head);
			head = app;

		} else {
			Nodo n = head;
			while (n.getLink() != null && n.getLink().getInfo().getTempo() < p.getTempo()) { ///scorre la lista fino a che non finisce o trova un tempo maggiore di p
				n = n.getLink();
			}
			app.setLink(n.getLink()); 
			n.setLink(app);
		}
		if (n>=MAXELEM) eliminaInCoda();
	}

	public void clear() {
		head=null;
	}

	@Override
	public String toString() {
		String s="";
		Nodo p=head;
		while(p!=null) { //scorre tutto
			s=s+p.getInfo().toString()+" ";
			p=p.getLink();
		}
		return s;
	}

	public int size() {
		int i=0;
		Nodo p = head;
		while(p!=null) {
			i++;
			p=p.getLink();
		}
		return i;
	}

	public int indexOf(Partita pl) {
		int pos=-1, i=0;
		Nodo p=head;
		while(p!=null) {
			if(p.getInfo().equals(pl)) {
				pos=i;
			}
			i++;
			p=p.getLink();
		}
		return pos;
	}

	

	public Partita getPartitaById(int id) {
		if (head == null) return null;

		Nodo p = head;
		int i = 0;

		while (p != null) {
			if (i == id) return p.getInfo();

			p = p.getLink();
			i++;
		}

		return null;
	}
	
	public String[][] getStringMatrix(){
		Nodo p=head.getLink().getLink().getLink();
		int i=4;
		String[][] s = new String[this.size()+1][3];
		s[0][0]="POSIZIONE";
		s[0][1]="NOME";
		s[0][2]="TEMPO";
		while(p!=null) {
			s[i-3][0]=""+(i);
			s[i-3][1]=p.getInfo().getNome();
			long min,sec,cent;
			cent=p.getInfo().getTempo();
			sec=cent/100;
			cent%=100;
			min=sec/60;
			sec%=60;
			s[i-3][2]=min+" "+sec+" "+cent;
			i++;
			p=p.getLink();
		}
		return s;
	}

}
