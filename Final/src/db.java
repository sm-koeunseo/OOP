import java.sql.*;

public class db {
    public static void main(String[] args) {
        // Connection 객체를 자동완성으로 import할 때는 com.mysql.connection이 아닌
        // java 표준인 java.sql.Connection 클래스를 import해야 한다.
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	boolean re = false;

        //String url = "jdbc:mysql://koeunseo.dothome.co.kr/myadmin/koeunseo";
		String url = "jdbc:mysql://127.0.0.1:3306/sys?serverTimezone=UTC";;
		String id = "root";
		String pw = "1118";
		
		int num = 0;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ee){
			System.err.println("DB연결 드라이버가 없음");
		}
		System.out.println("DB연결 드라이버");
		
		try{
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException a){
			System.err.println("DB 서버 연결 실패");
		}
		System.out.println("DB 서버 연결");
		
		try{
			stmt = conn.createStatement();
		}catch(SQLException ee){
			System.out.println("작업 처리 객체 생성 실패");
		}
		System.out.println("작업 처리 객체 생성");
		
		
		try {
			rs = stmt.executeQuery("SELECT count(*) as num FROM information_schema.tables WHERE TABLE_NAME = 'oop_test'");
			rs.next();
			num = rs.getInt(1);
		}catch(SQLException ee){
			System.out.println(ee + "테이블 여부 조회 실패");
		}
		
		if (num > 0) {
			try {
				rs = stmt.executeQuery("SELECT * FROM oop_test");
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
				}
			}catch(SQLException ee){
				System.out.println(ee + "테이블 조회 실패");
			}
		}else {
			try {
				re = stmt.execute("CREATE TABLE `oop_test` (\r\n"
						+ "  `id` INT NOT NULL AUTO_INCREMENT,\r\n"
						+ "  `user_name` VARCHAR(45) NOT NULL,\r\n"
						+ "  `user_pw` VARCHAR(45) NOT NULL,\r\n"
						+ "  PRIMARY KEY (`id`),\r\n"
						+ "  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC) VISIBLE);\r\n");
			} catch (SQLException e) {
				System.out.println(e + "테이블 생성 실패");
			}
		}
		
		try{
            if( conn != null && !conn.isClosed()){
                conn.close();
            }
        }
        catch( SQLException e){
            e.printStackTrace();
        }
		System.out.println("close");
		
		

        /*try{
            // 1. 드라이버 로딩
            // 드라이버 인터페이스를 구현한 클래스를 로딩
            // mysql, oracle 등 각 벤더사 마다 클래스 이름이 다르다.
            // mysql은 "com.mysql.jdbc.Driver"이며, 이는 외우는 것이 아니라 구글링하면 된다.
            // 참고로 이전에 연동했던 jar 파일을 보면 com.mysql.jdbc 패키지에 Driver 라는 클래스가 있다.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 연결하기
            // 드라이버 매니저에게 Connection 객체를 달라고 요청한다.
            // Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
            // mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.
            
            // @param  getConnection(url, userName, password);
            // @return Connection
            System.out.println("연결 시도");
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("연결 성공");
            

			rs = stmt.executeQuery("select * from two order by point desc");

        }
        catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println("에러: " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }*/
    }
}