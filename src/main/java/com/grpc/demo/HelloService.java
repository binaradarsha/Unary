package com.grpc.demo;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class HelloService extends HelloGrpc.HelloImplBase {

    private final static Logger logger = Logger.getLogger(HelloService.class.getName());

    @Override
    public void greet(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        // Retrieve input
        String name = request.getName();
        logger.info("Got request: " + name);

        // Prepare output
        String greeting = "Hello, " + name + "!";
        HelloResponse response = HelloResponse.newBuilder().setReply(greeting).build();

        // Send response via StreamObserver
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
