package util;
import JsonParser.JSONObject;
import JsonParser.XML;
import com.oracle.javafx.jmx.json.JSONException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by matthewletter on 11/10/14.
 */
public class XmlToJson {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING =
            "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static void main(String[] args) {
        Scanner myScanner = null;
        StringBuilder sb = new StringBuilder();
        PrintWriter out;
        try {
            myScanner = new Scanner(new File("/Users/matthewletter/Documents/final_project_big_data/Data/PollenHistoryCountCABQ-en-us.xml"));
            while(myScanner.hasNext()) {
                sb.append(myScanner.nextLine());
            }
            JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
            out = new PrintWriter("/Users/matthewletter/Documents/final_project_big_data/Data/PollenHistoryABQ.json");
            out.print(jsonPrettyPrintString);

        } catch (JSONException je) {
            System.out.println(je.toString());
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }finally {
            if(myScanner == null){
                myScanner.close();
            }
        }
    }
}
