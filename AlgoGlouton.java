
public class AlgoGlouton extends InterfaceAlgoRLMMO {

	@Override
	public int[] execute(int prix) {
		for(int a=0;a<typePiece.length;a++) {
			nbCoupPiece[a] = 0;
		}
		int somCour = 0;
		for(int i=typePiece.length-1;i>=0;i--) {
			while(somCour<=prix-typePiece[i]) {
				nbCoupPiece[i]++;
				somCour+=typePiece[i];
			}
		}
		return nbCoupPiece;
	}

}
