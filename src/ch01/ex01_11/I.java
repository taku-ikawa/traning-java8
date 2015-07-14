package ch01.ex01_11;

public interface I {

	void I_abstract__J_abstract();
	//void I_abstract__J_default(); //
	void I_abstract__J_static();
	default void I_default__J_abstract() {}
	//default void I_default__J_default() {} // Duplicate default methods named I_default__J_default with the parameters () and () are inherited from the types J and I
	default void I_default__J_static() {}
	static void I_static__J_abstract() {}
	static void I_static__J_default() {}
	static void I_static__J_static() {}

	void f();

}
