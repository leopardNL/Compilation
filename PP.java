// PP.java

import java.util.*;

/*********/
/* Types */
/*********/

abstract class Type {
	public abstract String toString();
}//Type

class Int extends Type {
	public String toString(){
        return "int";
    	}
}//Int

class Bool extends Type {
	public String toString(){
        return "boolean";
    	}
}//Bool

class Array extends Type {

    Type elements;

    Array (Type elements) {
        this.elements = elements;
    }//Array
    
    public String toString() {
	return "array ( " + elements + " )";
    }

}//Array

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class PPExpr {

abstract UPPExpr toUPP(ArrayList<String> locals);
public abstract String toString();

}//PPExpr

class PPCte extends PPExpr {

    int val;

    PPCte (int val) {
        this.val = val;
    }//PPCte

	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPCte(val);
	}
	
	public String toString(){
        return Integer.toString(val);
	}

}//PPCte

class PPTrue extends PPExpr {
UPPExpr toUPP(ArrayList<String> locals){
	return new UPPTrue();
	}
	
	public String toString(){
        return "true";
    	}
}//PPTrue

class PPFalse extends PPExpr {
	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPFalse();
	}
	
	public String toString(){
        return "false";
    	}	
}//PPFalse

class PPVar extends PPExpr {

    String name;

    PPVar (String name) {
        this.name = name;
    }//PPVar

	UPPExpr toUPP(ArrayList<String> locals){
	if(locals.contains(name)) {
		return new UPPVar(name);
		}
	else	{
		return new UPPGVar(name);
	}
	}

	public String toString(){
        return name;
    	}


}//PPVar

abstract class PPUnOp extends PPExpr {

    PPExpr e;

	
	

}//PPUnOp

class PPInv extends PPUnOp {

    PPInv (PPExpr e) {
        this.e = e;
    }//PPInv

	UPPExpr toUPP(ArrayList<String> locals){
	UPPExpr ne=e.toUPP(locals);
	return new UPPSub(new UPPCte(0),ne);
	}
	

	public String toString(){
        return "-("+e.toString()+")";
    	}

}//PPInv

class PPNot extends PPUnOp {

    PPNot (PPExpr e) {
        this.e = e;
    }//PPNot

	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPNot(e.toUPP(locals));
	}
	
	public String toString(){
        return "not("+e.toString()+")";
    	}

}//PPNot

abstract class PPBinOp extends PPExpr {

    PPExpr e1, e2;

}//PPBinOp

class PPAdd extends PPBinOp {

    PPAdd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAdd

	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPAdd(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
        return e1.toString()+"+"+e2.toString();
    	}

}//PPAd

class PPSub extends PPBinOp {

    PPSub (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPSub(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
        return e1.toString()+"-"+e2.toString();
    	}
    

}//PPSub

class PPMul extends PPBinOp {

    PPMul (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPMul

	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPMul(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
        return e1.toString()+"*"+e2.toString();
    	}

}//PPMul

class PPDiv extends PPBinOp {

    PPDiv (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPDiv

	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPDiv(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
        return e1.toString()+"/"+e2.toString();
    	}
}//PPDiv

class PPAnd extends PPBinOp {

    PPAnd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAnd

	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPAnd(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
        return "("+e1.toString()+") and ("+e2.toString()+")";
    	}

}//PPAnd

class PPOr extends PPBinOp {

    PPOr (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPOr

	UPPExpr toUPP(ArrayList<String> locals){
	return new UPPOr(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
        return "("+e1.toString()+") or ("+e2.toString()+")";
    	}

}//PPOr

class PPLe extends PPBinOp {

    PPLe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLe

	UPPExpr toUPP (ArrayList<String> locals) {	
	return new UPPLe(e1.toUPP(locals),e2.toUPP(locals));

    }//toUPP
    
    public String toString(){
    return "(" + e1.toString() + ") < (" + e2.toString() + ")" ;
    }

}//PPLe

class PPLeq extends PPBinOp {

    PPLeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLeq

	UPPExpr toUPP (ArrayList<String> locals) {	
	return new UPPLeq(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
    	return "(" + e1.toString() + ") <= (" + e2.toString() + ")" ;
    	}

}//PPLeq

class PPEq extends PPBinOp {

    PPEq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPEq

	UPPExpr toUPP (ArrayList<String> locals) {	
	return new UPPEq(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
    	return "(" + e1.toString() + ") = (" + e2.toString() + ")" ;
    	}

}//PPEq

class PPNeq extends PPBinOp {

    PPNeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPNeq

	UPPExpr toUPP (ArrayList<String> locals) {	
	return new UPPNeq(e1.toUPP(locals),e2.toUPP(locals));
	}
	public String toString(){
    	return "(" + e1.toString() + ") != (" + e2.toString() + ")" ;
    	}

}//PPNeq

class PPGeq extends PPBinOp {

    PPGeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGeq

	UPPExpr toUPP (ArrayList<String> locals) {	
	return new UPPGeq(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
    	return "(" + e1.toString() + ") >= (" + e2.toString() + ")" ;
    	}

}//PPGeq

class PPGe extends PPBinOp {

    PPGe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGe

	UPPExpr toUPP (ArrayList<String> locals) {	
	return new UPPGe(e1.toUPP(locals),e2.toUPP(locals));
	}
	
	public String toString(){
    	return "(" + e1.toString() + ") > (" + e2.toString() + ")" ;
    	}

}//PPGe

abstract class Callee {}//Callee

class Read extends Callee {
	public String toString(){
        return "Read";
    	}
}//Read

class Write extends Callee {
	public String toString(){
        return "Write";
	}
}//Write

class User extends Callee {

    String name;

    User (String name) {
        this.name = name;
    }//User
    
    public String toString(){
        return name;
    }


}//User

class PPFunCall extends PPExpr {

    Callee callee;
    ArrayList<PPExpr> args;

    PPFunCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall
	
	UPPExpr toUPP(ArrayList<String> locals){
        ArrayList<UPPExpr> nargs = new ArrayList<UPPExpr>();
	for (PPExpr e : args)
            nargs.add(e.toUPP(locals));
            return new UPPFunCall(callee,nargs);
        
    	}
    	
    	public String toString(){
        return callee.toString() + " (" + args.toString() + ")";
    	}


}//FunCall

class PPArrayGet extends PPExpr {

    PPExpr arr, index;

    PPArrayGet (PPExpr arr, PPExpr index) {
        this.arr = arr;
        this.index = index;
    }//PPArrayGet

	UPPExpr toUPP(ArrayList<String> locals){
	UPPExpr narr=arr.toUPP(locals);
	UPPExpr nindex=index.toUPP(locals);
	UPPExpr addr=new UPPAdd(narr,new UPPMul(nindex,new UPPCte(4)));
	return new UPPLoad(addr);
    	}
    	
    	public String toString(){
        return arr.toString() + " [" + index.toString() + "]";
    	}

}//PPArrayGet

class PPArrayAlloc extends PPExpr {

    Type type;
    PPExpr size;

    PPArrayAlloc (Type type, PPExpr size) {
        this.type = type;
        this.size = size;
    }//PPArrayAlloc

	UPPExpr toUPP(ArrayList<String> locals){
	UPPExpr nnsize=size.toUPP(locals);
	UPPExpr nsize=new UPPMul(nnsize,new UPPCte(4));
        ArrayList<UPPExpr> args = new ArrayList<UPPExpr>();
        args.add(nsize);
	return new UPPFunCall(new Alloc(),args);
    	}
    	
    	public String toString(){
        return type.toString() + "Alloc (" + size.toString() + ")";
    	}

}//PPArrayAlloc

/****************/
/* Instructions */
/****************/

abstract class PPInst {

    abstract UPPInst toUPP(ArrayList<String> locals);
    
}//PPInst

class PPAssign extends PPInst {

    String name;
    PPExpr val;

    PPAssign (String name, PPExpr val) {
        this.name = name;
        this.val = val;
    }//PPAssign
    
    UPPInst toUPP (ArrayList<String> locals){
        UPPExpr nval = val.toUPP(locals);
        return new UPPAssign(name, nval);
    }
    
    public String toString(){
    return name + " := " + val.toString();
    }

}//PPAssign

class PPArraySet extends PPInst {

    PPExpr arr, index, val;

    PPArraySet (PPExpr arr, PPExpr index, PPExpr val) {
        this.arr = arr;
        this.index = index;
        this.val = val;
    }//PPArraySet
    
    UPPInst toUPP (ArrayList<String> locals) {
        UPPExpr narr = arr.toUPP(locals); //Convert the PP var in UPP var
        UPPExpr nindex = index.toUPP(locals);
        UPPExpr nval = val.toUPP(locals);
        UPPExpr offset = new UPPMul(new UPPCte(4),nindex);
        return new UPPStore(new UPPAdd(narr,offset),nval);
    }
    
    public String toString(){
    return arr.toString() + "[" + index.toString() + "] = " + val.toString();
    }

}//PPArraySet

class PPCond extends PPInst {

    PPExpr cond;
    PPInst i1, i2;

    PPCond (PPExpr cond, PPInst i1, PPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//PPCond
    
    UPPInst toUPP (ArrayList<String> locals) {
        UPPExpr ncond = cond.toUPP(locals); //Convert the PP values in UPP values
        UPPInst ni1 = i1.toUPP(locals);
        UPPInst ni2 = i2.toUPP(locals);
        return new UPPCond(ncond,ni1,ni2);
    }
    
    public String toString(){
    return "if " + cond.toString() + " then " + i1.toString() + " else " + i2.toString();
    }

}//PPCond

class PPWhile extends PPInst {

    PPExpr cond;
    PPInst i;

    PPWhile (PPExpr cond, PPInst i) {
        this.cond = cond;
        this.i = i;
    }//PPWhile
    
    UPPInst toUPP (ArrayList<String> locals) {
        UPPExpr ncond = cond.toUPP(locals); //Convert the PP values in UPP values
        UPPInst ni = i.toUPP(locals);
        return new UPPWhile(ncond,ni);
    }
    
    public String toString(){
    return "while " + cond.toString() + " do " + i.toString();
    }

}//PPWhile

class PPProcCall extends PPInst {

    Callee callee;
    ArrayList<PPExpr> args;

    PPProcCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//PPProcCall
    
    UPPInst toUPP(ArrayList<String> locals){
        ArrayList<UPPExpr> nargs = new ArrayList<UPPExpr>();
        for (PPExpr e : args){
            nargs.add(e.toUPP(locals));
        }
        return new UPPProcCall(callee,nargs);
    }
    
    public String toString(){
    return callee.toString() + " (" + args.toString() + ")";
    }


}//PPProcCall
    
class PPSkip extends PPInst {
    UPPInst toUPP(ArrayList<String> locals){
        return new UPPSkip();
    }
    
    public String toString(){
        return "skip";
    }
}//PPSkip

class PPSeq extends PPInst {

    PPInst i1, i2;

    PPSeq (PPInst i1, PPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//PPSeq
    
    UPPInst toUPP(ArrayList<String> locals){
        UPPInst ni1 = i1.toUPP(locals);
        UPPInst ni2 = i2.toUPP(locals);
        return new UPPSeq(ni1,ni2);
    }
    
    public String toString(){
        return i1.toString() + "; " + i2.toString();
    }

}//PPSeq

/***************************************/
/* Definitions of functions/procedures */
/***************************************/

class Pair<L,R> {

    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }//Pair

    static <L,R> Pair<L,R> of(L left, R right){
        return new Pair<L,R>(left, right);
    }//of
    
    public String toString(){
        return "left : " + left.toString() + " right : " + right.toString();
    }

}//Pair

abstract class PPDef {

    String name;
    ArrayList<Pair<String,Type>> args, locals;
    PPInst code;
    abstract UPPDef toUPP(ArrayList<Pair<String,Type>> locals);
    public abstract String toString();
}//PPDef

class PPFun extends PPDef {

    Type ret;

    PPFun (String name, ArrayList<Pair<String,Type>> args, ArrayList<Pair<String,Type>> locals, PPInst code, Type ret) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
        this.ret = ret;
    }//PPFun

    UPPDef toUPP(ArrayList<Pair<String,Type>> locals){
        ArrayList<String> nargs = new ArrayList<String>();
        ArrayList<String> nlocals = new ArrayList<String>();
        ArrayList<String> nall = new ArrayList<String>();
        UPPInst ncode;
        for(Pair<String,Type> a : args){
            nargs.add(a.left);
            nall.add(a.left);
        }
        for(Pair<String,Type> e : locals){
            nlocals.add(e.left);
            nall.add(e.left);
        }
        ncode = code.toUPP(nall);
        return new UPPFun(name, nargs, nlocals, ncode);
    }
    
    public String toString(){
    return name + "(" + args.toString() + ") return" + ret.toString() + "var " + locals.toString() + " " + code.toString();
    }

}//PPFun

class PPProc extends PPDef {

    PPProc (String name, ArrayList<Pair<String,Type>> args, ArrayList<Pair<String,Type>> locals, PPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//PPProc

    UPPDef toUPP(ArrayList<Pair<String,Type>> locals){
        ArrayList<String> nargs=new ArrayList<String>();
        ArrayList<String> nlocals=new ArrayList<String>();
        ArrayList<String> nall=new ArrayList<String>();
        
        for(Pair<String,Type> a : args){
            nargs.add(a.left);
            nall.add(a.left);
        }
        for(Pair<String,Type> e : locals){
            nlocals.add(e.left);
            nall.add(e.left);
        }
        UPPInst ncode = code.toUPP(nall);

        return new UPPProc(name,nargs,nlocals,ncode);
    }//toUPP
    
    public String toString(){
        return name.toString() + "(" + args.toString() + ") var " + locals.toString() + " " + code.toString();
    }

    

}//PPProc

/************/
/* Programs */
/************/

class PPProg {

    ArrayList<Pair<String,Type>> globals;
    ArrayList<PPDef> defs;
    PPInst code;

    PPProg (ArrayList<Pair<String,Type>> globals, ArrayList<PPDef> defs, PPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }

    UPPProg toUPP(ArrayList<Pair<String,Type>> locals){
        ArrayList<String> nglobals = new ArrayList<String>();
        ArrayList<UPPDef> ndefs = new ArrayList<UPPDef>();
        UPPInst ncode;
        for(Pair<String,Type> e : locals){
            nglobals.add(e.left);
        }
        for (PPDef e : defs){
            ndefs.add(e.toUPP(locals));
        }
        ncode = code.toUPP(new ArrayList<String>());
        return new UPPProg(nglobals,ndefs,ncode); 
    }//toUPP
    
    public String toString(){
        return   "var " + globals.toString() + " " + defs.toString() + " " + code.toString();
    }

}

