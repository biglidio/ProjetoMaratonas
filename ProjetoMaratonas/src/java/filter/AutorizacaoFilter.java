/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import maratonas.bean.UsuarioBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import maratonas.entity.Usuario;

/**
 *
 * @author ciro
 */
@WebFilter(urlPatterns = "/faces/protected/*")
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession sessao = ((HttpServletRequest) request).getSession();
        Usuario user = (Usuario) sessao.getAttribute("usuario");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            if (user == null) {
                user = new Usuario();
            }
            sessao.setAttribute("usuario", user);
            sessao.setAttribute("message", "Faça o login");
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).
                    sendRedirect(contextPath + "/faces/index.xhtml");
        }

    }

    @Override
    public void destroy() {
    }

}
