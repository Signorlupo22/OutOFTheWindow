package classifica;

import java.io.Serializable;

public class Nodo implements Serializable{
  private Partita info;
  private Nodo link;
  
  public Nodo() {
	  info=new Partita();
	  link=null;
  }
  public Nodo(Partita info, Nodo link) {
	  this.info=new Partita(info);
	  this.link=link;
  }
  public Partita getInfo() {
	return info;
  }
  public void setInfo(Partita info) {
	this.info = new Partita(info);
  }
  public Nodo getLink() {
	return link;
  }
  public void setLink(Nodo link) {
	this.link = link;
  }
  @Override
  public String toString() {
	return "Nodo [info=" + info.toString() + "]";
  }
  
}
  