package ru.beleychev.notes.server.web;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring and GWT integration
 * @author beleychev.ilya 17.07.2017   14:42
 */
public class NotesGwtController extends RemoteServiceServlet implements Controller, ServletContextAware {
	private ServletContext servletContext;
	private RemoteService remoteService;
	private Class remoteServiceClass;


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super.doPost(request, response);
		return null;
	}

	@Override
	public String processCall(String payload) throws SerializationException {
		try {
			RPCRequest rpcRequest = RPC.decodeRequest(payload, this.remoteServiceClass);
			// delegate work to the spring injected service
			return RPC.invokeAndEncodeResponse(this.remoteService, rpcRequest.getMethod(), rpcRequest.getParameters());

		} catch (IncompatibleRemoteServiceException exception) {
			getServletContext()
					.log(
							"An IncompatibleRemoteServiceException was thrown while processing this call.",
							exception
					);
			return RPC.encodeResponseForFailure(null, exception);
		}
	}

	@Override
	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setRemoteService(RemoteService remoteService) {
		this.remoteService = remoteService;
		this.remoteServiceClass = this.remoteService.getClass();
	}
}
