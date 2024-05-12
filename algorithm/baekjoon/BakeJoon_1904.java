package baekjoon;

import java.util.Scanner;

/**
 * @author ubd2000
 */
public class BakeJoon_1904 {
    /**
     * 지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.
     * 어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
     * 그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
     * 우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.
     * DP[1] = 1 = 1
     * DP[2] = 00 11 = 2
     * DP[3] = 001 100 111 = 3
     * DP[4] = 0000 1001 1100 0011 1111 = 5
     * DP[5] = 00001 10000 00100 11100 11001 00111 10011 11111 = 8
     * DP[6] = 000000 000011 001111 111100 110000 111111 001100 001001 100100 110011 001100 111001 100111 = 13
     * 1 2 3 5 6
     * 입력
     * 첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(BakeJoon1904(n));
    }
    public static long BakeJoon1904(int num) {
        long[] arryLong = new long[1000001];
        arryLong[1] = 1;
        arryLong[2] = 2;

        for (int i = 3; i < arryLong.length; i++) {
            arryLong[i] = (arryLong[i - 2] + arryLong[i - 1]) % 15746;
        }
        return arryLong[num];
    }
}
