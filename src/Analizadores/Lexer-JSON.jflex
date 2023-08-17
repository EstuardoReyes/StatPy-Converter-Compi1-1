package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;


%%
%class Lexic
%cup
%public
%unicode
%line
%column
%char
%state CADENA



%{
    String cadena="";
    public static ArrayList<Error> ErroresLexicos = new ArrayList<Error>();
  
    
%}

//SIMBOLOS


LLAV_A = "{"
LLAV_C = "}"
DOSPUNTO = ":"
COMA = ","



//PALABRAS RESERVADAS



//EXPRESIONES REGULARES 

SPACE       =  [\ \r\t\f\t]
ENTER       =  [\ \n]
TITULO      =  <\*\*[^]*\*\*>
COMMENTARIO =  "<!"[^!]*"!>" 
COMENTARIO  =  \/\/.* 
COMILLA     =  [\"]



%%


<YYINITIAL> {SPACE}      {/* Espacios en blanco ignorado */}

<YYINITIAL> {TITULO}   { return new Symbol(TITULO, yycolumn, yyline, new String(yytext())); } 

<YYINITIAL> {COMMENTARIO}  {/*ignorando comentarios multilinea */ }

<YYINITIAL> {COMENTARIO}  {/* Ignorando comentarios de linea*/  }

<YYINITIAL> {COMILLA}      {yybegin(CADENA);}

<YYINITIAL> {LLAV_A}    { return new Symbol(LLAV_A, yycolumn, yyline,new String(yytext()));  } 

<YYINITIAL> {COMA}    {return new Symbol(COMA, yycolumn, yyline); } 

<YYINITIAL> {LLAV_C}    {return new Symbol(LLAV_C, yycolumn, yyline,new String(yytext()));  } 

<YYINITIAL> {DOSPUNTO}  { return new Symbol(DOSPUNTO, yycolumn, yyline,new String(yytext())); }
 
<YYINITIAL> {ENTER}      {/* Espacios en blanco ignorado */}

<CADENA>  {
        [\"] { String tmp=cadena; cadena="";  yybegin(YYINITIAL); return new Symbol(CADENA, yycolumn,yyline,tmp);}
        [\n] { String tmp=cadena; cadena="";    System.out.println("Se esperaba cierre de cadena");
                yybegin(YYINITIAL);
                System.out.println(yytext());
             }
        [^\"] { cadena+=yytext(); }

}


<YYINITIAL> . {
        String errLex = "Error lexico : '"+yytext()+"' en la linea : "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
        
}










