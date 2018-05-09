import java.io.FileWriter;
import java.io.IOException;

public class Test {
	static boolean debug = false;

	public static void main(String[] args) {
		int[] typePiece = { 1, 2, 5, 10, 20, 50, 100, 200 };
		String text = "";
		text += "nb\ttestDynamique\ttestGlouton\ttestEssaisSuccessif3\t\n";
		long debut = System.nanoTime();
		int i = 1;
		int prixMax = 1000; //prix maximum jusqu'à l'arret
		int minutes = 2; //temps jusqu'a l'arret
		try {
		if(args[1]!=null) {
			prixMax=Integer.parseInt(args[1]);
		}
		if(args[2]!=null) {
			minutes=Integer.parseInt(args[2]);
		}} catch(ArrayIndexOutOfBoundsException e) {
			
		}
		long temps = minutes*60000000000L;
		while(i <= prixMax && (System.nanoTime()-debut)<((long) temps)) { //Arret de la boucle si on depasse un certain temps
			text +=i+"\t";
			text +=testDynamique(typePiece, i);
			text +="\t";
			text +=testGlouton(typePiece, i);
			text +="\t";
			//text +=testEssaisSuccessif(typePiece, i, 0);
			//text +="\t";
			//text +=testEssaisSuccessif(typePiece, i, 1);
			//text +="\t";
			//text +=testEssaisSuccessif(typePiece, i, 2);
			//text +="\t";
			text +=testEssaisSuccessif(typePiece, i, 3);
			text +="\t\n";
			i++;
		}
		ecrireCSV(text, "./test.csv");
	}

	private static float testDynamique(int[] typePiece, int prix) {
		long start;
		long stop;
		AlgoDynamique ad = new AlgoDynamique();
		ad.setTypePiece(typePiece);
		start = System.nanoTime();
		int[] sol = ad.execute(prix);
		stop = System.nanoTime();
		float res = (float) (stop - start) / 1000000;
		if (debug) {
			System.out.println("Fin de l'algorithme dynamique : " + res + " ms");
			System.out.println(ad.affichage(sol));
		}
		return res;
	}

	private static float testGlouton(int[] typePiece, int prix) {
		long start;
		long stop;
		AlgoGlouton ag = new AlgoGlouton();
		ag.setTypePiece(typePiece);
		start = System.nanoTime();
		int[] sol = ag.execute(prix);
		stop = System.nanoTime();
		float res = (float) (stop - start) / 1000000;
		if (debug) {
			System.out.println("Fin de l'algorithme glouton : " + res + " ms");
			System.out.println(ag.affichage(sol));
		}
		return res;
	}

	private static float testEssaisSuccessif(int[] typePiece, int prix, int type) {
		long start;
		long stop;
		AlgoEssaiSucc aes = new AlgoEssaiSucc();
		aes.setAlgoSelect(type);
		aes.setTypePiece(typePiece);
		start = System.nanoTime();
		int[] sol = aes.execute(prix);
		stop = System.nanoTime();
		float res = (float) (stop - start) / 1000000;
		if (debug) {
			System.out.println("Fin de l'algorithme Successif (type" + type + "): " + res + " ms");
			System.out.println(aes.affichage(sol));
		}
		return res;
	}

	private static void ecrireCSV(String text, String nomFichier) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(nomFichier);
			fileWriter.append(text);
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}
}
