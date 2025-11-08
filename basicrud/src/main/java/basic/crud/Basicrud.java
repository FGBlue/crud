package basic.crud;

import io.javalin.Javalin;

public class Basicrud {
    public static void main(String[] args) {
        
        System.setProperty("file.encoding", "UTF-8");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public"); 
        }).start(7000);

        System.out.println("http://localhost:7000/index.html");
    }
}


