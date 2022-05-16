grammar Exprdump;

expr: expr '+' term #plus
    | expr '-' term #minus
    | term #t ; 
term: term '*' fac #multi
    | term '/' fac #div
    | fac #f ;
fac: '-' fac #unary
    | '(' expr ')'    #brac
    | NUM   #num
    | ID    #id ;
    
ID: [a-zA-Z]+;
NUM: [0-9]+;
WHITESPACE:  [ \t\r\n]+ -> skip ;
