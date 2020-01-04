

import com.chess.UserInterface.WebServer;
import com.chess.appl.PlayerLobby;
import com.google.gson.Gson;

import org.apache.log4j.BasicConfigurator;

import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.InputStream;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public final class Application {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());


    private WebServer webServer;


    private Application(final WebServer webServer)
    {
        Objects.requireNonNull(webServer,"webServer must not be null");
        this.webServer=webServer;
    }

    public static void main(String[] args){


        try{

            ClassLoader classLoader = Application.class.getClassLoader();
            final InputStream logConfig = classLoader.getResourceAsStream("log.properties");
            LogManager.getLogManager().readConfiguration(logConfig);

        } catch ( Exception e){
            e.printStackTrace();
            System.err.println("Could not initialize log manager because: " + e.getMessage());
        }

        // The application uses FreeMarker templates to generate the HTML
        // responses sent back to the client. This will be the engine processing
        // the templates and associated data.
        final TemplateEngine templateEngine = new FreeMarkerEngine();

        // The application uses Gson to generate JSON representations of Java objects.
        // This should be used by your Ajax Routes to generate JSON for the HTTP
        // response to Ajax requests.
        final Gson gson = new Gson();


        //creating the player lobby for the application
        final PlayerLobby lobby = new PlayerLobby();

        // inject the game center and freemarker engine into web server
        final WebServer webServer = new WebServer(templateEngine, gson, lobby);

        // inject web server into application
        final Application app = new Application(webServer);

        // start the application up
        app.initialize();

    }
    private void initialize()
    {
        BasicConfigurator.configure();

        LOG.config("Chess is initializing.");
        webServer.initialize();
        LOG.config("Chess initialization complete.");

    }
}
