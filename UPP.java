// UPP.java

import java.util.*;

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class UPPExpr {
    
    public abstract String toString(); //Printer for UPP
    
}//UPPExpr

class UPPCte extends UPPExpr {

    int val;

    UPPCte (int val) {
        this.val = val;
    }//UPPCte
    
    public String toString(){
        return Integer.toString(val);
    }

}//UPPCte

class UPPTrue extends UPPExpr {
    
    public String toString(){
        return "true";
    }
    
}//UPPTrue

class UPPFalse extends UPPExpr {
    
    public String toString(){
        return "false";
    }

}//UPPFalse

class UPPVar extends UPPExpr {

    String name;

    UPPVar (String name) {
        this.name = name;
    }//UPPVar
    
    public String toString(){
        return name.toString();
    }

}//UPPVar

class UPPGVar extends UPPExpr {

    String name;

    UPPGVar (String name) {
        this.name = name;
    }//UPPGVar
    
    public String toString(){
        return name.toString();
    }

}//UPPGVar

abstract class UPPUnOp extends UPPExpr {

    UPPExpr e;

}//UPPUnOp


class UPPNot extends UPPUnOp {

    UPPNot (UPPExpr e) {
        this.e = e;
    }//UPPNot
    
    public String toString(){
        return "not(" + e.toString() + ")" ;
    }

}//UPPNot

abstract class UPPBinOp extends UPPExpr {

    UPPExpr e1, e2;

}//UPPBinOp

class UPPAdd extends UPPBinOp {

    UPPAdd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAdd
    
    public String toString(){
        return e1.toString() + "+" + e2.toString() ;
    }

}//UPPAd

class UPPSub extends UPPBinOp {

    UPPSub (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPSub
    
    public String toString(){
        return e1.toString() + "-" + e2.toString() ;
    }

}//UPPSub

class UPPMul extends UPPBinOp {

    UPPMul (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPMul
    
    public String toString(){
        return e1.toString() + "*" + e2.toString() ;
    }

}//UPPMul

class UPPDiv extends UPPBinOp {

    UPPDiv (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPDiv
    
    public String toString(){
        return e1.toString() + "/" + e2.toString() ;
    }

}//UPPDiv

class UPPAnd extends UPPBinOp {

    UPPAnd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAnd
    
    public String toString(){
        return "(" + e1.toString() + ") and (" + e2.toString() + ")" ;
    }

}//UPPAnd

class UPPOr extends UPPBinOp {

    UPPOr (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPOr
    
    public String toString(){
        return "(" + e1.toString() + ") or (" + e2.toString() + ")" ;
    }

}//UPPOr

class UPPLe extends UPPBinOp {

    UPPLe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLe
    
    public String toString(){
        return "(" + e1.toString() + ") < (" + e2.toString() + ")" ;
    }

}//UPPLe

class UPPLeq extends UPPBinOp {

    UPPLeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLeq
    
    public String toString(){
        return "(" + e1.toString() + ") <= (" + e2.toString() + ")" ;
    }

}//UPPLeq

class UPPEq extends UPPBinOp {

    UPPEq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPEq
    
    public String toString(){
        return "(" + e1.toString() + ") == (" + e2.toString() + ")" ;
    }


}//UPPEq

class UPPNeq extends UPPBinOp {

    UPPNeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPNeq
    
    public String toString(){
        return "(" + e1.toString() + ") != (" + e2.toString() + ")" ;
    }

}//UPPNeq

class UPPGeq extends UPPBinOp {

    UPPGeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGeq
    
     public String toString(){
        return "(" + e1.toString() + ") >= (" + e2.toString() + ")" ;
    }

}//UPPGeq

class UPPGe extends UPPBinOp {

    UPPGe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGe
    
     public String toString(){
        return "(" + e1.toString() + ") > (" + e2.toString() + ")" ;
    }

}//UPPGe


class Alloc extends Callee {
    
    public String toString(){
        return "Alloc";
    }
    
}//Alloc

class UPPFunCall extends UPPExpr {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPFunCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall
    
    public String toString(){
        return callee.toString() + " (" + args.toString() + ")";
    }

}//FunCall

class UPPLoad extends UPPExpr {

    UPPExpr addr;

    UPPLoad (UPPExpr addr) {
        this.addr = addr;
    }//UPPLoad
    
    public String toString(){
        return "Reading at the address: "+ addr.toString();
    }

}//UPPLoad

/****************/
/* Instructions */
/****************/

abstract class UPPInst {}//UPPInst

class UPPAssign extends UPPInst {

    String name;
    UPPExpr val;

    UPPAssign (String name, UPPExpr val) {
        this.name = name;
        this.val = val;
    }//UPPAssign
    
    public String toString(){
        return name.toString() + " := " + val.toString();
    }

}//UPPAssign

class UPPStore extends UPPInst {

    UPPExpr addr, val;

    UPPStore (UPPExpr addr, UPPExpr val) {
        this.addr = addr;
        this.val = val;
    }//UPPStore
    
    public String toString(){
        return "Storing at the address: "+ addr.toString() +" the value "+ val.toString();
    }

}//UPPStore

class UPPCond extends UPPInst {

    UPPExpr cond;
    UPPInst i1, i2;

    UPPCond (UPPExpr cond, UPPInst i1, UPPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//UPPCond
    
    public String toString(){
        return "if " + cond.toString() + " then " + i1.toString() + " else " + i2.toString();
    }

}//UPPCond

class UPPWhile extends UPPInst {

    UPPExpr cond;
    UPPInst i;

    UPPWhile (UPPExpr cond, UPPInst i) {
        this.cond = cond;
        this.i = i;
    }//UPPWhile
    
    public String toString(){
        return "while " + cond.toString() + " do " + i.toString();
    }

}//UPPWhile

class UPPProcCall extends UPPInst {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPProcCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//UPPProcCall
    
    public String toString(){
        return callee.toString() + " (" + args.toString() + ")";
    }

}//UPPProcCall
    
class UPPSkip extends UPPInst {

    public String toString(){
        return "skip";
    }
    
}//UPPSkip

class UPPSeq extends UPPInst {

    UPPInst i1, i2;

    UPPSeq (UPPInst i1, UPPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//UPPSeq
    
     public String toString(){
        return i1.toString() + "; " + i2.toString();
    }

}//UPPSeq

/***************************************/
/* Definitions of functions/procedures */
/***************************************/


abstract class UPPDef {

    String name;
    ArrayList<String> args, locals;
    UPPInst code;
    
    public abstract String toString();

}//UPPDef

class UPPFun extends UPPDef {

    UPPFun (String name, ArrayList<String> args, ArrayList<String> locals,
            UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPFun
    
    public String toString(){
        return name.toString() + "(" + args.toString() + ") var " + locals.toString() + " " + code.toString();
    }

}//UPPFun

class UPPProc extends UPPDef {

    UPPProc (String name, ArrayList<String> args, ArrayList<String> locals,
             UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPProc
    
    public String toString(){
        return name.toString() + "(" + args.toString() + ") var " + locals.toString() + " " + code.toString();
    }

}//UPPProc

/************/
/* Programs */
/************/

class UPPProg {

    ArrayList<String> globals;
    ArrayList<UPPDef> defs;
    UPPInst code;

    UPPProg (ArrayList<String> globals, ArrayList<UPPDef> defs, UPPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }//UPPProg
    
    public String toString(){
        return   "var " + globals.toString() + " " + defs.toString() + " " + code.toString();
    }

}//UPPProg
