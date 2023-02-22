package server;

import interfaces.RMI;
import server.Main;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service extends UnicastRemoteObject implements RMI {

    private static final long serialVersionUID = 1L;
    //Usuario de prueba
    Cliente actualCliente = new Cliente("Santiago", "1725", 50000);

    //Cliente actualCliente;
    Cliente clientesRegistrados[] = {actualCliente};


    public Service() throws RemoteException
    {
    }

    @Override
    public int fn(int a) throws RemoteException
    {
        return a + 15;
    }

    @Override
    public boolean registerUser(String user, String password, int monto) throws RemoteException
    {
        clientesRegistrados[1] = new Cliente(user,password,monto);
        return true;
    }
    @Override
    public boolean login(String nombreUsuario, String contraseña) throws RemoteException
    {
        for (int i = 0; i < clientesRegistrados.length; i++)
        {
            if(actualCliente.getUser().equals(nombreUsuario))
            {
                if(actualCliente.getPassword().equals(contraseña))
                {
                    actualCliente = clientesRegistrados[i];
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean retDinero(int salidaDinero) throws RemoteException
    {
        if(salidaDinero> actualCliente.getMonto())
        {
            return false;
        }
        else
        {
            actualCliente.setMonto((actualCliente.getMonto()-salidaDinero));
            return true;
        }

    }

    @Override
    public boolean ingDinero(int entradaDinero) throws RemoteException
    {
        if(entradaDinero <0)
        {
            return false;
        }
        else
        {
            actualCliente.setMonto((actualCliente.getMonto()+entradaDinero));
            return true;
        }
    }

    @Override
    public int consultDinero() throws RemoteException
    {
        return actualCliente.getMonto();
    }


}
