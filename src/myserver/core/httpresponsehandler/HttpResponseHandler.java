package myserver.core.httpresponsehandler;

import java.net.Socket;

public interface HttpResponseHandler {
    HttpResponse selectHttpResponseHandler(Socket socket);
    HttpResponse createBadResponse(Socket socket);
}
