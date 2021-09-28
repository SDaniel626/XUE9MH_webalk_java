package szamologepszervlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="szamologep", urlPatterns="/szamologep.do")
public class SzamologepServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultDto resultDto = new ResultDto();
		List<String> errorList = new ArrayList<String>();
		String aString = req.getParameter("a");
		Double a = 0.0;
		if(aString == null) {
			errorList.add("az a parameter nem lehet ures, kerem adja meg az a erteket");
		} else {
			try {
				a = Double.parseDouble(aString);
			} catch (NumberFormatException ex) {
				errorList.add("az a parameter szam kell hogy legyen");
			}
		}
		resultDto.setA(aString);
		
		String bString = req.getParameter("b");
		Double b = 0.0;
		if(bString == null) {
			errorList.add("a b parameter nem lehet ures, kerem adja meg a b erteket");
		} else {
			try {
				b = Double.parseDouble(bString);
			} catch (NumberFormatException ex) {
				errorList.add("a b parameter szam kell hogy legyen");
			}
		}		
		resultDto.setB(bString);
		
		String operator = req.getParameter("operator");
		resultDto.setOperator(operator);
		
		if (operator == null) {
			errorList.add("az operator parameter nem lehet ures");
		}
		
		Double result = 0.0;
		if (errorList.isEmpty()) {
			if ("+".equals(operator)) {
				result = a + b;
			} else {
				errorList.add("nem tamogatott muvelet");
			}
		}
		resultDto.setResult(result);
		resultDto.setErrorList(errorList);
		//eltarolja a keres attributumba az osszes infot, h a jsp is elerje 
		req.setAttribute("result", resultDto);
		
		//forward
		RequestDispatcher rd = req.getSession().getServletContext().getRequestDispatcher("/");
		
		rd.forward(req, resp);	
		
		//resp.getWriter().println("hi from servlet 2");
	}
	
}
