package myserver.core.parser;

import myserver.core.httpenum.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ParserImpl implements Parser{
    @Override
    public HttpMethod parse(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = in.readLine();
        String[] strings = line.split(" ");

        // 예외처리...

        return HttpMethod.valueOf(strings[0]);
    }
}
