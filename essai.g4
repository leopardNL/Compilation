// essai.g4

grammar essai;

// This will be the entry point of our parser.
expr : (Type|c|atomExpr|uop|boolExpr|uop|additionExpr | multiplyExpr |appelExpr );

//programme
p: 'var'(X':'Type)* d* instr ;

//d reprente les fonctions et instructions
d:'f('(X':'Type)*')' 'var'(X':'Type)* instr;


Type : ('Number' | 'Boolean' | 'Array''of' Type);

// Addition and subtraction have the lowest precedence.
additionExpr : multiplyExpr ('+' multiplyExpr | '-' multiplyExpr)* ;

// Multiplication and division have a higher precedence.
multiplyExpr : atomExpr ('*' atomExpr | '/' atomExpr)* ;

// Boolean comparaison
binOpComp : atomExpr ('>' atomExpr | '>=' atomExpr | '<' atomExpr | '<=' atomExpr | '=' atomExpr | '!=' atomExpr) * ;

// Simple expression with boolean
boolExpr : Boolean | binOpComp | binOpAndOr | 'not' boolExpr ;

//expression AND or OR
binOpAndOr : Boolean ('and' boolExpr | 'or' boolExpr ) * ;

//variable X
X:[a-z]+;

//
Boolean : 'true'| 'false'  ; 

//c is a constant
c : Boolean | Number;



//appel function
appelExpr : ('read'|'write'|'f')'('expr')';

//uop 
uop: '-' expr | 'not' expr;

/* An expression atom is the smallest part of an expression: a number. Or 
   when we encounter parenthesis, we're making a recursive call back to the
   rule 'additionExpr'. As you can see, an 'atomExpr' has the highest
   precedence. */
atomExpr : Number | '(' additionExpr ')' | '-' atomExpr ;

// A number is an integer value
Number : ('0'..'9')+ ;

// We're going to ignore all white space characters
WS : [ \t\r\n]+ -> skip ;





//Array of Type
Array : 'array' 'of' Type; 

//instructions
instr : (conditions | expr | appelExpr);
//conditions if and while
conditions : ('if' expr 'then' expr 'else' expr | 'while' expr 'do' instr);



   







