package com.sunny.grokkingalgorithms.fasttrack.week2.thought;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Scanner;

/**
 * Created by sundas on 6/30/2018.
 */
public class BasicCountREST {

  /**
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    // Create a trust manager that does not validate certificate chains
    TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
      }
      public void checkClientTrusted(X509Certificate[] certs, String authType) {
      }
      public void checkServerTrusted(X509Certificate[] certs, String authType) {
      }
    }
    };

    // Install the all-trusting trust manager
    SSLContext context = SSLContext.getInstance("SSL");
    context.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

    // Create all-trusting host name verifier
    HostnameVerifier allHostsValid = new HostnameVerifier() {
      public boolean verify(String hostname, SSLSession session) {
        return true;
      }
    };
    URL url = new URL("https://http-hunt.thoughtworks-" +
        "labs.net/challenge/input");
    HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setRequestProperty("userId", "r1QWH8Qzm");
    //System.out.println(conn.getRequestProperty("userId"));
    conn.setDoInput(true);
    conn.setDoOutput(true);
    conn.connect();
    int responsecode = conn.getResponseCode();
    if(responsecode != 200) {
      throw new RuntimeException("HttpResponseCode:"+responsecode);
    }
    else
    {
      Scanner sc = new Scanner(url.openStream());
      String inline = "";
      while(sc.hasNext())
      {
        inline+=sc.nextLine();
      }
      System.out.println("\nJSON data in string format");
      System.out.println(inline);
      sc.close();
    }
  }

}
