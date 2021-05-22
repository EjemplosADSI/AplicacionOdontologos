/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DiegoAlonso
 */
public class Paciente {
    
    private int id;
    private String Nombres;
    private String Apellidos;
    private long N_Documento;
    private long Telefono;
    private String Correo;
    private String Direccion;
    private final Conexion cn = new Conexion("centro_odontologico", "root", "");

    public Paciente(String Nombres, String Apellidos, long N_Documento, int Telefono, String Correo, String Direccion) {
        this.id = id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.N_Documento = N_Documento;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
    }

    public Paciente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public long getN_Documento() {
        return N_Documento;
    }

    public void setN_Documento(long N_Documento) {
        this.N_Documento = N_Documento;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public boolean Nuevo (String Nombres, String Apellidos, long N_Documento, long Telefono, String Correo, String Direccion){
        
        try {
            this.Nombres = Nombres;
            this.Apellidos = Apellidos;
            this.N_Documento = N_Documento;
            this.Telefono = Telefono;
            this.Correo = Correo;
            this.Direccion = Direccion;
            
            cn.Conectar();
            cn.actualizar("INSERT INTO `centro_odontologico`.`paciente` (`idPACIENTE`, `NOMBRES`, `APELLIDOS`, `NUMERODEDOCUMENTO`, `TELEFONO`, `CORREOELECTRONICO`, `DIRECCION`) VALUES (NULL, '"+
                            this.Nombres+"', '"+this.Apellidos+"', '"+this.N_Documento+"', '"+this.Telefono+"', '"+this.Correo+"', '"+this.Direccion+"');");
            this.id = cn.getLastId();
            cn.cerrarConexion();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el Paciente: "+e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
               
       
    }
    
        public boolean Editar (int id, String Nombres, String Apellidos, long N_Documento, long Telefono, String Correo, String Direccion){
            try {
                this.id = id;
                this.Nombres = Nombres;
                this.Apellidos = Apellidos;
                this.N_Documento = N_Documento;
                this.Telefono = Telefono;
                this.Correo = Correo;
                this.Direccion = Direccion;
                
                cn.Conectar();
                boolean status = cn.actualizar("UPDATE `centro_odontologico`.`paciente` SET `NOMBRES` = '"+this.Nombres+"', `APELLIDOS` = '"+
                                                this.Apellidos+"', `NUMERODEDOCUMENTO` = '"+this.N_Documento+"', `TELEFONO` = '"+
                                                this.Telefono+"', `CORREOELECTRONICO` = '"+this.Correo+"', `DIRECCION` = '"+
                                                this.Direccion+"' WHERE `paciente`.`idPACIENTE` = "+this.id+"");
                
                if(status){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el Paciente", "Actualizar Paciente", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Paciente: ", "Error MySQL", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Paciente: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    
        public boolean Editar (Paciente paciente){
            try {
                cn.Conectar();
                cn.actualizar("UPDATE `centro_odontologico`.`paciente` SET `NOMBRES` = '"+paciente.Nombres+"', `APELLIDOS` = '"+
                                paciente.Apellidos+"', `NUMERODEDOCUMENTO` = '"+paciente.N_Documento+"', `TELEFONO` = '"+
                                paciente.Telefono+"', `CORREOELECTRONICO` = '"+paciente.Correo+"', `DIRECCION` = '"+
                                paciente.Direccion+"' WHERE `paciente`.`idPACIENTE` = "+paciente.id+"");
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el Paciente", "Actualizar Paciente", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Paciente: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
    public boolean Eliminar (int idPaciente){
        this.id = idPaciente;
        try {
            this.cn.Conectar();
            cn.actualizar("DELETE FROM centro_odontologico.paciente WHERE paciente.idPACIENTE = '"+this.id+"'");
            JOptionPane.showMessageDialog(null, "Se ha ELIMINADO correctamente el Paciente", "Eliminar Paciente", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public ArrayList<Paciente> Buscar (String Where){
        ArrayList<Paciente> listPacientes = new ArrayList<Paciente>();
        try {
            this.cn.Conectar();
            this.cn.consultar("SELECT * FROM centro_odontologico.paciente WHERE "+Where);
            while (cn.getRs().next()){               
                Paciente tmpPaciente = new Paciente();
                tmpPaciente.id = cn.getRs().getInt("idPACIENTE");
                tmpPaciente.Nombres = cn.getRs().getString("NOMBRES");
                tmpPaciente.Apellidos = cn.getRs().getString("APELLIDOS");
                tmpPaciente.N_Documento = cn.getRs().getLong("NUMERODEDOCUMENTO");
                tmpPaciente.Telefono = cn.getRs().getLong("TELEFONO");
                tmpPaciente.Correo = cn.getRs().getString("CORREOELECTRONICO");
                tmpPaciente.Direccion = cn.getRs().getString("DIRECCION");
                listPacientes.add(tmpPaciente);
            }
            this.cn.cerrarConexion();
            //JOptionPane.showMessageDialog(null, "Se han encontrado resultados de Odontologos", "Buscar Odontologo", JOptionPane.INFORMATION_MESSAGE);
            return listPacientes;
        } catch (Exception e) {
            System.out.println("Error al Cargar los Datos: "+e.getMessage());
            return null;
        }
    }
    
    public boolean getForId(int Id){
        try {
            this.cn.Conectar();
            cn.consultar("SELECT * FROM centro_odontologico.paciente WHERE `idPACIENTE` = "+Id+";");
            while (cn.getRs().next()){
                this.id = cn.getRs().getInt("idPACIENTE");
                this.Nombres = cn.getRs().getString("NOMBRES");
                this.Apellidos = cn.getRs().getString("APELLIDOS");
                this.N_Documento = cn.getRs().getLong("NUMERODEDOCUMENTO");
                this.Telefono = cn.getRs().getLong("TELEFONO");
                this.Correo = cn.getRs().getString("CORREOELECTRONICO");
                this.Direccion = cn.getRs().getString("DIRECCION");
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }  

    public Paciente getForIdPaciente(int Id){
        Paciente ps = new Paciente();
        try {
            this.cn.Conectar();
            cn.consultar("SELECT * FROM centro_odontologico.paciente WHERE `idPACIENTE` = "+Id+";");
            while (cn.getRs().next()){
                ps.id = cn.getRs().getInt("idPACIENTE");
                ps.Nombres = cn.getRs().getString("NOMBRES");
                ps.Apellidos = cn.getRs().getString("APELLIDOS");
                ps.N_Documento = cn.getRs().getLong("NUMERODEDOCUMENTO");
                ps.Telefono = cn.getRs().getLong("TELEFONO");
                ps.Correo = cn.getRs().getString("CORREOELECTRONICO");
                ps.Direccion = cn.getRs().getString("DIRECCION");
            }
            return ps;
        } catch (Exception e) {
            return null;
        }
    }  
    
    public String toString() {
        return Nombres + " " + Apellidos;
    }
    
}
