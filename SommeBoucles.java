public class SommeBoucles {
    
    public static void main(String[] args){

        int sommeFor = 0;
        for (int i = 1; i <= 10; i++){
            sommeFor += i;
        }
        System.out.println("Somme avec la boucle For : " + sommeFor);


        int sommeWhile = 0;
        int i = 1;
        while ( i <= 10) {
            sommeWhile += i;
            i++;
        }
        System.out.println("Somme avec la boucle While : " + sommeWhile);


        int sommeDoWhile = 0;
        int j = 1;
        do {
            sommeDoWhile += j;
            j++;
        } while (j <= 10);
        System.out.println("Somme avec la boucle do...while : " + sommeDoWhile);
    }

}
