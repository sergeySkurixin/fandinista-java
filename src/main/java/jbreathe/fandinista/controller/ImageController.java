package jbreathe.fandinista.controller;

import org.apache.commons.io.IOUtils;
import org.jets3t.service.S3Service;
import org.jets3t.service.ServiceException;
import org.jets3t.service.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by скурихин on 21.01.2017.
 */
@Controller
public class ImageController {

    @Value("${S3_BUCKET}")
    private String s3bucket;

    @Autowired
    private String resourcesImageFolder;

    @Autowired
    private S3Service s3Service;

    @RequestMapping(value = "/img/{filename}.{extension}", method = RequestMethod.GET)
    public void getImage(@PathVariable(value = "filename", required = false) String filename,
                         @PathVariable(value = "extension", required = false) String extension,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServiceException {
        if (filename == null) {
            filename = "deactivated_200";
            extension = "gif";
        }

        String imageFullName = filename + "." + extension;
        S3Object s3Object = s3Service.getObject(s3bucket, imageFullName);
        InputStream dataInputStream = s3Object.getDataInputStream();
        long contentLength = s3Object.getContentLength();
        String name = s3Object.getName();

        response.setHeader("Content-Type", "image/gif");
        response.setHeader("Content-Length", String.valueOf(contentLength));
        response.setHeader("Content-Disposition", "inline; filename=\"" + name + "\"");
        IOUtils.copy(dataInputStream, response.getOutputStream());
    }
}
