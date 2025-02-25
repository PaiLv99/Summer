package myserver.core.httprequesthandler;

import myserver.core.httpenum.HttpMethod;
import myserver.core.parser.Parser;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class HttpRequestHandlerImpl implements HttpRequestHandler {

    private final Parser parser;
    private final HashMap<HttpMethod, HttpRequest> httpRequestHandlers;

    public HttpRequestHandlerImpl(Parser parser, HashMap<HttpMethod, HttpRequest> httpRequestHandlers) {
        this.parser = parser;
        this.httpRequestHandlers = httpRequestHandlers;
    }

    @Override
    public HttpRequest selectRequestHandler(Socket socket) throws IOException {

        HttpMethod method = parser.parse(socket);

        HttpRequest httpRequestHandler = httpRequestHandlers.get(method);

        httpRequestHandler.setRequestHandler(socket);

        return httpRequestHandler;
    }
}
