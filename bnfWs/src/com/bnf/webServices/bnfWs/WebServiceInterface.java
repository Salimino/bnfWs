/**
 * 
 */
package com.bnf.webServices.bnfWs;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


/**
 * @author salimchouaf
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {
	@WebMethod String getHelloWorldAsString(String str);
}
