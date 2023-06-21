package PaketPro;

import java.util.Scanner;

public class PostAssistent {
    public void assistiere() {
        Postamt postamt = new Postamt("Hauptpostamt");
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n" + "----" + postamt.getName() + "----" + "\n");
            System.out.println("1. Paket hinzufügen");
            System.out.println("2. Paketstatus anzeigen");
            System.out.println("3. Pakete bearbeiten");
            System.out.println("4. Pakete ausliefern");
            System.out.println("5. Beenden" + "\n");
            System.out.print("Auswahl: ");

            try {
                int auswahl = scanner.nextInt();
                scanner.nextLine();

                switch (auswahl) {
                    case 1:
                        System.out.print("Absender: ");
                        String absender = scanner.nextLine();
                        System.out.print("Empfänger: ");
                        String empfaenger = scanner.nextLine();
                        System.out.print("Gewicht (in kg): ");
                        double gewicht = leseGewicht(scanner);
                        System.out.print("Zielkontinent ");
                        String zielland = leseGueltigenKontinent(scanner);
                        System.out.print("Versandart (S für Standardversand, E für Expressversand): ");
                        String versandart = leseGueltigeVersandart (scanner);

                        Paket paket = new Paket(absender, empfaenger, gewicht, zielland, versandart.equals("E"));
                        postamt.addPaket(paket);
                        System.out.println("Paket hinzugefügt.");
                        System.out.println("Versandkosten: " + paket.getVersandkosten() + " €");
                        System.out.println();
                        break;
                    case 2:
                        if (postamt.hatPakete()) {
                            postamt.zeigePaketStatus();
                        } else {
                            System.out.println("Es wurden noch keine Pakete hinzugefügt.");
                        }
                        System.out.println();
                        break;
                    case 3:
                        if (postamt.hatPakete()) {
                            postamt.bearbeitePakete();
                            System.out.println("Pakete wurden bearbeitet.");
                        } else {
                            System.out.println("Es wurden noch keine Pakete hinzugefügt.");
                        }
                        System.out.println();
                        break;
                    case 4:
                        if (postamt.hatPakete()) {
                            postamt.lieferePaketeAus();
                            System.out.println("Pakete wurden ausgeliefert.");
                        } else {
                            System.out.println("Es wurden noch keine Pakete hinzugefügt.");
                        }
                        System.out.println();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Ungültige Auswahl.");
                        System.out.println();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ungültige Eingabe.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static double leseGewicht(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                input = input.replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Ungültiges Gewicht. Bitte geben Sie das Gewicht erneut ein: ");
            }
        }
    }

    private static String leseGueltigenKontinent(Scanner scanner) {
        String kontinenteString = "( Nordamerika, Südamerika, Europa, Afrika, Asien, Ozeanien ):";
        while (true) {
            System.out.print(kontinenteString);
            String zielland = scanner.nextLine();
            switch (zielland.toLowerCase()) {
                case "nordamerika":
                case "südamerika":
                case "europa":
                case "afrika":
                case "asien":
                case "ozeanien":
                    return zielland;
            }
            System.out.println("Ungültiger Kontinent. Bitte geben Sie einen gültigen Kontinent ein.");
        }
    }


    private static String leseGueltigeVersandart(Scanner scanner) {
        while (true) {
            String versandart = scanner.nextLine().toUpperCase();
            if (versandart.equals("S") || versandart.equals("E")) {
                return versandart;
            }
            System.out.print("Ungültige Versandart. Bitte geben Sie S für Standardversand oder E für Expressversand ein: ");
        }
    }
}