record Option(String label, Runnable action, boolean attendre) {

    // option habituelle : après l'action, on attend que l'utilisateur appuie sur Entrée
    Option(String label, Runnable action) {
        this(label, action, true);
    }

    // option ouvrant un sous-menu : pas besoin d'attendre
    static Option sousMenu(String label, Runnable action) {
        return new Option(label, action, false);
    }
}
