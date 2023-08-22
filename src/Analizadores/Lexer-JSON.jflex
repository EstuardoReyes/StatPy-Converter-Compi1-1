package Analizadores;
import java_cup.runtime.*;
import java_cup.runtime.Symbol;
import java.util.ArrayList;


%%
%class LexicoJSON
%cup
%public
%unicode
%line
%column
%char
%state CADENA
%state TITULO



%{
    String cadena="";
    String titulo="";
    public static ArrayList<Error> ErroresLexicos = new ArrayList<Error>();
  
    
%}

//SIMBOLOS


LLAV_A = "{"
LLAV_C = "}"
DOSPUNTO = ":"
COMA = ","




//PALABRAS RESERVADAS



//EXPRESIONES REGULARES 

TITULO      =  \/\/\*\*.* 
DIGITO      =  [0-9]
INT         =  {DIGITO}+
DECIMAL     =  {DIGITO}*\.{DIGITO}+ | {DIGITO}+\.{DIGITO}*
NUMERO      =  {INT} | {DECIMAL}
SPACE       =  [\ \r\t\f\t]
ENTER       =  [\ \n]
COMMENTARIO =  "/*"[^!]*"*/" 
COMENTARIO  =  \/\/.* 
COMILLA     =  [\"]




%%
<YYINITIAL> {TITULO}   {System.out.println(yytext()); return new Symbol(sym.TITULO, yycolumn, yyline, new String(yytext()));  } 

<YYINITIAL> {SPACE}      {/* Espacios en blanco ignorado */}

<YYINITIAL> {NUMERO}   { return new Symbol(sym.NUMERO, yycolumn, yyline, new String(yytext())); } 

<YYINITIAL> {COMMENTARIO}  {/*ignorando comentarios multilinea */ }

<YYINITIAL> {COMENTARIO}  {/* Ignorando comentarios de linea*/  }

<YYINITIAL> {COMILLA}      {yybegin(CADENA);}

<YYINITIAL> {LLAV_A}    { return new Symbol(sym.LLAV_A, yycolumn, yyline,new String(yytext()));  } 

<YYINITIAL> {COMA}    {return new Symbol(sym.COMA, yycolumn, yyline); } 

<YYINITIAL> {LLAV_C}    {System.out.println(yytext()); return new Symbol(sym.LLAV_C, yycolumn, yyline,new String(yytext()));  } 

<YYINITIAL> {DOSPUNTO}  { return new Symbol(sym.DOSPUNTO, yycolumn, yyline,new String(yytext())); }
 
<YYINITIAL> {ENTER}      {/* Espacios en blanco ignorado */}

<CADENA>  {
        [\"] { String tmp=cadena; cadena="";  yybegin(YYINITIAL); return new Symbol(sym.CADENA, yycolumn,yyline,tmp);}
        [\n] { String tmp=cadena; cadena="";    System.out.println("Se esperaba cierre de cadena");
                yybegin(YYINITIAL);}
        [^\"] { cadena+=yytext(); }
}

<YYINITIAL> . {
        String errLex = "Error lexico : '"+yytext()+"' en la linea : "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex+" ERROR");
        
}










