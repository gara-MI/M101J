import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by gara on 23/03/2017.
 */
public class HelloWorldSpark {
    public static void main(String [] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSpark.class, "/");

        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                final StringWriter stringWriter = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    final Map<String, Object> map = new HashMap<String, Object>();
                    map.put("name", "Rama");
                    helloTemplate.process(map, stringWriter);
                    System.out.println(stringWriter);
                    return stringWriter;
                }
                catch (Exception e){
                    //halt(500);
                    e.printStackTrace();
                }
                return stringWriter;
            }
        });
    }
}
