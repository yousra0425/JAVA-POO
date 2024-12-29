import java.util.HashMap;
import java.util.Scanner;

class CompteBancaire {
    private String numero;
    private String nomClient;
    private double solde;

    public CompteBancaire(String numero, String nomClient, double soldeInitial) {
        this.numero = numero;
        this.nomClient = nomClient;
        this.solde = soldeInitial;
    }

    public boolean versement(double montant) {
        if (montant > 0) {
            solde += montant;
            return true;
        }
        return false;
    }

    public boolean debit(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public void afficherEtat() {
        System.out.println("\nÉtat du compte " + numero);
        System.out.println("Client: " + nomClient);
        System.out.println("Solde actuel: " + solde + "€");
    }

    public String getNumero() {
        return numero;
    }
}

public class GestionBanque {
    private static HashMap<String, CompteBancaire> comptes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int compteurCompte = 1000;

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    creerCompte();
                    break;
                case 2:
                    faireVersement();
                    break;
                case 3:
                    faireDebit();
                    break;
                case 4:
                    afficherEtatCompte();
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option invalide!");
            }
        } while (choix != 5);
        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Créer un compte");
        System.out.println("2. Faire un versement");
        System.out.println("3. Faire un débit");
        System.out.println("4. Afficher l'état d'un compte");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void creerCompte() {
        System.out.print("Nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Solde initial : ");
        double soldeInitial = scanner.nextDouble();

        String numero = "C" + compteurCompte++;
        CompteBancaire compte = new CompteBancaire(numero, nom, soldeInitial);
        comptes.put(numero, compte);

        System.out.println("Compte créé avec succès!");
        System.out.println("Numéro de compte : " + numero);
    }

    private static void faireVersement() {
        System.out.print("Numéro de compte : ");
        String numero = scanner.nextLine();
        CompteBancaire compte = comptes.get(numero);

        if (compte != null) {
            System.out.print("Montant à verser : ");
            double montant = scanner.nextDouble();
            if (compte.versement(montant)) {
                System.out.println("Versement effectué avec succès!");
            } else {
                System.out.println("Montant invalide!");
            }
        } else {
            System.out.println("Compte non trouvé!");
        }
    }

    private static void faireDebit() {
        System.out.print("Numéro de compte : ");
        String numero = scanner.nextLine();
        CompteBancaire compte = comptes.get(numero);

        if (compte != null) {
            System.out.print("Montant à débiter : ");
            double montant = scanner.nextDouble();
            if (compte.debit(montant)) {
                System.out.println("Débit effectué avec succès!");
            } else {
                System.out.println("Montant invalide ou solde insuffisant!");
            }
        } else {
            System.out.println("Compte non trouvé!");
        }
    }

    private static void afficherEtatCompte() {
        System.out.print("Numéro de compte : ");
        String numero = scanner.nextLine();
        CompteBancaire compte = comptes.get(numero);

        if (compte != null) {
            compte.afficherEtat();
        } else {
            System.out.println("Compte non trouvé!");
        }
    }
}