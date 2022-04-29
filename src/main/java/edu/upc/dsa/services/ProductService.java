package edu.upc.dsa.services;


import edu.upc.dsa.ProductManager;
import edu.upc.dsa.ProductManagerImpl;
import edu.upc.dsa.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/product", description = "Endpoint to Track Service")
@Path("/product")
public class ProductService {

    private ProductManagerImpl tm;

    public ProductService() {
        this.tm = ProductManagerImpl.getInstance();
        if (tm.productSize()==0) {
            this.tm.addProduct("donut", 1.5);
            this.tm.addProduct("bocata", 2);
            this.tm.addProduct("cafe", 0.9);

        }


    }

    @GET
    @ApiOperation(value = "get all Products ordered by price")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/price")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByPrice() {

        List<Product> productsPrice = this.tm.getListProductsByPrice();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(productsPrice) {};
        return Response.status(201).entity(entity).build();

    }
    @GET
    @ApiOperation(value = "get all Products ordered by sells")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/sells")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsBySells() {

        List<Product> productsSells = this.tm.getListProductsByPrice();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(productsSells) {};
        return Response.status(201).entity(entity).build();

    }

//    @GET
//    @ApiOperation(value = "get a Product", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Product.class),
//            @ApiResponse(code = 404, message = "Track not found")
//    })
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getProduct(@PathParam("id") String id) {
//        Product t = this.tm.getProduct(id);
//        if (t == null) return Response.status(404).build();
//        else  return Response.status(201).entity(t).build();
//    }

//    @DELETE
//    @ApiOperation(value = "delete a Track", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful"),
//            @ApiResponse(code = 404, message = "Track not found")
//    })
//    @Path("/{id}")
//    public Response deleteTrack(@PathParam("id") String id) {
//        Product t = this.tm.getTrack(id);
//        if (t == null) return Response.status(404).build();
//        else this.tm.deleteTrack(id);
//        return Response.status(201).build();
//    }
//
//    @PUT
//    @ApiOperation(value = "update a Track", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful"),
//            @ApiResponse(code = 404, message = "Track not found")
//    })
//    @Path("/")
//    public Response updateTrack(Product track) {
//
//        Product t = this.tm.updateTrack(track);
//
//        if (t == null) return Response.status(404).build();
//
//        return Response.status(201).build();
//    }
//
//
//
//    @POST
//    @ApiOperation(value = "create a new Track", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response= Product.class),
//            @ApiResponse(code = 500, message = "Validation Error")
//
//    })
//
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response newTrack(Product track) {
//
//        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
//        this.tm.addTrack(track);
//        return Response.status(201).entity(track).build();
//    }

}