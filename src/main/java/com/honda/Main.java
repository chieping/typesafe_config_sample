import com.typesafe.config.*;

public class Main {
	public static void main(String... args) throws Exception {
		Main.class.getMethod(args[0], null).invoke(null);
	}

	public static void load() {
		Config conf = ConfigFactory.load();
		System.out.println("The answer is: " + conf.getString("simple-app.answer"));
		System.out.println("dynamodb.table_name_prefix: " + conf.getString("dynamodb.table_name_prefix"));
	}

	public static void getString() {
		Config conf = ConfigFactory.parseString("sample=hoge, fuga=moge");
		System.out.println(conf.getString("sample"));
		System.out.println(conf.getString("fuga"));
		Config conf2 = ConfigFactory.parseString("sample2=\"double\\\"quote\", sample3=\"includes,comma\", sample4=\"includes=equal\"");
		System.out.println(conf2.getString("sample2"));
		System.out.println(conf2.getString("sample3"));
		System.out.println(conf2.getString("sample4"));
		Config conf3 = ConfigFactory.parseString("sample.sample5=nested_value");
		System.out.println(conf3.getString("sample.sample5"));
		Config conf4 = ConfigFactory.parseString("sample=[list1, list2]");
		// Config conf4 = ConfigFactory.parseString("sample.0=list1, sample.1=list2");
		System.out.println(conf4.getList("sample"));
	}
}
