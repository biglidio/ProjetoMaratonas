package maratonas.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import maratonas.entity.Usuario;
import session.SessionContext;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {
    private static final String LOGIN = "fatec";
    private static final String PASSWORD = "123";
    private Usuario usuario = new Usuario();

    public UsuarioBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMessage() {
        SessionContext session = SessionContext.getInstance();
        String message = (String) session.getAttribute("message");
        return message;
    }

    
    public String autenticar() {
        SessionContext session = SessionContext.getInstance();
        if (usuario.getLogin().equals(LOGIN) && usuario.getSenha().equals(PASSWORD)) {
            session.setAttribute("usuario", usuario);
            return "/protected/index";
        } else {
            this.sair();
        }
        session.setAttribute("message", "Login/senha inválidos");
        return null;
    }
    
    public String sair() {
        SessionContext session = SessionContext.getInstance();
        session.encerrarSessao();
        return "/login";
    }
}
