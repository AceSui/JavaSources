package hao.sui.LeastSqrare.curve;

import java.util.Arrays;

import Jama.Matrix;

public class Test {
	public static void main(String[] args) {
		double x[]= new double[]{1.2,2.0,2.3,3.3,};
		double y[]= new double[]{7.4,5.5,4.0,9.6};
		
		double xs[][]=new double [x.length][3];
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<3;j++) {
				xs[i][j]=Math.pow(x[i], j);
			}
		}
		Matrix aMatrix=new Matrix(xs);
//		aMatrix.print(aMatrix.getRowDimension(), aMatrix.getColumnDimension());
		double[][] ys=new double [y.length][1];
		for(int i=0;i<y.length;i++) {
			ys[i][0]=y[i];
		}
		Matrix aT=aMatrix.transpose();
		Matrix plus=aT.times(aMatrix);
//		plus.print(plus.getRowDimension(), plus.getColumnDimension());

		Matrix yMatrix=new Matrix(ys);
//		yMatrix.print(yMatrix.getRowDimension(), yMatrix.getColumnDimension());
		
		Matrix a=plus.inverse().times(aMatrix.transpose().times(yMatrix));
		double[] aValue=a.getColumnPackedCopy();
//		System.out.println(Arrays.toString(aValue));
		System.out.print("y=");
		for(int i=0;i<aValue.length;i++) {
			if(i==0) {
				System.out.print(aValue[i]);
			}else {
				if(aValue[i]>=0) {
					System.out.print("+"+aValue[i]);
				}else {
					System.out.print(aValue[i]);
				}
				for(int j=0;j<i;j++) {
					System.out.print("*x");
				}
			}
		}
		System.out.println();
	}
	
}
