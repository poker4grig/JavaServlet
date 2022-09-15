package ru.sergey.web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "C:\\Users\\poker\\Desktop\\names.csv";
    String line = "";
    String name = "";
    private static HashMap<String,String> dict = new HashMap<String,String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
            br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
            	String[] values = line.split(",");
            	dict.put(values[0], values[1]);
                               
            }       
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
//        } finally {
//        	if(br != null) {
//        		br.close();
//        	};
        }
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String surname = request.getParameter("surname");		
		response.setCharacterEncoding("cp1251");
		response.setContentType("charset=cp1251");
		
  		
		if (surname.isBlank()) {
			response.getWriter().append("Вы не ввели фамилию");
		}else if (dict.containsKey(surname)){
			response.getWriter().append("Человека с фамилией " + surname + " зовут ").append(dict.get(surname));
			
		}else {
			response.getWriter().append("Человека с фамилией " + surname + " нет в списке ");
		}
			
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
