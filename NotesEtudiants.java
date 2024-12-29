import java.util.Scanner;
public class NotesEtudiants {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nombre d'étudiants : ");
        int nombreEtudiants = scanner.nextInt();

        double[] notes = new double[nombreEtudiants];
        double somme = 0;

        System.out.println("Entrez les notes des étudiants : ");
        for(int i = 0; i < nombreEtudiants; i++){
            System.out.print("Note de l'étudiant " + (i + 1) + ": ");
            notes[i] = scanner.nextDouble();
            somme += notes[i];
        }

        double moyenne = somme / nombreEtudiants;
        System.out.println("La moyenne de la classe est : " + moyenne);
        System.out.println(moyenne);

        //le nbr d'étudiants ayant une note supérieure à la moyenne
        int nombreSuperieurMoyenne = 0;
        for(double note : notes){
            if(note > moyenne){
                nombreSuperieurMoyenne++;
            }
        }

        System.out.println("Nombre d'étudiants ayant une note supérieure à la moyenne : " + nombreSuperieurMoyenne);

        scanner.close();

        }
    
}
