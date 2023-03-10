package classifica;

public class TestClassifica {
	public static void main(String[] args) {
		
	VetClassifica v=new VetClassifica(5);
	for(int j=0;j<5;j++) {
		for(int i=0;i<130;i++) {
			v.getC(j).add(new Partita("prova "+(1+i),(long) (Math.random()*100000)));
		}
	}
	
	System.out.println(v.getC(0));
	v.save("classifiche.bin");
	VetClassifica v2=VetClassifica.load("classifiche.bin");
	System.err.println(v2.getC(0));
//	v.getC(0).add(new Partita("zkjsdfzksdnvfkzldnfvlkzdnfljdnzfblkjzndfblkjndfb",50));
	//for(int i=0;i<5;i++)
	new ShlClassifica(v2.getC(0));
	
	}		
}
