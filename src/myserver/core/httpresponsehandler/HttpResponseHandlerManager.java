package myserver.core.httpresponsehandler;

import java.io.IOException;
import java.net.Socket;

public interface HttpResponseHandlerManager {
    HttpResponse selectHttpResponseHandler(Socket socket) throws IOException;
}
