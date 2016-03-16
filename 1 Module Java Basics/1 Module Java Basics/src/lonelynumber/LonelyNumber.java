package lonelynumber;

public class LonelyNumber {

    public static void main(String[] args){
        int[] numbers = {2, 3, 2, 4, 3, 7, 7, 7, 11, 2, 3, 4, 4};
        System.out.println(findLonelyNumber(numbers));
        }

    private static int findLonelyNumber(int[] numbers){
        int result = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i != j){
                    if (numbers[j] == numbers[i]) {
                        count++;
                    }
                }
                if (count == 1) {
                    result = numbers[j];
                }
            }
        }
        return result;
    }
}
