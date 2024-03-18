public enum TestType {
    CBC("C"),
    FBC("F"),
    URINE("U"),
    XRAY("X"),
    MRI("M"),
    ENDOSCOPY("E");

    private final String testCode;

    TestType(String testCode) {
        this.testCode = testCode;
    }

    public String getTestCode() {
        return testCode;
    }
    
    public static TestType fromTestCode(String code) {
        for (TestType type : values()) {
            if (type.getTestCode().equalsIgnoreCase(code)) {
                return type;
            }
        }
        return null;
    }
}
