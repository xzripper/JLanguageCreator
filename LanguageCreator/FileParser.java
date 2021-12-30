package LanguageCreator;

import java.io.FileNotFoundException;
import java.io.File;

import java.util.Scanner;

public class FileParser {
    private String TheFile;

    /**
     * <h1>Tools for file parsing.</h1>
     * Create new instance of FileParser.
     * Now you calling constructor.
     * @param File Target file.
     */
    public FileParser(String File) {
        TheFile = File;
    }


    /**
     * Open a file.
     * Returns a File class.
     */
    public File GetFile() {
        return new File(TheFile);
    }

    /**
     * Get content of file.
     * Returns string as content.
     */
    public String ReadFile() throws FileNotFoundException {
        String Newline = "\n";
        String Empty = "";

        String Text = "";

        File OpenedFile = GetFile();
        Scanner ScannerObject = new Scanner(OpenedFile);

        while(true) {
            if(!ScannerObject.hasNextLine()) {
                ScannerObject.close();

                return Text;
            } else {
                Text += (ScannerObject.nextLine() + (ScannerObject.hasNextLine() ? Newline : Empty));
            }
        }
    }

    /**
     * Get lines from file.
     * Returns an array with lines.
     * @param EndSymbol End line symbol.
     */
    public String[] GetLines(String EndSymbol) throws FileNotFoundException {
        String End = String.format("%s\n", EndSymbol);
        String Content = ReadFile();
        String[] Lines = Content.split(End);

        Lines[Lines.length - 1] = Lines[Lines.length - 1].substring(0, Lines[Lines.length - 1].length() - 1);

        return Lines;
    }

    /**
     * Get line by position.
     * If line doesn't exist, returns null.
     * @param EndSymbol End line symbol.
     * @param Position Line position.
     */
    public String GetLine(String EndSymbol, int Position) throws FileNotFoundException {
        try {
            return GetLines(EndSymbol)[Position - 1];
        }

        catch(IndexOutOfBoundsException Error) {
            return null;
        }
    }

    /**
     * Search line by category.
     * If category doesn't match any template, returns empty array.
     * If line don't found, returns array with null.
     * <ul>
     *     <li>Starts with "*" - Search line where string starts with string after "*".</li>
     *     <li>Ends with "*" - Search line where string ends with string before "*".</li>
     *     <li>Starts with "%" - Search line where string have string after "%".</li>
     * </ul>
     * @param EndSymbol End line symbol.
     * @param Category Search category.
     */
    public String[] GetByCategory(String EndSymbol, String Category) throws FileNotFoundException {
        String[] Lines = GetLines(EndSymbol);
        String[] Filtered = new String[Lines.length];

        if(Category.startsWith("*")) {
            for(int Index=0;Index<Lines.length;Index++) {
                if(Lines[Index].startsWith(Category.substring(1))) {
                    Filtered[Index] = Lines[Index];
                }
            }

            return Filtered;
        } else if(Category.endsWith("*")) {
            for(int Index=0;Index<Lines.length;Index++) {
                if(Lines[Index].endsWith(Category.substring(0, Category.length() - 1))) {
                    Filtered[Index] = Lines[Index];
                }
            }

            return Filtered;
        } else if(Category.startsWith("%")) {
            for(int Index=0;Index<Lines.length;Index++) {
                if(Lines[Index].contains(Category.substring(1))) {
                    Filtered[Index] = Lines[Index];
                }
            }

            return Filtered;
        } else {
            return new String[] {};
        }
    }

    /**
     * Get file path.
     */
    public String GetTheFile() {
        return TheFile;
    }
}
