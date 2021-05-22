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
public class Odontologos {
    
    private int id;
    private String Nombres;
    private String Apellidos;
    private long N_Documento;
    private long Telefono;
    private String Correo;
    private String Direccion;
    private int Tiempo_Experiencia;
    private double Salario;
    private final Conexion cn = new Conexion("centro_odontologico", "root", "");

    public Odontologos(String Nombres, String Apellidos, long N_Documento, int Telefono, String Correo, String Direccion, int Tiempo_Experiencia, double Salario) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.N_Documento = N_Documento;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Tiempo_Experiencia = Tiempo_Experiencia;
        this.Salario = Salario;
        
    }

    public Odontologos() {
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

    public void setTelefono(int Telefono) {
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

    public int getTiempo_Experiencia() {
        return Tiempo_Experiencia;
    }

    public void setTiempo_Experiencia(int Tiempo_Experiencia) {
        this.Tiempo_Experiencia = Tiempo_Experiencia;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    @Override
    public String toString() {
        return this.getNombres()+" "+this.getApellidos();
    }
    
    public boolean Nuevo (String Nombres, String Apellidos, long N_Documento, long Telefono, String Correo, String Direccion, int Tiempo_Experiencia, double Salario){
        
        try {
            this.Nombres = Nombres;
            this.Apellidos = Apellidos;
            this.N_Documento = N_Documento;
            this.Telefono = Telefono;
            this.Correo = Correo;
            this.Direccion = Direccion;
            this.Tiempo_Experiencia = Tiempo_Experiencia;
            this.Salario = Salario;
            
            cn.Conectar();
            cn.actualizar("INSERT INTO centro_odontologico.odontologos (NOMBRES, APELLIDOS, TELEFONO, NUMERODEDOCUMENTO, CORREOELECTRONICO, TIEMPODEEXPERIECIA, SALARIO, DIRECCION) "+
                    "VALUES ('"+this.Nombres+"', '"+this.Apellidos+"', "+this.Telefono+" , "+this.N_Documento+", '"+this.Correo+"', "+this.Tiempo_Experiencia+", "+this.Salario+", '"+this.Direccion+"');");
            this.id = cn.getLastId();
            cn.cerrarConexion();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el Odontologo: "+e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
               
       
    }
    
        public boolean Editar (int id, String Nombres, String Apellidos, long N_Documento, long Telefono, String Correo, String Direccion, int Tiempo_Experiencia, double Salario){
            try {
                this.id = id;
                this.Nombres = Nombres;
                this.Apellidos = Apellidos;
                this.N_Documento = N_Documento;
                this.Telefono = Telefono;
                this.Correo = Correo;
                this.Direccion = Direccion;
                this.Tiempo_Experiencia = Tiempo_Experiencia;
                this.Salario = Salario;
                
                cn.Conectar();
                boolean status = cn.actualizar("UPDATE centro_odontologico.odontologos SET NOMBRES = '"+this.Nombres
                        +"', APELLIDOS = '"+this.Apellidos+"', TELEFONO = "+this.Telefono
                        +", NUMERODEDOCUMENTO = "+this.N_Documento+", CORREOELECTRONICO = '"+this.Correo+"', TIEMPODEEXPERIECIA = '"
                        +this.Tiempo_Experiencia+"', SALARIO = "+this.Salario+", DIRECCION = '"+this.Direccion
                        +"' WHERE idODONTOLOGOS = "+this.id+";");
                
                if(status){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el Odontologo", "Actualizar Odontologo", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Odontologo: ", "Error MySQL", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Odontologo: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    
        public boolean Editar (Odontologos odonto){
            try {
                cn.Conectar();
                cn.actualizar("UPDATE centro_odontologico.odontologos SET NOMBRES = '"+odonto.getNombres()
                        +"', APELLIDOS = '"+odonto.getApellidos()+"', TELEFONO = "+odonto.getTelefono()
                        +", NUMERODEDOCUMENTO = "+odonto.getN_Documento()+", TIEMPODEEXPERIECIA = '"
                        +odonto.getTiempo_Experiencia()+"', SALARIO = "+odonto.getSalario()+", DIRECCION = '"+odonto.getDireccion()
                        +"' WHERE idODONTOLOGOS = "+odonto.getApellidos()+";");
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el Odontologo", "Actualizar Odontologo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos del Odontologo: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
    public boolean Eliminar (int idOdontologo){
        this.id = idOdontologo;
        try {
            this.cn.Conectar();
            cn.actualizar("DELETE FROM centro_odontologico.odontologos WHERE `idODONTOLOGOS` = "+this.id+";");
            JOptionPane.showMessageDialog(null, "Se ha ELIMINADO correctamente el Odontologo", "Eliminar Odontologo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public ArrayList<Odontologos> Buscar (String Where){
        ArrayList<Odontologos> listOdontologos = new ArrayList<Odontologos>();
        try {
            this.cn.Conectar();
            this.cn.consultar("SELECT * FROM centro_odontologico.odontologos WHERE "+Where);
            while (cn.getRs().next()){
                Odontologos tmpOdontologo = new Odontologos();
                tmpOdontologo.id = cn.getRs().getInt("idODONTOLOGOS");
                tmpOdontologo.Nombres = cn.getRs().getString("NOMBRES");
                tmpOdontologo.Apellidos = cn.getRs().getString("APELLIDOS");
                tmpOdontologo.Telefono = cn.getRs().getLong("TELEFONO");
                tmpOdontologo.N_Documento = cn.getRs().getLong("NUMERODEDOCUMENTO");
                tmpOdontologo.Correo = cn.getRs().getString("CORREOELECTRONICO");
                tmpOdontologo.Tiempo_Experiencia = cn.getRs().getInt("TIEMPODEEXPERIECIA");
                tmpOdontologo.Salario = cn.getRs().getDouble("SALARIO");
                tmpOdontologo.Direccion = cn.getRs().getString("DIRECCION");
                listOdontologos.add(tmpOdontologo);
            }
            this.cn.cerrarConexion();
            //JOptionPane.showMessageDialog(null, "Se han encontrado resultados de Odontologos", "Buscar Odontologo", JOptionPane.INFORMATION_MESSAGE);
            return listOdontologos;
        } catch (Exception e) {
            System.out.println("Error al Cargar los Datos: "+e.getMessage());
            return null;
        }
    }
    
    public boolean getForId(int Id){
        try {
            this.cn.Conectar();
            cn.consultar("SELECT * FROM centro_odontologico.odontologos WHERE `idODONTOLOGOS` = "+Id+";");
            while (cn.getRs().next()){
                this.id = cn.getRs().getInt("idODONTOLOGOS");
                this.Nombres = cn.getRs().getString("NOMBRES");
                this.Apellidos = cn.getRs().getString("APELLIDOS");
                this.Telefono = cn.getRs().getLong("TELEFONO");
                this.N_Documento = cn.getRs().getLong("NUMERODEDOCUMENTO");
                this.Correo = cn.getRs().getString("CORREOELECTRONICO");
                this.Tiempo_Experiencia = cn.getRs().getInt("TIEMPODEEXPERIECIA");
                this.Salario = cn.getRs().getDouble("SALARIO");
                this.Direccion = cn.getRs().getString("DIRECCION");
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Odontologos getForIdOdontologos(int Id){
        try {
            Odontologos od = new Odontologos();
            this.cn.Conectar();
            cn.consultar("SELECT * FROM centro_odontologico.odontologos WHERE `idODONTOLOGOS` = "+Id+";");
            while (cn.getRs().next()){
                od.id = cn.getRs().getInt("idODONTOLOGOS");
                od.Nombres = cn.getRs().getString("NOMBRES");
                od.Apellidos = cn.getRs().getString("APELLIDOS");
                od.Telefono = cn.getRs().getLong("TELEFONO");
                od.N_Documento = cn.getRs().getLong("NUMERODEDOCUMENTO");
                od.Correo = cn.getRs().getString("CORREOELECTRONICO");
                od.Tiempo_Experiencia = cn.getRs().getInt("TIEMPODEEXPERIECIA");
                od.Salario = cn.getRs().getDouble("SALARIO");
                od.Direccion = cn.getRs().getString("DIRECCION");
            }
            return od;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
