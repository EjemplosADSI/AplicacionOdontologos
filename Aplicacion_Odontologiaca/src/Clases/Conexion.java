/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author DiegoAlonso
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Conexion {
    
    private String BaseDeDatos = "";
    private String Usuario = "";
    private String Contrasena = "";
    private Connection Con = null;
    private Statement Stmt = null;
    private ResultSet Rs = null;
    
    public Conexion() {
        
    }
    
    public Conexion(String BaseDeDatos, String Usuario, String Contrasena) {
        this.BaseDeDatos = BaseDeDatos;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;

    }   
    
    public void Conectar(){
        try{
            System.out.println("Intentando Conectar con la base de datos: "+BaseDeDatos);
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance()    ;
            Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+BaseDeDatos+"?user="+Usuario+"&password="+Contrasena+"&useSSL=false&serverTimezone=UTC");
            System.out.println("ConConexion Exitosa a la BD: "+BaseDeDatos);
        }catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, "Error al conectar con el servidor de MySQL", "Error MySQL", JOptionPane.ERROR_MESSAGE);
            System.err.println("SQLException: " + sqlEx.getMessage());
            System.err.println("SQLState: " + sqlEx.getSQLState());
            System.err.println("VendorError: " + sqlEx.getErrorCode());
        }catch(ClassNotFoundException cnfEx){
            JOptionPane.showMessageDialog(null, "Clase MySQL No Encontrada: "+cnfEx.getMessage(), "Clase No Encontrada", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(), "Error General", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean consultar (String Query){
        try{
            System.out.println("Intentando realizar la consulta: "+Query);
            Stmt = Con.createStatement();
            Rs = Stmt.executeQuery(Query);
            System.out.println("Consulta realizada con exito: "+Query);
            return true;
        }catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, "Error de MySQL al consultar la informacion", "Error MySQL", JOptionPane.ERROR_MESSAGE);
            System.err.println("SQLException: " + sqlEx.getMessage());
            System.err.println("SQLState: " + sqlEx.getSQLState());
            System.err.println("VendorError: " + sqlEx.getErrorCode());
            return false;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(), "Error General", JOptionPane.ERROR_MESSAGE);
            return false;
        }  
    }
    
    public boolean actualizar (String Query){
        try{
            System.out.println("Intentando realizar la consulta: "+Query);
            Stmt = Con.createStatement();
            Stmt.executeUpdate(Query,Statement.RETURN_GENERATED_KEYS);
            System.out.println("Consulta realizada con exito: "+Query);
            return true;
        }catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, "Error de MySQL al ejecutar la consulta", "Error MySQL", JOptionPane.ERROR_MESSAGE);
            System.err.println("SQLException: " + sqlEx.getMessage());
            System.err.println("SQLState: " + sqlEx.getSQLState());
            System.err.println("VendorError: " + sqlEx.getErrorCode());
            return false;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(), "Error General", JOptionPane.ERROR_MESSAGE);
            return false;
        }  
    }
    
    public int getLastId(){
       try{
           Rs = Stmt.getGeneratedKeys();
            while (Rs.next()) {
                System.out.println("El Id de la consulta es: "+Rs.getInt(1));
                return Rs.getInt(1);
            }
        }catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, "Error de MySQL al obtener el ultimo indice ", "Error MySQL", JOptionPane.ERROR_MESSAGE);
            System.err.println("SQLException: " + sqlEx.getMessage());
            System.err.println("SQLState: " + sqlEx.getSQLState());
            System.err.println("VendorError: " + sqlEx.getErrorCode());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(), "Error General", JOptionPane.ERROR_MESSAGE);
        }
       return -1;
    }
    
    
    public void cerrarConexion(){
        try{
            System.out.println("Intentando cerrar la conexion...");
            if (this.Rs != null) {
                this.Rs.close();
            }
            if (this.Stmt != null) {
                this.Stmt.close();
            }
            if (this.Con != null) {
                this.Con.close();
            }
        }catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, "Error de MySQL al cerrar la conexion", "Error MySQL", JOptionPane.ERROR_MESSAGE);
            System.err.println("SQLException: " + sqlEx.getMessage());
            System.err.println("SQLState: " + sqlEx.getSQLState());
            System.err.println("VendorError: " + sqlEx.getErrorCode());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(), "Error General", JOptionPane.ERROR_MESSAGE);
        }finally{
            this.Rs = null;
            this.Stmt = null;
            this.Con = null;
            System.out.println("Conexion Cerrada...");
        }
    }

    public void setBaseDeDatos(String BaseDeDatos) {
        this.BaseDeDatos = BaseDeDatos;
    }

    public String getBaseDeDatos() {
        return BaseDeDatos;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setCon(Connection Con) {
        this.Con = Con;
    }

    public Connection getCon() {
        return Con;
    }

    public void setRs(ResultSet Rs) {
        this.Rs = Rs;
    }

    public ResultSet getRs() {
        return Rs;
    }

    public void setStmt(Statement Stmt) {
        this.Stmt = Stmt;
    }

    public Statement getStmt() {
        return Stmt;
    }
    
}
