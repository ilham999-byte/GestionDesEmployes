
package ma.projet.connexion;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class Connexion {
private static FileInputStream f =null;
private static Properties p=null;
private static Connection cn=null;
static {
try {
FileInputStream f = new FileInputStream("base.properties");
p = new Properties();
p.load(f);
String url = p.getProperty("jdbc.url");
String login = p.getProperty("jdbc.username");
String password = p.getProperty("jdbc.password");
String driver = p.getProperty("jdbc.driver");
Class.forName(driver);
cn = DriverManager.getConnection(url, login, password);
} catch (Exception ex) {
System.out.println(""+ex.getMessage());
}
}
public static Connection getConnection() {
return cn;
}
    
}
