package com.bnf.webServices.lotusWs;

import java.io.File;

import javax.jws.WebService;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.hraccess.openhr.HRSessionFactory;
import com.hraccess.openhr.IHRSession;
import com.hraccess.openhr.exception.SessionBuildException;
import com.hraccess.openhr.exception.SessionConnectionException;

@WebService(endpointInterface = "com.bnf.webServices.lotusWs.bnfLotusWs")
public class bnfLotusWsImpl implements bnfLotusWs {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bnf.webServices.lotusWs.bnfLotusWs#getLibPoste(java.lang.String)
	 */
	@Override
	public String getLibPoste(String libCode) {
		// TODO Auto-generated method stub
		// Creation session OpenHR
		IHRSession openHrSession;
		File openHrConfFile = new File("/Users/salimchouaf/git/bnfWs/bnfWs/conf/openhr.properties");
		try {
			Configuration openHrSessionConf = new PropertiesConfiguration(openHrConfFile);
			openHrSession = HRSessionFactory.getFactory().createSession(openHrSessionConf);
		} catch (ConfigurationException | SessionBuildException | SessionConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Libelle TOTO";
	}
}
