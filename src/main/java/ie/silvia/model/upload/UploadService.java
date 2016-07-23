package ie.silvia.model.upload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Silvia
 * Class which finds the attachments for a specific Task
 */
public class UploadService {

	public static void createDirectory(Integer taskId){
		
		File directory = new File(UploadConstants.UPLOAD_PATH+taskId);
		if(!directory.exists()){
			System.out.println("CREATING DIR: " + taskId);
			
			try{
				directory.mkdir();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	public static List<String> getFilesInTaskDirectory(Integer taskId){
		List<String> attachmentNames = new ArrayList<>();
		String directoryName = UploadConstants.UPLOAD_PATH + taskId;
		File folder = new File(directoryName);

		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        // System.out.println("File " + listOfFiles[i].getName());
		    	  attachmentNames.add(listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        // System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		return attachmentNames;
	}
	
}
