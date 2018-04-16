
public class AlgoEssaiSucc extends InterfaceAlgoRLMMO {
	int algoSelect = 0;// 0: sans elag, 1: avec elag1, 2:avec elag2, 3: avec elag1 et 2
	int nbOpt = 0;
	int solution[]=new int[typePiece.length];
	int somcour=0;
	int nbPiece = 0;
	
	public void setAlgoSelect(int i) {
		algoSelect=i;
	}
	public void setSansElag() {
		algoSelect=0;
	}
	
	public void setElag1() {
		algoSelect=1;
	}
	public void setElag2() {
		algoSelect=2;
	}
	public void setElag12() {
		algoSelect=3;
	}
	
	
	
	@Override
	public int[] execute(int prix) { //Sans elagage
		for(int k=0;k<typePiece.length-1;k++) {
			solution[k]=0;
			nbCoupPiece[k]=0;
		}
		this.prix=prix;
		nbOpt = prix + 5;
		switch (algoSelect) {
			case 0: rlmmoSansElag(0);break;
			case 1: rlmmoAvecElag1(0);break;
			case 2: rlmmoAvecElag2(0);break;
			case 3: rlmmoAvecElag12(0);break;
		}
		
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
	
	public void rlmmoAvecElag1(int i) {
		for(int h=0;h<=prix;h++) {
			nbCoupPiece[i]=h;
			if(somcour<=prix/typePiece[i]) {
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
						rlmmoAvecElag1(i+1);
					}
				}
				somcour=somcour-h*typePiece[i];
				nbPiece = nbPiece - h;
			}
		}
	}

	
	public void rlmmoAvecElag2(int i) {
		for(int h=0;h<=prix;h++) {
			nbCoupPiece[i]=h;
			if(somcour<=prix) {
				nbPiece+=h;
				somcour+=h*typePiece[i];
				if(nbPiece<nbOpt) {
					if(somcour==prix) {
						if(nbPiece<nbOpt) {
							nbOpt = nbPiece;
							for(int p = 0;p<=i;p++) {
								solution[p] = nbCoupPiece[p];
							}
						}
					} else {
						if(i<typePiece.length-1) {
							rlmmoAvecElag2(i+1);
						}
					}
				}
				somcour=somcour-h*typePiece[i];
				nbPiece = nbPiece - h;
			}
		}
	}
	
	public void rlmmoAvecElag12(int i) {
		for(int h=0;h<=prix;h++) {
			nbCoupPiece[i]=h;
			if(somcour<=prix/typePiece[i]) {
				nbPiece+=h;
				somcour+=h*typePiece[i];
				if(nbPiece<nbOpt) {
					if(somcour==prix) {
						if(nbPiece<nbOpt) {
							nbOpt = nbPiece;
							for(int p = 0;p<=i;p++) {
								solution[p] = nbCoupPiece[p];
							}
						}
					} else {
						if(i<typePiece.length-1) {
							rlmmoAvecElag12(i+1);
						}
					}
				}
				somcour=somcour-h*typePiece[i];
				nbPiece = nbPiece - h;
			}
		}
	}
}
