package server;

public class Cliente {

    String user = "";
    String password = "";
    int monto = 0;

    public Cliente(String usuario, String contraseña, int montoDisponible)
    {
        this.user = usuario;
        this.password = contraseña;
        this.monto = montoDisponible;
    }

    public String getUser()
    {
        return user;
    }

    public void setUsuario(String user)
    {
        this.user = user;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getMonto()
    {
        return monto;
    }

    public void setMonto(int monto)
    {
        this.monto = monto;
    }
}
