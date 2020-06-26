package astparsing;

public class PythonVisitor extends PythonParserBaseVisitor<Value> {

    @Override
    public Value visitRoot(PythonParser.RootContext ctx) {
        System.out.println(ctx.start);
        return visitChildren(ctx);
    }

}