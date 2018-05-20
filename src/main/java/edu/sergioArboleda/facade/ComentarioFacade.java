package edu.sergioArboleda.facade;

import com.mycompany.jpa.Comentario;
import edu.sergioArboleda.dao.ServiceImpl;
import edu.sergioArboleda.dao.SingletonConnection;
import edu.sergioArboleda.exception.ConexionException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nicolas Chicuazuque
 */
public class ComentarioFacade extends ServiceImpl<Comentario>{

    public ComentarioFacade() throws ConexionException {
        super(Comentario.class);
        try {
            EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConexionException("Problemas en la realizacion de conexion con la base de datos");
        }
    }

    @Override
    public List<Comentario> findAll() {
        return super.findAll();
    }

}
