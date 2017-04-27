import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import org.jblas.DoubleMatrix;

/*
This is where real execution happens
*/
public class UnitCompute extends UnicastRemoteObject implements IUnitCompute
{
	public UnitCompute()throws RemoteException{
	}
	public double add(double A, double B)throws RemoteException{
    		double ans = A+B; 
		//DoubleMatrix ans;
		//ans = A.add(B);
  	return ans;
	}
	public double sub(double A, double B)throws RemoteException{
    		double ans = A-B; 
		//DoubleMatrix ans;
		//ans = A.sub(B);
  	return ans;
	}
	public double mul(double A, double B)throws RemoteException{
		double ans = A*B; 
		//DoubleMatrix ans;
		//ans = A.mul(B);
		return ans;
	}
	public DoubleMatrix mmul(DoubleMatrix A, DoubleMatrix B) throws RemoteException{
		DoubleMatrix ans; 
		ans = A.mmul(B); 
		return ans; 
	}
}
