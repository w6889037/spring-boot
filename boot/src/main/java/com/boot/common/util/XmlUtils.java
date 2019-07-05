package com.boot.common.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

public class XmlUtils {
    private final static Logger logger = LoggerFactory.getLogger(XmlUtils.class);

    public static Document parseToDocument(HttpServletRequest request) {
        InputStream inputStream = null;
        Document document = null;
        try {
            inputStream = request.getInputStream();
            SAXReader reader = new SAXReader();
            document = reader.read(inputStream);
        } catch (Exception e) {
            logger.error("read xml failed: {}", e.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return document;
    }
}
