package LanguageCreator;

public class Credits {
    public static final String License = "MIT License";
    public static final String Creator = "Ivan Perzhinsky";
    public static final String LibNote = "Ported from Python on Java";

    public static final short CreateYear = 2021;
    public static final float LibVersion = 1.0f;

    public static final boolean Finished = true;

    /**
     * Get array with credits and information.
     */
    public static Object[] Get() {
        return new Object[] {License, Creator, LibNote, CreateYear, LibVersion, Finished};
    }
}
