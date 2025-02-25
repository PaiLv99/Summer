package myserver.core.parser;

import myserver.core.httpenum.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ParserImpl implements Parser{
    @Override
    public HttpMethod parse(Socket socket) throws IOException {

        String method = HttpMethod.GET.toString();

        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ){
            String line = in.readLine();
            String[] strings = line.split(" ");
            method = strings[0];
        }catch( IOException e ){
            e.printStackTrace();
        }

        return HttpMethod.valueOf(method);
    }
}
