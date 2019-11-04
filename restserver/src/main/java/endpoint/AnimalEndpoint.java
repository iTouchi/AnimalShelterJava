package endpoint;

import com.google.gson.Gson;
import data.ProductStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/animal")
public class AnimalEndpoint {

    private static final Logger log = LoggerFactory.getLogger(AnimalEndpoint.class);
    private static ProductStore productStore = ProductStore.getInstance();
    private final Gson gson;

    public AnimalEndpoint() {
        gson = new Gson();
    }

    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAnimal() {
        log.info("GET animal");
        return Response.status(200).build();
    }
}
