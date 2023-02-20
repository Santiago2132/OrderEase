package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main
{
    public static void main(String[] args)
    {
        Properties properties= new Properties();
        try
        {
            properties.load(new FileInputStream(new File("server.properties")));
            Server server = new Server(
                    (String) properties.get("IP"),
                    (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME")
            );
            server.deployService();
            System.out.print("Service on");





        }
         catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}