/**
 *  자식 클래스의 작성 (클래스 다이어그램 구현)
 *  부모의 모든 기능을 상속받고 있으며,
 *  곱셈과 나눗셈을 추가하여 부모의 기능을 확장시켰다.
 */
public class CalcChild  extends CalcParent {
    public int times(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        int result = 0;

        if (y != 0) {
            result = x / y;
        }

        return result;
    }
}
