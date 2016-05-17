// ExprArith.java

abstract class NumExpr {

    abstract int eval ();

}//ExprArith

abstract class BoolExpr {

    abstract int eval ();

}//ExprArith


class Number extends NumExpr {

    int val;

    Cte (int val) {
        this.val = val;
    }//Cte

    int eval () {
        return val;
    }//eval

}

class Bool extends BoolExpr {

    Boolean val;

    BoolExpr (Boolean val) {
        this.val = val;
    }

    Boolean eval () {
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


class Inf extends BinOpInt {

    Inf (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    Boolean eval () {
        if(e1.eval() < e2.eval())
        {return true;}
        else{return false;}
    }//eval

}

class InfEg extends BinOpInt {

    InfEg (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    Boolean eval () {
        if(e1.eval() <= e2.eval())
        {return true;}
        else{return false;}
    }//eval

}

class Sup extends BinOpInt {

    Sup (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    Boolean eval () {
        if(e1.eval() > e2.eval())
        {return true;}
        else{return false;}
    }//eval

}


class SupEg extends BinOpInt {

    SupEg (NumExpr e1, NumExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    Boolean eval () {
        if(e1.eval() >= e2.eval())
        {return true;}
        else{return false;}
    }//eval

}


abstract class BinOpBool extends NumExpr {

    BoolExpr e1, e2;

}//BinOp


class And extends BinOpBool {

    And (BoolExpr e1, BoolExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    Boolean eval () {
        return e1.eval() && e2.eval();
    }//eval

}

class Or extends BinOpBool {

    And (BoolExpr e1, BoolExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    Boolean eval () {
        return e1.eval() || e2.eval();
    }//eval

}




