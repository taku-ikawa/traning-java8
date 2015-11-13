package ch09.ex03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class ExException {

	// 共通の親クラスを型とする
	
	public void process() throws IOException {
		try {
			if(true) {
				throw new FileNotFoundException();
			}else {
				throw new UnknownHostException();
			}
		}catch (FileNotFoundException | UnknownHostException ex) {
			throw ex;
		}
	}
}
