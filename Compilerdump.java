import java.io.FileInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

//
//PREREQUISITE: the device is installed with ANTLR jar 
//
//HOW TO RUN:
//
//  1. add ANTLR jar file to the REFERENCED LIBRARY of this project
//         so that we can execute import org.antlr.v4...
//
//  2. open a terminal window at the project folder, type:
//         -> export CLASSPATH=".:/path/to/your/antlr-jar:$CLASSPATH"
//         -> alias antlr4='java -Xmx500M -cp "/path/to/your/antlr-jar:$CLASSPATH" org.antlr.v4.Tool'
//         -> alias grun='java -Xmx500M -cp "/path/to/your/antlr-jar:$CLASSPATH" org.antlr.v4.gui.TestRig'
//
//         -> antlr4 -visitor Exprdump.g4     (to launch the grammar)
//         -> javac *.java                    (to compile all relevant files in the project folder)
//
//         -> java Compilerdump textfile.name      (to run the compiler for the grammar file.
//                                                  The text files are in the project folder: e1,e2,e3,e4.txt)
//
//  3. to view the parse tree, on the same terminal window, type:
//         -> grun Exprdump expr -gui
//         -> type in your expression here, press "Enter", then press "^D"
//
 

             

public class Compilerdump {
public static void main(String[] args) throws Exception {

    //read a file name as input
    CharStream input = CharStreams.fromStream(new FileInputStream(args[0]));

    //set up the lexer and parser
    ExprdumpLexer lexer = new ExprdumpLexer(input);
    ExprdumpParser parser = new ExprdumpParser(new CommonTokenStream(lexer));
    
    //generate a parse tree from the parser
    ParseTree tree = parser.expr(); // begin parsing at rule ’expr'
    
    //print tree in LISP format
    System.out.println("Lisp Format:");
    System.out.println(tree.toStringTree(parser)); 

    //call visitor to apply semantic rules on the tree
    DumpVisitor exprVisitor = new DumpVisitor();
    String result = exprVisitor.visit(tree); //visit
    //print out the result after applying the semantic rules
    System.out.println("Postfix: " + result);


}
}
