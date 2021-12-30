package LanguageCreator;

import java.util.function.Function;

public class Exceptions {
    private String Scheme;
    private String[] ExceptionsArray;

    /**
     * <h1>Tools for language exceptions.</h1>
     * Create new instance of exceptions.
     * Now you using constructor.
     * @param NewExceptionsArray New exceptions list.
     */
    public Exceptions(String... NewExceptionsArray) {
        ExceptionsArray = NewExceptionsArray;
    }

    /**
     * Set new scheme.
     * If "$Type" and "$Message" not in scheme, scheme will be null.
     * @param NewScheme The scheme.
     */
    public void SetScheme(String NewScheme) {
        if(NewScheme.contains("$Type") && NewScheme.contains("$Message")) {
            Scheme = NewScheme;
        } else {
            Scheme = null;
        }
    }

    /**
     * Throw user scheme.
     * If scheme is null, exception prints null.
     * @param Type Exception type.
     * @param Message Exception message.
     * @param Kills Is exception kills app.
     */
    public void ThrowScheme(String Type, String Message, boolean Kills) {
        String HandledScheme = Scheme == null ? null : Scheme.replace("$Type", Type).replace("$Message", Message);
        int $ExitCode = 1;

        System.out.println(HandledScheme);

        if(Kills) {
            System.exit($ExitCode);
        }
    }

    /**
     * If expression is false, function will raise user scheme.
     * @param Expression Expression to check.
     * @param Type Exception type.
     * @param Message Exception message.
     * @param Kills Is exception kills app.
     */
    public void Check(boolean Expression, String Type, String Message, boolean Kills) {
        if(!Expression) {
            ThrowScheme(Type, Message, Kills);
        }
    }

    /**
     * Intercept function exception.
     * If there is no exception, function will return an empty array.
     * Else function will return array with exception type and exception message.
     * @param Func The function to call.
     * @param Arguments Function arguments.
     */
    public Object[] Except(Function<Object, Object> Func, Object... Arguments) {
        try {
            Func.apply(Arguments);

            return new Object[] {};
        }

        catch(Exception Error) {
            return new Object[] {Error.getClass(), Error.getMessage()};
        }
    }

    /**
     * Get exceptions array.
     */
    public String[] GetExceptions() {
        return ExceptionsArray;
    }

    /**
     * Update exceptions array.
     * @param NewExceptionsArray New exceptions array.
     */
    public void UpdateExceptions(String... NewExceptionsArray) {
        ExceptionsArray = NewExceptionsArray;
    }

    /**
     * Clean exceptions array.
     */
    public void CleanExceptions() {
        ExceptionsArray = null;
    }
}
