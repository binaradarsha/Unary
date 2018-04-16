package com.grpc.demo;

import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class HelloServer {

    public final static int PORT = 60000;

    private final static Logger logger = Logger.getLogger(HelloServer.class.getName());

    public static void main(String[] args) {
        try {

            logger.info("Grpc server started listening on port " + PORT);

            ServerBuilder.forPort(PORT)
                    .addService(new HelloService())
                    .build()
                    .start()
                    .awaitTermination();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
