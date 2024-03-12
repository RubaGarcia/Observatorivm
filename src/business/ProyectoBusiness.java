package observatorio.business;

//Importamos el modelo de dominio del objeto y el data mapper
import observatorio.persistenceLayer.ProyectoDataMapper;

import observatorio.domain.Proyecto;
import observatorio.domain.DesglosePresupuesto;
import observatorio.domain.DesgloseGastos;

import java.sql.Date;

/**
 * 
 */
public class ProyectoBusiness {
    
    
    /**
     * 
     * @param id
     * @param fechaIni
     * @param fechaFin
     * @param estadoProyecto
     * @param fechaFinEstimada
     * @param descripcion
     * @return
     */
    public boolean newProyecto(String id, Date fechaIni, Date fechaFin, String estadoProyecto, Date fechaFinEstimada,
            String descripcion) {
        

        Proyecto p = new Proyecto(id, fechaIni, fechaFin, estadoProyecto
            , fechaFinEstimada, descripcion);
        
        return new ProyectoDataMapper().creaProyecto(p);
    }

    /**
     * 
     * @param id
     * @param fechaIni
     * @param fechaFin
     * @param estadoProyecto
     * @param fechaFinEstimada
     * @param descripcion
     * @return
     */
    public boolean actualizaProyecto(String id, Date fechaIni, Date fechaFin, 
    String estadoProyecto, Date fechaFinEstimada, String descripcion){
        return new ProyectoDataMapper().actualizaProyecto(new Proyecto(id, fechaIni, fechaFin, estadoProyecto, fechaFinEstimada, descripcion));
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean eliminaProyecto(String id){
        return new ProyectoDataMapper().eliminarProyecto(id);
    }

    /**
     * 
     * @param idProyecto
     * @param cantidad
     * @param descripcion
     * @param numeroDesglose
     * @return
     */
    public boolean actualizarPresupuesto(String idProyecto, float cantidad,
         String descripcion, String numeroDesglose){
        

        DesglosePresupuesto dp = new DesglosePresupuesto(idProyecto, cantidad, descripcion, numeroDesglose);

        return new ProyectoDataMapper().actualizarPresupuesto(dp);
    }

    /**
     * 
     * @param idProyecto
     * @param cantidad
     * @param descripcion
     * @param numeroDesglose
     * @return
     */

    public boolean registroGasto(String idProyecto, float cantidad, String descripcion, String numeroDesglose){

        DesgloseGastos dg = new DesgloseGastos(idProyecto, cantidad, descripcion, numeroDesglose);
        return new ProyectoDataMapper().registroGasto(dg);
    }
}
