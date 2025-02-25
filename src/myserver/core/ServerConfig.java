package myserver.core;

import myserver.core.httpenum.HttpMethod;
import myserver.core.httprequesthandler.HttpRequestGet;
import myserver.core.httprequesthandler.HttpRequest;
import myserver.core.httprequesthandler.HttpRequestHandler;
import myserver.core.httprequesthandler.HttpRequestHandlerImpl;
import myserver.core.httpresponsehandler.HttpResponseGet;
import myserver.core.httpresponsehandler.HttpResponse;
import myserver.core.httpresponsehandler.HttpResponseHandler;
import myserver.core.httpresponsehandler.HttpResponseHandlerImpl;
import myserver.core.parser.Parser;
import myserver.core.parser.ParserImpl;
import myserver.core.webserver.WebServer;
import myserver.core.webserver.WebServerImpl;

import java.util.HashMap;

public class ServerConfig {

    public WebServer webServer(){
        return new WebServerImpl(7777, httpRequestHandlerManager(), httpResponseHandlerManager());
    }

    public HttpRequestHandler httpRequestHandlerManager(){

        HashMap<HttpMethod, HttpRequest> requestHandlers = new HashMap<>();

        HttpRequestGet httpRequestGetHandler = new HttpRequestGet();
        requestHandlers.put(HttpMethod.GET, httpRequestGetHandler);

        return new HttpRequestHandlerImpl(parser(), requestHandlers);
    }

    public HttpResponseHandler httpResponseHandlerManager() {

        HashMap<HttpMethod, HttpResponse> responseHandlers = new HashMap<>();

        HttpResponseGet httpResponseGetHandler = new HttpResponseGet();
        responseHandlers.put(HttpMethod.GET, httpResponseGetHandler);

        return new HttpResponseHandlerImpl(parser(), responseHandlers);
    }

    public Parser parser() {
        return new ParserImpl();
    }

}
