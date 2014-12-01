package util;

import JsonParser.JSONObject;
import JsonParser.XML;
import com.oracle.javafx.jmx.json.JSONException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by matthewletter on 11/15/14.
 */
public class XmlToCleanXml {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING =
            "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static void main(String[] args) {
        Scanner myScanner = null;
        StringBuilder sb = new StringBuilder();
        PrintWriter out = null;
        String output = "";
        try {
            String strTemp = "";
            String strTempNoWS = "";
            out = new PrintWriter("/Users/matthewletter/Documents/final_project_big_data/Data/PollenHistoryABQclean.xml");
            myScanner = new Scanner(new File("/Users/matthewletter/Documents/final_project_big_data/Data/PollenHistoryCountCABQ-en-us.xml"));
            while(myScanner.hasNext()) {
                strTemp =myScanner.nextLine();
                strTempNoWS = strTemp.trim();
                out.print(strTemp + "\n");
                if(strTempNoWS.equals("<row>")){
                    strTemp = myScanner.nextLine();
                    strTemp = strTemp.replaceAll("value", "submission_date");
                    out.print(strTemp + "\n");
                    strTemp = myScanner.nextLine();
                    strTemp = strTemp.replaceAll("value", "location");
                    out.print(strTemp + "\n");
                    strTemp = myScanner.nextLine();
                    strTemp = strTemp.replaceAll("value", "tree_type");
                    out.print(strTemp + "\n");
                    strTemp = myScanner.nextLine();
                    strTemp = strTemp.replaceAll("value", "level");
                    out.print(strTemp + "\n");
                }
            }
            System.out.println("done");

        } catch (JSONException je) {
            System.out.println(je.toString());
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }finally {
            if(myScanner != null && out != null){
                myScanner.close();
                out.close();
            }
        }
    }
}
