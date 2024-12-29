package ex6;

public class MatrixPoints {
    public static void main(String[] args) {
       
        Point[][] matrice = new Point[2][3];
        
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 2.0);
        Point p3 = new Point(3.0, 3.0);
        Point p4 = new Point(4.0, 4.0);
        Point p5 = new Point(5.0, 5.0);
        
        matrice[0][0] = p1;
        matrice[0][1] = p2;
        matrice[0][2] = p3;
        matrice[1][0] = p4;
        matrice[1][1] = p5;
        
        System.out.println("Contenu de la matrice :");
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

