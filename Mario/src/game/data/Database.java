package game.data;
import java.sql.*;
import java.util.ArrayList;


public class Database {

    public static final String JDBC_CLASS = "org.sqlite.JDBC";
    public static final String DATABASE_PATH = "jdbc:sqlite:src/game/data/mydb.sqlite";
    public static ArrayList<String> name=new ArrayList<>();
    public static ArrayList<Integer> highscore=new ArrayList<>();

    static
    {

           try {
               Class.forName(JDBC_CLASS);
           } catch (ClassNotFoundException e) {
               System.out.println("Please user JDBC");
           }
    }


   public static boolean checkData(String email,String password)
      {
            int flag=-1;
            try {
                Connection c = DriverManager.getConnection(DATABASE_PATH);
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM `Data` ");

                while (r.next()) {
                    int e = email.compareTo(r.getString("Email"));
                    int p = password.compareTo(r.getString("Password"));
                    if (e == 0 && p == 0) {
                        flag = 1;
                        break;
                    }
                }
                s.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


                if (flag == 1)
                    return true;
                else
                    return false;

     }
public static boolean checkEmail(String email)
      {
            int flag=-1;
            try {
                Connection c = DriverManager.getConnection(DATABASE_PATH);
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM `Data` ");

                while (r.next()) {
                    int e = email.compareTo(r.getString("Email"));
                    if (e == 0 ) {
                        flag = 1;
                        break;
                    }
                }
                s.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

                if (flag == 1)
                    return true;
                else
                    return false;

     }

    public static int searchEmail(String email)
    {  int highscore=0;
        try {
            Connection c = DriverManager.getConnection(DATABASE_PATH);
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM `Data` ");

            while (r.next()) {
                int e = email.compareTo(r.getString("Email"));
                if (e == 0 ) {
                  highscore=  r.getInt("Highscore");
                    break;
                }
            }
            s.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
      return highscore;
    }
    public static void updateHighscore(String email,int highscore)
    {
        try {Connection c = DriverManager.getConnection(DATABASE_PATH);
            Statement s = c.createStatement();

            String query = "UPDATE `Data`" +
                    "SET `Highscore`=? "+
                    "WHERE `Email`=?;";
            PreparedStatement p=c.prepareStatement(query);
            p.setInt(1,highscore);
            p.setString(2,email);
            p.execute();

            s.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void sortScore()
    {     name.clear();
          highscore.clear();
        try {Connection c = DriverManager.getConnection(DATABASE_PATH);
            Statement s = c.createStatement();


            ResultSet r = s.executeQuery( "SELECT `Name`,`Highscore` " +
                                               "FROM `Data`"+
                                               "ORDER BY `Highscore` DESC;");
            while(r.next())
            {
               name.add(r.getString("Name"));
                highscore.add(r.getInt("Highscore"));

            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    public static void add(String name,String dob,String mobile,String email,String password)
      {
           try {
               Connection c = DriverManager.getConnection(DATABASE_PATH);
               String query="INSERT INTO `Data`(`Name`,`Dob`,`Mobile`,`Email`,`Password`) VALUES (?,?,?,?,?)";
               PreparedStatement p=c.prepareStatement(query);
               p.setString(1,name);
               p.setString(2,dob);
               p.setString(3,mobile);
               p.setString(4,email);
               p.setString(5,password);
               p.execute();

           }
           catch (SQLException e) {
               e.printStackTrace();
           }
       }


}