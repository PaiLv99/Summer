package myserver.core.httpresponsehandler;

import java.io.IOException;
import java.net.Socket;

public interface HttpResponseHandler {
    HttpResponse selectHttpResponseHandler(Socket socket) throws IOException;
}
