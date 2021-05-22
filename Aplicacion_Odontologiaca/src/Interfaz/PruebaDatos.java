/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DiegoAlonso
 */
public class PruebaDatos {
 
    public static void main(String[] args) {
        
       /* for (int i = 0; i < 4; i++) {
            String Nombres = JOptionPane.showInputDialog(null, "Ingrese Los Nombres"+i, "Ingrese Nombres", JOptionPane.QUESTION_MESSAGE);
            String Apellidos = JOptionPane.showInputDialog(null, "Ingrese Los Apellidos"+i, "Ingrese Apellidos", JOptionPane.QUESTION_MESSAGE);
            long N_Documento = Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese Su Numero de Identificacion"+i, "Ingrese Identificacion", JOptionPane.QUESTION_MESSAGE));
            int Telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Su Telefono"+i, "Ingrese Telefono", JOptionPane.QUESTION_MESSAGE));
            String Correo = JOptionPane.showInputDialog(null, "Ingrese Su Correo", "Ingrese Correo+i", JOptionPane.QUESTION_MESSAGE);
            String Direccion = JOptionPane.showInputDialog(null, "Ingrese Su Direccion", "Ingrese Direccion"+i, JOptionPane.QUESTION_MESSAGE);
            int Tiempo_Experiencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Su Tiempo de Experiencia"+i, "Ingrese Experiencia", JOptionPane.QUESTION_MESSAGE));
            double Salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese Su Salario", "Ingrese Salario"+i, JOptionPane.QUESTION_MESSAGE));

            Odontologos od = new Odontologos();
            od.Nuevo(Nombres, Apellidos, N_Documento, Telefono, Correo, Direccion, Tiempo_Experiencia, Salario);
        }*/
        

        
        
        /*
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del usuario que desea actualizar", "Ingrese ID", JOptionPane.QUESTION_MESSAGE));
        String Nombres = JOptionPane.showInputDialog(null, "Ingrese Su Numero de Identificacion", "Ingrese Identificacion", JOptionPane.QUESTION_MESSAGE);
        int Telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Su Telefono", "Ingrese Telefono", JOptionPane.QUESTION_MESSAGE));
        String Correo = JOptionPane.showInputDialog(null, "Ingrese Su Correo", "Ingrese Correo", JOptionPane.QUESTION_MESSAGE);
        String Direccion = JOptionPane.showInputDialog(null, "Ingrese Su Direccion", "Ingrese Direccion", JOptionPane.QUESTION_MESSAGE);
        int Tiempo_Experiencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Su Tiempo de Experiencia", "Ingrese Experiencia", JOptionPane.QUESTION_MESSAGE));
        double Salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese Los Nombres", "Ingrese Nombres", JOptionPane.QUESTION_MESSAGE));
        String Apellidos = JOptionPane.showInputDialog(null, "Ingrese Los Apellidos", "Ingrese Apellidos", JOptionPane.QUESTION_MESSAGE);
        long N_Documento = Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese Su Salario", "Ingrese Salario", JOptionPane.QUESTION_MESSAGE));
        */
        //Odontologos od = new Odontologos(Nombres, Apellidos, N_Documento, Telefono, Correo, Direccion, Tiempo_Experiencia, Salario);
        //od.Editar(id, Nombres, Apellidos, N_Documento, Telefono, Correo, Direccion, Tiempo_Experiencia, Salario);
        
        /*
        int IdOdontologo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese El id del odontologo a eliminar", "Ingrese ID", JOptionPane.QUESTION_MESSAGE));
        
        Odontologos ol = new Odontologos();
        
        ol.Eliminar(IdOdontologo);
        */
        /*
        for (int i = 0; i < 5; i++) {
            
            String Campo = JOptionPane.showInputDialog(null, "Ingrese el nombre del campo por el que desea realizar la consulta", "Campo Consulta", JOptionPane.QUESTION_MESSAGE);
            String Dato = JOptionPane.showInputDialog(null, "Ingrese el dato del campo por el que desea realizar la consulta", "Dato Consulta", JOptionPane.QUESTION_MESSAGE);

            String WHERE = "`"+Campo+"` LIKE  '"+Dato+"'";

            Odontologos od = new Odontologos();
            ArrayList<Odontologos> listOdont = od.Buscar(WHERE);
            
            for (Odontologos tempOdonto : listOdont) {
             
                System.out.print(tempOdonto.toString());
                
            }
            
            * */
            
   
            Odontologos od = new Odontologos();
            od.getForId(1);
            System.out.println("Sus nombres son: "+od.getNombres()+" y sus apellidos son: "+od.getApellidos());
            System.out.println(od.toString());
        
    }
    
}
