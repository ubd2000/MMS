package baekjoon;

/**
 * @author ubd2000
 */
public class BaekJoon_11726 {
    /*
    *
    * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
    * 2 * n = n - 1 + n - 2
    */
    public static void main(String[] args) {
        int num = fibo_dp(9) % 10007;
        System.out.println(num);
    }

    public static int fibo_dp(int num) {
        int[] ints = new int[num + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;

        for (int i = 3; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }

        return ints[num];
    }
}
