<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*"%> 
<%@ page import="java.text.SimpleDateFormat"%> 
<%@ page import="org.apache.commons.fileupload.*"%> 
<%@ page import="org.apache.commons.fileupload.disk.*"%> 
<%@ page import="org.apache.commons.fileupload.servlet.*"%> 
<%@ page import="org.json.simple.*"%> 
<%@ page import="org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper"%>
<%  


        //文件保存目录路径    //D:\Tomcat6.0\webapps\zswz\attached/  
        String savePath = request.getSession().getServletContext().getRealPath("/") + "photo/upload/"; 
        //文件保存目录URL /zswz/attached/  
        String saveUrl = request.getContextPath() + "/photo/upload/";  
        //定义允许上传的文件扩展名  
        HashMap<String, String> extMap = new HashMap<String, String>();  
        extMap.put("image", "gif,jpg,jpeg,png,bmp");  
        extMap.put("flash", "swf,flv");  
        extMap.put("media",  
                "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");  
        extMap.put("file",  
                "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2"); //允许最大上传文件大小 struts.xml struts.multipart.maxSize=3G
        long maxSize = 3000000000l;  
        response.setContentType("text/html; charset=UTF-8");  
        if (!ServletFileUpload.isMultipartContent(request)) {  
            out.println(getError("请选择文件。"));  
            return;  
        }  
        //检查目录  
        File uploadDir = new File(savePath);  
        if (!uploadDir.exists()) {  
            uploadDir.mkdirs();  
        } 
        if (!uploadDir.isDirectory()) {  
            out.println(getError("上传目录不存在。"));  
            return;  
        }  
        //System.out.println("检查目录写权限");  
        //检查目录写权限  
        if (!uploadDir.canWrite()) {  
            out.println(getError("上传目录没有写权限。"));  
            return;  
        }  
        String dirName = request.getParameter("dir");  
        //image  
        if (dirName == null) {  
            dirName = "image";  
        }  
        if (!extMap.containsKey(dirName)) {  
            out.println(getError("目录名不正确。"));  
            return;  
        }  
        //创建文件夹  
        File saveDirFile = new File(savePath);  
        if (!saveDirFile.exists()) {  
            saveDirFile.mkdirs();  
        }  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
        String ymd = sdf.format(new Date());  
        File dirFile = new File(savePath);  
        if (!dirFile.exists()) {  
            dirFile.mkdirs();  
        }  
        if (!dirFile.isDirectory()) {  
            out.println(getError("上传目录不存在 。"));  
            return;  
        }  
        //检查目录写入权限  
        if (!dirFile.canWrite()) {  
            out.println(getError("上传目录没有写入权限。"));  
            return;  
        }  
        //Struts2 请求 包装过滤器，此处使用struts2的包装过滤器  
        MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;  
        //获得上传的文件名  
        String fileName = wrapper.getFileNames("imgFile")[0];  
        //imgFile
        //获得文件过滤器  
        File file = wrapper.getFiles("imgFile")[0];  
        //检查扩展名  
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)  
                .toLowerCase();  
        if (!Arrays.<String> asList(extMap.get(dirName).split(","))  
                .contains(fileExt)) {  
            out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"  
                    + extMap.get(dirName) + "格式。"));  
            return;  
        }  
        //检查文件大小  
        if (file.length() > maxSize)  
         {        
           out.println(getError("上传文件大小超过限制。"));       
              return;  
              }     
              //重构上传图片的名称   
              SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
              String newImgName = df.format(new Date()) + "_"  + new Random().nextInt(1000) + "." + fileExt;byte[] buffer = new byte[1024]; 
              //获取文件输出流  
              FileOutputStream fos = new FileOutputStream(savePath +"/" + newImgName); 
              //获取内存中当前文件输入流  
              InputStream in = new FileInputStream(file);  
              try {        
                int num = 0;      
                while ((num = in.read(buffer)) > 0){              
                   fos.write(buffer, 0, num);    
                 }
               }catch (Exception e) {   
                   e.printStackTrace(System.err);}   
                finally {       
                   in.close();     
                   fos.close();
                }  
            //发送给 KE  
             JSONObject obj = new JSONObject();  
             obj.put("error", 0);  
             obj.put("url", saveUrl +"/" + newImgName); 
             ///zswz/attached/image/20111129/  image 20111129195421_593.jpg 
             out.println(obj.toJSONString());  
                 //System.out.println("检查目录写权限2");  
%> 


 <%!  
    private String getError (String message )  
     {  
            JSONObject obj = new JSONObject();  
            obj.put("error", 1);  
            obj.put("message", message);  
            return obj.toJSONString();  
        }
        
%>