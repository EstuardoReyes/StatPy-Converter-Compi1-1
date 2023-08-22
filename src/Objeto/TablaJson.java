/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author tato_
 */
public class TablaJson {
    public String nombreTabla;
    public HashMap valoresTabla;

    public TablaJson(String nombreTabla) {
        this.nombreTabla = nombreTabla;
        HashMap<Object,Object> valoresTabla = new HashMap<Object,Object>();
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public HashMap getValoresTabla() {
        return valoresTabla;
    }

    public void setValoresTabla(HashMap valoresTabla) {
        this.valoresTabla = valoresTabla;
    }

  
    
    
}
