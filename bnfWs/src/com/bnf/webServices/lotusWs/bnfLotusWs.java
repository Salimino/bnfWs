/**
 * 
 */
package com.bnf.webServices.lotusWs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @author 
 *
 */
@WebService
@SOAPBinding(style=Style.RPC)
public interface bnfLotusWs {
	
	/**
	 * @param libCode
	 * @return
	 */
	@WebMethod String getLibPoste(@WebParam(name="libCode") String libCode);
}