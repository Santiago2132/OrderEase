package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote
{
    public int fn(int a) throws RemoteException;
    public boolean registerUser(String user, String password, int monto)throws RemoteException;

    public boolean login(String nombreUsuario, String contraseña) throws  RemoteException;

    public boolean retDinero(int salidaDinero) throws  RemoteException;

    public boolean ingDinero(int entradaDinero) throws  RemoteException;

    public int consultDinero() throws  RemoteException;


}
