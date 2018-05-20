package com.mycompany.holamuntorest;

import com.mycompany.jpa.Comentario;
import edu.sergioArboleda.exception.ConexionException;
import edu.sergioArboleda.facade.ComentarioFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.o7planning.restfulcrud.model.ComentarioDTO;

/**
 *
 * @author Nicolas Chicuazuque
 */
@Path("/comentario")
public class ComentarioServicio {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public List<ComentarioDTO> getPerro_JSON() throws ConexionException {
        List<ComentarioDTO> ComentsDTO = new ArrayList<ComentarioDTO>();
        ComentarioFacade facade = null;

        facade = new ComentarioFacade();
        List<Comentario> coments = facade.findAll();
        for (Comentario comentarios : coments) {
            ComentarioDTO dtoC = new ComentarioDTO();
            dtoC.setId(comentarios.getId());
            dtoC.setAutor(comentarios.getAutor());
            dtoC.setFecha(comentarios.getFecha());
            dtoC.setContenido(comentarios.getContenido());
            ComentsDTO.add(dtoC);
        }

        return ComentsDTO;
    }

    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ComentarioDTO addStudent(ComentarioDTO coments) throws ConexionException {
        ComentarioFacade facade = null;
        ComentarioDTO dto = null;

        facade = new ComentarioFacade();
        Comentario studentJPA = new Comentario();
        studentJPA.setId(coments.getId());
        studentJPA.setAutor(coments.getAutor());
        studentJPA.setFecha(coments.getFecha());
        studentJPA.setContenido(coments.getContenido());
        facade.save(studentJPA);

        return dto;
    }
}
