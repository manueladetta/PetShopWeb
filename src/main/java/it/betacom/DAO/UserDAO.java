package it.betacom.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.betacom.controller.ServletRegistrazione;
import it.betacom.model.User;
import it.betacom.model.UserDemo;
import it.betacom.utilities.MyUtilities;

public class UserDAO {
	
    private static final int MAX_LOGIN_ATTEMPTS = 3; // Numero massimo di tentativi di login

	public static Connection getConnection(){
		Connection con=null;
		try{
			String db_name = "db_petshop";
			String db_user = "root";
			String db_password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, db_user, db_password);
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static List<User> getAllRecords() {
		Connection con = null;
        PreparedStatement ps = null;
		
        List<User> list = new ArrayList<>();
	    
	    try {
	        con = getConnection();
	        ps = con.prepareStatement("SELECT * FROM PSUtenti");
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            User u = new User();
	            u.setId(rs.getInt("id"));
	            u.setNome(rs.getString("nome"));
	            u.setCognome(rs.getString("cognome"));
	            u.setUsername(rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setDataDiNascita(MyUtilities.convertToLocalDate(rs.getDate("data_di_nascita")));
	            u.setCellulare(rs.getString("cellulare"));
	            u.setPassword(rs.getString("password"));
	            u.setRuolo(rs.getString("ruolo"));
	            u.setStato(rs.getString("stato"));
	            u.setLoginRimanenti(rs.getInt("login_rimanenti"));
	            list.add(u);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	    
	    return list;
	}
	
	public static User getRecordById(int id) {
		Connection con = null;
        PreparedStatement ps = null;
		
        User u = null;
	    
	    try {
	        con = getConnection(); 
	        ps = con.prepareStatement("SELECT * FROM PSUtenti WHERE id = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            u = new User();
	            u.setId(rs.getInt("id"));
	            u.setNome(rs.getString("nome"));
	            u.setCognome(rs.getString("cognome"));
	            u.setUsername(rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setDataDiNascita(MyUtilities.convertToLocalDate(rs.getDate("data_di_nascita")));
	            u.setCellulare(rs.getString("cellulare"));
	            u.setPassword(rs.getString("password"));
	            u.setRuolo(rs.getString("ruolo"));
	            u.setStato(rs.getString("stato"));
	            u.setLoginRimanenti(rs.getInt("login_rimanenti"));

	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	    
	    return u;
	}

	public static User getUserByEmail(String email) {
		Connection con = null;
        PreparedStatement ps = null;
		
		User u = null;
	    
	    try {
	        con = getConnection(); 
	        ps = con.prepareStatement("SELECT * FROM PSUtenti WHERE email = ?");
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            u = new User();
	            u.setId(rs.getInt("id"));
	            u.setNome(rs.getString("nome"));
	            u.setCognome(rs.getString("cognome"));
	            u.setUsername(rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setDataDiNascita(MyUtilities.convertToLocalDate(rs.getDate("data_di_nascita")));
	            u.setCellulare(rs.getString("cellulare"));
	            u.setPassword(rs.getString("password"));
	            u.setRuolo(rs.getString("ruolo"));
	            u.setStato(rs.getString("stato"));
	            u.setLoginRimanenti(rs.getInt("login_rimanenti"));
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	    
	    return u;
	}

	public static User getUserByUsername(String username) {
		Connection con = null;
        PreparedStatement ps = null;
		
		User u = null;
	    
	    try {
	        con = getConnection(); 
	        ps = con.prepareStatement("SELECT * FROM PSUtenti WHERE username = ?");
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            u = new User();
	            u.setId(rs.getInt("id"));
	            u.setNome(rs.getString("nome"));
	            u.setCognome(rs.getString("cognome"));
	            u.setUsername(rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setDataDiNascita(MyUtilities.convertToLocalDate(rs.getDate("data_di_nascita")));
	            u.setCellulare(rs.getString("cellulare"));
	            u.setPassword(rs.getString("password"));
	            u.setRuolo(rs.getString("ruolo"));
	            u.setStato(rs.getString("stato"));
	            u.setLoginRimanenti(rs.getInt("login_rimanenti"));
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	    
	    return u;
	}
	
	public static void updateUserLoginAttempts(String username, int loginAttemptsLeft) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection(); 

            String query = "UPDATE PSUtenti SET login_rimanenti = ? WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, loginAttemptsLeft);
            ps.setString(2, username);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public static void disableUser(String username) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection(); 

            String query = "UPDATE PSUtenti SET stato = 'D' WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public static void enableUser(String username) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection(); 

            String query = "UPDATE PSUtenti SET stato = 'A' login_rimanenti = 3 WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public static int update(User user) {
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String query = "UPDATE psutenti SET nome=?, cognome=?, username=?, email=?, data_di_nascita=?, cellulare=?, password=?, ruolo=?, stato=?, login_rimanenti=? WHERE id=?";
            ps = con.prepareStatement(query);
            
            ps.setString(1, user.getNome());
            ps.setString(2, user.getCognome());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getEmail());
            ps.setDate(5, new java.sql.Date(MyUtilities.convertToDate(user.getDataDiNascita()).getTime()));
            ps.setString(6, user.getCellulare());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getRuolo());
            ps.setString(9, user.getStato());
            ps.setInt(10, user.getLoginRimanenti());
            ps.setInt(11, user.getId());

            status = ps.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
	
	public static int save(User u){
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String query = "INSERT INTO psutenti(nome, cognome, username, email, data_di_nascita, cellulare, password, ruolo, stato, login_rimanenti) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setString(1, u.getNome());
            ps.setString(2, u.getCognome());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getEmail());
            ps.setDate(5, new java.sql.Date(MyUtilities.convertToDate(u.getDataDiNascita()).getTime()));
            ps.setString(6, u.getCellulare());
            ps.setString(7, u.getPassword());
            ps.setString(8, u.getRuolo());
            ps.setString(9, u.getStato());
            ps.setInt(10, u.getLoginRimanenti());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
	
	public static int saveUser(UserDemo u){
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String query = "INSERT INTO psutenti(nome, cognome, username, email, data_di_nascita, cellulare, password, ruolo, stato, login_rimanenti) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setString(1, u.getNome());
            ps.setString(2, u.getCognome());
            String username = MyUtilities.generateUsername(u.getNome(), u.getCognome(), u.getDataDiNascita().getYear());
            ps.setString(3, username);
            ps.setString(4, u.getEmail());
            ps.setDate(5, new java.sql.Date(MyUtilities.convertToDate(u.getDataDiNascita()).getTime()));
            ps.setString(6, u.getCellulare());
            ps.setString(7, u.getPassword());
            ps.setString(8, u.getRuolo());
            ps.setString(9, u.getStato());
            ps.setInt(10, MAX_LOGIN_ATTEMPTS);

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
	
	public static int changeStatus(User u) {
		if(u.getStato().equals("D")) {
			u.setStato("A");
			u.setLoginRimanenti(MAX_LOGIN_ATTEMPTS);
		} else {
			u.setStato("D");
			u.setLoginRimanenti(0);
		}
		
		return update(u);
	}
	
	public static int changeRole(User u) {
		if(u.getRuolo().equals("G")) {
			u.setRuolo("M");
		} else {
			u.setRuolo("G");
		}
		
		return update(u);
	}
	
}
