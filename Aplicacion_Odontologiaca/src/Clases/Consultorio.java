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
public class Consultorio {
    
    private int id;
    private int N_Consultorio;
    private int Piso;
    private String Disponibilidad;
    private final Conexion cn = new Conexion("centro_odontologico", "root", "");

    public Consultorio(int N_Consultorio, int Piso, String Disponibilidad) {
        this.id = id;
        this.N_Consultorio = N_Consultorio;
        this.Piso = Piso;
        this.Disponibilidad = Disponibilidad;
    }

    public Consultorio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN_Consultorio() {
        return N_Consultorio;
    }

    public void setN_Consultorio(int N_Consultorio) {
        this.N_Consultorio = N_Consultorio;
    }

    public int getPiso() {
        return Piso;
    }

    public void setPiso(int Piso) {
        this.Piso = Piso;
    }

    public String getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(String Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public boolean Nuevo (int N_Consultorio, int Piso, String Disponibilidad){
        
        try {
            this.N_Consultorio = N_Consultorio;
            this.Piso = Piso;
            this.Disponibilidad = Disponibilidad;
           
            cn.Conectar();
            cn.actualizar("INSERT INTO `centro_odontologico`.`consultorio` (`idCONSULTORIO`, `NUMERODECONSULTORIO`, `PISO`, `DISPONIBILIDAD`) VALUES (NULL, '"+this.N_Consultorio+"', '"+this.Piso+"', '"+this.Disponibilidad+"');");
            this.id = cn.getLastId();
            cn.cerrarConexion();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el Consultorio: "+e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
               
       
    }
    
        public boolean Editar (int id, int N_Consultorio, int Piso, String Disponibilidad){
            try {
                this.id = id;
                this.N_Consultorio = N_Consultorio;
                this.Piso = Piso;
                this.Disponibilidad = Disponibilidad;
                
                cn.Conectar();
                boolean status = cn.actualizar("UPDATE `centro_odontologico`.`consultorio` SET `NUMERODECONSULTORIO` = '"+this.N_Consultorio+"', `PISO` = '"+
                                                this.Piso+"', `DISPONIBILIDAD` = '"+this.Disponibilidad+
                                                "' WHERE `consultorio`.`idCONSULTORIO` = "+this.id+"");
                if(status){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el Consultorio", "Actualizar Consultorio", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Consultorio: ", "Error MySQL", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Consultorio: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    
        public boolean Editar (Consultorio consultorio){
            try {
                cn.Conectar();
                cn.actualizar("UPDATE `centro_odontologico`.`consultorio` SET `NUMERODECONSULTORIO` = '"+consultorio.N_Consultorio+"', `PISO` = '"+
                                                consultorio.Piso+"', `DISPONIBILIDAD` = '"+consultorio.Disponibilidad+
                                                "' WHERE `consultorio`.`idCONSULTORIO` = "+consultorio.id+"");
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el Consultorio", "Actualizar Consultorio", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Consultorio: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
    public boolean Eliminar (int idConsultorio){
        this.id = idConsultorio;
        try {
            this.cn.Conectar();
            cn.actualizar("DELETE FROM centro_odontologico.consultorio WHERE consultorio.idCONSULTORIO = '"+this.id+"'");
            JOptionPane.showMessageDialog(null, "Se ha ELIMINADO correctamente el Consultorio", "Eliminar Consultorio", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public ArrayList<Consultorio> Buscar (String Where){
        ArrayList<Consultorio> listConsultorios = new ArrayList<Consultorio>();
        try {
            this.cn.Conectar();
            this.cn.consultar("SELECT * FROM centro_odontologico.consultorio WHERE "+Where);
            while (cn.getRs().next()){         
                Consultorio tmpConsultorio = new Consultorio();
                tmpConsultorio.id = cn.getRs().getInt("idCONSULTORIO");
                tmpConsultorio.N_Consultorio = cn.getRs().getInt("NUMERODECONSULTORIO");
                tmpConsultorio.Piso = cn.getRs().getInt("PISO");
                tmpConsultorio.Disponibilidad = cn.getRs().getString("DISPONIBILIDAD");
                listConsultorios.add(tmpConsultorio);
            }
            this.cn.cerrarConexion();
            //JOptionPane.showMessageDialog(null, "Se han encontrado resultados de Odontologos", "Buscar Odontologo", JOptionPane.INFORMATION_MESSAGE);
            return listConsultorios;
        } catch (Exception e) {
            System.out.println("Error al Cargar los Datos: "+e.getMessage());
            return null;
        }
    }
    
    public boolean getForId(int Id){
        try {
            this.cn.Conectar();
            cn.consultar("SELECT * FROM centro_odontologico.consultorio WHERE `idCONSULTORIO` = "+Id+";");
            while (cn.getRs().next()){
                this.id = cn.getRs().getInt("idCONSULTORIO");
                this.N_Consultorio = cn.getRs().getInt("NUMERODECONSULTORIO");
                this.Piso = cn.getRs().getInt("PISO");
                this.Disponibilidad = cn.getRs().getString("DISPONIBILIDAD");
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }  

    public Consultorio getForIdConsultorio(int Id){
        Consultorio con = new Consultorio();
        try {
            this.cn.Conectar();
            cn.consultar("SELECT * FROM centro_odontologico.consultorio WHERE `idCONSULTORIO` = "+Id+";");
            while (cn.getRs().next()){
                con.id = cn.getRs().getInt("idCONSULTORIO");
                con.N_Consultorio = cn.getRs().getInt("NUMERODECONSULTORIO");
                con.Piso = cn.getRs().getInt("PISO");
                con.Disponibilidad = cn.getRs().getString("DISPONIBILIDAD");
            }
            return con;
        } catch (Exception e) {
            return null;
        }
    }  
    
    
    @Override
    public String toString() {
        return N_Consultorio+" - "+ Piso;
    }

    
    
}
