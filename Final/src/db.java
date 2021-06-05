import java.sql.*;

public class db {
    public static void main(String[] args) {
        // Connection ��ü�� �ڵ��ϼ����� import�� ���� com.mysql.connection�� �ƴ�
        // java ǥ���� java.sql.Connection Ŭ������ import�ؾ� �Ѵ�.
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	boolean re = false;

        //String url = "jdbc:mysql://koeunseo.dothome.co.kr/myadmin/koeunseo";
		String url = "jdbc:mysql://127.0.0.1:3306/sys?serverTimezone=UTC";
		String id = "root";
		String pw = "1118";
		
		int num = 0;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ee){
			System.err.println("DB���� ����̹��� ����");
		}
		System.out.println("DB���� ����̹�");
		
		try{
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException a){
			System.err.println("DB ���� ���� ����");
		}
		System.out.println("DB ���� ����");
		
		try{
			stmt = conn.createStatement();
		}catch(SQLException ee){
			System.out.println("�۾� ó�� ��ü ���� ����");
		}
		System.out.println("�۾� ó�� ��ü ����");
		
		
		try {
			rs = stmt.executeQuery("SELECT count(*) as num FROM information_schema.tables WHERE TABLE_NAME = 'oop_test'");
			rs.next();
			num = rs.getInt(1);
		}catch(SQLException ee){
			System.out.println(ee + "���̺� ���� ��ȸ ����");
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
				System.out.println(ee + "���̺� ��ȸ ����");
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
				System.out.println(e + "���̺� ���� ����");
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
            // 1. ����̹� �ε�
            // ����̹� �������̽��� ������ Ŭ������ �ε�
            // mysql, oracle �� �� ������ ���� Ŭ���� �̸��� �ٸ���.
            // mysql�� "com.mysql.jdbc.Driver"�̸�, �̴� �ܿ�� ���� �ƴ϶� ���۸��ϸ� �ȴ�.
            // ������ ������ �����ߴ� jar ������ ���� com.mysql.jdbc ��Ű���� Driver ��� Ŭ������ �ִ�.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. �����ϱ�
            // ����̹� �Ŵ������� Connection ��ü�� �޶�� ��û�Ѵ�.
            // Connection�� ��� ���� �ʿ��� url ����, �����縶�� �ٸ���.
            // mysql�� "jdbc:mysql://localhost/�����db�̸�" �̴�.
            
            // @param  getConnection(url, userName, password);
            // @return Connection
            System.out.println("���� �õ�");
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("���� ����");
            

			rs = stmt.executeQuery("select * from two order by point desc");

        }
        catch(ClassNotFoundException e){
            System.out.println("����̹� �ε� ����");
        }
        catch(SQLException e){
            System.out.println("����: " + e);
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