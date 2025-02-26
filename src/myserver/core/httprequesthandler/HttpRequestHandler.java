package myserver.core.httprequesthandler;

import myserver.core.httpenum.HttpMessage;

import java.io.IOException;
import java.net.Socket;

public interface HttpRequestHandler {
    HttpRequest selectRequestHandler(Socket socket);
    HttpMessage validHttpRequest(Socket socket);
}
