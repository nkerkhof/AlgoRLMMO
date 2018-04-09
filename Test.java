
public class Test {
	public static void main(String[] args) {
		long start;
		long stop;
		AlgoDynamique ad = new AlgoDynamique();
		AlgoGlouton ag = new AlgoGlouton();
		AlgoEssaiSucc aes = new AlgoEssaiSucc();
		start = System.nanoTime();
		int[] sol = ad.execute(99);
		stop = System.nanoTime();
		System.out.println("Fin de l'algorithme dynamique : "+((float)(stop-start))/1000000+" ms");
		System.out.println(ad.affichage(sol));
		start = System.nanoTime();
		sol=ag.execute(99);
		stop = System.nanoTime();
		System.out.println("Fin de l'algorithme glouton : "+((float)(stop-start))/1000000+" ms");
		System.out.println(ag.affichage(sol));
		start = System.nanoTime();
		sol=aes.execute(99);
		stop = System.nanoTime();
		System.out.println("Fin des essais successifs : "+((float)(stop-start))/1000000+" ms");
		System.out.println(aes.affichage(sol));
	}
}
