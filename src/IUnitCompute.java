import java.rmi.*;
import org.jblas.DoubleMatrix;

/*
this interface is implemented by UnitCompute
todo - more operations needs to be added
*/
public interface IUnitCompute extends Remote{
  public double add(double A, double B)throws RemoteException;
  public double sub(double A, double B)throws RemoteException;
  public double mul(double A, double B)throws RemoteException;
  public DoubleMatrix mmul(DoubleMatrix A, DoubleMatrix B) throws RemoteException; 

}
