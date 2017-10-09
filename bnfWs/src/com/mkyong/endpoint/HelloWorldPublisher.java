package com.mkyong.endpoint;

import javax.xml.ws.Endpoint;
import com.mkyong.ws.HelloWorldImpl;

//Endpoint publisher
public class HelloWorldPublisher{

	public static void main(String[] args) {
	   Endpoint.publish("http://MBPdeSaimChouaf:9996/ws/hello", new HelloWorldImpl());
	   System.out.println("deployed");
    }

}