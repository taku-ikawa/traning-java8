package ch08.ex09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ScannerStreamCreator {

	public static void main(String[] args) {
		// 単語読み込み
		try (Scanner scanner = new Scanner(new File("alice.txt"))) {
			Stream<String> lineStream = words(scanner);
			lineStream.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 行読み込み
		try (Scanner scanner = new Scanner(new File("alice.txt"))) {
			Stream<String> lineStream = lines(scanner);
			lineStream.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 数字読み込み
		try (Scanner scanner = new Scanner(new File("number.txt"))) {
			Stream<Double> lineStream = numbers(scanner);
			lineStream.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Stream<String> words(Scanner scanner) {
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED
						| Spliterator.NONNULL), false);
	}

	public static Stream<String> lines(Scanner scanner) {
		scanner.useDelimiter("\r\n|[\n\r\u2028\u2029\u0085]");
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED
						| Spliterator.NONNULL), false);
	}

	public static Stream<Double> numbers(Scanner scanner) {
        Iterator<Double> iter = new Iterator<Double>() {

        	@Override
            public boolean hasNext() {
                return scanner.hasNextDouble();
            }

            @Override
            public Double next() {
                return scanner.nextDouble();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
        		iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

}
