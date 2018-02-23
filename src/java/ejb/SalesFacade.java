package ejb;

import bean.Sale;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SalesFacade {

    @PersistenceContext(unitName = "frontEndPU")
     private EntityManager emMySql;
    
    public List<Sale> listVentas() {
        try {
            String query = "SELECT * FROM sale";
            List<Object[]> resultado = emMySql.createNativeQuery(query).getResultList();
            List<Sale> listadoVentas = new ArrayList<>();
            for (int i = 0; i < resultado.size(); i++) {
                Object[] fila = resultado.get(i);
                Sale e = new Sale();
                e.setSaleId(Integer.parseInt(String.valueOf(fila[0])));
                e.setProductId(Integer.parseInt(String.valueOf(fila[1])));
                e.setTotalSale(Integer.parseInt(String.valueOf(fila[2])));
                listadoVentas.add(e);
            }
            return listadoVentas.size()<= 0 ? null : listadoVentas;

        } catch (NumberFormatException e) {
            Logger.getLogger(SalesFacade.class.getName()).log(Level.SEVERE, "Fallo en el listado de ventas", e);
            return null;
        }
    }



}
