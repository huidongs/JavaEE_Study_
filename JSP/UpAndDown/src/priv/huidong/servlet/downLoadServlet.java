package priv.huidong.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class downLoadServlet
 */
@WebServlet("/downLoadServlet")
public class downLoadServlet extends HttpServlet {
	//IE:文件转码URLEncoder.encode(fileName,"UTF-8");

//    //仅提供了部分代码，因为我们已经明确问题的所在，知道修改那一部分了，（代码中downloadFileName 即代表 *=utf-8'zh_cn'文件名.xx部分）
//    String agent = (String)getRequest().getHeader("USER-AGENT");  
//     if(agent != null && agent.toLowerCase().indexOf("firefox") > 0)
//     {
//         downloadFileName = "=?UTF-8?B?" + (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";    
//     }
//     else
//     {
//         downloadFileName =  java.net.URLEncoder.encode(fileName, "UTF-8");
//     }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//获取需要下载的文件名
		
		String fileName = request.getParameter("filename");
		//下载文件：需要设置消息头
		response.addHeader("contentType","application/octet-stream");
		response.addHeader("content-Disposition","attachment;filename"+fileName);
		//Servlet通过文件的地址，将文件转为输入流，读到Servlet中
		InputStream in = getServletContext().getResourceAsStream("/res/test.png");
		ServletOutputStream out = response.getOutputStream(); 
		byte[] bs = new byte[10];
		int len = -1;
		while((len=in.read(bs))!=-1) {
			out.write(bs,0,len);
		}
		out.close();
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
