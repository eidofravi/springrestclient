package com.rest;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class _8PostCreateAllEmployee {
    public static void main(String[] args) {
        final String uri = "http://localhost:8081/api/employee/createAll";
        final String payload = "[{\"firstName\":\"ravi\",\"employeeId\":111}," +
                "{\"firstName\":\"toni\",\"employeeId\":222}" +
                ",{\"firstName\":\"mona\",\"employeeId\":333}]";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(payload, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

        System.out.println(result);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
    }
}
