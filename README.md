[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=17822307&assignment_repo_type=AssignmentRepo)
# CS-2003-Lab-1

## Overview
You are an agent that works for the Type Unknown Criminal Services (TU CS), which is investigative unit hired to assess potential crimes that require an alternative perspective. TU CS has been hired to investigate the death of the mayor of Turingville, who passed away suddenly late last night while locked away in his office. The cause of death, means, and motive are unclear. His death could just be due to natural causes, but the local police would like to be sure. You've been requested to determine if there is any evidence that might shed light on the circumstances surrounding the mayor's passing.

Your investigation begins in the mayor's office. Nothing stood out during the first few hours of combing through his belongings, but you've recently noticed that the mayor's desk is littered with papers. This is not unexpected, but after paying closer attention to some of the documents, what first appears to be terrible handwriting turns out to be actual nonsense. You suspect that several of the papers were written in code. It is now your responsibility to write an algorithm to decode the documents.

## Assignment - Part I
In this assignment, you are tasked with implementing a [Caesar shift cipher](https://cryptii.com/pipes/caesar-cipher) to decode the mayor's documents. A Caesar shift cipher is a type of encoding where each character in the original message is replaced by another character that is X larger (the shift offset) in lexicographic order. For example, the word 'hey' could be encoded as 'kh|' using a shift of X=3. **Note that the characters can include numbers, special characters, and lowercase and uppercase characters.** Lexicographic order is determined by the [ASCII table](https://www.asciitable.com/). On the ASCII table, the characters 'h', 'e', and 'y' have the numeric values 104, 101, and 121, respectively. By increasing each of these values by 3 (the shift offset), we compute the numbers 107, 104, and 124, which are the characters 'k', 'h', and '|', respectively.

You will receive the content of each message over STDIN as well as the suspected shift offset. Your algorithm must then compute the decoded message by shifting each character in the message using the shift offset. **Don't forget to ask yourself whether you should shift forwards or backwards when decoding.** You must output the decoded message on STDOUT.

When you're ready, please implement your algorithm in `src/main/java/Main.java` and then move on to _Assignment - Part II_.

## Input
All inputs will be provided over STDIN. You'll be given a line of input containing a single integer `n (1 <= n <= 10^3)`, where `n` is the number of characters in the message. The next line will contain a string of `n` characters, where each character has an ASCII value `c (32 <= c <= 126)`. The message is followed by another line that includes a single integer `X (1 <= X < 50)`, where `X` is the shift offset. **Spaces should be treated the same as any other character.**

You may find that the shift offset sometimes causes the resulting character to fall outside the range of 32 to 126. In such cases, you must wrap around. For example, if the character 'w' is encoded with a shift offset of 12, then its value of 119 plus 12 would be 131, which is larger than 126. The resulting encoded value would wrap around to 32 and continue up from there to a value of 36, which is the character '$'.

## Output
You are to output a single line containing the decoded message on STDOUT.

## Samples
| Sample Input | Sample Output |
| ------------ | ------------- |
| `8` | |
| `zhofrph$` | |
| `3` | `welcome!` |
| | |
| `12` | |
| `Olssv3'^vysk` | |
| `7` | `Hello, World` |

## Grading Rubric
- [ ] (35pts) Completes Assignment - Part I
- [ ] (35pts) Completes Assignment - Part II
- [ ] (15pts each) Manual review conducted by the instructor and/or TA(s)

## Submission
The assignment is due by the end-of-day Friday of the following week.

To submit your work, you must _stage_, _commit_, and _sync_ your changes. If you need assistance submitting your work, please contact your instructor or a TA. After submitting, you can check the **Actions** tab on your GitHub repo online to ensure that your work was submitted and to see the results of the autograder. If the autograder shows a green check for your latest commit, you've completed the autograded portion of the lab. Note that labs also include a manually graded portion.

### Commits
Commits should be made incrementally. Many commits are always better than few, and commits can always be squashed together later if there are too many. You should try to make a commit every time you've made tangible progress in the development of your code.

Every commit should have a commit message. The standard format for commit messages is to start with a verb in present-tense followed by a concise message (typically less than 50 characters) that summarizes the change that the commit is introducing to the repo. For example, "updates README", "implements Array", "passes testGet".

Popular IDEs, such as Visual Studio Code, provide integrated Git tools. If you're on Windows, you can install Git Bash or Windows Subsystem for Linux (WSL). If you're on Mac or Linux, you already have git installed. Mac users will need to ensure that XCode stays up to date.

You can use the Source Control (branch) extension provided by VS Code to stage, commit, and sync your assignment. These three steps are the submission process. To stage changes, use the plus sign next to each file. To commit changes, add a commit message in the text field at the top and then click commit. To sync changes, click the sync button.

At some point, you'll want to get familiar with using the git terminal commands instead.

To sync changes made from another device, use the following command.
- `git fetch origin main`
- `git pull origin main`

To push commits from command line, use the following commands.
- `git add -A`
- `git commit -m "<your message goes here>"`
- `git push origin main`

You can also sync all changes and submit with the following commands depending on your terminal.
- `./build.sh submit`

## Assignment - Part II
After decoding the first document, you notice that only fragments of its contents appear to be legible. It would appear that each document uses a combination of different shift offsets. You'll need to modify your algorithm to be able to apply different shift offsets to different slices of the message. A [slice](https://en.wikipedia.org/wiki/Array_slicing) in this context is a substring of consecutive characters that start at one position in the string and end at another (or go to the end of the string). **Note that you must still shift every character in the message using the initial shift number.**

## Input
All inputs will be provided over STDIN. After you receive the input from _Assignment - Part I_, you will additionally be given a line of input containing a single integer `q (0 <= q <= 10^3)`, where `q` is the number of shift queries. Each shift query contains a slice and a shift offset. There will then be `2*q` lines, where the first line contains two space-separated integers `a b (0 <= a < b < n)`, where `a` is the start of the slice (inclusive) and `b` is the end of the slice (exclusive). The second line contains a single integer `Y (1 <= Y <= 50)`, which is the shift offset for that slice. **Note that the first character of the message starts at position 0.**

## Output
You are to output a single line containing the decoded message on STDOUT.

## Samples
| Sample Input | Sample Output |
| ------------ | ------------- |
| `8` | |
| `!nufrph$` | |
| `3` | |
| `1` | |
| `0 3` | |
| `6` | `welcome!` |
| | |
| `12` | |
| `Wt{{~6*bz}wo` | |
| `10` | |
| `2` | |
| `0 5` | |
| `5` | |
| `7 12` | |
| `1` | `Hello, World` |

## Help

### Can't submit due to Git log
If you've just installed git or this is your first time submitting an assignment with git on this machine, it will need to be configured. The easiest way to configure git is from a terminal. Use the following commands. Note that the quotes need to stay but the angular brackets (<>) should be replaced alongside your username and email.
- `git config --global user.name "<github-username-goes-here>"`
- `git config --global user.email "<github-email-goes-here>"`
- `git config --global pull.rebase false`
- `git config --global fetch.prune true` (optional)
- `git config --global diff.colorMoved zebra` (optional)

### Can't sync due to Git error
In some cases, when you attempt to sync, you'll see a down-arrow rather than just an up-arrow. The up-arrow indicates that you have changes that need to be pushed to the cloud whereas the down-arrow indicates that there are changes in the cloud that need to be pulled to your machine. You can use the ellipsis at the top next to the commit text field to navigate to the pull option which will download and apply those changes to your local machine. If you're unable to use the sync button, please pull first. This may create conflicts on your machine which will have to be resolved manually. If you need help, please ask your instructor or a TA for assistance. Once all changes have been pulled and the down-arrow is gone, you can sync your changes.
- You may find it easier to use `git pull origin main` in your terminal

## Hints

### Hint 1 - parsing STDIN using Scanner
All inputs are provided on STDIN. One of the most common ways to parse inputs from STDIN is to use the `Scanner` class, which can be imported with `import java.util.Scanner;`. You must place this import statement at the top of your program after the `package` declaration. You can use a scanner to parse numbers and lines using the `nextInt()` and `nextLine()` methods, respectively. **Note that if you use `nextInt()`, then you must also use `nextLine()` to close the current line before moving on to the next one.**

```java
Scanner scanner = new Scanner(System.in);
int n = scanner.nextInt();
// int n = Integer.parseInt(scanner.nextInt()); // parses a single line with a single integer
```

### Hint 2 - getting a character from a string
The simplest approach to reading in the message is to store the message as a `String`. If you do so, then you will need to be able to access each character of the `String` individually to decode that character. You can use the following loop to access each character of a `String` individually one after another from beginning to end.

```java
String msg = scanner.nextLine();
for (int i = 0; i < msg.length(); i++) {
    char ch = msg.charAt(i);
    // do stuff
}
```

### Hint 3 - ASCII values
Java provides the `char` primitive type to work with ASCII characters, but a `char` really is just a number from between 0 and 255 (inclusive). As such, any `char` in Java can be cast to a numeric type, such as `byte`, `short`, `int`, or `long`, using a typical cast operation. You can use the following code to cast a `char` to its numeric equivalent as a `byte`. You can add numbers to a `byte` like any other numeric type. Just remember that a `byte` can never be larger than 255.

```java
String msg = scanner.nextLine();
char ch = msg.charAt(0);
byte b = (byte) ch;
// do stuff
```

### Hint 4 - arrays of chars
In Java, you can instantiate a `String` from a `char[]`, which is an array of bytes that represent ASCII characters (i.e., a `char`). You may find it easier to work with the Caesar shift cipher if you decode each character of the message into an array of chars. A `String` in Java is immutable, but an array of chars is not. Therefore, you can't change any character in a `String` but you can change any `char` in a `char[]`. You can use the following code to create an array of chars and to create a `String` from an array of chars.

```java
char[] chars = new char[n];
// do stuff
String out = new String(chars);
```

## Compiling and Testing Code
Your IDE should provide tools to compile your code. If you're unfamiliar with that process, instructions are provided on Harvey. While we'll be using VS Code in this course, most developers compile and run their code from command line using a shell script, such as a **Makefile** or build script (**build.sh**).

You've been provided a build script written in _Bash_. Refer to the following directions on how to use this script based on the terminal that you're using. If you're on Windows, please use Windows Subsystem for Linux (WSL) or Git Bash.

Only failing tests are shown by default. `TUGrader.java` can be run in `--verbose`  mode to show the output of passing tests. Tests are run in parallel, so **please do not use static variables unless they are provided to you.** Console output is always silenced during testing to grade your output, so don't use console output to debug your code. You should instead rely on debugging tools provided by your development environment or switch to manual testing.

### Windows Users (WSL, Git Bash), Mac and Linux Users
- To compile your code: `./build.sh`
- To compile and run your code: `./build.sh run` (forwards clargs to program)
- To compile and test your code: `./build.sh test` (forwards clargs to TUGrader)
- To format your code: `./build.sh fmt`
- To generate docs of your code: `./build.sh docs`
- To sync your code: `./build.sh sync`
- To submit your code: `./build.sh submit`
- To remove class files: `./build.sh clean`

These scripts use the following commands. Note that Windows users need to replace the colon with a semicolon in the Java classpath.
- To compile a Java file: `javac -d target -cp lib/*:src <filepath>.java`
- To execute a Java file: `java -cp lib/*:target <package-path>.<filename>`
- To format a Java file: `java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting <filepath>.java`
- To remove class files: `rm -r target/*`

## Docs
A docs folder is provided with every assignment. You can open the `docs/index.html` file in the browser of your choice to navigate and search the Java docs of the assignment. This may provide a more helpful means of exploring the assignment and whatever code is provided to you as a part of the lab.

## Code Style
All code should follow the [Google Java style guidelines](https://google.github.io/styleguide/javaguide.html). If you find anything in the code that does not follow the style guidelines, feel free to fix it, but you are not required to do so. Only your handwritten code will be evaluated for its style. You do not need to follow the style guidelines to the letter but egregious deviations from the style guidelines will be penalized. A submission that passes all test cases but does not use an appropriate style will not receive an A for the assignment.

For those using an IDE, such as Eclipse or VS Code, the IDE should provide a formatting tool. I've included the XML specification of the Google Java Style Guidelines at `.vscode/java-google-style.xml`. You can configure your IDE to use the provided XML as its formatting rules to format your code to the Google Java Style Guidelines, which are the industry standard.

If you're working from command-line, [google-java-format](https://github.com/google/google-java-format) is an open-source formatting tool that you can use to format your files. You can use the following commands to format your code depending on your terminal.
- `./build.sh fmt`
