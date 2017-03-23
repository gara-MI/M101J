import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gara on 23/03/2017.
 */
public class HelloWorldFreeMarker {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter stringWriter = new StringWriter();
            Map<String, Object> map= new HashMap<String, Object>();
            map.put("name", "Rama");
            helloTemplate.process(map,stringWriter);
            System.out.println(stringWriter);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
