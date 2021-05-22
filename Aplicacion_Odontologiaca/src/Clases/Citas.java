/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DiegoAlonso
 */
public class Citas {
    
    private int id;
    private Date Fecha;
    private String Hora_Inicio;
    private String Hora_Fin;
    private String Tratamiento;
    private Paciente paciente;
    private Odontologos odontologo;
    private Consultorio consultorio;
    private final Conexion cn = new Conexion("centro_odontologico", "root", "");
    

    public Citas(Date Fecha, String Hora_Inicio, String Hora_Fin, String Tratamiento, Paciente paciente, Odontologos odontologo, Consultorio consultorio) {
        this.id = id;
        this.Fecha = Fecha;
        this.Hora_Inicio = Hora_Inicio;
        this.Hora_Fin = Hora_Fin;
        this.Tratamiento = Tratamiento;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.consultorio = consultorio;
    }

    public Citas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(String Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public String getHora_Fin() {
        return Hora_Fin;
    }

    public void setHora_Fin(String Hora_Fin) {
        this.Hora_Fin = Hora_Fin;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologos getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologos odontologo) {
        this.odontologo = odontologo;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public boolean Nuevo (Date Fecha, String Hora_Inicio, String Hora_Fin, String Tratamiento, Paciente paciente, Odontologos odontologo, Consultorio consultorio){
        
        try {
            this.Fecha = Fecha;
            this.Hora_Inicio = Hora_Inicio;
            this.Hora_Fin = Hora_Fin;
            this.Tratamiento = Tratamiento;
            this.paciente = paciente;
            this.odontologo = odontologo;
            this.consultorio = consultorio;
                        
            cn.Conectar();
            cn.actualizar("INSERT INTO `centro_odontologico`.`citas` (`idCITAS`, `FECHA`, `HORADEINICIO`, "
                    + "`HORAFIN`, `TRATAMIENTO`, `PACIENTE_idPACIENTE`, `ODONTOLOGOS_idODONTOLOGOS`, "
                    + "`CONSULTORIO_idCONSULTORIO`) VALUES (NULL, "
                    + "'"+ Utility.DateToString(this.Fecha,"yyyy-MM-dd")+"', "
                    + "'"+this.Hora_Inicio+"', '"+this.Hora_Fin+"', '"+this.Tratamiento+"', "
                    + "'"+this.paciente.getId()+"', '"+this.getOdontologo().getId()+"', "
                    + "'"+this.getConsultorio().getId()+"');");
            this.id = cn.getLastId();
            cn.cerrarConexion();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear la cita: "+e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
               
       
    }
    
        public boolean Editar (int id, Date Fecha, String Hora_Inicio, String Hora_Fin, String Tratamiento, Paciente paciente, Odontologos odontologo, Consultorio consultorio){
            try {
                this.id = id;
                this.Fecha = Fecha;
                this.Hora_Inicio = Hora_Inicio;
                this.Hora_Fin = Hora_Fin;
                this.Tratamiento = Tratamiento;
                this.paciente = paciente;
                this.odontologo = odontologo;
                this.consultorio = consultorio;
                
                cn.Conectar();
                boolean status = cn.actualizar("UPDATE `centro_odontologico`.`citas` SET "
                        + "`FECHA` = '"+Utility.DateToString(this.Fecha,"yyyy-MM-dd")+"', "
                        + "`HORADEINICIO` = '"+this.Hora_Inicio+"', `HORAFIN` = '"+this.Hora_Fin+"', "
                        + "`TRATAMIENTO` = '"+this.Tratamiento+"', PACIENTE_idPACIENTE = '"+this.paciente.getId()+"', "
                        + "`ODONTOLOGOS_idODONTOLOGOS` = '"+this.odontologo.getId()+"', "
                        + "`CONSULTORIO_idCONSULTORIO` = '"+this.consultorio.getId()+"' WHERE `citas`.`idCITAS` = "+this.getId()+" ");
                if(status){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente la Cita", "Actualizar Cita", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Error al actulizar los datos de la Cita: ", "Error MySQL", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos de la Cita: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    
        public boolean Editar (Citas cita){
            try {
                cn.Conectar();
                boolean status = cn.actualizar("UPDATE `centro_odontologico`.`citas` SET "
                        + "`FECHA` = '"+Utility.DateToString(cita.Fecha,"yyyy-MM-dd")+"', "
                        + "`HORADEINICIO` = '"+cita.Hora_Inicio+"', `HORAFIN` = '"+cita.Hora_Fin+"', "
                        + "`TRATAMIENTO` = '"+cita.Tratamiento+"', PACIENTE_idPACIENTE = '"+cita.paciente.getId()+"', "
                        + "`ODONTOLOGOS_idODONTOLOGOS` = '"+cita.odontologo.getId()+"', "
                        + "`CONSULTORIO_idCONSULTORIO` = '"+cita.consultorio.getId()+"' WHERE `citas`.`idCITAS` = "+cita.getId()+" ");
                if(status){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente la Cita", "Actualizar Cita", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Error al actulizar los datos de la Cita: ", "Error MySQL", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actulizar los datos de la Cita: "+e, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
    public boolean Eliminar (int idCita){
        this.id = idCita;
        try {
            this.cn.Conectar();
            cn.actualizar("DELETE FROM centro_odontologico.citas WHERE citas.idCITAS = '"+this.id+"'");
            JOptionPane.showMessageDialog(null, "Se ha ELIMINADO correctamente la Cita", "Eliminar Cita", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    

    public ArrayList<Citas> Buscar (String Where){
        ArrayList<Citas> listCitas = new ArrayList<Citas>();
        try {
            this.cn.Conectar();
            this.cn.consultar("SELECT * FROM centro_odontologico.citas WHERE "+Where);
            while (cn.getRs().next()){         
                Citas tmpCita = new Citas();
                tmpCita.id = cn.getRs().getInt("idCITAS");
                tmpCita.Fecha = cn.getRs().getDate("FECHA");
                tmpCita.Hora_Inicio = cn.getRs().getString("HORADEINICIO");
                tmpCita.Hora_Fin = cn.getRs().getString("HORAFIN");
                tmpCita.Tratamiento = cn.getRs().getString("TRATAMIENTO");
                
                int idPaciente = cn.getRs().getInt("PACIENTE_idPACIENTE");                
                tmpCita.paciente = new Paciente().getForIdPaciente(idPaciente);
                                
                int idOdontologo = cn.getRs().getInt("ODONTOLOGOS_idODONTOLOGOS");
                tmpCita.odontologo = new Odontologos().getForIdOdontologos(idOdontologo);
                
                int idConsultorio = cn.getRs().getInt("CONSULTORIO_idCONSULTORIO");
                tmpCita.consultorio = new Consultorio().getForIdConsultorio(idConsultorio);
                listCitas.add(tmpCita);
            }
            this.cn.cerrarConexion();
            //JOptionPane.showMessageDialog(null, "Se han encontrado resultados de Odontologos", "Buscar Odontologo", JOptionPane.INFORMATION_MESSAGE);
            return listCitas;
        } catch (Exception e) {
            System.out.println("Error al Cargar los Datos: "+e.getMessage());
            return null;
        }
    }

    public ArrayList<Citas> BuscarVistaCita (String Where, String vista){
        ArrayList<Citas> listCitas = new ArrayList<Citas>();
        try {
            this.cn.Conectar();
            this.cn.consultar("SELECT * FROM "+vista+" WHERE "+Where);
            while (cn.getRs().next()){         
                Citas tmpCita = new Citas();
                tmpCita.id = cn.getRs().getInt("idCITAS");
                tmpCita.Fecha = cn.getRs().getDate("FECHA");
                tmpCita.Hora_Inicio = cn.getRs().getString("HORADEINICIO");
                tmpCita.Hora_Fin = cn.getRs().getString("HORAFIN");
                tmpCita.Tratamiento = cn.getRs().getString("TRATAMIENTO");
                
                int idPaciente = cn.getRs().getInt("PACIENTE_idPACIENTE");
                tmpCita.paciente = new Paciente().getForIdPaciente(idPaciente);
                System.out.println(tmpCita.paciente.getNombres());
                
                int idOdontologo = cn.getRs().getInt("ODONTOLOGOS_idODONTOLOGOS");
                tmpCita.odontologo = new Odontologos().getForIdOdontologos(idOdontologo);
                
                int idConsultorio = cn.getRs().getInt("CONSULTORIO_idCONSULTORIO");
                tmpCita.consultorio = new Consultorio().getForIdConsultorio(idConsultorio);
                listCitas.add(tmpCita);
            }
            this.cn.cerrarConexion();
            return listCitas;
        } catch (Exception e) {
            System.out.println("Error al Cargar los Datos: "+e.getMessage());
            return null;
        }
    }
    
    public boolean getForId(int Id){
        try {
            this.cn.Conectar();
            cn.consultar("SELECT * FROM centro_odontologico.citas WHERE `idCITAS` = "+Id+";");
            while (cn.getRs().next()){
                this.id = cn.getRs().getInt("idCONSULTORIO");
                this.Fecha = cn.getRs().getDate("FECHA");
                this.Hora_Inicio = cn.getRs().getString("HORADEINICIO");
                this.Hora_Fin = cn.getRs().getString("HORAFIN");
                this.Tratamiento = cn.getRs().getString("TRATAMIENTO");
                
                int idPaciente = cn.getRs().getInt("PACIENTE_idPACIENTE");
                this.paciente = new Paciente().getForIdPaciente(idPaciente);

                int idOdontologo = cn.getRs().getInt("ODONTOLOGOS_idODONTOLOGOS");
                this.odontologo = new Odontologos().getForIdOdontologos(idOdontologo);
                
                int idConsultorio = cn.getRs().getInt("CONSULTORIO_idCONSULTORIO");
                this.consultorio = new Consultorio().getForIdConsultorio(idConsultorio);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return Fecha + " - " + Hora_Inicio + " a " + Hora_Fin + " : " + paciente.getNombres() + " - " + odontologo.getNombres();
    }
    
    
    
}
