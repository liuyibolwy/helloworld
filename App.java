package com.ricebook.main;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.servlet.GrizzlyWebContainerFactory;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

import com.ricebook.resource.UserResource;

/**
 * Created by liuyb on 16/12/26.
 */
public class App {
    private static final URI BASE_URI = URI.create("http://localhost:8080/webapp/");
    public static final String ROOT_PATH = "users";

    public static void main(String[] args) {
        System.out.println("主程序入口!");
        try {

            Map<String, String> initParams = new HashMap<String, String>();
            initParams.put(ServerProperties.PROVIDER_PACKAGES,  UserResource.class.getPackage().getName());

            final HttpServer server = GrizzlyWebContainerFactory.create(BASE_URI, ServletContainer.class, initParams);

            System.out.println(String.format("Application started.%nTry out %s%s%nHit enter to stop it...",
                    BASE_URI, ROOT_PATH));
            System.in.read();
            server.shutdownNow();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
