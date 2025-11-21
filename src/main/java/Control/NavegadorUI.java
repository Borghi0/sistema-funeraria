package Control;

import Interfaces.I_JanelaRaiz;
import View.*;
import Model.*;


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
    private JCadAltVelorio jCadVelorio;
    private JCadAltVelorio jAltVelorio;
    private JRelatorioUsuario jRelatorioUsuario;
    
    // janelas do usuario
    
    
    // janelas do admin e usuario
    private JRelatorioPlano jRelatorioPlano;
    private JAlterarUsuario jAlterarUsuario;
    
    
    public NavegadorUI(){}

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
            fecharJMenuUsuario();
        }
        else if(jAdmin != null){            
            fecharJAdmin();
        }
        mostrarJLogin();
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
        if(jRelatorioUsuario != null){
            jRelatorioUsuario.dispose();
            jRelatorioUsuario = null;
        }
        if(jCadVelorio!=null){
            jCadVelorio.dispose();
            jCadVelorio = null;
        }
        if(jAltVelorio!=null){
            jAltVelorio.dispose();
            jAltVelorio = null;
        }        
    }
    
    public void mostrarJRelatorioPlano(Usuario usuario){
        if(jRelatorioPlano == null) jRelatorioPlano = new JRelatorioPlano(this, usuario);
        
        jRelatorioPlano.setVisible(true);        
        jRelatorioPlano.toFront();
    }
    
    public void mostrarJCadAltPlano(Plano plano, boolean modoCadastro){
        if(modoCadastro){
            if(jCadPlano == null) jCadPlano = new JCadAltPlano(null, true);
                    
            jCadPlano.setVisible(true);            
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
        jCadRelatServico.toFront();
    }
    
    public void mostrarJRelatorioUsuario(){
        if(jRelatorioUsuario == null) jRelatorioUsuario = new JRelatorioUsuario(this);
        
        jRelatorioUsuario.setVisible(true);
        jRelatorioUsuario.toFront();
    }
    
    public void fecharJRelatorioUsuario(){
        if(jRelatorioUsuario != null){
            jRelatorioUsuario.setVisible(false);
            jRelatorioUsuario = null;
        }
    }
    
    public void mostrarJAlterarUsuario(I_JanelaRaiz janelaRaiz, Usuario usuario){
        if(jAlterarUsuario != null) jAlterarUsuario.dispose();
        
        jAlterarUsuario = new JAlterarUsuario(janelaRaiz, usuario);
        jAlterarUsuario.setVisible(true);               
    }
    
    public void atualizarMenuUsuario(Usuario usuario){
        jMenuUsuario.setUsuario(usuario);
    }
}
