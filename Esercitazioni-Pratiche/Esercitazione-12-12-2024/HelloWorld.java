//versione con Logger

import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloWorld {

    private static final Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Hello, World!");
    }
}

/*
versione senza logger

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

 */
