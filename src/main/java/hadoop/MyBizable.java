package hadoop;

public interface MyBizable {
    long versionID = 123456;//该字段必须要有，不然会报java.lang.NoSuchFieldException: versionID异常
    String doSomething(String str);
}
