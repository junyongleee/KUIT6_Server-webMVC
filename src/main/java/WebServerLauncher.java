import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.util.logging.Logger;

@SpringBootApplication
public class WebServerLauncher {
    private static final Logger logger = Logger.getLogger(WebServerLauncher.class.getName());

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebServerLauncher.class, args);


//        String webappDirLocation = "./webapp/";
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//        tomcat.getConnector();
//
//        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
//        logger.info("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());
//
//        tomcat.start();
//        tomcat.getServer().await();
    }
}
