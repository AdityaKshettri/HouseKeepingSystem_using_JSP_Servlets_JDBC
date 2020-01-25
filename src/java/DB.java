import java.sql.*;
import java.util.*;

public class DB 
{
    static final String driver="org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/aditya";
    static final String USER = "aditya";
    static final String PASS = "1234";
    static Connection con=null;
    
    public static void main(String args[])throws SQLException,ClassNotFoundException
    {
        Class.forName(driver);
        con=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Connected to database successfully...");
        Statement st = con.createStatement();
        st.execute("CREATE TABLE TASKALLOCATED (assetId varchar(100) not null, taskId varchar(100) primary key not null, workerId varchar(100) not null, timeOfAllocation varchar(100) not null, taskToBePerformedBy varchar(100) not null)"); 
        st.execute("CREATE TABLE ASSET (assetId varchar(100) primary key not null, assetname varchar(100) not null, quantity varchar(100) not null, place varchar(100) not null)"); 
        st.execute("CREATE TABLE TASK (taskId varchar(100) primary key not null, taskname varchar(100) not null, freq varchar(100) not null)"); 
        st.execute("CREATE TABLE WORKER (workerId varchar(100) primary key not null, workername varchar(100) not null, skills varchar(100) not null)"); 
    }
}
