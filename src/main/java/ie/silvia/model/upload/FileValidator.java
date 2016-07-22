package ie.silvia.model.upload;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator {

	public boolean supports(Class<?> paramClass) {

		return File.class.equals(paramClass);

	}



	public void validate(Object obj, Errors errors) {
		
		File file = (File) obj;
		System.out.println("Validating file: " + file);
		System.out.println("PROPERTY: " + file.getFile());
		
		  if (file.getFile().getSize() == 0) {

		   errors.rejectValue("file", "valid.file");

		  }

	}

}