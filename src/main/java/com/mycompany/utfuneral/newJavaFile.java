/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.utfuneral;


public class newJavaFile {    
    
    public class MySQLInicializadorBD{
        public void criarTabelas(){
            // implementação concreta
        }
    }
    
    public class PostgreSQLInicializadorBD{
        public void criarTabelas(){
            // implementação concreta
        }
    }
    
    public interface I_InicializadorBD {
        void criarTabelas(); // abstração
    }
    
    public class Banco_Ctrl {        
        private I_InicializadorBD inicializadorBD;

        private Banco_Ctrl(I_InicializadorBD inicializadorBD){
            this.inicializadorBD = inicializadorBD;
        }

        public void criarTabelas() throws Exception{
            inicializadorBD.criarTabelas();
        }        
    }
   
    
}
