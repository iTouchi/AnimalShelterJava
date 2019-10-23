package endpoint;

import com.google.gson.Gson;
import data.ProductStore;
import domain.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductEndpoint {

    private static final Logger log = LoggerFactory.getLogger(ProductEndpoint.class);
    private static ProductStore productStore = ProductStore.getInstance();
    private final Gson gson;

    public ProductEndpoint() {
        gson = new Gson();
    }

    @Path("/{product}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getProduct(@PathParam("product") String product) {
        log.info("GET product called for key: {}", product);
        Product myResponse = productStore.getProduct(product);

        return Response.status(200).entity(gson.toJson(myResponse)).build();
    }

    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllProducts() {
        log.info("GET all called");

        return Response.status(200).entity(gson.toJson(productStore.getAll())).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        log.info("POST add called for key: {}", product.getName());

        productStore.addProduct(product);

        return Response.status(200).entity(gson.toJson(product)).build();
    }
}
