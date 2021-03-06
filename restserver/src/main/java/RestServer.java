import endpoint.AnimalEndpoint;
import endpoint.ProductEndpoint;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestServer {

    private static final Logger log = LoggerFactory.getLogger(RestServer.class);

    public static void main(String[] args) throws Exception {
        Server server = new Server(8091);

        server.setHandler(getJerseyHandler());

        server.start();
        log.info("Server started");

        server.join();
        log.info("Server joined");
    }

    private static Handler getJerseyHandler() {
        log.info("Create Jersey Handler");
        ServletContextHandler handler = new ServletContextHandler(
                ServletContextHandler.SESSIONS);

        handler.setContextPath("/");

        ServletHolder servletHolder = handler.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitOrder(0);
//        servletHolder.setInitParameter("jersey.config.server.provider.classnames",
//                SimpleRestEndpoint.class.getCanonicalName());

        var endPoints = new String[]{
                AnimalEndpoint.class.getCanonicalName(),
                ProductEndpoint.class.getCanonicalName()};
        servletHolder.setInitParameter(
                "jersey.config.server.provider.classnames",
                String.join("\n", endPoints));


        return handler;
    }

}
