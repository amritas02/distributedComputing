import java.rmi.*;
import java.net.*;
import java.io.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
/*
this Binds rmi to UnitCompute
and then volunteers to (registerIp,registerPort) by sending "sign in" and
rmiRegistryPort which is port in volunteer's machine where rmi is running
*/
public class StartServer
{
	static String registerIp;
	static int registerPort;
	static int rmiRegistryPort;


	public static void signIn() throws IOException{
		OutputStream os = null;
		PrintStream ps = null;
		Socket client = null;
		try{
				client = new Socket(registerIp, registerPort);
				os = client.getOutputStream();
				ps = new PrintStream(os);
				System.out.println("sign in sent to register server at "+registerIp+" "+registerPort);
				ps.println("sign in");
				ps.println(rmiRegistryPort);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				ps.close();
				os.close();
				client.close();
			}
	}
	public static void signOut() throws IOException{
		OutputStream os = null;
		PrintStream ps = null;
		Socket client = null;
		try{
				client = new Socket(registerIp, registerPort);
				os = client.getOutputStream();
				ps = new PrintStream(os);
				System.out.println("sign out sent to register server at "+registerIp+" "+registerPort);
				ps.println("sign out");
				ps.println(rmiRegistryPort);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				ps.close();
				os.close();
				client.close();
			}
	}
	public static void main (String[] args) throws IOException
	{
		rmiRegistryPort = Integer.parseInt(args[0]);
		registerIp = args[1];
		registerPort = Integer.parseInt(args[2]);
		try{
			System.out.println("\tcreating UnitCompute object");
			UnitCompute uc = new UnitCompute();

			System.out.println("\tcalling rebind");
			Naming.rebind("rmi://localhost:"+rmiRegistryPort+"/UnitCompute",uc);
			System.out.println("server ready");
			signIn();
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
		}
		catch(RemoteException re){
			System.out.println("Remote Exception :"+re.getMessage());
	    re.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			signOut();
		}

	}
}
