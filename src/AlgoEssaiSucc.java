
public class AlgoEssaiSucc extends InterfaceAlgoRLMMO {

	int nbOpt = 0;
	int solution[]=new int[typePiece.length];
	int somcour=0;
	int nbPiece = 0;
	@Override
	public int[] execute(int prix) { //Sans elagage
		for(int k=0;k<typePiece.length-1;k++) {
			solution[k]=0;
			nbCoupPiece[k]=0;
		}
		this.prix=prix;
		nbOpt = prix + 5;
		rlmmoSansElag(0);
		return solution;
		
	}
	
	public void rlmmoSansElag(int i) {
		for(int h=0;h<=prix;h++) {
			nbCoupPiece[i]=h;
			if(somcour<=prix) {
				nbPiece+=h;
				somcour+=h*typePiece[i];
				if(somcour==prix) {
					if(nbPiece<nbOpt) {
						nbOpt = nbPiece;
						for(int p = 0;p<=i;p++) {
							solution[p] = nbCoupPiece[p];
						}
					}
				} else {
					if(i<typePiece.length-1) {
						rlmmoSansElag(i+1);
					}
				}
				somcour=somcour-h*typePiece[i];
				nbPiece = nbPiece - h;
			}
		}
	}

}
