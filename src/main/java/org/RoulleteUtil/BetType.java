package org.RoulleteUtil;

public enum BetType {
    RED("Red"),
    BLACK("Black"),
    EVEN("Even"),
    ODD("Odd"),
    FIRSTHALF("First Half"),
    SECONDHALF("Second Half"),
    FIRSTINTERVAL("First Interval"),
    SECONDINTERVAL("Second Interval"),
    THIRDINTERVAL("Third Interval"),
    MOD3EQUALS0("Mod 3 Equals 0"),
    MOD3EQUALS1("Mod 3 Equals 1"),
    MOD3EQUALS2("Mod 3 Equals 2"),
    NUMBER("Number");

    private final String label;

    BetType(String label) {
        this.label = label;
    }

    public String getLabel() {

        return label;
    }

    public static BetType fromString(String text) {
        for (BetType betType : BetType.values()) {
            if (betType.label.equalsIgnoreCase(text)) {
                return betType;
            }
        }
        throw new IllegalArgumentException("No constant with label " + text + " found in BetType enum");
    }

}