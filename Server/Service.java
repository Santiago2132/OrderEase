package OrderEase.Server;

import java.rmi.RemoteException;

public class Service
{
    public Service() throws RemoteException
    {
    }
    public int fn(int a) throws RemoteException
    {
        return a + 15;
    }
}
