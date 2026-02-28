package HelloWorld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HelloWorld {
    // static方法来修饰可以不用对象调用，程序入口
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int number1 = scanner.nextInt();
//        System.out.println(number1);
//
//        int number2 = scanner.nextInt();
//        System.out.println(number2);
        int[] arr1 = {9,8,6,7,5,3};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.stream(arr1).max().getAsInt());

        Test test = new Test();
        test.setName("ZhangSan");
        System.out.println(test);
    }
}



