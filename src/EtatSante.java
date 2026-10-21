public enum EtatSante {
    SAIN ("sain"),
    SOIN_LEGER("soin léger"),
    SOIN_INTENSIF("soin intensif");

    private final String name;

    EtatSante(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
