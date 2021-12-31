package LanguageCreator;

public class StringParser {
    private String Str;

    /**
     * <h1>Tools for string parsing.</h1>
     * Create new instance of parser.
     * Now you using constructor.
     * @param Line The line.
     */
    public StringParser(String Line) {
        Str = Line;
    }

    /**
     * Cut string from start.
     * @param From Cut from.
     */
    public String CutStart(int From) {
        return Str.substring(From);
    }

    /**
     * Cut string from end.
     * @param From Cut from.
     */
    public String CutEnd(int From) {
        return Str.substring(0, Str.length() - From);
    }

    /**
     * Cut string from start and end.
     * @param Start Cut from start.
     * @param End Cut from end.
     */
    public String Cut(int Start, int End) {
        return Str.substring(Start, Str.length() - End);
    }


    /**
     * Strip the side.
     * If side will be invalid, function will return null.
     * <ul>
     *     <li>0 - Left.</li>
     *     <li>1 - Right.</li>
     *     <li>2 - Left and right.</li>
     * </ul>
     * @param Side Side to strip.
     */
    public String RemoveSpaces(int Side) {
        return switch (Side) {
            case 0 -> Str.stripLeading();
            case 1 -> Str.stripTrailing();
            case 2 -> Str.strip();
            default -> null;
        };
    }

    /**
     * Replace string.
     * If Old length is 1 and New length is 1, function just replaces old on new and returns new string.
     * If Old lenght not 1 and New length not 1, function replaces Old[Position] on New[Position]. If New will have more that Old or less that Old, returns null.
     * If error returns null.
     * @param Old String to replace.
     * @param New Replace on.
     */
    public String Replace(String[] Old, String[] New) {
        String Replaced = Str;

        if(Old.length == 1 && New.length == 1) {
            return Str.replace(Old[0], New[0]);
        } else if(Old.length > 1 && New.length > 1) {
            if(New.length > Old.length || New.length < Old.length) {
                return null;
            } else {
                for(int Index=0;Index<Old.length;Index++) {
                    Replaced = Replaced.replace(Old[Index], New[Index]);
                }

                return Replaced;
            }
        } else {
            return null;
        }
    }

    /**
     * Crash string by separator.
     * @param Separator The separator.
     */
    public String[] Crash(String Separator) {
        return Str.split(Separator);
    }

    /**
     * Split string by <i>separator</i><b>s</b>
     * Returns an array with splitted string step by step.
     * @param Separator The separator.
     */
    public String[][] Crash(String[] Separator) {
        String[][] Splitted = new String[Separator.length][Separator.length];

        for(int Index=0;Index<Separator.length;Index++) {
            Splitted[Index] = Str.split(Separator[Index]);
        }

        return Splitted;
    }

    /**
     * Remove substring from string.
     * @param Character
     */
    public String Remove(String Character) {
        return Str.replace(Character, "");
    }

    /**
     * Convert string to case.
     * If will be chosen unknown case, function will return null.
     * <ul>
     *     <li>Lower case - 1.</li>
     *     <li>Upper case - 2.</li>
     * </ul>
     * @param Case The case.
     */
    public String ToCase(int Case) {
        return switch (Case) {
            case 1 -> Str.toLowerCase();
            case 2 -> Str.toUpperCase();
            default -> null;
        };
    }

    /**
     * Get string from scobes.
     */
    public String GetFromScobes() {
        return Cut(1, 1);
    }

    /**
     * Is substring in string.
     * @param TheString The substring.
     */
    public boolean InString(String TheString) {
        return Str.contains(TheString);
    }

    /**
     * Convert array to string.
     * @param Array
     */
    public static String ArrayToString(String[] Array) {
        return String.format("<[%s]>", String.join(", ", Array));
    }

    /**
     * Update written string.
     */
    public void UpdateString(String Line) {
        Str = Line;
    }

    /**
     * Create new string.
     * @param Obj The string.
     */
    public String NewString(Object Obj) {
        return String.valueOf(Obj);
    }

    /**
     * Clean the string.
     */
    public void CleanString() {
        Str = null;
    }

    /**
     * Get written string.
     */
    public String GetString() {
        return Str;
    }
}
