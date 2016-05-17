// ExprArith.java

abstract class NumExpr {

    abstract int eval ();

}

abstract class BoolExpr {

    abstract boolean eval ();

}


class Number extends NumExpr {

    int val;

    Number (int val) {
        this.val = val;
    }

    int eval () {
        return val;
    }

}

class Bool extends BoolExpr {

    boolean val;

    Bool (boolean val) {
        this.val = val;
    }

    boolean eval () {
        return val;
    }

}

/*class Array extends Type {

    Number tab[];

}*/


class Inv extends NumExpr {

    NumExpr e;

    Inv (NumExpr e) {
        this.e = e;
    }//Inv

    int eval () {
        return -e.eval();
    }//eval

}//Inv


abstract class BinOpInt extends NumExpr {

    NumExpr e1, e2;

}//BinOp


class Add extends BinOpInt {

    Add (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Add

    int eval () {
        return e1.eval() + e2.eval();
    }//eval

}//Add

class Sub extends BinOpInt {

    Sub (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Sub

    int eval () {
        return e1.eval() - e2.eval();
    }//eval

}//Sub

class Mul extends BinOpInt {

    Mul (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Mul

    int eval () {
        return e1.eval() * e2.eval();
    }//eval

}//Mul

class Div extends BinOpInt {

    Div (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Div

    int eval () {
        return e1.eval() / e2.eval();
    }//eval

}//Div



abstract class BinOpComp extends BoolExpr {

    NumExpr e1, e2;

}//BinOp


class Inf extends BinOpComp {

    Inf (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        if(e1.eval() < e2.eval())
        {return true;}
        else{return false;}
    }

}

class InfEg extends BinOpComp {

    InfEg (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        if(e1.eval() <= e2.eval())
        {return true;}
        else{return false;}
    }//eval

}

class Sup extends BinOpComp {

    Sup (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        if(e1.eval() > e2.eval())
        {return true;}
        else{return false;}
    }//eval

}


class SupEg extends BinOpComp {

    SupEg (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        if(e1.eval() >= e2.eval())
        {return true;}
        else{return false;}
    }//eval

}


class Eg extends BinOpComp {

    Eg (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        if(e1.eval() == e2.eval())
        {return true;}
        else{return false;}
    }//eval

}

class NotEg extends BinOpComp {

    NotEg (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        if(e1.eval() != e2.eval())
        {return true;}
        else{return false;}
    }//eval

}





abstract class BinOpBool extends BoolExpr {

    BoolExpr e1, e2;

}//BinOp




class And extends BinOpBool {

    And (BoolExpr e1, BoolExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        return e1.eval() && e2.eval();
    }//eval

}

class Or extends BinOpBool {

    Or (BoolExpr e1, BoolExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    boolean eval () {
        return e1.eval() || e2.eval();
    }//eval

}





