package edu.upc.dsa.services;


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

//package edu.upc.dsa.services;
//
//        import edu.upc.dsa.models.*;
//        import edu.upc.dsa.GameManager;
//        import edu.upc.dsa.GameManagerImpl;
//        import io.swagger.annotations.Api;
//        import io.swagger.annotations.ApiOperation;
//        import io.swagger.annotations.ApiResponse;
//        import io.swagger.annotations.ApiResponses;
//
//        import javax.ws.rs.*;
//        import javax.ws.rs.core.GenericEntity;
//        import javax.ws.rs.core.MediaType;
//        import javax.ws.rs.core.Response;
//        import java.util.LinkedList;
//        import java.util.List;
//
//@Api(value = "/game", description = "Endpoint to Game Service")
//@Path("/game")
//public class GameService {
//
//    private GameManager manager;
//
//    public GameService() {
//        this.manager = GameManagerImpl.getInstance();
//
//        if (manager.numPunto()==0) {
//            //Añadir objetos disponibles
//            GameManagerImpl.getInstance().addPunto("Puerta");
//            GameManagerImpl.getInstance().addPunto("Casilla");
//        }
//        if(manager.numUsuario()==0) {
//
//            //Crear clientes
//            GameManagerImpl.getInstance().addUsuario("Lorena");
//            GameManagerImpl.getInstance().addUsuario("Julia");
//            GameManagerImpl.getInstance().addUsuario("Paco");
//        }
//
//    }
//
//    @GET
//    @ApiOperation(value = "Listado de usuarios ordenado alfabéticamente", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
//            @ApiResponse(code = 404, message= "Lista de usuarios no encontrada (está vacía)")
//    })
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listarUsuariosOrdenados(){
//
//        List<Usuario> usuarioList = this.manager.listarUsuariosOrdenados();
//        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usuarioList) {};
//
//        if(usuarioList.size() > 0)
//            return Response.status(201).entity(entity).build();
//        return Response.status(404).entity(entity).build();
//    }
//
//    @POST
//    @ApiOperation(value = "Añadir un usuario", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful",response=Usuario.class),
//            @ApiResponse(code = 500, message = "Validation Error")
//
//    })
//
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addUsuario(UsuarioCRUD user) {
//        if (user.getNombre()==null )  return Response.status(500).entity(user).build();
//        this.manager.addUsuario(new Usuario(user.getNombre()));
//        return Response.status(201).entity(user).build();
//    }
//
//    @GET
//    @ApiOperation(value = "Consultar información de un usuario", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
//            @ApiResponse(code = 404, message = "Usuario not found")
//    })
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response consultarInfoUsuario(@PathParam("id") String id) {
//        Usuario user = this.manager.consultarInfoUsuario(id);
//        if (user == null) return Response.status(404).build();
//        else  return Response.status(201).entity(user).build();
//    }
//
//
//    @GET
//    @ApiOperation(value = "Consultar los puntos de interés por los que un usuario pasa", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = PuntoUsuario.class, responseContainer="List"),
//            @ApiResponse(code = 404, message= "Lista de objetos no encontrada (está vacía)")
//    })
//
//
//    @Path("/getPuntos/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listadoObjetosUsuario(@PathParam("id") String id){
//
//        List<PuntoUsuario> objetoList = this.manager.listadoPuntosUsuario(id);
//        GenericEntity<List<PuntoUsuario>> entity = new GenericEntity<List<PuntoUsuario>>(objetoList) {};
//
//        if(objetoList.size() > 0)
//            return Response.status(201).entity(entity).build();
//        else
//            return Response.status(404).entity(entity).build();
//    }
//
//
//    @PUT
//    @ApiOperation(value = "Informar que un usuario pasa por un punto de interés", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Integer.class),
//            @ApiResponse(code = 404, message = "User not found")
//    })
//    @Path("/AddObjeto/{idUser}")
//    public Response addPuntoUsuario(@PathParam("idUser") String idUser, PuntoUsuarioCRUD pUser) {
//
//        Integer res=this.manager.addPuntoUsuario(idUser,pUser.getPunto(),pUser.getFecha());
//
//        if (res!=0) return Response.status(404).build();
//        return Response.status(201).build();
//    }
//
//
//    @GET
//    @ApiOperation(value = "Listado de usuarios que han pasado por un punto de interés", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = UsuarioCRUD.class, responseContainer="List"),
//            @ApiResponse(code = 404, message= "Lista de objetos no encontrada (está vacía)")
//    })
//
//
//    @Path("/getUsuarios/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listadoUsuariosPasan(@PathParam("id") String id){
//
//        List<Usuario> usuarioList = this.manager.listadoUsuariosPasan(id);
//        List<UsuarioCRUD> usuarioList2= new LinkedList<>();
//        for(Usuario user:usuarioList){
//            usuarioList2.add(new UsuarioCRUD(user.getNombre()));
//        }
//        GenericEntity<List<UsuarioCRUD>> entity = new GenericEntity<List<UsuarioCRUD>>(usuarioList2) {};
//
//        if(usuarioList.size() > 0)
//            return Response.status(201).entity(entity).build();
//        else
//            return Response.status(404).entity(entity).build();
//    }
//
//    @GET
//    @ApiOperation(value = "Listado de usuarios ordenado descendentemente por puntos de interés por los que han pasado", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = UsuarioCRUD.class, responseContainer="List"),
//            @ApiResponse(code = 404, message= "Lista de objetos no encontrada (está vacía)")
//    })
//
//
//    @Path("/getUsuarios")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listadoUsuariosPorPuntos(){
//
//        List<Usuario> usuarioList = this.manager.listarUsuariosPuntos();
//        List<UsuarioCRUD> usuarioList2= new LinkedList<>();
//        for(Usuario user:usuarioList){
//            usuarioList2.add(new UsuarioCRUD(user.getNombre()));
//        }
//        GenericEntity<List<UsuarioCRUD>> entity = new GenericEntity<List<UsuarioCRUD>>(usuarioList2) {};
//
//        if(usuarioList.size() > 0)
//            return Response.status(201).entity(entity).build();
//        else
//            return Response.status(404).entity(entity).build();
//    }
//
//
//
//
//
//
//
//}

//package edu.upc.dsa.services;
//
//        import edu.upc.dsa.models.Cliente;
//        import edu.upc.dsa.models.Pedido;
//        import edu.upc.dsa.models.PedidoCRUD;
//        import edu.upc.dsa.models.Producto;
//        import edu.upc.dsa.util.ProductManager;
//        import edu.upc.dsa.util.ProductManagerImpl;
//        import io.swagger.annotations.Api;
//        import io.swagger.annotations.ApiOperation;
//        import io.swagger.annotations.ApiResponse;
//        import io.swagger.annotations.ApiResponses;
//
//        import javax.ws.rs.*;
//        import javax.ws.rs.core.GenericEntity;
//        import javax.ws.rs.core.MediaType;
//        import javax.ws.rs.core.Response;
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Api(value = "/product", description = "Endpoint to Product Service")
//@Path("/product")
//public class ProductService {
//
//    private ProductManager manager;
//
//    public ProductService() {
//        this.manager =ProductManagerImpl.getInstance();
//        //Factory.getProductManager();//
//        if (true){//manager.listarProductosOrdenados().size()==0&&manager.numPedidos()==0) {
//            //Productos
//            this.manager.añadirProductos("Bocadillo", 2.50);
//            this.manager.añadirProductos("Pastel", 1.50);
//            this.manager.añadirProductos("Ensalada", 2.0);
//            //Clientes
//            this.manager.addCliente("Julia");
//            this.manager.addCliente("Paco");
//            this.manager.addCliente("Lorena");
//            //Pedido
//            Pedido p = new Pedido(this.manager.buscarCliente("Julia"));
//            p.addLP(3, "Bocadillo");
//            p.addLP(1, "Ensalada");
//            this.manager.realizarPedido(p);
//            Pedido p2 = new Pedido(this.manager.buscarCliente("Julia"));
//            p2.addLP(2, "Bocadillo");
//            this.manager.realizarPedido(p2);
//            //Servir pedido
//            this.manager.servirPedido();
//        }
//
//    }
//    @Path("basic")
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Got it!";
//    }
//
//    @GET
//    @ApiOperation(value = "get all Productos ordenados precio", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="List"),
//            @ApiResponse(code = 404, message= "Lista de productos no encontrada (está vacía)")
//    })
//    @Path("/get")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listarProductosOrdenados(){
//
//        List<Producto> productoList = this.manager.listarProductosOrdenados();
//        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productoList) {};
//
//        if(productoList.size() > 0)
//            return Response.status(201).entity(entity).build();
//        return Response.status(404).entity(entity).build();
//    }
//
//    @GET
//    @ApiOperation(value = "get all Productos ordenados vendas", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="List"),
//            @ApiResponse(code = 404, message= "Lista de productos no encontrada (está vacía)")
//    })
//    @Path("/getVendas")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listarProductosVendas(){
//
//        List<Producto> productoList = this.manager.listarProductosVendas();
//        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productoList) {};
//
//        if(productoList.size() > 0)
//            return Response.status(201).entity(entity).build();
//        else
//            return Response.status(404).entity(entity).build();
//    }
//
//    @GET
//    @ApiOperation(value = "get listar pedidos cliente", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Pedido.class,responseContainer = "List"),
//            @ApiResponse(code = 404, message = "Track not found")
//    })
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listadoPedidosCliente(@PathParam("id") String id) {
//        List<Pedido> pedidoList = this.manager.listadoPedidosCliente(id);
//        GenericEntity<List<Pedido>> entity = new GenericEntity<List<Pedido>>(pedidoList) {};
//        if (pedidoList.size()==0) return Response.status(404).build();
//        else  return Response.status(201).entity(entity).build();
//    }
//    @POST
//    @ApiOperation(value = "realizar Pedido", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful"),
//            @ApiResponse(code = 500, message = "Validation Error")
//
//    })
//
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response realizarPedido(PedidoCRUD pedidoCRUD) {
//        Pedido pedido =new Pedido(this.manager.buscarCliente(pedidoCRUD.getCliente()));
//        if (pedido.getCliente()==null)  return Response.status(500).build();
//        this.manager.realizarPedido(pedido);
//        return Response.status(201).build();
//    }
//
//
//}