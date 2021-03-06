import study.java.helper.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  다중 행의 결과를 조회하기 위한 SQL 구문 준비하기
 */
public class Main07 {
    public static void main(String[] args) {
        // 학과목록 조회하기
        String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno ASC";

        /** DBHelper를 통한 DB  접속 처리 */
        DBHelper db = DBHelper.getInstance();
        Connection conn = db.open();

        /** SQL 구문 실행하기 */
        // SQL문을 실행할 수 있는 객체
        // SELECT 구문은 MySQL로 부터 조회 결과를 전달받아야 하기 때문에 조회 결과를 저장하기 위한 ResultSet 객체가 필요하다.
        Statement stmt = null;

        // SELECT 결과를 저장할 객체
        // --> import java.sql.ResultSet;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();

            // SELECT 구문을 실행한 후, 결과셋을 리턴받는다.
            rs = stmt.executeQuery(sql);

            // ResultSet은 조회결과에 대해 한 줄씩만 읽어들일 수 있기 때문에 반복문을 사용해서 다음 행으로 이동(rs.next())을 반복적으로
            // 수행해야 한다. -> while문 처리 패턴

            // 한 줄씩 스캔하는 반복문 구성
            while (rs.next()) {
                   int deptNo = rs.getInt("deptno");
                   String dname = rs.getString("dname");
                   String loc = rs.getString("loc");

                System.out.printf("학과번호: %d\n", deptNo);
                System.out.printf("학과이름: %s\n", dname);
                System.out.printf("위치: %s\n", loc);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {

            // ResultSet 닫기 --> 생성된 순서의 역순으로 객체를 닫는다.
            if (rs != null) {
                // 객체 닫기
                try {
                    rs.close();
                } catch (SQLException e) { }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }


                /** DB 접속 해제 */
                db.close();
            }
        }
    }
}
