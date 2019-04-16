package priv.huidong.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class upLoadServlet
 */
@WebServlet("/upLoadServlet")
public class upLoadServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		boolean isMultipart =ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//通过parseRequest解析form中的所有请求字段，并保存到items集合中（即前台传递的sno sname ）
			try {
				List<FileItem>  items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					int sno=-1;
					String sname = null;
					//判断前台字段是普通form表单字段还是文件字段
					if(item.isFormField()) {
						if(itemName.equals("sno")) {
							sno = Integer.parseInt(item.getString());
						}else if(itemName.equals("sname")) {
							sname = item.getString("UTF-8");
						}else {
							System.out.println("其他字段");
						}
					}else {
						//文件上传
					//文件名getFieldName是获取普通表单字段的name值
						//getName（）是获取文件名
						//用于获得文件上传字段中的文件名。注意IE或FireFox中获取的文件名是不一样的，IE中是绝对路径，FireFox中只是文件名。
						String filename = item.getName();//
						//获取文件内容并上传
						//定义我呢见路径：指定上传的位置（服务器路径）
						//获取服务器路径
						String path = request.getSession().getServletContext().getRealPath("upload");
						File file = new File(path,filename);
						
						item.write(file);//上传
						PrintWriter out = response.getWriter();
						out.println(filename+"上传成功！");
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
