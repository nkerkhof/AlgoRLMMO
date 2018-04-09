public abstract class InterfaceAlgoRLMMO {
	public int prix = 0;
	public int typePiece[] = {1,2,5,10,20,50,100,200};
	public int nbCoupPiece[] = new int[typePiece.length];
	
	public abstract int[] execute(int prix);
	public String affichage() {
		String str = "";
		for(int i=0; i<typePiece.length;i++) {
			str += "valeur "+typePiece[i]+"   avec un nb " +nbCoupPiece[i]+"\n";
		}
		return str;
	}
}
