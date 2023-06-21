package PaketPro;

import java.util.ArrayList;
import java.util.List;

public class Postamt {
    private String name;
    private List<Paket> pakete;

    public Postamt(String name) {
        this.name = name;
        this.pakete = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPaket(Paket paket) {
        pakete.add(paket);
    }

    public boolean hatPakete() {
        return !pakete.isEmpty();
    }

    public void zeigePaketStatus() {
        System.out.println("Paketstatus:");
        for (Paket paket : pakete) {
            System.out.println(paket.toString());
            System.out.println("Versandkosten: " + paket.getVersandkosten() + " €");
            System.out.println();
        }
    }


    public void bearbeitePakete() {
        System.out.println("Pakete werden bearbeitet...");
        // Hier können weitere Bearbeitungsschritte implementiert werden
    }

    public void lieferePaketeAus() {
        System.out.println("Pakete werden ausgeliefert...");
        // Hier können weitere Schritte für die Auslieferung implementiert werden
        pakete.clear();
    }
}