package Algorithm_Two.CH9.greedy_prof;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// 동전들의 액면가 배열
				int[] coinValue = {500, 100, 50, 10, 5, 1};
				int i;			// 동전들의 액면가 배열 지수
				int[] numCoin;	// 거스름돈에 포함되는 각 동전의 수 배열
				int change;		// 남은 거스름돈
				int count = 0;	// 거스름돈에 포함되는 동전들의 수

				numCoin = new int[6];

				Scanner scan = new Scanner(System.in);

				// 거스름돈에 포함되는 각 동전의 수를 0으로 초기화한다
				for (i = 0; i < numCoin.length; i++)
					numCoin[i] = 0;

				System.out.print("거스름돈을 입력하세요[0-999]: ");

				// 거스름돈을 입력 받는다
				change = scan.nextInt();

				// 가치가 가장 큰 동전으로 500원짜리 동전을 선택한다
				i = 0;

				System.out.println (change + "원의 거스름돈은 다음과 같다:");

				// 거스름돈이 남아 있는 동안 거스름돈에 포함되는 각 동전의 갯수를 계산한다
				while (change > 0)
				{
					// 거스름돈에 포함되는 남아 있는 동전들중 가치가 가장 큰 동전들의 수를 계산한다
					numCoin[i] = change /  coinValue[i];

					count = count + numCoin[i];

					// 남은 거스름돈을 계산한다
					change = change % coinValue[i];

					if (numCoin[i] > 0)
						// 거스름돈에 포함되는 남아 있는 동전들중 가치가 가장 큰 동전들의 갯수를 출력한다
						System.out.println(coinValue[i] + "원짜리 동전 " + numCoin[i] + "개");

					// 남아 있는 동전들중 다음으로 가치가 가장 큰 동전을 선택한다
					i++;
				}

				// 거스름돈에 포함되는 동전들의 수를 출력한다
				System.out.println ("\n거스름돈에 포함되는 동전들의 수: " + count);
				scan.close();
		  }

	}
