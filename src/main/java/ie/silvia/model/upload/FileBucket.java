package ie.silvia.model.upload;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {

	private MultipartFile file;
	
	// every file is an attachment for a certain task
	// I have added taskId property in order to facilitate attachment-file mapping
	private Integer taskId; 

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	
	
	
}
