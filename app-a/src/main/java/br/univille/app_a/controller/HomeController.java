package br.univille.app_a.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @GetMapping("/startASync")
    public ResponseEntity startASync(){
        System.out.println("App A Start");
        try(DaprClient client = new DaprClientBuilder().build()) {
            var mensagem = "Hello from App A";
            client.invokeMethod("app-b", "/api/v1/startBSync",
                mensagem, HttpExtension.POST).block();
        }catch (Exception e ) { 
            e.printStackTrace();
        }
            
        return ResponseEntity.ok().build();
    }

      @PostMapping("/pub")
    public ResponseEntity startAASync() {
        System.out.println("App A started");
        try(DaprClient daprClient = new DaprClientBuilder().build()){
            var message = "Hello from App A";
            daprClient.publishEvent("pubsub-dapr", "topicodapr", message).block();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.status(500).body("Error starting App A");
        }
        return ResponseEntity.ok().body("App A started");
    }
}
