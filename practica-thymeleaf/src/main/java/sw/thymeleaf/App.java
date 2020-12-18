package sw.thymeleaf;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.thymeleaf.*;
import static spark.Spark.get;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        get("/hello", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            //model.put("message", "Hello Thymeleaf!");
            model.put("personas", new Personas(
					"Markus W Mahlberg <markus.mahlberg@icloud.com"));
            return new ModelAndView(model, "hello"); // located in resources/templates
        }, new ThymeleafTemplateEngine());
    }
}
class Personas{
    public String message;

    public Personas(String message) {
        this.message = message;
    }

}