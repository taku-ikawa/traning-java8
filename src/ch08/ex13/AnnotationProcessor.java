package ch08.ex13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import ch08.ex12.AnnotationSample;

// プロセッサを指定してのコンパイルがうまくできませんでした。
// >javac -processor AnnotationProcessor AnnotationSample.java
// エラー:注釈プロセッサ 'AnnotationProcessor' が見つかりません
// エラー 1 個

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes({ "*" })
public class AnnotationProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		Method method = null;
		try {
			Class<AnnotationSample> clazz = AnnotationSample.class;
			method = clazz.getMethod("factorial", new Class[] { int.class });
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		for (TypeElement annotation : annotations) {
			for (Element element : roundEnv
					.getElementsAnnotatedWith(annotation)) {
				TestCase testCase = element.getAnnotation(TestCase.class);
				try {
					System.out.println("params:" + testCase.params()
							+ ", expected:" + testCase.expected());
					Long ret = (Long) method.invoke(null,
							new Object[] { new Integer(testCase.params()) });
					if (ret == Long.valueOf(testCase.expected()).longValue()) {
						System.out.println("True");
					} else {
						System.out.println("False!! expected:"
								+ testCase.expected() + " actual:" + ret);
					}
					System.out.println("ret:" + ret);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
