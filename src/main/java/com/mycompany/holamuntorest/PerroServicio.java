package com.mycompany.holamuntorest;

import com.mycompany.jpa.Perro;
import edu.sergioArboleda.exception.ConexionException;
import edu.sergioArboleda.facade.PerroFacade;
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
import org.o7planning.restfulcrud.model.PerroDTO;

/**
 *
 * @author Nicolas Chicuazuque
 */
@Path("/misperros")
public class PerroServicio {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public List<PerroDTO> getPerro_JSON() throws ConexionException {
        List<PerroDTO> PerretesDTO = new ArrayList<PerroDTO>();
        PerroFacade facade = null;

        facade = new PerroFacade();
        List<Perro> perretes = facade.findAll();
        for (Perro perro : perretes) {
            PerroDTO dto = new PerroDTO();
            dto.setId(perro.getId());
            dto.setRaza(perro.getRaza());
            dto.setPersonalidad(perro.getPersonalidad());
            dto.setEnergia(perro.getEnergia());
            dto.setDescripcion(perro.getDescripcion());
            PerretesDTO.add(dto);
        }

        return PerretesDTO;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PerroDTO getPerro(@PathParam("id") String id) throws ConexionException {
        PerroFacade facade = null;
        PerroDTO dto = null;

        facade = new PerroFacade();
        Perro perrete = facade.get(Integer.parseInt(id));
        dto = new PerroDTO();
        dto.setId(perrete.getId());
        dto.setRaza(perrete.getRaza());
        dto.setPersonalidad(perrete.getPersonalidad());
        dto.setEnergia(perrete.getEnergia());
        dto.setDescripcion(perrete.getDescripcion());

        return dto;
    }

    // URI:
    // /contextPath/servletPath/misperros
    /*
        PARA POSTMAN localhost:8090/PerrosApp/rest/comentario
    {   
        "id": "2",
        "autor": "Napoleon Ruiz",
        "fecha": "19/07/1602",
        "contenido": "Que lindos perritos joven."
    }
    */
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PerroDTO addStudent(PerroDTO perretes) throws ConexionException {
        PerroFacade facade = null;
        PerroDTO dto = null;

        facade = new PerroFacade();
        Perro studentJPA = new Perro();
        studentJPA.setId(perretes.getId());
        studentJPA.setRaza(perretes.getRaza());
        studentJPA.setPersonalidad(perretes.getPersonalidad());
        studentJPA.setEnergia(perretes.getEnergia());
        studentJPA.setDescripcion(perretes.getDescripcion());
        facade.save(studentJPA);

        return dto;
    }

}
