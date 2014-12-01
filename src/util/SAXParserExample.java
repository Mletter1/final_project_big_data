package util;

/**
 * Created by matthewletter on 11/10/14.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample extends DefaultHandler{

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/allergy";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "b31yoyzk";

    private String tempVal;

    //to maintain context
    String date=null;
    String loc=null;
    String tree=null;
    String lev=null;


    public SAXParserExample(){

    }

    public void runExample() {
        PrintWriter out;
        try {
            out = new PrintWriter("/Users/matthewletter/Documents/final_project_big_data/Data/inserts.sql");
            parseDocument();
        }catch (Exception e){

        }
    }
    public void openCon(String submission_date, String location, String tree_type, String level){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.err.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //STEP 4: Execute a query
            System.err.println("Creating statement...");
            // the mysql insert statement
            String query = "insert into pollen_data (submission_date, location, tree_type, level)"
                    + " values ('"+submission_date+"', '"+location+"', '"+tree_type+"', "+level+")";
            System.err.println(query);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    private void parseDocument() {

        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            //parse the file and also register this class for call backs
            sp.parse("/Users/matthewletter/Documents/final_project_big_data/Data/PollenHistoryABQclean.xml", this);

        }catch(SAXException se) {
            se.printStackTrace();
        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch (IOException ie) {
            ie.printStackTrace();
        }
    }


    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        if(qName.equalsIgnoreCase("row")) {
            if(date==null){
                date="";
                loc="";
                tree="";
                lev="";
            }else{
                openCon(date,loc,tree,lev);
//                System.out.println(date+loc+tree+lev);
//                date="";
//                loc="";
//                tree="";
//                lev="";
            }
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch,start,length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(qName.equalsIgnoreCase("submission_date")) {
            //add it to the list
            //myEmpls.add(tempEmp);
            date = tempVal;

        }else if (qName.equalsIgnoreCase("location")) {
            loc = tempVal;
        }else if (qName.equalsIgnoreCase("tree_type")) {
            tree = tempVal;
        }else if (qName.equalsIgnoreCase("level")) {
            lev = tempVal;
        }

    }

    public static void main(String[] args){
        SAXParserExample spe = new SAXParserExample();
        spe.runExample();
    }

}



