package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

//Para qualquer URL acessada
@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Não usa HTTPSERVLETREQUEST -> Serve pra qualquer protocolo

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI(); // Verifica a URI acessada

		String usuario = getUsuario(req);

		System.out.println("Usuário " + usuario + " acessando a URI " + uri);

		chain.doFilter(request, response); // Continue seu caminho

	}

	private String getUsuario(HttpServletRequest req) {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");

		if (usuario == null) {
			return "<deslogado>";
		}
		return usuario.getEmail();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
