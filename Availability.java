public enum Availability {
    AVAILABLE("A"),
    ON_LEAVE("L"),
    ON_BREAK("B");

    private final String code;
    Availability(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    public static Availability fromCode(String code) {
        for (Availability availability : values()) {
            if (availability.getCode().equalsIgnoreCase(code)) {
                return availability;
            }
        }
        return null;
    }
}
