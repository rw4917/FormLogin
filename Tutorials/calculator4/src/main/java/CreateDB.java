import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class CreateDB {

    public CreateDB() {


        System.out.println("Something is working");
        try {
            Connection connection = getConnection();
            Statement s=connection.createStatement();
            System.out.println("connection works");
            s.executeUpdate("DROP TABLE IF EXISTS patients");
            String sqlStr3 = "create table patients (\n" +
                    "                    id SERIAL PRIMARY KEY,\n" +
                    "                    familyname varchar(128) NOT NULL, givenname varchar(128) NOT NULL, phonenumber varchar(32)" +
                    ",username varchar(128), password varchar(128) " +
                    "            );\n";
            s.executeUpdate(sqlStr3);
            s.executeUpdate("DROP TABLE IF EXISTS patientsinfo");
            String sqlStr2 = "create table patienstinfo(" +
                    "    id SERIAL PRIMARY KEY ," +
                    "    patientid int NOT NULL," +
                    "    doctorid int NOT NULL" +
                    ");\n";
            s.executeUpdate(sqlStr2);
            s.executeUpdate("DROP TABLE IF EXISTS logs");
            String sqlStr5 = "create table logs(" +
                    "    id SERIAL PRIMARY KEY ," +
                    "    patientid int NOT NULL," +
                    "    date date ," +
                    "    method int NOT NULL," +
                    "    GlucoseLevel int NOT NULL," +
                    "    GlucoseTime timestamp," +
                    "    Exercice varchar," +
                    "    ExerciceStartTime timestamp ," +
                    "    ExerciceEndTime timestamp ," +
                    "    Food varchar ," +
                    "    FoodTime timestamp ," +
                    "    Carbs int NOT NULL ," +
                    "    Med int NOT NULL," +
                    "    MedTime timestamp ," +
                    "    Dosage int NOT NULL,"+
                    ");\n";
            s.executeUpdate(sqlStr5);
//
            String sqlStr = "insert into patients (familyname,givenname,phonenumber,username,password) values('ruben','Bill','07755678899','ruben', 'weitz');";
            s.executeUpdate(sqlStr);
            System.out.println("we updated the table ");
            s.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("There was a problem:");
            e.printStackTrace();
        }

    }
    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println("Working until now");
        return DriverManager.getConnection(dbUrl);
    }
    public static void main(String[] args) throws SQLException, URISyntaxException {

    }
}