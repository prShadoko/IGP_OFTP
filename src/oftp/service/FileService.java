package oftp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileService {
	
	private File file;
	InputStream in;
	
	public FileService() {
		file = new File("/home/pierre/Pictures/Photos/48ca54da60b2d68be570620fb7ce2cff.jpg");
//		file = new File("/home/pierre/Pictures/moi.txt");
		
		reset();
	}
	
	public long getFileSize() {
		return file.length();
	}

	public void reset() {
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getByte(byte[] buff) {
		try {
			return in.read(buff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
