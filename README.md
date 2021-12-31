# JLanguageCreator.
#### Ported version of <a href="https://github.com/xzripper/LanguageCreator">LanguageCreator</a> on Java, from Python.

## Content of ported version.
### What's new?
Here is a tables of new content.

| Characters.java |
| --- |
| Added `public static char[] AsArray()` |

| Credits.java |
| --- |
| Added `public static final LibNote` |

| Exceptions.java |
| --- |
| Added `public void UpdateExceptions(String... NewExceptionsArray)` |
| Added `public void CleanExceptions()` |

| StringParser.java |
| --- |
| Added `public static String ArrayToString(String[] Array)` |

| FileParser.java |
| --- |
| Added `public String GetTheFile()` |

### What's removed?
Here is a tables of removed content.

| Characters.java |
| --- |
| Nothing removed. |

| Credits.java |
| --- |
| Nothing removed. |

| Exceptions.java |
| --- |
| Removed `getexc(self, key: str) -> Union[None, Any]` |
| Removed `getscheme(self) -> Union[None, str]` |

| StringParser.java |
| --- |
| Removed `inscobes(self, rlcs: bool) -> Union[None, bool]` |

| FileParser.java |
| --- |
| Nothing removed. |

## Why so many content not ported?
**Beacuse author dont have enough knowledge in Java,and, some things failed to create in Java.<br>
And about another content, i dont added this beacuse it's useless or very easy to create, and user can create it myself.**

## Examples.
### Intercept function exception and get array with data exception, after convert it to string array.
```java
import LanguageCreator.Exceptions; // Importing exceptions tools.
import java.util.Arrays; // Importing tool for array to string converting. We can use StringParser.ArrayToString, but in this case better use Arrays class.

public class Main {
	public static void main(String[] args) {
		Exceptions ExceptionsTool = new Exceptions(); // Creating new instance.
		Object[] ExceptionData = ExceptionsTool.Except(Main::MyFunc); // Except exception.

		System.out.println(Arrays.toString(ExceptionData)); // Print exception info.
	}

	// Creating function. The "$_" must be in functions always, if functions doesn't requires arguments. 
	public static float MyFunc(Object $_) {
		return 1 / 0; // Summoning error.
	}
}
```
#### Result is [class java.lang.ArithmeticException, / by zero]

How we see, first element is type of exception, and second is message.
If function not raise an exception, result will be [].

### Remove "X" in start and end.
```java
import LanguageCreator.StringParser; // Importing string parsing tools.

public class Main {
    public static void main(String[] args) {
        StringParser Parser = new StringParser("X Remove this stupid 'X'! X"); // Create new instance of parser with our string.
        System.out.println(Parser.GetString()); // Get and print string.
        System.out.println(Parser.Cut(2, 2)); // Remove X in start and end and print.
    }
}
```
#### Result.
```
X Remove this stupid 'X'! X
Remove this stupid 'X'!
```

How we see, we removed "X" in start and end, and printed it.

### Replace three strings in one time.
```java
import LanguageCreator.StringParser; // Importing string parsing tools.

public class Main {
    public static void main(String[] args) {
        StringParser Parser = new StringParser("Hello, XMy name is Ivan!Y Do you like my repo's?Z Bye!"); // Create new instance of parser with our string.
        System.out.println(Parser.GetString()); // Get and print string.
        System.out.println(Parser.Replace(new String[] {"X", "Y", "Z"}, new String[] {"", "", ""})); // Replace useless characters and print.
    }
}
```
#### Result.
```
Hello, XMy name is Ivan!Y Do you like me repo's?Z Bye!
Hello, My name is Ivan! Do you like me repo's? Bye!
```

How we see, we removed X, Y, Z in one time in string.
That's cool and fast!

# How to install?
Install this repository.
Copy folder LanguageCreator and paste it in your project.
Result looks like?
```
Project/
├─ src/
│  ├─ com/
│  │  ├─ company/
│  │  │  ├─ Main.java
│  │  │  ├─ LanguageCreator/
```

## Known issues.
**No known issues... _But this is temporary._**

## Why you need to try this library?
Beacuse...? Beacuse it's free, strong, and easy,<br>with source code, any issue can be fixed in you push new issue,<br>you can push your version of code, error solution, just new function.<br>And... It's just nice!<br>

# End.
_Thanks for reading, i hope you will be happy using this library, have a good day, bye bye!_

<hr>
<p align="center">^_^</p>
