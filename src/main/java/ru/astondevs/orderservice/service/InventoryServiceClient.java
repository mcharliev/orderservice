package ru.astondevs.orderservice.service;

import inventory.Inventory;
import inventory.InventoryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceClient {
    private final InventoryServiceGrpc.InventoryServiceBlockingStub inventoryServiceStub;

    public InventoryServiceClient(@Value("${inventory.grpc.server.address}") String serverAddress,
                                  @Value("${inventory.grpc.server.port}") int serverPort) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();
        this.inventoryServiceStub = InventoryServiceGrpc.newBlockingStub(channel);
    }

    public boolean checkProductAvailability(String productName, int quantity) {
        Inventory.CheckInventoryRequest request = Inventory.CheckInventoryRequest.newBuilder()
                .setProductName(productName)
                .setQuantity(quantity)
                .build();
        try {
            Inventory.CheckInventoryResponse response = inventoryServiceStub.checkInventory(request);
            return response.getAvailable();
        } catch (StatusRuntimeException e) {
            System.err.println("gRPC request failed: " + e.getStatus());
            return false;
        }
    }
}
