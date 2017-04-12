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
	public DoubleMatrix add(DoubleMatrix A, DoubleMatrix B)throws RemoteException{
    DoubleMatrix ans;
		ans = A.add(B);
  	return ans;
	}
	public DoubleMatrix sub(DoubleMatrix A, DoubleMatrix B)throws RemoteException{
    DoubleMatrix ans;
		ans = A.sub(B);
  	return ans;
	}
	public DoubleMatrix mul(DoubleMatrix A, DoubleMatrix B)throws RemoteException{
		DoubleMatrix ans;
		ans = A.mul(B);
		return ans;
	}
}
