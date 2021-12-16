package controller.promotions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import persistence.commons.DAOFactory;
import services.BuyPromotionService;

@WebServlet("/promotions/buy.do")
public class BuyPromotionServlet extends HttpServlet{

	private static final long serialVersionUID = 2647401166756358983L;
	private BuyPromotionService buyPromotionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.buyPromotionService = new BuyPromotionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer promocionId = Integer.parseInt(req.getParameter("id"));
		User user = (User) req.getSession().getAttribute("user");
		Map<String, String> errors;
		try {
			errors = buyPromotionService.buy(user.getId(), promocionId);
			User user2 = DAOFactory.getUserDAO().find(user.getId());
			req.getSession().setAttribute("user", user2);

			if (errors.isEmpty()) {
				req.setAttribute("success", "¡Gracias por comprar!");
			} else {
				req.setAttribute("errors", errors);
				req.setAttribute("flash", "No ha podido realizarse la compra");
			}

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/promotions/index.do");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
