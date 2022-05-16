
**PREREQUISITE:**
the device is installed with an ANTLR jar file (**verson 4.9.3**)

**HOW TO RUN (macOS):**
1. unzip the project
2. open a terminal window at the project folder, type:
```sh
export CLASSPATH=".:/path/to/your/4.9.3-antlr-jar-file:$CLASSPATH"
```
```sh 
alias antlr4='java -Xmx500M -cp "/path/to/your/antlr-jar:$CLASSPATH" org.antlr.v4.Tool'
```
```sh 
alias grun='java -Xmx500M -cp "/path/to/your/antlr-jar:$CLASSPATH" org.antlr.v4.gui.TestRig' 
```
launch the grammar .g4 file (we're using visitor)
```sh 
antlr4 -visitor Exprdump.g4  
```
compile everything
```sh
javac *.java            
```
run the compiler. The text files are in the project folder: *e1, e2, e3, e4.txt*
```sh
java Compilerdump textfile.name      
```
4. to view the parse tree, on the same terminal window, type:
```sh
grun Exprdump expr -gui
```
type in your expression here, press "Enter", then press "^D"

**When opening project on IDE**:
Remember to add the ANTLR jar file to the REFERENCED LIBRARY of the project
so that we can import org.antlr.v4....