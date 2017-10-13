package com.bnf.webServices.lotusWs.pblisher;

import javax.xml.ws.Endpoint;
import com.bnf.webServices.lotusWs.bnfLotusWsImpl;

public class bnfLotusWsPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:4549/services/lotusWs", new bnfLotusWsImpl());
	}
}
