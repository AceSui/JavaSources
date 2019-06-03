import java.util.Arrays;

import javax.security.auth.x500.X500Principal;

import Jama.Matrix;

public class SavitzkyGolay {

	public void predict(double[][] data,int windowSize,int rank) {
		int m=(windowSize-1)/2;
		Matrix x=createX(m, rank);
		double [][] xdouble=x.getArray();

		Matrix xT=x.transpose();
		Matrix timeMatrix=xT.times(x);

		Matrix b=x.times(((x.transpose().times(x))).inverse()).times(x.transpose());
	
		Matrix a0=b.getMatrix(m,m, 0, b.getColumnDimension()-1);
		Matrix b0=a0.transpose();

		double [][]xy=data;
		double [][] lat=new double[1][xy.length];
		double [][] lng=new double[1][xy.length];
		for(int i=0;i<xy.length;i++) {
			lat[0][i]=xy[i][0];
			lng[0][i]=xy[i][1];
		}
		
		Matrix xMatrix=new Matrix(lat);
		Matrix yMatrix=new Matrix(lng);
		
		xMatrix=xMatrix.times(b0);
		yMatrix=yMatrix.times(b0);
		double[][] latResult=xMatrix.getArray();
		double[][] lngResult=yMatrix.getArray();
		
		for(int i=0;i<latResult.length;i++) {
			System.out.println(lngResult[i][0]+" "+latResult[i][0]);
		}
	}
	
	private Matrix createX(int size,int rank) {
		double[][]x=new double[2*size+1][1];
		Matrix matrix=new Matrix(x);
		for(int i=0;i<2*size+1;i++) {
			matrix.set(i, 0, 1);
		}
		return matrix;
	}
	
}
