/*
 * package semi.team.baro.blacklist.controller;
 * 
 * import java.io.BufferedInputStream; import java.io.BufferedOutputStream;
 * import java.io.FileInputStream; import java.io.IOException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.ServletOutputStream; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import semi.team.baro.blacklist.model.service.BlacklistService; import
 * semi.team.baro.blacklist.model.vo.Blacklist;
 * 
 *//**
	 * Servlet implementation class BlacklistFileDownLoadServlet
	 */
/*
 * @WebServlet(name = "BlacklistFileDownLoad", urlPatterns = {
 * "/blacklistFileDownLoad.do" }) public class BlacklistFileDownLoadServlet
 * extends HttpServlet { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public BlacklistFileDownLoadServlet() { super(); // TODO Auto-generated
 * constructor stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * request.setCharacterEncoding("utf-8"); int blackNo =
 * Integer.parseInt(request.getParameter("blackNo")); BlacklistService service =
 * new BlacklistService(); //Blacklist bla = service.getBlacklist(blackNo); //
 * 1. 경로 생성 2. 읽기 스트림 생성 3. 쓰기 스트림 생성 4. 파일 명 설정 5. 파일 다운로드 설정 6. 파일 전송 //다운로드
 * 시킬 파일과 서블릿을 연결 String root = getServletContext().getRealPath("/"); String
 * downFile = root+"upload/blacklist/"+bla.getBlackFilepath(); //파일을 서블릿으로 읽어오기
 * 위한 스트림 생성 (+ 속도 개선위한 보조스트림까지 생성) FileInputStream fileInputStream = new
 * FileInputStream(downFile); BufferedInputStream bufferedInputStream = new
 * BufferedInputStream(fileInputStream); //읽어온 파일을 사용자에게 내보낼 스트림 생성 (+ 보조 스트림)
 * ServletOutputStream servletOutputStream = response.getOutputStream();
 * BufferedOutputStream bufferedOutputStream = new
 * BufferedOutputStream(servletOutputStream); //파일명 처리 //String resFilename =
 * new String(bla.getBlackFilepath().getBytes("utf-8"),"iso-8859-1"); //파일 다운로드를
 * 위한 HTTP 헤더 설정 response.setContentType("application/octeet-stream");
 * response.setHeader("Content-Disposition", "attachment;filename=" +
 * resFilename); //파일 전송 while(true) { int read = bufferedInputStream.read();
 * if(read != -1) { bufferedOutputStream.write(read); }else { break; } }
 * bufferedOutputStream.close(); bufferedInputStream.close(); }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */