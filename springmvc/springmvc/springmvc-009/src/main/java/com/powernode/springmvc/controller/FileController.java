package com.powernode.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

/**
 * ClassName: FileController
 * Description:
 *      文件上传：浏览器端向服务器端发送文件，最终服务器将文件保存到服务器上。
 * Datetime: 2024/3/28 21:37
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class FileController {

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request) throws IOException {
        File file = new File(request.getServletContext().getRealPath("/upload") + "/touxiang.jpeg");
        // 创建响应头对象
        HttpHeaders headers = new HttpHeaders();
        // 设置响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置下载文件的名称
        headers.setContentDispositionFormData("attachment", file.getName());

        // 下载文件
        return new ResponseEntity<byte[]>(Files.readAllBytes(file.toPath()), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/fileup", method = RequestMethod.POST)
    public String fileup(@RequestParam("fileName") MultipartFile multipartFile, HttpServletRequest request) throws IOException {

        // 获取请求参数的名字
        String name = multipartFile.getName();
        System.out.println(name); //fileName

        // 获取的是文件真实的名字
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename); //touxiang.jpeg

        // 接下来就是看在JavaSE当中的IO功底了。
        // 一边读，一边写。
        // 读什么？写什么？
        // 读客户端传过来的文件，写到服务器上。
        // 输入流
        InputStream in = multipartFile.getInputStream(); // 输入流，负责读客户端的文件
        BufferedInputStream bis = new BufferedInputStream(in); // 封装成带有缓冲区的输入流

        // 输出流
        ServletContext application = request.getServletContext();
        String realPath = application.getRealPath("/upload");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //File destFile = new File(file.getAbsolutePath() + "/" + originalFilename);
        File destFile = new File(file.getAbsolutePath() + "/" + UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf(".")));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        // 一边读一边写
        byte[] bytes = new byte[1024 * 10];
        int readCount = 0;
        while((readCount = bis.read(bytes)) != -1){
            bos.write(bytes, 0, readCount);
        }

        bos.flush();
        bos.close();
        bis.close();

        return "ok";
    }
}
