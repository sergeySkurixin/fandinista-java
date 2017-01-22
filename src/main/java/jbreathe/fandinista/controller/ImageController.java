package jbreathe.fandinista.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by скурихин on 21.01.2017.
 */
@Controller
public class ImageController {


    public static final String RESOURCES_IMAGES_FORLDER = "/resources/images/";

    @RequestMapping(value = "/img/{filename}.{extension}", method = RequestMethod.GET)
    public void getImage(@PathVariable(value = "filename", required = false) String filename,
                         @PathVariable(value = "extension", required = false) String extension,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        File file = null;

        if (filename == null) {
            filename = "deactivated_200";
            extension = "gif";
        }

        String directory = request.getServletContext()
                .getRealPath(RESOURCES_IMAGES_FORLDER);
        File directoryFile = new File(directory);
        String path = directory + filename + "." + extension;
        file = new File(path);

//        FileInputStream fis = new FileInputStream(file);
//        byte[] bytes = IOUtils.readFully(fis,-1,true);
//        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(bytes);
//        //cb12f34fe1f1af2a5d6170633c1d11d5
//        fis.close();

        response.setHeader("Content-Type", "image/gif");
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}
