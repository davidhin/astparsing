package astparsing;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import com.mintegral.msdk:alphab

public class App {
    public static void main(String[] args) {
        System.out.println("Parse Python Code");
        try {
            InputStream inputStream = App.class.getResourceAsStream("/pythontests.txt");
            PythonLexer lexer = new PythonLexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream((TokenSource) lexer);
            PythonParser parser = new PythonParser(tokenStream);
            ParserRuleContext t = parser.root();
            ParseTree tree = t;
            PythonVisitor visitor = new PythonVisitor();
            visitor.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
