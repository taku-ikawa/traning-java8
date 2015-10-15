function createArrayListEx() {
	var arr = new (Java.extend(java.util.ArrayList)) {
		add: function(x) {
			print('Adding ' + x);
			return java.super(arr).add(x);
		}
	}
	return arr;
}
var list = createArrayListEx();
list.add("hoge")

// Exception発生

/*
Adding hoge
Exception in thread "main" java.lang.RuntimeException: java.lang.ClassNotFoundEx
ception: java.super
        at jdk.nashorn.javaadapters.java.util.ArrayList.add(Unknown Source)
        at jdk.nashorn.internal.scripts.Script$arrayListEx.runScript(arrayListEx
.js:12)
        at jdk.nashorn.internal.runtime.ScriptFunctionData.invoke(ScriptFunction
Data.java:535)
        at jdk.nashorn.internal.runtime.ScriptFunction.invoke(ScriptFunction.jav
a:209)
        at jdk.nashorn.internal.runtime.ScriptRuntime.apply(ScriptRuntime.java:3
78)
        at jdk.nashorn.tools.Shell.apply(Shell.java:383)
        at jdk.nashorn.tools.Shell.runScripts(Shell.java:312)
        at jdk.nashorn.tools.Shell.run(Shell.java:168)
        at jdk.nashorn.tools.Shell.main(Shell.java:132)
        at jdk.nashorn.tools.Shell.main(Shell.java:111)
Caused by: java.lang.ClassNotFoundException: java.super
        at jdk.nashorn.internal.runtime.NativeJavaPackage.classNotFound(NativeJa
vaPackage.java:158)
        at jdk.nashorn.internal.scripts.Script$arrayListEx.createArrayListEx$L:3
(arrayListEx.js:5)
        ... 10 more
*/