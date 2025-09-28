package com.naman.mcp.mcp_spring.controller;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@RestController
public class McpController {

    @Tool(name = "StringEncoder", description = "this method takes one string and encode it using Base64")
    @GetMapping(value = "/encode/{input}")
    public String getEncoder(@PathVariable String input) {
        String encodedString = "";
        try {
            // Get the byte array of the string, specifying UTF-8 encoding
            byte[] stringBytes = input.getBytes("UTF-8");

            // Get a Base64 Encoder instance
            Base64.Encoder encoder = Base64.getEncoder();

            // Encode the byte array to a Base64 string
            encodedString = encoder.encodeToString(stringBytes);

            System.out.println("Original String: " + input);
            System.out.println("Base64 Encoded String: " + encodedString);

        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding not supported: " + e.getMessage());
        }
        return encodedString;
    }

    @Tool(name = "FunnyStringGenerator", description = "this method generates a funny string based on the given topic")
    @GetMapping(value = "/funny/{input}")
    public String generateFunnyString(@PathVariable String input) {
        String output = "Why did the " + input + " cross the road? To get to the other side!";
        System.out.println(output);
        return output;
    }   
}
