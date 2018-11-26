import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;


public class FriendDBAImpl implements FriendDBA {
	String url,user,pwd;
			public FriendDBAImpl() {
				
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				url="jdbc:oracle:thin:@localhost:1521:xe";
				user = "scott";
				pwd = "TIGER";
			    
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	@Override
	public void friendInsert(Friend f) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			String sql = "insert into Friend values(FRE_seq.nextval,?,?,?,?)";
			ps =  con.prepareStatement(sql);
			
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
				if(con!=null)con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public ArrayList<Friend> friendView() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st=null;
		ResultSet rs = null;
		ArrayList<Friend> arr= new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			String sql = "Select * from friend";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Friend f =new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
			
				arr.add(f);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		return arr;
	}

	@Override
	public ArrayList<Friend> friendsearch(String str, String word) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		ArrayList<Friend> arr= new ArrayList<>();
		try {
			con=DriverManager.getConnection(url,user,pwd);
			String sql="select *from Friend where "+str+" Like '%"+word+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Friend f =new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				
				arr.add(f);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
		
		return arr;
	}
	//수정
	public void friendUpdate(Friend f) {
		Connection con =null;
		PreparedStatement ps = null;
		try {
			con=DriverManager.getConnection(url,user,pwd);
			String sql = "update friend set name=?,birth=?,phone=?,addr=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.setInt(5, f.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
				if(con!=null)con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	//상세보기
	public Friend friendSelect(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		Friend f=null;
		
		try {
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			String sql = "select * from friend where num="+num;
			rs=st.executeQuery(sql);
			while(rs.next()) {
				f =new Friend();
				
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
		
	}
	//삭제
	public void friendDelect(int num) {
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			String sql = "delete from friend where num="+num; 
			st = con.createStatement();
			st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st!=null)st.close();
				if(con!=null)con.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
