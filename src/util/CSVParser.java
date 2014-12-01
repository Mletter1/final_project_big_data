package util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by matthewletter on 11/28/14.
 */
public class CSVParser {

        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/allergy";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "b31yoyzk";

        public void openCon(String MST,
                            String Max_TemperatureF,
                            String Mean_TemperatureF,
                            String Min_TemperatureF,
                            String Max_Dew_PointF,
                            String MeanDew_PointF,
                            String Min_DewpointF,
                            String Max_Humidity,
                            String Mean_Humidity,
                            String Min_Humidity,
                            String Max_Sea_Level_PressureIn,
                            String Mean_Sea_Level_PressureIn,
                            String Min_Sea_Level_PressureIn,
                            String Max_VisibilityMiles,
                            String Mean_VisibilityMiles,
                            String Min_VisibilityMiles,
                            String Max_Wind_SpeedMPH,
                            String Mean_Wind_SpeedMPH,
                            String Max_Gust_SpeedMPH,
                            String PrecipitationIn,
                            String CloudCover,
                            String Events,
                            String WindDirDegrees){
            Connection conn = null;
            Statement stmt = null;
            try{
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.err.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //STEP 4: Execute a query
                System.err.println("Creating statement...");
                // the mysql insert statement
                String query = "insert into weather_data(MST," +
                        "Max_TemperatureF," +
                        "Mean_TemperatureF," +
                        "Min_TemperatureF," +
                        "Max_Dew_PointF," +
                        "MeanDew_PointF," +
                        "Min_DewpointF," +
                        "Max_Humidity," +
                        "Mean_Humidity," +
                        "Min_Humidity," +
                        "Max_Sea_Level_PressureIn," +
                        "Mean_Sea_Level_PressureIn," +
                        "Min_Sea_Level_PressureIn," +
                        "Max_VisibilityMiles," +
                        "Mean_VisibilityMiles," +
                        "Min_VisibilityMiles," +
                        "Max_Wind_SpeedMPH," +
                        "Mean_Wind_SpeedMPH," +
                        "Max_Gust_SpeedMPH," +
                        "PrecipitationIn," +
                        "CloudCover," +
                        "Events," +
                        "WindDirDegrees) values ('"+MST
                        +"',"+Max_TemperatureF+","+Mean_TemperatureF+","+Min_TemperatureF
                        +","+Max_Dew_PointF+","+MeanDew_PointF+","+Min_DewpointF+","+Max_Humidity+","+Mean_Humidity+","+Min_Humidity
                        +","+Max_Sea_Level_PressureIn+","+Mean_Sea_Level_PressureIn+","+Min_Sea_Level_PressureIn
                        +","+Max_VisibilityMiles+","+Mean_VisibilityMiles+","+Min_VisibilityMiles
                        +","+Max_Wind_SpeedMPH+","+Mean_Wind_SpeedMPH+","+Max_Gust_SpeedMPH+","+PrecipitationIn
                        +","+CloudCover+",'"+Events+"',"+WindDirDegrees+")";
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
            Scanner myScanner;
            String str;
            String strLine[];
            int x = 1;
            try {
                myScanner = new Scanner(new File("/Users/matthewletter/Documents/final_project_big_data/Data/weatherData.csv"));
                while (myScanner.hasNext() && x==1 ) {
                    str = myScanner.nextLine();
                    //clean data
                    str = str.replaceAll("\\s+", " ");
                    strLine = str.split(",");
                    if(strLine[19].equals("T") || strLine[19].equals("0.00")){
                        strLine[19] = "0.0";
                    }
                    if(strLine[18].equals("")){
                        strLine[18] = "0";
                    }
                    openCon(strLine[0],strLine[1],strLine[2],strLine[3],strLine[4],strLine[5],strLine[6],strLine[7],strLine[8],strLine[9],strLine[10],strLine[11],strLine[12],strLine[13],strLine[14],
                            strLine[15],strLine[16],strLine[17],strLine[18],strLine[19],strLine[20],strLine[21],strLine[22]);
                    //x = 2;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public static void main(String[] args){
            CSVParser c = new CSVParser();
            c.parseDocument();
        }
}
