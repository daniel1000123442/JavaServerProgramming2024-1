package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemverDAO {

	Connection conn = null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER ="org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "sa", "");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> getAll(){
		List<Member> memberlist =new ArrayList<>();
		open();
		
		try {
			pstmt =conn.prepareStatement("select * from members");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setCompany(rs.getString("company"));
				m.setBirthday(rs.getDate("birthday"));
				m.setEmail(rs.getString("email"));
				memberlist.add(m);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return memberlist;
	}
	
	public void insert(Member m){
		
		open();
		try {

			String sql = "insert into members (username, company, birthday, email)" +
					"values(?,?,?,?)";
			
			// 여기서부터 다음주 프로그램 시작, 2024 5 20
			// 신규 멤버를 members 테이블에 추가함
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
}
