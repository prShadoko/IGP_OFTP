package oftp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileService {

	private File inputFile;
	InputStream in;
	
	private File outputFile;
	OutputStream out;
	
	public FileService() {
//		inputFile = new File("/home/pierre/Pictures/Photos/48ca54da60b2d68be570620fb7ce2cff.jpg");
		inputFile = new File("/home/pierre/Pictures/moi.txt");
		
		reset();
	}
	
	public long getFileSize() {
		return inputFile.length();
	}

	public void reset() {
		try {
			in = new FileInputStream(inputFile);
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
	
	public void setOutputPath(String path) {
		outputFile = new File("out/" + path);
		try {
			outputFile.createNewFile();
			out = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void putByte(byte[] data) {
		System.out.println(" - Data: " + data);
		try {
			out.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeFile() {
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
