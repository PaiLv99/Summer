package myserver.core.httprequesthandler;

import java.io.IOException;
import java.net.Socket;

public interface HttpRequestHandler {
    HttpRequest selectRequestHandler(Socket socket) throws IOException;
}
