package controller;

import model.DirectoryOffice;
import repository.DirectoryOfficeRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
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

    @POST
    public Response save(@Valid DirectoryOffice directoryOffice) {
        try {
        directoryOfficeRepository.save(directoryOffice);
        return Response.ok().entity(directoryOffice).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response updated(@PathParam("id") Long id, @Valid DirectoryOffice directoryOffice) {
        try {

        DirectoryOffice tempDirectoryOffice = directoryOfficeRepository.findBy(id);

        if (tempDirectoryOffice == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(directoryOffice.getDirectoryName() != null) {
            tempDirectoryOffice.setDirectoryName(directoryOffice.getDirectoryName());
        }

        if(directoryOffice.getAddressLine() != null) {
            tempDirectoryOffice.setAddressLine(directoryOffice.getAddressLine());
        }

        if(directoryOffice.getCountry() != null) {
            tempDirectoryOffice.setCountry(directoryOffice.getCountry());
        }

        if(directoryOffice.getState() != null) {
            tempDirectoryOffice.setState(directoryOffice.getState());
        }

        if(directoryOffice.getCity() != null) {
            tempDirectoryOffice.setCity(directoryOffice.getCity());
        }

        if(directoryOffice.getZone() != null) {
            tempDirectoryOffice.setZone(directoryOffice.getZone());
        }

        if(directoryOffice.getPhone() != null) {
            tempDirectoryOffice.setPhone(directoryOffice.getPhone());
        }

        if(directoryOffice.getPhone2() != null) {
            tempDirectoryOffice.setPhone2(directoryOffice.getPhone2());
        }

        tempDirectoryOffice.setUpdatedAt(LocalDateTime.now());

        directoryOfficeRepository.save(tempDirectoryOffice);

        return Response.ok().entity(tempDirectoryOffice).build();

    } catch (Exception ex) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    }
}
