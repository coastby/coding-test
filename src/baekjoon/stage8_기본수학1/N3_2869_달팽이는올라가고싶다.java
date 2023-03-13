package baekjoon.stage8_기본수학1;


import java.util.Scanner;

public class N3_2869_달팽이는올라가고싶다 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();

		V -= A;
		System.out.println((int) Math.ceil(((double) V)/(A-B)) + 1);
	}
}
