import java.util.Scanner;

public class MaxTableau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la taille du tableau : ");
        int taille = scanner.nextInt();

        int[] tableau = new int[taille];

        System.out.println("Entrez les éléments du tableau : ");
        for (int i = 0; i < taille; i++) {
            System.out.print("Élément " + (i + 1) + ": ");
            tableau[i] = scanner.nextInt();
        }
        //  le maximum
        int maximum = tableau[0];
        for (int i = 1; i < taille; i++) {
            if (tableau[i] > maximum) {
                maximum = tableau[i];
            }
        }
        System.out.println("Le maximum des éléments est : " + maximum);

        scanner.close();
    }
}
