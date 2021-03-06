package persistence.commons;

import model.Itinerario;
import persistence.AttractionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.impl.AttractionDAOImpl;
import persistence.impl.PromocionDAOImpl;
import persistence.impl.UserDAOImpl;

public class DAOFactory {

	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}

	public static AttractionDAO getAttractionDAO() {
		return new AttractionDAOImpl();
	}

	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
	}

	public static ItinerarioDAO getItinerarioDAO() {
		// TODO Auto-generated method stub
		return new ItinerarioDAO();
	}
}
