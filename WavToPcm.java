import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

public class WavToRaw {
	
	private FileInputStream fstream = null;
	private int read;
	private byte[] audioBytes = new byte[1024];
	byte[] buff = new byte[1024];

	
	

	public WavToRaw() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void SaveRaw(File file) {
		OutputStream output = null;
		
		try {
			output = new FileOutputStream("Please Write Name Here To Save Raw Data.raw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			output.write(formatWavToRaw(WavToByte(file)));
			
			System.out.print("Success");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public byte[] WavToByte(File file) {
		try {
			File inFile = file;
	        fstream = new FileInputStream(inFile);

	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	    	BufferedInputStream in = new BufferedInputStream(fstream);
	        
	    	while ((read = in.read(buff)) > 0)
	    	{
	    	    out.write(buff, 0, read);
	    	}
	    	out.flush();
	    	audioBytes = out.toByteArray();
	        
	    } catch (FileNotFoundException ex) {
	        
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return audioBytes;
		
		
	}
	
	
	public byte[] formatWavToRaw(@NotNull final byte[] audioFileContent) {
        return Arrays.copyOfRange(audioFileContent, 44, audioFileContent.length);
    }

}
