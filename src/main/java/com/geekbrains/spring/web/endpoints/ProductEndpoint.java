package com.geekbrains.spring.web.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

import com.geekbrains.spring.web.services.ProductsService;
import com.geekbrains.spring.web.soap.product.GetAllProductsRequest;
import com.geekbrains.spring.web.soap.product.GetAllProductsResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private final ProductsService productsService;
    private static final String NAMESPACE_URI = "http://www.flamexander.com/spring/ws/products";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        productsService.getAllProducts().forEach(response.getProducts()::add);
        return response;
    }


}

    /*
        Пример запроса: POST http://localhost:8189/app/ws
        Header -> Content-Type: text/xml

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.flamexander
        .com/spring/ws/products">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllProductsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
     */

