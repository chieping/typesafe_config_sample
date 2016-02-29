import com.typesafe.config.*;

public class Main {
	public static void main(String... args) {
		Config conf = ConfigFactory.load();
		System.out.println("The answer is: " + conf.getString("simple-app.answer"));
		System.out.println("dynamodb.table_name_prefix: " + conf.getString("dynamodb.table_name_prefix"));
	}
}
