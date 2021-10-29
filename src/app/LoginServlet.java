package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("campo_nome");
		String password = req.getParameter("campo_password");
		
		if(user.equals("admin") && password.equals("admin")) {
			HttpSession session = req.getSession();
		
			session.setAttribute("id", "500");
			session.setAttribute("user", "swordsman");
			session.setAttribute("logado", true);
			session.setMaxInactiveInterval(60);
			//System.out.println(req.getContextPath());
			
			String sucesso = "Você está logado";
			req.setAttribute("sucesso", sucesso);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			//resp.sendRedirect(req.getContextPath()+"/feedback_positivo");
		} else {
			String erro = "Suas informações estão incorretas";
			req.setAttribute("erro", erro);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
}
