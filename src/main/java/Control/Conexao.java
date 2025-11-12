/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Control;

/**
 *
 * @author joaop
 */
import java.sql.*;

public class Conexao{
	static Connection conexao = null;
	static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
	static String senha = "";
	static String user = "";
	static String driver = "com.mysql.cj.jdbc.Driver";

	public static void main(){
            try{
                Class.forName(driver);
            } catch(Exception e){
                System.out.println("Falha no carregamento do driver");
            }
            
            try{
                conexao = DriverManager.getConnection(url, user, senha);
            } catch(Exception e){
                System.out.println("Falha na conexão");
            }
	}
}
