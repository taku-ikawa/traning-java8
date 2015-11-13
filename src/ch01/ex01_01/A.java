package ch01.ex01_01;

public enum A {
	
	A {
		
	};
	
	public static void hoge() {
		System.out.println(A.class.getSimpleName());
	}

}
