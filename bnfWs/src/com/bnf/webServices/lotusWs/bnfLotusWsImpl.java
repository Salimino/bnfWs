package com.bnf.webServices.lotusWs;

import java.io.File;
import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.hraccess.datasource.TDataNode;
import com.hraccess.openhr.HRSessionFactory;
import com.hraccess.openhr.IHRRole;
import com.hraccess.openhr.IHRSession;
import com.hraccess.openhr.IHRUser;
import com.hraccess.openhr.beans.HRExtractionSource;
import com.hraccess.openhr.exception.AuthenticationException;
import com.hraccess.openhr.exception.SessionBuildException;
import com.hraccess.openhr.exception.SessionConnectionException;
import com.hraccess.openhr.exception.UserConnectionException;

@WebService(endpointInterface = "com.bnf.webServices.lotusWs.bnfLotusWs")
public class bnfLotusWsImpl implements bnfLotusWs {

	private static final String USERID = "HR";
	private static final String USERPWD = "HR";
	private IHRSession openHrSession;
	private IHRUser lotusUser;
	private IHRRole lotusUserRole;
	private HRExtractionSource extractionSource;
	private TDataNode node;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bnf.webServices.lotusWs.bnfLotusWs#getLibPoste(java.lang.String)
	 */
	@Override
	public String getLibPoste(String libCode) {
		// TODO Auto-generated method stub
		// Creation session OpenHR

		File openHrConfFile = new File("/Users/salimchouaf/git/bnfWs/bnfWs/conf/openhr.properties");
		openHrSession = creatOpenHrSession(openHrConfFile);
		lotusUser = userConnect(openHrSession, USERID, USERPWD);
		lotusUserRole = lotusUser.getRole("ALLHRLO");
		String getLibPostOrder = "SELECT * FROM ZT00";
		setContext(lotusUser, lotusUserRole);
		execSqlOrder(getLibPostOrder);
		closeContext();
		
		return "Libelle TOTO";
	}

	public IHRSession creatOpenHrSession(File confFile) {
		IHRSession session = null;
		try {
			Configuration openHrSessionConf = new PropertiesConfiguration(confFile);
			session = HRSessionFactory.getFactory().createSession(openHrSessionConf);
		} catch (ConfigurationException | SessionBuildException | SessionConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}

	public IHRUser userConnect(IHRSession session, String userID, String userPwd) {
		IHRUser user = null;
		try {
			user = session.connectUser(userID, userID);
		} catch (AuthenticationException | UserConnectionException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public void setContext(IHRUser userId, IHRRole userRole) {
		extractionSource = new HRExtractionSource(userId.getMainConversation(), userRole);
		extractionSource.setMaxRowCount(500);
	}

	public void closeContext() {
		extractionSource.setActive(false);
	}

	public TDataNode execSqlOrder(String sqlOrder) {
		extractionSource.setSQLExtraction(sqlOrder);
		extractionSource.setActive(true);
		node = extractionSource.getDataNode();
		return node;
	}

	public ArrayList<String> nodeToList(TDataNode node) {
		ArrayList<String> listParam = new ArrayList<String>();
		if (node.first()) {
			do {
				for (int i = 0; i < node.getColumnCount(); i++) {
					listParam.add(new String(node.getValue(i).toString()));
				}
			} while (node.next());
			return listParam;
		} else {
			return null;
		}
	}
}
