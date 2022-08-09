package controller;

import model.DirectoryOffice;
import repository.DirectoryOfficeRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("directory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryOfficeController {

    @Inject
    DirectoryOfficeRepository directoryOfficeRepository;

    @GET
    public Response  getAll(){
        List<DirectoryOffice> directoryOffices = directoryOfficeRepository.getAll();
        return Response.ok().entity(directoryOffices).build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response getById(@PathParam("id") Long id) {
        DirectoryOffice directoryOffice = directoryOfficeRepository.findBy(id);
        return Response.ok().entity(directoryOffice).build();
    }
}
