package com.service;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class DownFileService {
	
	private static DownFileService downFileService;
	
	public static DownFileService getDownFileService(){
		if(downFileService == null){
			downFileService = new DownFileService();
		}
		return downFileService;
	}
	
	private DownFileService(){} 
	//==================================单例构造完毕
	
	// 预处理
	public ZipOutputStream preProcess(OutputStream res,ZipOutputStream zos,String filename) throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		res = response.getOutputStream();
		//清空输出流
		response.reset();
		//设定输出文件头
		System.out.println("inline filename = " + filename);

		response.setHeader("Content-disposition ","attachment; filename=" + filename);
		response.setContentType("application/zip");
		zos = new ZipOutputStream(res);

		System.out.println("end preprocess");

		if(zos==null)
			System.out.println("inline zops is null");

		return zos;
	}
	
	// 写文件到客户端
	public void outputZipFile(List<File> fileList,File sourceFile, ZipOutputStream zos)
			throws IOException, FileNotFoundException {
		ZipEntry ze = null;
		byte[] buf = new byte[1024];
		int readLen = 0;


		for(int i=0;i<fileList.size();i++){
			File file = fileList.get(i);
			// 1.动态压缩一个File到zip中
			// 创建一个ZipEntry，并设置Name和其它的一些属性
			// 压缩包中的路径和文件名称
			ze = new ZipEntry("1\\1\\" + file.getName());
			ze.setSize(file.length());
			ze.setTime(file.lastModified());
			// 将ZipEntry加到zos中，再写入实际的文件内容
			zos.putNextEntry(ze);
		}
		InputStream is = new BufferedInputStream(new FileInputStream(sourceFile));
		// 把数据写入到客户端
		while ((readLen = is.read(buf, 0, 1024)) != -1) {
			zos.write(buf, 0, readLen);
		}
		is.close();
		
		
//		// 2.动态压缩一个String到zip中
//		String customFile = "This is a text file.";
//		// 压缩包中的路径和文件名称
//		ZipEntry cze = new ZipEntry("1\\1\\" + "Test.txt");
//		zos.putNextEntry(cze);
//		
//		// 利用ByteArrayInputStream把流数据写入到客户端
//		is = new ByteArrayInputStream(customFile.getBytes());
//		while ((readLen = is.read(buf, 0, 1024)) != -1) {
//			zos.write(buf, 0, readLen);
//		}
//		is.close();
	}
}
