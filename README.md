************Purpose************

The purpose of this program is to build a GUI application that can open up a text document, read in and count all the occurrences of each word using Java. The application will then print out to a file the total count of words along with all the counts of the separate words, doing so in dictionary order.


**********Organization**********

    WordCount.java - It is the main driver for the word count application. It taks a document, reads every line, and count the number of words in the document and count the all the occurrences of each word. 
        It has three methods/functions: 
            main: Runs the word count program using BufferedReader, Map, and helping methods.

            removePunctuations: Removes punctuation from a given string.

            removeHyphens: Removes hyphens from a given string.

            getWordCount: Gets the total word count from an output file that contains words and their counts.
    WordCountTest.java - It is the test class that tests all the methods of the program.

**********How to use/run**********

When 'WordCount.java' is run. It takes the document that is specified of which the user provides the input and performs the word count operation on it. The total word count is then printed to the terminal and a new output file is created to listen the number of times each word occurred.


**********Design Notes**********

The project uses different Java imports/libraries to execute the word count including: BufferedReader, BufferedWriter, FileReader, FileWriter, HashMap, and Map.
The test class uses requires the JUnit5 standalone-console jar to execute.