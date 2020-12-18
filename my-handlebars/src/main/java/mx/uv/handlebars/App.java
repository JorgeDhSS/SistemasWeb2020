package mx.uv.handlebars;

/**
 * Hello world!
 *
 */
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.*;

import static spark.Spark.get;

/**
 * Handlebars template engine example
 */
public class App {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Sam");

        // hello.hbs file is in resources/templates directory
        get("/hello", (rq, rs) -> new ModelAndView(map, "hello.hbs"), new HandlebarsTemplateEngine());
    }
}
