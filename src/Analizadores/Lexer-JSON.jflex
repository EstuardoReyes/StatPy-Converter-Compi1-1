package Analizadores;
import java_cup.runtime.Symbol;
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

<YYINITIAL> {TITULO}   { return new Symbol(sym.TITULO, yycolumn, yyline);  System.out.println(yytext()); } 

<YYINITIAL> {COMMENTARIO}  {/*ignorando comentarios multilinea */ }

<YYINITIAL> {COMENTARIO}  {/* Ignorando comentarios de linea*/  }

<YYINITIAL> {COMILLA}      {yybegin(CADENA);}

<YYINITIAL> {LLAV_A}    { return new Symbol(sym.LLAV_A, yycolumn, yyline,new String(yytext())); System.out.println(yytext()); } 

<YYINITIAL> {COMA}    {return new Symbol(sym.COMA, yycolumn, yyline); } 

<YYINITIAL> {LLAV_C}    {return new Symbol(sym.LLAV_C, yycolumn, yyline,new String(yytext())); System.out.println(yytext()); } 

<YYINITIAL> {DOSPUNTO}  { return new Symbol(sym.DOSPUNTO, yycolumn, yyline,new String(yytext())); System.out.println(yytext());}
 
<YYINITIAL> {ENTER}      {/* Espacios en blanco ignorado */}

<CADENA>  {
        [\"] { String tmp=cadena; cadena="";  yybegin(YYINITIAL); return new Symbol(sym.CADENA, yycolumn,yyline,tmp);}
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










