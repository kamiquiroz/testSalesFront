package controller;

import bean.Sale;
import ejb.SalesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "listadosController")
@SessionScoped
public class SaleController implements Serializable{

    @EJB
    private SalesFacade modelVentas;

    private List<Sale> listadoVentas;

    /**
     * @return the listadoVentas
     */
    public List<Sale> getListadoVentas() {
         try {
            listadoVentas = modelVentas.listVentas();
        } catch (Exception ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, "Error", ex);
        }
        return listadoVentas;
    }

    /**
     * @param listadoVentas the listadoVentas to set
     */
    public void setListadoVentas(List<Sale> listadoVentas) {
        this.listadoVentas = listadoVentas;
    }
    
}
