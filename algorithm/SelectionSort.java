import java.util.Random;

/**
 * @author ubd2000
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] data_list = new int[20];
        Random random = new Random();
        for (int i = 0; i < data_list.length; i++) {
            data_list[i] = random.nextInt(100) + 1;
        }
        int lowest = 0;
        int switchNum1 = 0;
        int switchNum2 = 0;

        for (int i = 0; i < data_list.length - 1; i++) {
            lowest = i;
            for (int j = i + 1; j < data_list.length; j++) {
                if (data_list[lowest] > data_list[j]) {
                    lowest = j;
                }
            }
            switchNum1 = data_list[lowest];
            switchNum2 = data_list[i];
            data_list[lowest] = switchNum2;
            data_list[i] = switchNum1;
        }
        for (int i = 0; i < data_list.length; i++) {
            System.out.println(data_list[i]);
        }
    }
}
