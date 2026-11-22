package cat.iesesteveterradas;

import cat.iesesteveterradas.db.DatabaseInitializer;
import cat.iesesteveterradas.dbo.FaccioDAO;
import cat.iesesteveterradas.dbo.PersonatgeDAO;

import java.util.Scanner;

public class PR210LOL {

    public static void main(String[] args) {

        DatabaseInitializer.init();

        Scanner sc = new Scanner(System.in);

        FaccioDAO faccioDAO = new FaccioDAO();
        PersonatgeDAO personatgeDAO = new PersonatgeDAO();

        int opcio;

        do {

            System.out.println("\n=== LOL DATABASE ===");
            System.out.println("1. Mostrar Faccions");
            System.out.println("2. Mostrar Personatges");
            System.out.println("3. Personatges per Facció");
            System.out.println("4. Millor Atacant");
            System.out.println("5. Millor Defensor");
            System.out.println("0. Sortir");

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:
                    faccioDAO.mostrarFaccions();
                    break;

                case 2:
                    personatgeDAO.mostrarPersonatges();
                    break;

                case 3:
                    System.out.print("Nom facció: ");
                    personatgeDAO.mostrarPersonatgesPerFaccio(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Nom facció: ");
                    personatgeDAO.millorAtacant(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Nom facció: ");
                    personatgeDAO.millorDefensor(sc.nextLine());
                    break;
            }

        } while (opcio != 0);

        sc.close();
    }
}