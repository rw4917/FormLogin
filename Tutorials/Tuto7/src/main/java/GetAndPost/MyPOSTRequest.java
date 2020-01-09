package GetAndPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import BasicClasses.BloodGLucoseLevel;
import com.google.gson.Gson;

public class MyPOSTRequest {
    public MyPOSTRequest() throws IOException
    {
        BloodGLucoseLevel lev=new BloodGLucoseLevel();
        // Set up the body data
        Gson gson = new Gson();
        String jsonString = gson.toJson(lev);
        System.out.println(jsonString);
        String message = "Hello servlet";
        byte[] body = jsonString.getBytes(StandardCharsets.UTF_8);
        URL myURL = new URL("https://calculator4.herokuapp.com/patients"); HttpURLConnection conn = null;
//        URL myURL = new URL("http://localhost:8080/untitled/patients"); HttpURLConnection conn = null;
        conn = (HttpURLConnection) myURL.openConnection();
        // Set up the header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json"); conn.setRequestProperty("charset", "utf-8"); conn.setRequestProperty("Content-Length", Integer.toString(body.length)); conn.setDoOutput(true);
        // Write the body of the request

        try (OutputStream outputStream = conn.getOutputStream())
        {
            outputStream.write(body, 0, body.length);
        }
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }

        String inputLine;
        // Read the body of the response
        while ((inputLine = bufferedReader.readLine()) != null)
        {
            System.out.println(inputLine);
        }
        bufferedReader.close();
    }
}
