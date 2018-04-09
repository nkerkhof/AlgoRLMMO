
public class Test {
	public static void main(String[] args) {
		AlgoDynamique ad = new AlgoDynamique();
		AlgoGlouton ag = new AlgoGlouton();
		AlgoEssaiSucc aes = new AlgoEssaiSucc();
		int[] sol = ad.execute(99);
		System.out.println(ad.affichage(sol));
		sol=ag.execute(99);
		System.out.println(ag.affichage(sol));
		sol=aes.execute(99);
		System.out.println(aes.affichage(sol));
	}
}
