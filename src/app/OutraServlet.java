package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pagina")
public class OutraServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if(session.getAttribute("logado") == null) {
			
			req.setAttribute("nao_logado", "Você não está logado");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			//resp.sendRedirect(req.getContextPath()+"/index.jsp");
		} else {
			//System.out.println("A sessão é: "+session);
			req.setAttribute("avisoSucesso", "Você está logado");
			RequestDispatcher rd = req.getRequestDispatcher("pagina.jsp");
			//resp.sendRedirect(req.getContextPath()+"/pagina.jsp");
			rd.forward(req, resp);
		}
	}
}
