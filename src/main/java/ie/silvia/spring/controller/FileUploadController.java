package ie.silvia.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import ie.silvia.model.upload.FileBucket;
import ie.silvia.model.upload.FileValidator;
import ie.silvia.model.upload.MultiFileBucket;
import ie.silvia.model.upload.MultiFileValidator;
import ie.silvia.model.upload.UploadConstants;
import ie.silvia.model.upload.UploadService;

 


 

@Controller

public class FileUploadController {

 


    // @Autowired

    FileValidator fileValidator = new FileValidator();

 

    // @Autowired

    MultiFileValidator multiFileValidator = new MultiFileValidator();

 

    @InitBinder("fileBucket")

    protected void initBinderFileBucket(WebDataBinder binder) {

        binder.setValidator(fileValidator);

    }

 

    @InitBinder("multiFileBucket")

    protected void initBinderMultiFileBucket(WebDataBinder binder) {

        binder.setValidator(multiFileValidator);

    }

 

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)

    public String getHomePage(ModelMap model) {

        return "welcome";

    }

 

    @RequestMapping(value = "/singleUpload", method = RequestMethod.GET)

    public String getSingleUploadPage(ModelMap model) {

        FileBucket fileModel = new FileBucket();

        model.addAttribute("fileBucket", fileModel);

        return "singleFileUploader";

    }

 

    @RequestMapping(value = "/singleUpload", method = RequestMethod.POST)

    public String singleFileUpload(@Valid FileBucket fileBucket,

            BindingResult result, ModelMap model) throws IOException {

    	System.out.println("UPLOADING AN ATTACHMENT FOR TASK ID = " + fileBucket.getTaskId());
    	UploadService.createDirectory(fileBucket.getTaskId());

        if (result.hasErrors()) {

            System.out.println("validation errors");

            return "singleFileUploader";

        } else {

            System.out.println("Fetching file");

            MultipartFile multipartFile = fileBucket.getFile();

 


            String filenameElements[] = fileBucket.getFile().getOriginalFilename().split("\\\\");
            String filename = filenameElements[filenameElements.length-1];
            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File( UploadConstants.UPLOAD_PATH + fileBucket.getTaskId() + "/"+ filename));

            String fileName = multipartFile.getOriginalFilename();

            model.addAttribute("fileName", fileName);

            return "redirect:/tasks/viewtask/"+fileBucket.getTaskId()+"/";

        }

    }

 

    @RequestMapping(value = "/multiUpload", method = RequestMethod.GET)

    public String getMultiUploadPage(ModelMap model) {

        MultiFileBucket filesModel = new MultiFileBucket();

        model.addAttribute("multiFileBucket", filesModel);

        return "multiFileUploader";

    }

 

    @RequestMapping(value = "/multiUpload", method = RequestMethod.POST)

    public String multiFileUpload(@Valid MultiFileBucket multiFileBucket,

            BindingResult result, ModelMap model) throws IOException {

 

        if (result.hasErrors()) {

            System.out.println("validation errors in multi upload");

            return "multiFileUploader";

        } else {

            System.out.println("Fetching files");

            List<String> fileNames = new ArrayList<String>();

            // Now do something with file...

            for (FileBucket bucket : multiFileBucket.getFiles()) {

                FileCopyUtils.copy(bucket.getFile().getBytes(), new File(UploadConstants.UPLOAD_PATH + bucket.getFile().getOriginalFilename()));

                fileNames.add(bucket.getFile().getOriginalFilename());

            }

 

            model.addAttribute("fileNames", fileNames);

            return "multiSuccess";

        }

    }

 

}
