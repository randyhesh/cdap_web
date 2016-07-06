package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String filePath = "D:/ML/cdap_web/web_project/feature_table.csv";
		PrintWriter out = response.getWriter();
		String val = request.getParameter("func");

		if (val.equals("1")) {
			out.print("<br>header n value");
			handleRequest(out, filePath, request, response);

		} else {
			out.print("<br>repeat value");
			getRequestTimely(out, filePath, request, response);
		}
	}

	private void handleRequest(PrintWriter out, String filePath, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		FileWriter fw = new FileWriter(filePath);

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

		String headerLine = "";
		for (String header : headerList) {
			headerLine += header;
			headerLine += ",";
		}
		headerLine += "\n";
		fw.append(headerLine);

		String valueLine = "";
		for (String value : valueList) {
			valueLine += value;
			valueLine += ",";
		}
		valueLine += "\n";
		fw.append(valueLine);

		fw.close();

	}

	private void getRequestTimely(PrintWriter out, String filePath, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		FileWriter fw = new FileWriter(filePath, true);
		BufferedWriter bw = new BufferedWriter(fw);

		// arrays to store headers and its values
		ArrayList<String> valueList = new ArrayList<>();

		// filter header and its values
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);

			// get value according to needed header
			if (Arrays.stream(headers).anyMatch(key::equals)) {
				out.print("<br>RK = " + key + ", RV = " + value);

				// if value contains comma replace it with "|"
				value = value.replace(",", "|");
				valueList.add(value);
			}
		}

		String valueLine = "";
		for (String value : valueList) {
			valueLine += value;
			valueLine += ",";
		}
		valueLine += "\n";

		bw.write(valueLine);

		bw.close();
	}
}
