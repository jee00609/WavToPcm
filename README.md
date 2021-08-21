# WavToRawPCM

이것은 Wav 파일을 Raw PCM 데이터로 변환하여 저장하는 프로젝트 입니다.

This is a project that converts Wav files into Raw pcm  data and saves them.

## 사용법 (Usage)

Main.java
```Java
File resourcesDirectory = new File("Your Directoty with file.wav that wants to change Raw");
WavToRaw test = new WavToRaw();
test.SaveRaw(resourcesDirectory);
```

WavToRaw.java

```Java
public void SaveRaw(File file) throws UnsupportedAudioFileException {
	OutputStream output = null;
	
	try {
	
		//Example -> output = new FileOutputStream("src/main/resources/static/audio/test.raw");
		output = new FileOutputStream("Directory with Raw file that you make(Wav to Raw).raw");
	} 
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		//핵심 코드
		//core code
		output.write(formatWavToRaw(changeFormat(AudioToByte(file), FORMAT)));

		//Just Test Code
		//Can Delete
		System.out.print("Success");

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
```


## Update Posting

[Wav To Raw PCM - Step 1](https://jee00609.github.io/java/how-convert-wav-to-raw/)

[Wav To Raw PCM - Step 2](https://jee00609.github.io/java/how-convert-wav-to-raw2/)
