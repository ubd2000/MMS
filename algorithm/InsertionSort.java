import java.util.Random;

/**
 * @author ubd2000
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] data_list = new int[100];
        Random random = new Random();
        for (int i = 0; i < data_list.length; i++) {
            data_list[i] = random.nextInt(100) + 1;
        }

        int num = 0;
        int num2 = 0;


        for (int i = 1; i < data_list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data_list[j - 1] > data_list[j]) {
                    num = data_list[j - 1];
                    num2 = data_list[j];
                    data_list[j - 1] = num2;
                    data_list[j] = num;
                }
            }
        }

        for (int i = 0; i < data_list.length; i++) {
            System.out.println(data_list[i]);
        }
    }
}
