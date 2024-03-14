/**
 * @author ubd2000
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int num = fibo_dp(10);

        System.out.println(num);
    }

    public static int fibo_dp(int num) {
        int[] ints = new int[num + 1];
        ints[0] = 0;
        ints[1] = 1;

        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }

        return ints[num];
    }
}
