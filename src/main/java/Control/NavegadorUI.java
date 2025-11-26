package Control;

import View.*;
import Model.*;
import Interfaces.JanelaRaiz;


public class NavegadorUI {    
    private JConexaoBD jConexaoBD;
    private JLogin jLogin;
    private JCadastro jCadastro;
    
    private JAdmin jAdmin;
    private JMenuUsuario jMenuUsuario;
    
    // janelas do admin    
    private JCadAltPlano jCadPlano;
    private JCadAltPlano jAltPlano;
    private JCadRelatServico jCadRelatServico;
    private JCadRelatProduto jCadRelatProduto;
    private JCadAltVelorio jCadVelorio;
    private JCadAltVelorio jAltVelorio;
    private JRelatorioUsuario jRelatorioUsuario;
    private JRelatorioDefunto jRelatorioDefunto;
    private JSala jSala;    
    private JAlterarDefunto jAlterarDefunto;
    private JCadastroDefunto jCadastroDefunto;    
    
    // janelas do admin e usuario
    private JRelatorioPlano jRelatorioPlano;
    private JAlterarUsuario jAlterarUsuario;
    
    
    public NavegadorUI(){}

    public void mostrarJConexaoBD(){
        if(jConexaoBD == null) jConexaoBD = new JConexaoBD(this);
                
        jConexaoBD.setVisible(true);
        jConexaoBD.setState(java.awt.Frame.NORMAL);
        jConexaoBD.toFront();
    }
    
    public void mostrarJLogin(){
        if(jLogin == null) jLogin = new JLogin(this);
        
        jLogin.setVisible(true);        
        jLogin.setState(java.awt.Frame.NORMAL);
        jLogin.toFront();
    }
    
    public void mostrarJCadastro(){
        if(jCadastro == null) jCadastro = new JCadastro(this);
        
        jCadastro.setVisible(true);
        jCadastro.setState(java.awt.Frame.NORMAL);
        jCadastro.toFront();
    }        
    
    public void logar(Usuario usuario){
        if(usuario.isAdmin()) mostrarJAdmin(usuario);
        else mostrarJMenuUsuario(usuario);
    }
    
    public void deslogar(){
        if(jMenuUsuario != null){
            fecharJMenuUsuario();
        }
        else if(jAdmin != null){            
            fecharJAdmin();
        }
        mostrarJLogin();
    }
    
    private void mostrarJAdmin(Usuario usuario){
        if(jAdmin == null) jAdmin = new JAdmin(this, usuario);
        
        jAdmin.setVisible(true);
        jAdmin.setState(java.awt.Frame.NORMAL);
        jAdmin.toFront();
    }

    private void mostrarJMenuUsuario(Usuario usuario){
        if(jMenuUsuario == null) jMenuUsuario = new JMenuUsuario(this, usuario);
        
        jMenuUsuario.setVisible(true);
        jMenuUsuario.setState(java.awt.Frame.NORMAL);
        jMenuUsuario.toFront();
    }
    
    private void fecharJMenuUsuario(){
        jMenuUsuario.dispose();
        jMenuUsuario = null;
        if(jRelatorioPlano!=null){
            jRelatorioPlano.dispose();
            jRelatorioPlano = null;
        }
        if(jAlterarUsuario!=null){
            jAlterarUsuario.dispose();
            jAlterarUsuario = null;
        }
    }
    
    private void fecharJAdmin(){
        jAdmin.dispose();
        jAdmin = null;
        if(jRelatorioPlano!=null){
            jRelatorioPlano.dispose();
            jRelatorioPlano = null;
        }
        if(jAlterarUsuario!=null){
            jAlterarUsuario.dispose();
            jAlterarUsuario = null;
        }
        if(jCadPlano!=null){
            jCadPlano.dispose();
            jCadPlano = null;
        }
        if(jAltPlano!=null){
            jAltPlano.dispose();
            jAltPlano = null;
        }
        if(jCadRelatServico!=null){
            jCadRelatServico.dispose();
            jCadRelatServico = null;
        }
        if(jCadRelatProduto!=null){
            jCadRelatProduto.dispose();
            jCadRelatProduto = null;
        }        
        if(jCadVelorio!=null){
            jCadVelorio.dispose();
            jCadVelorio = null;
        }
        if(jAltVelorio!=null){
            jAltVelorio.dispose();
            jAltVelorio = null;
        }
        if(jRelatorioUsuario != null){
            jRelatorioUsuario.dispose();
            jRelatorioUsuario = null;
        }        
        if(jRelatorioDefunto!=null){
            jRelatorioDefunto.dispose();
            jRelatorioDefunto = null;
        }        
        if(jCadRelatProduto!=null){
            jCadRelatProduto.dispose();
            jCadRelatProduto = null;
        }
        if(jSala != null){
            jSala.dispose();
            jSala = null;
        }
        if(jAlterarDefunto != null){
            jAlterarDefunto.dispose();
            jAlterarDefunto = null;
        }
        if(jCadastroDefunto != null){
            jCadastroDefunto.dispose();
            jCadastroDefunto = null;
        }
    }
    
    public void mostrarJRelatorioPlano(Usuario usuario){
        if(jRelatorioPlano == null) jRelatorioPlano = new JRelatorioPlano(this, usuario);
        
        jRelatorioPlano.setVisible(true);
        jRelatorioPlano.setState(java.awt.Frame.NORMAL);
        jRelatorioPlano.toFront();
    }
    
    public void mostrarJCadAltPlano(Plano plano, boolean modoCadastro){
        if(modoCadastro){
            if(jCadPlano == null) jCadPlano = new JCadAltPlano(null, true);
                                
            jCadPlano.setVisible(true);
            jCadPlano.setState(java.awt.Frame.NORMAL);
            jCadPlano.toFront();
        }else{
            if(jAltPlano != null) jAltPlano.dispose();
            
            jAltPlano = new JCadAltPlano(plano, false);
            jAltPlano.setVisible(true);
        }
    }
    
    public void mostrarJCadAltVelorio(Velorio velorio, boolean modoCadastro){
        if(modoCadastro){
            if(jCadVelorio == null) jCadVelorio = new JCadAltVelorio(velorio, true);

            jCadVelorio.setVisible(true);
            jCadVelorio.setState(java.awt.Frame.NORMAL);
            jCadVelorio.toFront();
        }else{
            if(jAltVelorio != null) jAltVelorio.dispose();
        
            jAltVelorio = new JCadAltVelorio(velorio, false);        
            jAltVelorio.setVisible(true);  
        }
    }
    
    public void mostrarJCadRelatServico(){
        if(jCadRelatServico == null) jCadRelatServico = new JCadRelatServico();
        
        jCadRelatServico.setVisible(true);
        jCadRelatServico.setState(java.awt.Frame.NORMAL);        
        jCadRelatServico.toFront();
    }
    
    public void mostrarJCadRelatProduto(){
        if(jCadRelatProduto == null) jCadRelatProduto = new JCadRelatProduto();
        
        jCadRelatProduto.setVisible(true);
        jCadRelatProduto.setState(java.awt.Frame.NORMAL);
        jCadRelatProduto.toFront();
    }
    
    public void mostrarJRelatorioUsuario(Usuario usuario){
        if(jRelatorioUsuario == null) jRelatorioUsuario = new JRelatorioUsuario(usuario);
        
        jRelatorioUsuario.setVisible(true);
        jRelatorioUsuario.setState(java.awt.Frame.NORMAL);
        jRelatorioUsuario.toFront();
    }        
    
    public void mostrarJAlterarUsuario(JanelaRaiz janelaRaiz, Usuario usuario){
        if(jAlterarUsuario != null) jAlterarUsuario.dispose();
        
        jAlterarUsuario = new JAlterarUsuario(janelaRaiz, usuario);
        jAlterarUsuario.setVisible(true);               
    }                
            
    public void mostrarJRelatorioDefunto(){
        if(jRelatorioDefunto == null) jRelatorioDefunto = new JRelatorioDefunto(this);
        
        jRelatorioDefunto.setVisible(true);
        jRelatorioDefunto.setState(java.awt.Frame.NORMAL);
        jRelatorioDefunto.toFront();
    }
    
    public void mostrarJCadastroDefunto(){
        if(jCadastroDefunto == null) jCadastroDefunto = new JCadastroDefunto();
        
        jCadastroDefunto.setVisible(true);
        jCadastroDefunto.setState(java.awt.Frame.NORMAL);
        jCadastroDefunto.toFront();
    }
    
    public void mostrarJAlterarDefunto(Defunto defunto){
        if(jAlterarDefunto == null) jAlterarDefunto = new JAlterarDefunto(defunto);
        
        jAlterarDefunto.setVisible(true);
        jAlterarDefunto.setState(java.awt.Frame.NORMAL);
        jAlterarDefunto.toFront();
    }            
    
    public void mostarJSala(){
        if(jSala == null) jSala = new JSala();
        
        jSala.setVisible(true);
        jSala.setState(java.awt.Frame.NORMAL);
        jSala.toFront();
    }
    
    public void atualizarMenuUsuario(Usuario usuario){
        jMenuUsuario.setUsuario(usuario);
    }
}
