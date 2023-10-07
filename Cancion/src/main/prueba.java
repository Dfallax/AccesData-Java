package main;

import java.util.Scanner;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		Scanner s = new Scanner(System.in);
 	      String num;
 	      do {
 				System.out.print("numero ");
 			num=s.nextLine().trim();
 			
 			}while(num.isEmpty());
 	 System.out.println(num);     
	}

}
