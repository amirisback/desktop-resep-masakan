/*
 * Muhammad Faisal Amir
 * f.miir117@gmail.com
 * id.amirisback.bandung
 * Copyright 2017
 */
package dnb;

import java.io.File; //import library file

//import library dari pluggin library JDBC MySQL--------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
//------------------------------------------------------------------------------

/**
 *
 * @author Faisal Amir
 */
public class connection {
    //Deklarasi data path hasil program ----------------------------------------
    private String Folder_Data = "C:/DapurNB";
    private String Folder_Excel = Folder_Data + "/Data_Excel";
    //--------------------------------------------------------------------------
    
    
    //Deklarasi operasi CRUD Database-------------------------------------------
    private PreparedStatement preStatement;
    private Statement statement;
    private Connection connect;
    private ResultSet resultSet;
    //--------------------------------------------------------------------------
    
    
    //Koneksi MySQL-------------------------------------------------------------
    //private String driver = "com.mysql.jdbc.Driver";
    //private String url_db = "jdbc:mysql://localhost:3306/promadika";
    //private String user_db = "root";
    //private String pw_db = "";
    //--------------------------------------------------------------------------
    
    
    //Koneksi SQLite------------------------------------------------------------
    private String driver = "com.mysql.jdbc.Driver";
    private String Nama_database = "DataBaseDapurNB.db";
    private String url = Folder_Data + "/" + Nama_database;
    private String url_db = "jdbc:sqlite:" + url;
    private String sql_table_data_akun;
    private String sql_table_data_pulau;
    private String sql_table_data_masakan;
    private String sql = "";
    private String sql1, sql2, sql3, sql4, sql5, sql6, sql7;
    //--------------------------------------------------------------------------
    
    public connection() {
    }

    public PreparedStatement getPreStatement() {
        return preStatement;
    }

    public void setPreStatement(PreparedStatement preStatement) {
        this.preStatement = preStatement;
    }
    
    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl_db() {
        return url_db;
    }

    public void setUrl_db(String url_db) {
        this.url_db = url_db;
    }

//    public String getUser_db() {
//        return user_db;
//    }
//
//    public void setUser_db(String user_db) {
//        this.user_db = user_db;
//    }
//
//    public String getPw_db() {
//        return pw_db;
//    }
//
//    public void setPw_db(String pw_db) {
//        this.pw_db = pw_db;
//    }
    
    public String getFolder_Data() {
        return Folder_Data;
    }

    public void setFolder_Data(String Folder_Data) {
        this.Folder_Data = Folder_Data;
    }

    public String getFolder_Excel() {
        return Folder_Excel;
    }

    public void setFolder_Excel(String Folder_Excel) {
        this.Folder_Excel = Folder_Excel;
    }

    //Setter Getter Database SQLite---------------------------------------------
    public String getNama_database() {
        return Nama_database;
    }

    public void setNama_database(String Nama_database) {
        this.Nama_database = Nama_database;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSql_table_data_akun() {
        return sql_table_data_akun;
    }

    public void setSql_table_data_akun(String sql_table_data_akun) {
        this.sql_table_data_akun = sql_table_data_akun;
    }

    public String getSql_table_data_pulau() {
        return sql_table_data_pulau;
    }

    public void setSql_table_data_pulau(String sql_table_data_pulau) {
        this.sql_table_data_pulau = sql_table_data_pulau;
    }

    public String getSql_table_data_masakan() {
        return sql_table_data_masakan;
    }

    public void setSql_table_data_masakan(String sql_table_data_masakan) {
        this.sql_table_data_masakan = sql_table_data_masakan;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    

    //--------------------------------------------------------------------------

    //Create DataBase SQLite----------------------------------------------------
    public void createAllTable(){
        sql_table_data_akun = "CREATE TABLE data_akun (\n"
                + "    username VARCHAR (20) PRIMARY KEY,\n"
                + "    password VARCHAR (20),\n"
                + "    nama     VARCHAR (35),\n"
                + "    telp     VARCHAR (15),\n"
                + "    email    VARCHAR (30),\n"
                + "    status   VARCHAR (10) \n"
                + ");";
        
        sql_table_data_pulau = "CREATE TABLE table_pulau (\n"
                + "    id_pulau   VARCHAR (25) PRIMARY KEY,\n"
                + "    nama_pulau VARCHAR (25) \n"
                + ");";
        
        sql_table_data_masakan = "CREATE TABLE data_masakan (\n"
                + "    id_masakan    VARCHAR (15)   PRIMARY KEY,\n"
                + "    nama_masakan  VARCHAR (20),\n"
                + "    bahan_masakan VARCHAR (1000),\n"
                + "    resep_masakan VARCHAR (5000),\n"
                + "    id_pulau                  REFERENCES data_pulau (id_pulau) ON DELETE CASCADE\n"
                + "                                                                         ON UPDATE CASCADE\n"
                + ");";
        
        try {
            statement = connect.createStatement();

            statement.execute(sql_table_data_akun);

            statement.execute(sql_table_data_pulau);

            statement.execute(sql_table_data_masakan);      
        } catch (SQLException e) {
        }

    }   
    //--------------------------------------------------------------------------*/
    
    public void insertImportantData(){
        sql = "INSERT INTO data_akun(username, password, nama, telp, email, status) VALUES ('admin','admin','admin','admin','081357108568','admin');";
        sql1 = "INSERT INTO table_pulau(id_pulau, nama_pulau) VALUES ('IDP_SUMATRA','Sumatra');";
        sql2 = "INSERT INTO table_pulau(id_pulau, nama_pulau) VALUES ('IDP_KALIMANTAN','Kalimantan');";
        sql3 = "INSERT INTO table_pulau(id_pulau, nama_pulau) VALUES ('IDP_JAWA','Jawa');";
        sql4 = "INSERT INTO table_pulau(id_pulau, nama_pulau) VALUES ('IDP_BALI','Bali');";
        sql5 = "INSERT INTO table_pulau(id_pulau, nama_pulau) VALUES ('IDP_NT','Nusa Tenggara');";
        sql6 = "INSERT INTO table_pulau(id_pulau, nama_pulau) VALUES ('IDP_SULAWESI','Sulawesi');";
        sql7 = "INSERT INTO table_pulau(id_pulau, nama_pulau) VALUES ('IDP_PAPUA','Papua');";
        try {
            statement = connect.createStatement();
            statement.execute(sql);
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
            statement.execute(sql4);
            statement.execute(sql5);
            statement.execute(sql6);
            statement.execute(sql7);
        } catch (Exception e) {
        }
    }
    
    
    public void ConnectToDB(){
        try{
            File folder = new File(Folder_Data);
            if (!folder.exists()) {
                folder.mkdir();
            }
            
            //Source Code Koneksi MySQL-----------------------------------------
            //Class.forName(driver);
            //connect = DriverManager.getConnection(url_db, user_db, pw_db);       
            //------------------------------------------------------------------
              
            //Source Code Koneksi SQLite----------------------------------------
            connect = DriverManager.getConnection(url_db);
            DatabaseMetaData meta = connect.getMetaData();
            //------------------------------------------------------------------
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
        
    public void dataDapurNB() {
        try {
            //Membuat Folder Data------------------------------------------------
            File folder_excel = new File(Folder_Excel);
            if (!folder_excel.exists()) {
                folder_excel.mkdir();
            }
            //------------------------------------------------------------------
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
