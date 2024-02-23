public class PatternPrinter implements PatternBuilder {
    protected String patternCharacter = "*";
    private final StringBuilder pattern = new StringBuilder();

    /**
     * Constructs a pattern according to the specified rows and with the specified pattern character. This pattern is constructed in two parts
     * @param rows The number of rows our constructed pattern will have
     */
    @Override
    public void constructPattern(int rows) {
        // Constructs the first part of the pattern - decrementing (i) to decrease pattern characters per row
        for (int i = rows; i >= 1; i--) {
            // Constructs each row with pattern characters starting from the value of @param rows down to 1
            for (int j = 1; j <= i; j++) {
                pattern.append(patternCharacter);
            }

            // After completing a row, we 'bounce' to the next row
            pattern.append("\n");
        }

        // Used as the pattern separator. A clear distinction between the descending and ascending patterns
        pattern.append("---").append("\n");

        // Constructs the second part of the pattern - incrementing (i) to increase pattern characters per row
        for (int i = 1; i <= rows; i++) {
            // Constructs each row with pattern characters starting from 1 up to the value of @param rows
            for (int j = 1; j <= i; j++) {
                pattern.append(patternCharacter);
            }

            pattern.append("\n");
        }

        printPattern();

        // Maintains the default character
        if (!this.patternCharacter.equals("*")) {
            setPatternCharacter("*");
        }

        resetPattern();
    }

    /**
     * Sets the pattern character to the specified value
     * @param patternCharacter The character that is to be used when constructing a pattern
     */
    @Override
    public void setPatternCharacter(String patternCharacter) {
        this.patternCharacter = patternCharacter;
    }

    /**
     * Resets the pattern
     */
    @Override
    public void resetPattern() {
        pattern.setLength(0);
    }

    /**
     * Prints the pattern
     */
    @Override
    public void printPattern() {
        System.out.println(this.pattern);
    }
}
