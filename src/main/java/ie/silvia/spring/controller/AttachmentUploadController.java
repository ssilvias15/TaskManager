package ie.silvia.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import ie.silvia.model.upload.FileBucket;
import ie.silvia.model.upload.FileValidator;

@Controller
@RequestMapping("/uploadfile.htm")
public class AttachmentUploadController {

//	@Autowired
	FileValidator validator = new FileValidator();

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(Model model) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("file", fileModel);
		return "file";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String fileUpload(Model model, @Validated FileBucket file, BindingResult result) {

		String resultVal = "successFile";
		if(result.hasErrors()){
			resultVal = "file";
		}else{
			MultipartFile multipartFile = file.getFile();
		}
		return resultVal;
	}
}
