/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kisuke
 */
public class Utility {
    
    public static String DateToString(Date Fecha, String Format){
        SimpleDateFormat formato = new SimpleDateFormat(Format);
        String strFecha = formato.format(Fecha);
        return strFecha;
    }
    
}
