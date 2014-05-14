package oftp.service;

import java.io.*;

public class FileService {

	private File inputFile;
	InputStream in;
	
	private File outputFile;
	OutputStream out;
	
	public FileService() {
		inputFile = new File("/home/pierre/Pictures/Photos/48ca54da60b2d68be570620fb7ce2cff.jpg");
//		file = new File("/home/pierre/Pictures/moi.txt");
		
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
			out = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void putByte(byte[] data) {
		try {
			out.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
