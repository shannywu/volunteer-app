package com.example.termproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Information {
	
    public static void main(String[] args) throws Exception {
    	
    }
    
    public ArrayList<String> parse() throws IOException {
    	
    	ArrayList<String> news = new ArrayList<String>();
    	URL url = new URL("http://www.scsrc.org.tw/news_list.php?no=10");
    	String web="", text = "", date = "";
    	
        // Create the Document Object
        Document doc = Jsoup.parse(url, 3000);
        // #margin_01 is table name
        Elements table = doc.select("#margin_01");

        Iterator<Element> ite = table.select("td").iterator();
     
        for(int i=0; i<10; i++)
        {
        	//select data 
        	ite.next().text();
        	ite.next().text();
        	ite.next().text();
            date += ite.next().text() + "\t";
            
            Element e5 = ite.next().select("a").first();
            
            String h = e5.attr("href");
            if(!h.startsWith("http:"))
        		h = "http://www.scsrc.org.tw/" + h;
            
        	text += e5.text() + "\t";
        	web += h + "\t";
        }

        news.add(text);
        news.add(web);
        news.add(date);
        
    	return news;
    }
}

