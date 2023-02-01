package OrderEase.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    public static void main(String[] args)
    {
        try
        {
            // Define la interfaz remota
            interface RemoteServer extends Remote
            {
                public String sayHello() throws RemoteException;
            }
        // Implementa la clase servidor
            class ServerImpl extends UnicastRemoteObject implements RemoteServer
            {
                public ServerImpl() throws RemoteException
                {
                }
            @Override
                public String sayHello() throws RemoteException
                {
                    return "Hello, World!";
                }
            }
        // Crea un registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
        // Publica el objeto remoto
            RemoteServer server = new ServerImpl();
            registry.rebind("HelloServer", server);
            System.out.println("Server ready");
        }
        catch (Exception e)
        {
            System.out.println("Server exception: " + e.toString());
        }
    }
}
