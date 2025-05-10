package Wayfair;
import java.io.*;
import java.util.*;

/*
You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:


result=[900,"google.com",100,".com"]
----result=[910,"google.com","110",".com" ]
        

counts = [ "900,google.com",
      "10",fb.google.com,
     "60,mail.yahoo.com",
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts)
1340    com
 900    google.com
  10    stackoverflow.com
  20    overflow.com
 410    yahoo.com
  60    mail.yahoo.com
  10    mobile.sports.yahoo.com
  50    sports.yahoo.com
   3    org
   3    wikipedia.org
   2    en.wikipedia.org
   1    m.wikipedia.org
   1    mobile.sports
   1    sports
   1    uk
   1    co.uk
   1    google.co.uk

n: number of domains in the input
(subdomains within a domain are constant)

*/

public class CountWords {

  public static void countDomain(String[] counts){
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    int len = counts.length;
    for(int i=0; i<len;i++){
      String[] item = counts[i].split(",");
      //Building the initial Map
      if(!map.containsKey(item[1])) map.put(item[1],Integer.parseInt(item[0]));
      if(item[1].contains(".")){
        String subItem = item[1].substring(item[1].indexOf(".")+1, item[1].length());
        while(subItem.contains(".") ){
        	map.put(subItem,map.getOrDefault(subItem,0)+Integer.parseInt(item[0]));
        	subItem = (subItem.substring(subItem.indexOf(".")+1, subItem.length()));
        }
        
        map.put(subItem,map.getOrDefault(subItem,0)+Integer.parseInt(item[0]));
        
        String s="aabdsdaf";
        
       
      }
      }
    Iterator<Map.Entry<String,Integer>> itr = map.entrySet().iterator();
    while(itr.hasNext()){
      Map.Entry<String,Integer> entry = itr.next();
      System.out.println("\nKey "+entry.getKey()+" Value:"+entry.getValue()+"\n");
    }
  
  }
  
  
  
  public static void main(String[] argv) {
    String[] counts = {
      "900,google.com",
      "60,mail.yahoo.com",
      "10,mobile.sports.yahoo.com",
      "40,sports.yahoo.com",
      "300,yahoo.com",
      "10,stackoverflow.com",
      "20,overflow.com",
      "2,en.wikipedia.org",
      "1,m.wikipedia.org",
      "1,mobile.sports",
      "1,google.co.uk"
    };
    String[] counts2 = {
    			"30,yahoo.com",
    	      "900,mail.google.com",
    	      "20,maps.google.com",
    	      "100,facebook.com"
    	    };
    countDomain(counts2);

  }
}
