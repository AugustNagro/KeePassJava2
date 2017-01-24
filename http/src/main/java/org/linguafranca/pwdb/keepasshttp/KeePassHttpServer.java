package org.linguafranca.pwdb.keepasshttp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

/**
 * Embedded server
 */
public class KeePassHttpServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector http = new ServerConnector(server);
        http.setHost("0.0.0.0");
        http.setPort(19455);
        http.setIdleTimeout(300000);
        server.addConnector(http);
        server.setHandler(new KeePassHttpHandler());
        server.start();
        server.join();
    }
}