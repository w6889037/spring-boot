package com.boot.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xianchun.hu on 12/5/2017.
 */
@Controller
public class UpLoadController {

    private static Logger LOG = Logger.getLogger(UpLoadController.class);

    @RequestMapping(value = "/upLoadPage", method = RequestMethod.GET)
    public String goToUpLoadPage(Model model) {
        model.addAttribute("aaa","bbb");
        return "upLoad";
    }

    @RequestMapping(value = "/upLoad", method = RequestMethod.POST)
    public void upLoad(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        LOG.info("contentType:" + contentType);
        String fileName = file.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/upLoad");
        LOG.info("fileName:" + fileName);
        LOG.info("realPath:" + realPath);
        try {
            upLoadFile(file.getBytes(), realPath, fileName);
        } catch (IOException e) {
            LOG.error("上传失败" + e);
        }
    }

    private void upLoadFile(byte[] file, String realPath, String fileName) {
        try {
            FileOutputStream out = new FileOutputStream(realPath + fileName);
            out.write(file);
            out.flush();
            out.close();
        } catch (Exception e) {
            LOG.error(e);
        }
    }
}
