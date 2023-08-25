
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.HashMap;
import Objeto.TablaJson;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class SintaticoJSON extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public SintaticoJSON() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public SintaticoJSON(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SintaticoJSON(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\013\000\002\002\004\000\002\002\003\000\002\006" +
    "\004\000\002\006\003\000\002\007\006\000\002\003\004" +
    "\000\002\003\003\000\002\004\006\000\002\004\005\000" +
    "\002\005\003\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\004\006\004\001\002\000\006\004\016\005" +
    "\012\001\002\000\006\002\000\006\004\001\002\000\006" +
    "\002\ufffe\006\ufffe\001\002\000\004\002\010\001\002\000" +
    "\004\002\001\001\002\000\006\002\uffff\006\uffff\001\002" +
    "\000\014\004\ufff7\005\ufff7\007\ufff7\010\ufff7\011\ufff7\001" +
    "\002\000\010\004\ufffb\005\ufffb\007\ufffb\001\002\000\010" +
    "\004\016\005\012\007\023\001\002\000\004\010\017\001" +
    "\002\000\014\004\ufff8\005\ufff8\007\ufff8\010\ufff8\011\ufff8" +
    "\001\002\000\006\004\016\005\012\001\002\000\012\004" +
    "\ufff9\005\ufff9\007\ufff9\011\021\001\002\000\010\004\ufffa" +
    "\005\ufffa\007\ufffa\001\002\000\010\004\ufffc\005\ufffc\007" +
    "\ufffc\001\002\000\004\012\024\001\002\000\006\002\ufffd" +
    "\006\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\010\002\006\006\004\007\005\001\001\000" +
    "\010\003\013\004\012\005\014\001\001\000\004\007\010" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\004\021\005\014\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\005\017\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SintaticoJSON$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SintaticoJSON$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SintaticoJSON$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


//codigo visible
    
 
    public static ArrayList < TablaJson > tablasDatos = new ArrayList< TablaJson >();
    public static ArrayList<String> erroresSintacticos = new ArrayList<String>();
    public static TablaJson tablaNueva;


    public int cont = 0;
    ArrayList<String> elementosSeparado = new ArrayList<String>();

    public void syntax_error(Symbol s){  //devuelve errores sintacticos
        System.out.println("Error de sintaxis: Linea: "+ (s.right+1) +" columna: " + (s.left+1)+ " no reconocido");
        erroresSintacticos.add("Error sintactico: "+s.value.toString()+" Linea: "+(s.right+1)+";");
    }

    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
        System.out.println("Error síntactico irrecuperable en la Línea " + 
        (s.right+1)+ " Columna "+(s.left+1)+". Componente " + s.value + 
        " no reconocido."); 
        erroresSintacticos.add("Error Sintactico: "+s.value.toString()+" Linea: "+(s.right+1)+";");
    }  

    public void agregarNombre(String nombreTabla){
        tablaNueva = new TablaJson(nombreTabla);
    }
    
    public void agregarItems (Object llave, Object valor){
        tablaNueva.valoresTabla.put(llave,valor);
    }




/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$SintaticoJSON$actions {
  private final SintaticoJSON parser;

  /** Constructor */
  CUP$SintaticoJSON$actions(SintaticoJSON parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$SintaticoJSON$do_action_part00000000(
    int                        CUP$SintaticoJSON$act_num,
    java_cup.runtime.lr_parser CUP$SintaticoJSON$parser,
    java.util.Stack            CUP$SintaticoJSON$stack,
    int                        CUP$SintaticoJSON$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SintaticoJSON$result;

      /* select the action based on the action number */
      switch (CUP$SintaticoJSON$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)).value;
		RESULT = start_val;
              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SintaticoJSON$parser.done_parsing();
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= DOCUMENTOS 
            {
              Object RESULT =null;

              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // DOCUMENTOS ::= DOCUMENTOS DOCUMENTO 
            {
              Object RESULT =null;
		System.out.println(11);
              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("DOCUMENTOS",4, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // DOCUMENTOS ::= DOCUMENTO 
            {
              Object RESULT =null;
		 System.out.println(10); 
              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("DOCUMENTOS",4, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // DOCUMENTO ::= LLAV_A SENTENCIAS LLAV_C TITULO 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.peek()).value;
		 
    System.out.println(a.substring(5));
    //agregarNombre(a.substring(5));
    System.out.println(1);

              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("DOCUMENTO",5, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-3)), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // SENTENCIAS ::= SENTENCIAS SENTENCIA 
            {
              Object RESULT =null;

              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("SENTENCIAS",1, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // SENTENCIAS ::= SENTENCIA 
            {
              Object RESULT =null;

              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("SENTENCIAS",1, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // SENTENCIA ::= DATO DOSPUNTO DATO COMA 
            {
              Object RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-3)).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-1)).value;
		 
    System.out.println(2);
    //agregarItems(b,c);
    System.out.println("En teoria funcionando");

              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("SENTENCIA",2, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-3)), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // SENTENCIA ::= DATO DOSPUNTO DATO 
            {
              Object RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-2)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.peek()).value;
		
    System.out.println("Terminando el arreglo"); 

    //agregarItems(d,e);
    //System.out.println(tablaNueva.valoresTabla);
    System.out.println(4);

 
              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("SENTENCIA",2, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.elementAt(CUP$SintaticoJSON$top-2)), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DATO ::= CADENA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.peek()).value;
		System.out.println("                   "+a);
              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("DATO",3, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // DATO ::= NUMERO 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$SintaticoJSON$stack.peek()).value;
		 System.out.println("                                 "+a.toString());
              CUP$SintaticoJSON$result = parser.getSymbolFactory().newSymbol("DATO",3, ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaticoJSON$stack.peek()), RESULT);
            }
          return CUP$SintaticoJSON$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$SintaticoJSON$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$SintaticoJSON$do_action(
    int                        CUP$SintaticoJSON$act_num,
    java_cup.runtime.lr_parser CUP$SintaticoJSON$parser,
    java.util.Stack            CUP$SintaticoJSON$stack,
    int                        CUP$SintaticoJSON$top)
    throws java.lang.Exception
    {
              return CUP$SintaticoJSON$do_action_part00000000(
                               CUP$SintaticoJSON$act_num,
                               CUP$SintaticoJSON$parser,
                               CUP$SintaticoJSON$stack,
                               CUP$SintaticoJSON$top);
    }
}

}
