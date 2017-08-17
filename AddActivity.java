package com.example.deepthigunasekara.smartdoorlock;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        final EditText passwordAdmin = (EditText) findViewById(R.id.paswordAdmin);          // the entered key
        final EditText name = (EditText) findViewById(R.id.name);          // the entered key
        final EditText passwordNew = (EditText) findViewById(R.id.passwordNew);          // the entered key

        final Button family = (Button) findViewById(R.id.family);           //lock button
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendingRequst(passwordAdmin, name, passwordNew, "addPeople", family);

            }
        });

        final Button guest = (Button) findViewById(R.id.guest);          //unlock button

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendingRequst(passwordAdmin, name, passwordNew, "addPeople", guest);
            }
        });
    }

    private void sendingRequst(final EditText adminKey, final EditText nameEntered, final EditText confirmKey, final String selection, final Button member) {

       // final AlertDialog.Builder alert = new AlertDialog.Builder(AddActivity.this);
//        alert.setMessage("Do you want to set the route\n").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//                //startActivity(new Intent(AddActivity.this,Roots.class));
//            }
//        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        AlertDialog alertDialog = alert.create();
//        // alertDialog.setTitle("hiiii");
//        alertDialog.show();
//
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Socket socket = new Socket("192.168.43.10", 5000);
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

                  //  pw.write(key.getText().toString()+"\r\n");
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