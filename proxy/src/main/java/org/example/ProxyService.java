package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class ProxyService {
    @Value("${math.primary.url}")
    private String primaryUrl;
    @Value("${math.secondary.url}")
    private String secondaryUrl;




    public Integer  searchLinearSearch(List<Integer> list, Integer value) throws IOException {
        String path = "/linearsearch?list="+list+"&value"+value;
        try {
            Integer body = Integer.valueOf(doGet(primaryUrl + path));
            return  body;

        } catch (Exception e) {
            Integer  body = Integer.valueOf(doGet(secondaryUrl + path));
            return body;
        }
    }

    public String searchBinarySearch(List<Integer> list, Integer value) throws IOException {
        String path = "/binarySearch?list="+list+"&value"+value;
        try {
            return doGet(primaryUrl + path);

        } catch (Exception e) {
            return  doGet(secondaryUrl + path);

        }
    }


    private String doGet(String urlText) throws IOException {
        URL url = new URL(urlText);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(2000);
        con.setReadTimeout(2000);

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        con.disconnect();

        return response.toString();
    }
}
