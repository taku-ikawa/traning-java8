package ch09.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExException {

	public void scannerSample() {
		try (Scanner in = new Scanner(new File("alice.txt"))) {
			while(in.hasNext()) {
				System.out.println(in.next().toLowerCase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void scannerSampleWithoutUsingTryWithResources() {
		Scanner in = null;
		try {
			in = new Scanner(new File("alice.txt"));
			while(in.hasNext()) {
				System.out.println(in.next().toLowerCase());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}
	}

	public void printerSample() {
		try (Scanner in = new Scanner(new File("alice.txt"))) {
			PrintWriter out = new PrintWriter("out.txt");
			while(in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void printerSampleWithoutUsingTryWithResources() {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(new File("alice.txt"));
			out = new PrintWriter("out.txt");
			while(in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				if(out != null) {
					out.close();
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}
	}

}
