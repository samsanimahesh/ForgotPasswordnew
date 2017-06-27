package com.mahesh.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mahesh.beans.UserDetails;
import com.mahesh.constant.Constants;
import com.mahesh.dao.DataAccess;

/**
 * Servlet implementation class CustomerRegServlet
 */
@WebServlet({ "/CustomerRegServlet"})
public class CustomerRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		UserDetails userDetails = createBean(request);
		
		DataAccess access = new DataAccess();
		int userId = access.saveUserDetails(userDetails);
		if(userId == -1){
			response.sendRedirect("error page");
		}else{
			response.sendRedirect("success page");
		}
	}

	private UserDetails createBean(HttpServletRequest request) {
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(request.getParameter(Constants.FIRST_NAME));
		userDetails.setLastName(request.getParameter(Constants.LAST_NAME));
		userDetails.setDob(request.getParameter(Constants.DATE_OF_BIRTH));
		userDetails.setEmailId(request.getParameter(Constants.EMAIL_ID));
		userDetails.setPassword(request.getParameter(Constants.PASSWORD));
		userDetails.setSecurityQuestion(request.getParameter(Constants.SECURITY_QUESTION));
		userDetails.setAnswer(request.getParameter(Constants.ANSWER));
		userDetails.setAddress(request.getParameter(Constants.ADDRESS));
		userDetails.setPhoneNumber(request.getParameter(Constants.PHONE_NUMBER));
		return userDetails;
	}

}
