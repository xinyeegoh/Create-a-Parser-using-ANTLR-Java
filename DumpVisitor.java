public class DumpVisitor extends ExprdumpBaseVisitor<String>{

    @Override
    public String visitMulti(ExprdumpParser.MultiContext ctx){
        // term * fac  ->  term fac *
        return  visit(ctx.term()) + visit(ctx.fac()) + ctx.children.get(1).getText() + " ";
        
    }

    @Override
    public String visitDiv(ExprdumpParser.DivContext ctx){
        // term / fac  ->  term fac /
        return  visit(ctx.term()) + visit(ctx.fac()) + ctx.children.get(1).getText() + " ";
        
    }

    @Override
    public String visitPlus(ExprdumpParser.PlusContext ctx){
        // expr + term  ->  expr term +
        return  visit(ctx.expr()) + visit(ctx.term()) + ctx.children.get(1).getText() + " ";
        
    }

    @Override
    public String visitMinus(ExprdumpParser.MinusContext ctx){
        // expr - term  ->  expr term -
        return  visit(ctx.expr()) + visit(ctx.term()) + ctx.children.get(1).getText() + " ";
        
    }

    @Override
    public String visitBrac(ExprdumpParser.BracContext ctx){
        // ( expr ) -> expr
        return  visit(ctx.expr()); 
        
    }

    @Override
    public String visitNum(ExprdumpParser.NumContext ctx){
        // numbers
        return  ctx.getText() + " "; 
        
    }

    @Override
    public String visitId(ExprdumpParser.IdContext ctx){
        // identifier
        return  ctx.getText() + " "; 
        
    }

    @Override
    public String visitUnary(ExprdumpParser.UnaryContext ctx){
        // - fac -> fac -
        return  visit(ctx.fac()) + ctx.children.get(0).getText() + " "; 
        
    }

    @Override
    public String visitT(ExprdumpParser.TContext ctx){
        // go to term
        return  visit(ctx.term()); 
        
    }

    @Override
    public String visitF(ExprdumpParser.FContext ctx){
        // go to fac
        return  visit(ctx.fac()); 
    }
        
    
    
}
