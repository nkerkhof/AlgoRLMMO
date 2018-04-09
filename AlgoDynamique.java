
public class AlgoDynamique extends InterfaceAlgoRLMMO {
	protected CaseType tab[][];
	
	@Override
	public int[] execute(int prx) {
		prix=prx;
		tab = new CaseType[prix+1][typePiece.length+1];
		for(int j=0;j<=prix;j++) {
			for(int i=0;i<=typePiece.length;i++) {
				if(j==0) {
					tab[j][i]=new CaseType(j,i,0,false);
				}
				else if(i==0 && j!=0) {
					tab[j][i]=new CaseType(j,i,0, true);
				}
				else if(j-typePiece[i-1]>=0) {
					CaseType aCopie = CaseType.minplus1d(tab[j][i-1], tab[j-typePiece[i-1]][i]);
					tab[j][i] = new CaseType(j,i,aCopie.valeur, aCopie.estinfini);
					if(aCopie==tab[j-typePiece[i-1]][i]) {tab[j][i].add(1);}
					tab[j][i].next = aCopie;
				} else {
					tab[j][i] = new CaseType(j,i,tab[j][i-1].valeur, tab[j][i-1].estinfini);
					tab[j][i].next = tab[j][i-1];
				}
				
				/*if(tab[j][i].estinfini) {
					System.out.print("i");
				} else {System.out.print(tab[j][i].valeur);}
				System.out.print("  ");*/
			}
			//System.out.println("");
		}
		
		CaseType resultat = getMin();
		while(resultat!=null) {
			if(resultat.next != null && resultat.j!=resultat.next.j) {
				nbCoupPiece[resultat.i-1]++;
			}
			resultat=resultat.next;
		}
		return nbCoupPiece;
	}
	
	protected CaseType getMin(){
		CaseType res = tab[prix][0];
		for(int k = 1; k<=typePiece.length;k++) {
			res=CaseType.min(tab[prix][k],res);
		}
		return res;
	}
	
	
	protected static class CaseType{
		public int valeur;
		public boolean estinfini;
		public int i;
		public int j;
		public CaseType next = null;
		
		public CaseType(int jj, int ii, int val, boolean estInfini){
			valeur=val;
			estinfini=estInfini;
			j=jj;
			i=ii;
		}
		
		public void add(int i) {
			valeur += i;
		}
		
		public static CaseType minplus1d(CaseType c1, CaseType c2add1) {
			if(c1.estinfini && c2add1.estinfini) {
				return c1;
			}
			if(c1.estinfini) {
				return c2add1;
			}
			if(c2add1.estinfini) {
				return c1;
			}
			if(c1.valeur<=c2add1.valeur+1) {
				return c1;
			}
			return c2add1;
		}
		
		public static CaseType min(CaseType c1, CaseType c2) {
			if(c1.estinfini && c2.estinfini) {
				return c1;
			}
			if(c1.estinfini) {
				return c2;
			}
			if(c2.estinfini) {
				return c1;
			}
			if(c1.valeur<=c2.valeur) {
				return c1;
			}
			return c2;
		}
	}
	

}
