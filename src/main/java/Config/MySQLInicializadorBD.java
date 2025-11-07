package Config;

import Control.Banco_Ctrl;
import Interfaces.I_InicializadorBD;
import java.sql.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MySQLInicializadorBD implements I_InicializadorBD{
    private static MySQLInicializadorBD instancia;
    
    private MySQLInicializadorBD(){}
    
    public static MySQLInicializadorBD getInstancia(){
        if(instancia==null) instancia = new MySQLInicializadorBD();
        return instancia;
    }
    
    @Override
    public void criarTabelas() throws Exception{
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        Statement st = con.createStatement();
        File script = new File("UTFuneral.sql");
        String linha = new String();
        StringBuilder texto_script = new StringBuilder();
        
        try(Scanner leitor = new Scanner(script)){
            while(leitor.hasNextLine()){
                linha = leitor.nextLine();
                texto_script.append(linha);
            }
            
            String[] sts = texto_script.toString().split(";");
            
            for (String executavel : sts) {
                if(!executavel.trim().equals(""))
                    st.executeUpdate(executavel);
            }
            
        } catch(FileNotFoundException fnfe){
            System.out.println("Arquivo inexistente no diretório ou corrompido");
        } finally{
            st.close();
            con.close();
        }
    }
}
