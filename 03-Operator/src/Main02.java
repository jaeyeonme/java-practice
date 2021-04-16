public class Main02 {
    public static void main(String[] args) {
        /** 정수의 나눗셈 */
        int a = 7;
        int b = 3;
        int result1 = a / b;
        System.out.println("7 / 3 = " + result1);

        /** 실수의 나눗셈 */
        double c = 7.0d;
        double d = 3.0d;
        double result2 = c /d ;
        System.out.println("7.0 / 3.0 = " + result2);

        /** 정수와 실수를 계산 */
        // 이건 에러
        // int result3 = c / b;
        // 결과는?
        double result3 = c / b;
        System.out.println("7.0 / 3 = " + result3);

        /** 나눈셈의 오차 */
        // 결과에 이상 없음
        System.out.println("5 % 2 = " + 5 % 2);
        // 오차 발생
        System.out.println("5.2d % 2.0d = " + 5.2d % 2.0d);

        /** 0으로 나누기 */
        int num = 100;
        int zero = 0;
        int result4 = num / zero;

        // 연산이 가능한가? --> 에러
        System.out.println("100 / 0 = " + result4);
    }
}
