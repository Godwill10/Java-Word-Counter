************Purpose************

The purpose of this program is to build a GUI application that can open up a text document, read in and count all the occurrences of each word using Java. The application will then print out to a file the total count of words along with all the counts of the separate words, doing so in dictionary order.


**********Organization**********

The application has 4 classes:
    WordCount.java - Contains the main to create the WordCount application. It is the driver class for the Word Count application.
                    It simply contains one line of code that creates a WordCountGUI object and makes it visible.

    WordCountGUI - The Word Counter application graphical user interface. It sets the components and their positions in the gui. 
                    It also sets the Controller as the buttons' action listener.

    WordCountModel - 

    Controller.java - The controller does most of the work. It retrieves the path of the file selected by the user and uses the path to read each line in the file, count the occurrences of every word, and output a the result in a seperate text file.


**********How to use/run**********

When 'WordCount.java' is ran. The GUI pops up with a select files option and a submit button. The user can then select a text file
that the program will then read and count the occurrences of every word in the file. The result of this execution will be printed out 
to a file named "output.txt".


**********Design Notes**********

