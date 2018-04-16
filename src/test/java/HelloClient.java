import com.grpc.demo.HelloGrpc;
import com.grpc.demo.HelloRequest;
import com.grpc.demo.HelloResponse;
import com.grpc.demo.HelloServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    private final static String HOST = "localhost";
//    private final static String HOST = "35.200.139.92";

    public static void main(String[] args) {
        // Creating the channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, HelloServer.PORT)
                .usePlaintext(true)
                .build();

        // Retrieving the service stub
        HelloGrpc.HelloBlockingStub blockingStub = HelloGrpc.newBlockingStub(channel);

        // Creating the request
        String name = "Binara";
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        // Invoking the service method with passing the request object
        HelloResponse response = blockingStub.greet(request);

        System.out.println("\n>>> Response = " + response.getReply());
    }

}
