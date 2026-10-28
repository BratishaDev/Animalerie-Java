public record Resultat(boolean succes, String message) {

    public static Resultat ok(String message) {
        return new Resultat(true, message);
    }

    public static Resultat erreur(String message) {
        return new Resultat(false, "Erreur: " + message);
    }
}