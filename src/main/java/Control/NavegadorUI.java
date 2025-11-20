package Control;

import View.*;
import Model.*;


public class NavegadorUI {    
    private JConexaoBD jConexaoBD;
    private JLogin jLogin;
    private JCadastro jCadastro;
    
    private JAdmin jAdmin;
    private JMenuUsuario jMenuUsuario;
    
    // janelas do admin
    private JRelatorioPlano jRelatorioPlano;
    private JCadAltPlano jCadPlano;
    private JCadAltPlano jAltPlano;
    private JCadRelatServico jCadRelatServico;
    
    public NavegadorUI(){
        
    }

    public void mostrarJConexaoBD(){
        if(jConexaoBD == null) jConexaoBD = new JConexaoBD(this);
                
        jConexaoBD.setVisible(true);        
        jConexaoBD.toFront();
    }
    
    public void mostrarJLogin(){
        if(jLogin == null) jLogin = new JLogin(this);
        
        jLogin.setVisible(true);        
        jLogin.toFront();
    }
    
    public void mostrarJCadastro(){
        if(jCadastro == null) jCadastro = new JCadastro(this);
        
        jCadastro.setVisible(true);        
        jCadastro.toFront();
    }
    
    private void mostrarJAdmin(Usuario usuario){
        if(jAdmin == null) jAdmin = new JAdmin(this, usuario);
        
        jAdmin.setVisible(true);        
        jAdmin.toFront();
    }

    private void mostrarJMenuUsuario(Usuario usuario){
        if(jMenuUsuario == null) jMenuUsuario = new JMenuUsuario(this, usuario);
        
        jMenuUsuario.setVisible(true);
        jMenuUsuario.toFront();
    }
    
    public void logar(Usuario usuario){
        if(usuario.isAdmin()) mostrarJAdmin(usuario);
        else mostrarJMenuUsuario(usuario);
    }
    
    public void deslogar(){
        if(jMenuUsuario != null){
            jMenuUsuario.dispose();
            jMenuUsuario = null;
        }
        else if(jAdmin != null){            
            fecharJAdmin();
        }
        mostrarJLogin();
    }
    
    public void fecharJAdmin(){
        jAdmin.dispose();
        jAdmin = null;
        jRelatorioPlano.dispose();
        jRelatorioPlano = null;
        jCadPlano.dispose();
        jCadPlano = null;        
        jAltPlano.dispose();
        jAltPlano = null;
        jCadRelatServico.dispose();
        jCadRelatServico = null;
        //fechar demais janelas associadas
    }
    
    public void mostrarJRelatorioPlano(Usuario usuario){
        if(jRelatorioPlano == null) jRelatorioPlano = new JRelatorioPlano(this, usuario);
        
        jRelatorioPlano.setVisible(true);        
        jRelatorioPlano.toFront();
    }
    
    public void mostrarJAltPlano(Plano plano){
        if(jAltPlano != null) jAltPlano.dispose();
        
        jAltPlano = new JCadAltPlano(plano, false);        
        jAltPlano.setVisible(true);        
    }
    
    public void mostrarJCadPlano(){
        if(jCadPlano != null) jCadPlano.dispose();
        
        jCadPlano = new JCadAltPlano(null, true);        
        jCadPlano.setVisible(true);        
    }
    
    public void mostrarJCadRelatServico(){
        if(jCadRelatServico == null) jCadRelatServico = new JCadRelatServico();
        
        jCadRelatServico.setVisible(true);        
        jCadRelatServico.toFront();
    }
    
}
