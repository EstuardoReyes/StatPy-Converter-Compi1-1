package ventana;
import java_cup.runtime.Symbol;
import java.util.ArrayList;


%%
%class Lexico
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
ASIGN = "->"
DOSPUNTO = ":"
LIMIT = "%%"
PYCOMA = ";"
SUMA = "+"
MULTI = "*"
PREGUNTA = "?"
RAYA = "|"
VIRGUILLA = "~"
PUNTO = "."
COMA = ","



//PALABRAS RESERVADAS

CONJUNTO = "CONJ"

//EXPRESIONES REGULARES 

ID      =     [A-Za-zÑñ][_0-9A-Za-zÑñ$] *   
NUMERO  =     "-"?[0-9]+(\.[0-9]+)?
SPACE   =     [\ \r\t\f\t]
ENTER   =     [\ \n]
COMMENTARIO =  "<!"[^!]*"!>" 
COMENTARIO =   \/\/.* 
CARACTER  =     [!-\/:-@\[-`{-~]
COMILLA =     [\"]



%%


<YYINITIAL> {SPACE}      {/* Espacios en blanco ignorado */}

<YYINITIAL> {COMMENTARIO}      {/*ignorando comentarios multilinea */ }

<YYINITIAL> {COMENTARIO}  {/* Ignorando comentarios de linea*/  }

<YYINITIAL> {COMILLA}      {yybegin(CADENA);}

<YYINITIAL> {CONJUNTO}   { return new Symbol(sym.CONJUNTO, yycolumn, yyline);   } 

<YYINITIAL> {LLAV_A}    { return new Symbol(sym.LLAV_A, yycolumn, yyline,new String(yytext())); } 

<YYINITIAL> {COMA}    {return new Symbol(sym.COMA, yycolumn, yyline); } 

<YYINITIAL> {VIRGUILLA}    {  return new Symbol(sym.VIRGUILLA, yycolumn, yyline,new String(yytext())); }  

<YYINITIAL> {PUNTO}    { return new Symbol(sym.PUNTO, yycolumn, yyline,new String(yytext()));}

<YYINITIAL> {LLAV_C}    {return new Symbol(sym.LLAV_C, yycolumn, yyline,new String(yytext()));} 

<YYINITIAL> {DOSPUNTO}  { return new Symbol(sym.DOSPUNTO, yycolumn, yyline,new String(yytext()));}

<YYINITIAL> {LIMIT}     { return new Symbol(sym.LIMIT, yycolumn, yyline,new String(yytext()));} 

<YYINITIAL> {ASIGN}     {  return new Symbol(sym.ASIGN, yycolumn, yyline,new String(yytext()));} 

<YYINITIAL> {PYCOMA}    {return new Symbol(sym.PYCOMA, yycolumn, yyline,new String(yytext()));}

<YYINITIAL> {SUMA}      { return new Symbol(sym.SUMA, yycolumn, yyline,new String(yytext()));}

<YYINITIAL> {MULTI}     {return new Symbol(sym.MULTI, yycolumn, yyline,new String(yytext()));} 

<YYINITIAL> {PREGUNTA}  { return new Symbol(sym.PREGUNTA, yycolumn, yyline,new String(yytext())); }

<YYINITIAL> {RAYA}      {return new Symbol(sym.RAYA, yycolumn, yyline,new String(yytext()));} 

<YYINITIAL> {ID}        { return new Symbol(sym.ID, yycolumn,yyline,new String(yytext()));} 

<YYINITIAL> {NUMERO}    { return new Symbol(sym.NUMERO, yycolumn,yyline,new String(yytext()));}  

<YYINITIAL> {CARACTER}  { return new Symbol(sym.CARACTER, yycolumn,yyline,new String(yytext()));} 


<YYINITIAL> {ENTER}      {/* Espacios en blanco ignorado */}

<CADENA>  {
        [\"] { String tmp=cadena; cadena="";  yybegin(YYINITIAL); return new Symbol(sym.CADENA, yycolumn,yyline,tmp);}
        [\n] { String tmp=cadena; cadena="";    System.out.println("Se esperaba cierre de cadena");
                yybegin(YYINITIAL);
             }
        [^\"] { cadena+=yytext(); }

}


<YYINITIAL> . {
        String errLex = "Error lexico : '"+yytext()+"' en la linea : "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
        Error error = new Error("Lexico","El caracter: "+yytext()+" no pertenece al lenguaje",Integer.toString(yyline+1),Integer.toString(yycolumn));
        ErroresLexicos.add(error);
}






