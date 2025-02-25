package myserver.core;

import myserver.core.httprequesthandler.HttpRequest;
import myserver.core.httprequesthandler.HttpRequestHandler;
import myserver.core.httprequesthandler.HttpRequestHandlerImpl;
import myserver.core.httpresponsehandler.HttpResponse;
import myserver.core.httpresponsehandler.HttpResponseHandler;
import myserver.core.httpresponsehandler.HttpResponseHandlerImpl;
import myserver.core.parser.Parser;
import myserver.core.parser.ParserImpl;
import myserver.core.webserver.WebServer;
import myserver.core.webserver.WebServerImpl;

public class ServerConfig {

    public WebServer webServer(){
        return new WebServerImpl(7777, httpRequestHandlerManager(), httpResponseHandlerManager());
    }

    public HttpRequestHandler httpRequestHandlerManager(){
        return new HttpRequestHandlerImpl(httpRequest());
    }

    public HttpResponseHandler httpResponseHandlerManager() {
        return new HttpResponseHandlerImpl(httpResponse());
    }

    public Parser parser() {
        return new ParserImpl();
    }

    public HttpRequest httpRequest() {
        return new HttpRequest();
    }

    public HttpResponse httpResponse() {
        return new HttpResponse();
    }

}
