package org.nobleson;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.nobleson.controllers.UserController;

public class EmbeddedJettyServer {
    public static void main(String[] args)  throws Exception{
        Server server = new Server(8091);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        server.setHandler(context);
        context.addServlet(new ServletHolder(new Main()), "/hello");
        context.addServlet(new ServletHolder(new DatabaseServlet()), "/database");
        context.addServlet(new ServletHolder(new UserController()), "/api/users/*");


        //Start the Jetty server
        server.start();
        server.join();
    }
}
