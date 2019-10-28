package bean;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class UserBean {
 
    private String first_name, last_name, email, uname, pass, regdate, selectedname, msg="";
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getFirst_name() {
        return first_name;
    }
 
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
 
    public String getLast_name() {
        return last_name;
    }
 
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
 
    public String getPass() {
        return pass;
    }
 
    public void setPass(String pass) {
        this.pass = pass;
    }
 
    public String getRegdate() {
        return regdate;
    }
 
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
 
    public String getSelectedname() {
        return selectedname;
    }
 
    public void setSelectedname(String selectedname) {
        this.selectedname = selectedname;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public List<SelectItem> getFullName() {
        List<SelectItem> retVal = new ArrayList<SelectItem>();
 
        try {
            Connection con = Database.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String myQuery = "SELECT concat(first_name, ' ', last_name) as name FROM members";
 
            rs = st.executeQuery(myQuery);
            while (rs.next()) {
                retVal.add(new SelectItem(rs.getString("name")));
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return retVal;
    }
 
   
    
}
