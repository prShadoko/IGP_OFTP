package oftp.service;

import java.io.File;

public class FileService {
	
	private File file;
	
	public FileService() {
		file = new File("/home/pierre/Pictures/Photos/48ca54da60b2d68be570620fb7ce2cff.jpg");
	}
	
	public long getFileSize() {
		return file.length();
	}
}
