package PaketPro;

public class Paket {
    private String absender;
    private String empfaenger;
    private double gewicht;
    private String zielland;
    private boolean expressVersand;

    public Paket(String absender, String empfaenger, double gewicht, String zielland, boolean expressVersand) {
        this.absender = absender;
        this.empfaenger = empfaenger;
        this.gewicht = gewicht;
        this.zielland = zielland;
        this.expressVersand = expressVersand;
    }

    public double getVersandkosten() {
        double versandkosten = 0.0;
        if (expressVersand) {
            switch (zielland.toLowerCase()) {
                case "nordamerika":
                    versandkosten = gewicht * 12.0;
                    break;
                case "südamerika":
                    versandkosten = gewicht * 11.0;
                    break;
                case "europa":
                    versandkosten = gewicht * 10.0;
                    break;
                case "afrika":
                    versandkosten = gewicht * 13.0;
                    break;
                case "asien":
                    versandkosten = gewicht * 14.0;
                    break;
                case "ozeanien":
                    versandkosten = gewicht * 15.0;
                    break;
            }
        } else {
            switch (zielland.toLowerCase()) {
                case "nordamerika":
                    versandkosten = gewicht * 8.0;
                    break;
                case "südamerika":
                    versandkosten = gewicht * 7.0;
                    break;
                case "europa":
                    versandkosten = gewicht * 6.0;
                    break;
                case "afrika":
                    versandkosten = gewicht * 9.0;
                    break;
                case "asien":
                    versandkosten = gewicht * 10.0;
                    break;
                case "ozeanien":
                    versandkosten = gewicht * 11.0;
                    break;
            }
        }
        return Math.round(versandkosten);
    }

    public String getAbsender() {
        return absender;
    }

    public void setAbsender(String absender) {
        this.absender = absender;
    }

    public String getEmpfaenger() {
        return empfaenger;
    }

    public void setEmpfaenger(String empfaenger) {
        this.empfaenger = empfaenger;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public String getZielland() {
        return zielland;
    }

    public void setZielland(String zielland) {
        this.zielland = zielland;
    }

    public boolean isExpressVersand() {
        return expressVersand;
    }

    public void setExpressVersand(boolean expressVersand) {
        this.expressVersand = expressVersand;
    }

    @Override
    public String toString() {
        return "Paket{" +
                "Absender='" + absender + '\'' +
                ", Empfänger='" + empfaenger + '\'' +
                ", Gewicht=" + gewicht +
                ", Zielkontinent='" + zielland + '\'' +
                ", Expressversand=" + expressVersand +
                '}';
    }
}