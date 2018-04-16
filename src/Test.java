import java.io.FileWriter;
import java.io.IOException;

public class Test {
	static boolean debug = false;

	public static void main(String[] args) {
		int[] typePiece = { 1, 2, 5, 10, 20, 50, 100, 200 };
		String text = "";
		text += "nb\ttestDynamique\ttestGlouton\ttestEssaisSuccessif2\ttestEssaisSuccessif3\t\n";
		for(int prix=1; prix<100;prix++) {
			text +=prix+"\t";
			text +=testDynamique(typePiece, prix);
			text +="\t";
			text +=testGlouton(typePiece, prix);
			text +="\t";
			// testEssaisSuccessif(typePiece, prix, 0);
			// testEssaisSuccessif(typePiece, prix, 1);
			text +=testEssaisSuccessif(typePiece, prix, 2);
			text +="\t";
			text +=testEssaisSuccessif(typePiece, prix, 3);
			text +="\t\n";
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
