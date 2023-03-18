package baekjoon.stage10_시간복잡도;

import java.util.Scanner;

/** *
 *    for i <- 1 to n - 2
 *         for j <- i + 1 to n - 1
 *             for k <- j + 1 to n
 *
*     for i <- 1 to n - 1
 *         for j <- i + 1 to n
*     > (n-1)*n/2
 *
 *     (n-2)(n-1)/2
 *
 *
 *	i = 1
 *		j = 2 : n-2
 *		j = 3 : n-3
 *		j = n-1 : 1
 *	i = 2
 *		j = 3 : n-4
 *		j = n-1 : 1
 *	i = n-2
 *		j = n-1 : 1
 *
 *	n-2 : 1개
 *	n-3 : 2개
 *	...
 *	1 : n-2개
 * **/

public class N6_24267_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long sum = 0;
		for (int i = 1; i < n-1; i++) {
			sum += i*(n-i-1);
		}
		System.out.println(sum);
		System.out.println(3);
	}

}
