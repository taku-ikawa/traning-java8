package ch01.ex01_11;

public class IJImpl extends S implements I, J {

	@Override
	public void I_abstract__J_abstract() {}	//Override可能(Override強制される)

	//public void I_abstract__J_default() {}	メソッド定義できない
	//The default method I_abstract__J_default() inherited from J conflicts with another method inherited from I

	@Override
	public void I_abstract__J_static() {}	//Override可能(Override強制される)

	@Override
	public void I_default__J_abstract() {}	//Override可能(Override強制される)

	//	default void I_default__J_default() {}	メソッド定義できない
	//Duplicate default methods named I_default__J_default with the parameters () and () are inherited from the types J and I

	@Override
	public void I_default__J_static() {}	//Override可能

	@Override
	public void I_static__J_abstract() {}	//Override可能

	@Override
	public void I_static__J_default() {}	//Override可能

	public void I_static__J_static() {}		//メソッド定義は可能だがOverrideはできない

	@Override
	public void f() {};	//Override可能

}
