package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Timer;

/**
 * Servlet implementation class RequestController
 */
@WebServlet("/RequestController")
public class RequestController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String headers[] = { "host", "user-agent", "accept", "accept-language", "accept-encoding",
			"content-type", "x-requested-with", "referer", "content-length", "connection" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		handleRequest("D:/ML/cdap_web/web_project/feature_table.csv", request, response);
	}

	private void handleRequest(String filePath, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		PrintWriter out = response.getWriter();
		PrintWriter pw = new PrintWriter(new File(filePath));
		StringBuilder sb = new StringBuilder();

		// arrays to store headers and its values
		ArrayList<String> headerList = new ArrayList<>();
		ArrayList<String> valueList = new ArrayList<>();

		// filter header and its values
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);

			// get value according to needed header
			if (Arrays.stream(headers).anyMatch(key::equals)) {
				out.print("<br>K = " + key + ", V = " + value);

				// if value contains comma replace it with "|"
				value = value.replace(",", "|");

				headerList.add(key);
				valueList.add(value);
			}
		}

		for (String header : headerList) {
			sb.append(header);
			sb.append(',');
		}
		sb.append('\n');

		for (String value : valueList) {
			sb.append(value);
			sb.append(',');
		}
		sb.append('\n');

		
		//for every 3 secs get request and fill feature table
		Timer timer = new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getRequestTimely(pw, sb, request, response);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		timer.setRepeats(false); // Only execute once
		timer.start();

		pw.write(sb.toString());
		pw.close();

	}

	private void getRequestTimely(PrintWriter pw, StringBuilder sb, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		// arrays to store headers and its values
		ArrayList<String> valueList = new ArrayList<>();

		// filter header and its values
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);

			// get value according to needed header
			if (Arrays.stream(headers).anyMatch(key::equals)) {
				out.print("<br>KR = " + key + ", VR = " + value);

				// if value contains comma replace it with "|"
				value = value.replace(",", "|");
				valueList.add(value);
			}
		}

		for (String value : valueList) {
			sb.append(value);
			sb.append(',');
		}
		sb.append('\n');

	}
}
