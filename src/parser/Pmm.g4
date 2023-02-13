grammar Pmm;	

program: INT_CONSTANT
       ;

LETTER: [a-zA-Z]
;
  		 
INT_CONSTANT: [1-9][0-9]* | '0'
;

REAL_CONSTANT: INT_CONSTANT*? DOT INT_CONSTANT+
    | INT_CONSTANT+ DOT
;


CHAR_CONSTANT: '\'' LETTER '\''
;

fragment DOT: .
;



TRASH: [\n\r ] -> skip
;
