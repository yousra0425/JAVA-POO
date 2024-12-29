import java.util.Scanner;

public class CalculFacture {
    static final double TAUX_TVA = 0.186; 

    public static double calculerRemise(double montantTTC) {
        double tauxRemise;
        if (montantTTC < 1000) {
            tauxRemise = 0;
        } else if (montantTTC < 2000) {
            tauxRemise = 0.01; 
        } else if (montantTTC < 5000) {
            tauxRemise = 0.03; 
        } else {
            tauxRemise = 0.05; 
        }
        return montantTTC * tauxRemise;
    }

    public static void calculerEtAfficherFacture(double prixHT) {
        double montantTVA = prixHT * TAUX_TVA;
        double montantTTC = prixHT + montantTVA;
        double remise = calculerRemise(montantTTC);
        double montantFinal = montantTTC - remise;

        System.out.println("\nDétails de la facture :");
        System.out.println("Prix HT : " + prixHT + " DH");
        System.out.println("Montant TVA (18.6%) : " + String.format("%.2f", montantTVA) + " DH");
        System.out.println("Montant TTC : " + String.format("%.2f", montantTTC) + " DH");
        System.out.println("Remise appliquée : " + String.format("%.2f", remise) + " DH");
        System.out.println("Montant final à payer : " + String.format("%.2f", montantFinal) + " DH");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Premier exemple
        System.out.println("=== Premier exemple ===");
        calculerEtAfficherFacture(1500);

        // Deuxième exemple
        System.out.println("\n=== Deuxième exemple ===");
        calculerEtAfficherFacture(4000);

        System.out.println("\n=== Saisie utilisateur ===");
        System.out.print("Entrez le prix HT en DH : ");
        double prixHT = scanner.nextDouble();
        calculerEtAfficherFacture(prixHT);

        scanner.close();
    }
}