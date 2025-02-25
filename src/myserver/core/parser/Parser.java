package myserver.core.parser;

import myserver.core.httpenum.HttpMethod;

import java.io.IOException;
import java.net.Socket;

public interface Parser {
    HttpMethod parse(Socket socket) throws IOException;
}
