public interface PatternBuilder {
    StringBuilder pattern = new StringBuilder();
    /**
     * Constructs a pattern according to the specified rows
     * @param rows The amount of rows our constructed pattern will have
     */
    void constructPattern(int rows);

    /**
     * Sets the pattern character to the specified String
     * @param patternCharacter The character that is to be used when constructing a pattern
     */
    void setPatternCharacter(String patternCharacter);

    void resetPattern();
    void printPattern();
}
