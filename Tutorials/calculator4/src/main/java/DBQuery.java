import java.sql.*;
import java.net.URISyntaxException;


public class DBQuery {
    public String output="";
    public DBQuery() {
        System.out.println("Something is working");
        try {
            Connection connection = getConnection();
            Statement s=connection.createStatement();
            System.out.println("connection works");

//            String sqlStr3 = "create table patients (\n" +
//                    "                    id SERIAL PRIMARY KEY,\n" +
//                    "                    familyname varchar(128) NOT NULL, givenname varchar(128) NOT NULL, phonenumber varchar(32)\n" +
//                    "            );";
//            s.executeUpdate(sqlStr3);
//            String sqlStr2 = "create table patientofdoctor(" +
//                    "    id SERIAL PRIMARY KEY ," +
//                    "    patientid int NOT NULL," +
//                    "    doctorid int NOT NULL" +
//                    ");\n";
//            s.executeUpdate(sqlStr2);
//
            s.executeUpdate("insert into patients (familyname,givenname,phonenumber,username,password) values('Jones','Bill','07755678899','ruben','weitz');");
            String sqlStr = "SELECT * FROM patients";
            ResultSet rset=s.executeQuery(sqlStr);

            while(rset.next()){
                output+=rset.getInt("id")+" "+ rset.getString("familyname"); }
            rset.close();
            s.close();
        }
        catch (Exception e)
        {
            System.out.println("There was a problem:");
            e.printStackTrace();
        }


    }
    public String getOutput()
    {
        System.out.println("Is this a string");
        return output;

    }
    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println("Working until now");
        return DriverManager.getConnection(dbUrl);
    }
}
