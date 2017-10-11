package com.bnf.webServices.lotusWs;

import javax.jws.WebService;

@WebService (endpointInterface = "com.bnf.webServices.lotusWs.bnfLotusWs")
public class bnfLotusWsImpl implements bnfLotusWs{

	@Override
	public String getLibPoste(String libCode) {
		// TODO Auto-generated method stub
		return "Libelle TOTO";
	}

}
