package com.example.deepthigunasekara.smartdoorlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;

public class RemoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        final EditText adminKey = (EditText)findViewById(R.id.adminKey);          // the entered key
        final EditText name = (EditText)findViewById(R.id.name);          // the entered key
        final Button remove = (Button)findViewById(R.id.remove);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendingRequst(adminKey,name,"remove");

            }
        });

    }

    private void sendingRequst(final EditText key,final EditText nameRemove, final String selection){
//"t=t?user=admin&key="+key.getText().toString()+"&nameRemove="+nameRemove.getText().toString()+"&option="+option;
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Socket socket = new Socket("192.168.43.10", 5000);
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

                    pw.write("admin\r\n");
                    pw.write("1234\r\n");
                    pw.flush();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


//                try {

//                    final String option = selection;
//
//                    String url = "http://192.168.43.10:5000/Lumos/ServletURLPattern";
//                    URL obj = new URL(url);
//                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//                    //add reuqest header
//                    con.setRequestMethod("POST");
//                    //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//                    String urlParameters ="t=t?user=admin&key="+key.getText().toString()+"&nameRemove="+nameRemove.getText().toString()+"&option="+option;
//                    // Send post request
//                    con.setDoOutput(true);
//                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//                    wr.writeBytes(urlParameters);
//                    wr.flush();
//                    wr.close();
//
//                    int responseCode = con.getResponseCode();
//                    System.out.println("\nSending 'POST' request to URL : " + url);
//                    System.out.println("Post parameters : " + urlParameters);
//                    System.out.println("Response Code : " + responseCode);
//
//
//                    BufferedReader in = new BufferedReader(
//                            new InputStreamReader(con.getInputStream()));
//                    String inputLine;
//                    final StringBuffer response = new StringBuffer();
//
//                    while ((inputLine = in.readLine()) != null) {
//                        response.append(inputLine);
//                    }
//                    in.close();
//
//                    //print result
//                    System.out.println(response.toString());
//
//
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });

        worker.start();
    }
}
