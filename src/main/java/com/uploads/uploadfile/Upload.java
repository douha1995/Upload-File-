/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uploads.uploadfile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author Abdelrahman Mamdouh
 */
public class Upload extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        
        try {
            PrintWriter out=response.getWriter();
            ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> multifiles=sf.parseRequest(request);
             
            out.println("files are uploaded1  "+multifiles.size());
             
            for(FileItem item:multifiles)
            {    out.println("files are uploaded2");
                item.write(new File("/"+item.getName()));  
            }
            out.println("files are uploaded3");
            
        } catch (FileUploadException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
