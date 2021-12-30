package LanguageCreator;

public class Characters {
    public static final String LowerChars = "abcdefghijklmnopqrstuvwxyz";
    public static final String UpperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String Characters = String.format("%s%s", LowerChars, UpperChars);
    public static final String TheSymbols = "`~!@\"#№$;%^:&?*()_+-=[]{}',<.>\\|/";
    public static final String AllSymbols = String.format("%s%s", Characters, TheSymbols);

    /**
     * Get all characters as array.
     */
    public static char[] AsArray() {
        return AllSymbols.toCharArray();
    }
}
