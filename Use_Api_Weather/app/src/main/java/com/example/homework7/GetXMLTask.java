package com.example.homework7;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.*;
import java.io.*;

public class GetXMLTask extends AsyncTask<String, Void, Document> {
    String No2 = "";
    String O3 = "";
    String Co = "";
    String So2 = "";
    String Pm10 = "";
    String Pm25 = "";
    @Override
    protected Document doInBackground(String... urls) {
        URL url;
        Document doc=null;
        Log.i("getTest", "push[0] : " + urls[0]);
        try {
            url = new URL(urls[0]);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {}
        return doc;
    }

    @Override
    protected void onPostExecute(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("row");

        for(int i = 0; i< nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            Element fstElmnt = (Element) node;

            NodeList no2 = fstElmnt.getElementsByTagName("NO2");
            if(no2.item(0).getChildNodes().getLength()==0){
                No2 = "정보없음";
            }
            else {
                No2 = no2.item(0).getChildNodes().item(0).getNodeValue() + "\n";
            }

            NodeList o3 = fstElmnt.getElementsByTagName("O3");
            if(o3.item(0).getChildNodes().getLength()==0){
                O3 = "정보없음";
            }
            else {
                O3 = o3.item(0).getChildNodes().item(0).getNodeValue() + "\n";
            }

            NodeList co  = fstElmnt.getElementsByTagName("CO");
            if(co.item(0).getChildNodes().getLength() == 0){
                Co = "정보없음";
            }
            else {
                Co = co.item(0).getChildNodes().item(0).getNodeValue() + "\n";
            }

            NodeList so2 = fstElmnt.getElementsByTagName("SO2");
            if(so2.item(0).getChildNodes().getLength()==0){
                So2 = "정보없음";
            }
            else {
                So2 = so2.item(0).getChildNodes().item(0).getNodeValue() + "\n";
            }

            NodeList pm10 = fstElmnt.getElementsByTagName("PM10");
            if(pm10.item(0).getChildNodes().getLength()==0){
                Pm10 = "정보없음";
            }
            else
                Pm10 = pm10.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList pm25 = fstElmnt.getElementsByTagName("PM25");
            if (pm25.item(0).getChildNodes().getLength()==0)
                Pm25 = "정보없음";
            else
                Pm25 = pm25.item(0).getChildNodes().item(0).getNodeValue() +"\n";
        }
        super.onPostExecute(doc);
    }
}