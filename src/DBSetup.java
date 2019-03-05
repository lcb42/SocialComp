import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.almworks.sqlite4java.SQLiteConnection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author sqlitetutorial.net
 */
public class DBSetup {

    /**
     * Connect to a database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:\\Users\\Lucy\\Documents\\University\\ThirdYear\\SocialComputing\\Coursework\\SocialComp\\db" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertData(String csvName, SQLiteConnection c) {
        String csvFile = csvName;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            SQLiteStatement stat = c.prepare("INSERT INTO " + "comp3208.db" + "  VALUES (?,?,?)");

            while ((line = br.readLine()) != null) {
                String[] table = line.split(cvsSplitBy);

                c.exec("BEGIN");

                for (Map.Entry<Integer, Float> itemRatingPair : data.get(user).entrySet()) {
                    stat.bind(1, user);
                    stat.bind(2, itemRatingPair.getKey());
                    stat.bind(3, itemRatingPair.getValue());
                    stat.stepThrough();
                    stat.reset();

                }

                // now do the commit part to save the changes to file
                c.exec("COMMIT");
            }


        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


}}