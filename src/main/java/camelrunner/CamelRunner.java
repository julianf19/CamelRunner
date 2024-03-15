package camelrunner;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/** 
 * @author A.Marchand
 */

public  class CamelRunner extends TimerTask{

    static final String version = "2.0.0";
    static final Logger logger = LoggerFactory.getLogger("infoAppender");
    static ApplicationContext context;        
    private File configFile;
    private long lastFileUpdateTime;        
    
    public static void main(String[] args) throws Exception {
                      
        logger.info("Version:" + version + " on java:" + System.getProperty("java.version"));
        logger.info("SYNTAX: java -jar xxx.jar /PATH/TO/thefile.xml");
        logger.info("Default Charset=" + Charset.defaultCharset());
        
        String current = new java.io.File( "." ).getCanonicalPath();
        logger.info("Current dir:"+current);
        
        for(String param:args)        
            logger.info("Parameter:"+param);        
        
        if(args.length<=0)
        {
            logger.error("No context file specified.");
            return;
        }
        
        File configFile = new java.io.File( args[0]);
        logger.info("Opening:"+configFile.getAbsolutePath());
        if(!configFile.exists())
        {
            logger.error("File not found.");
            return;
        }
        
        // Loading the context file
        try {
            logger.info("Creating context...");
            context = new FileSystemXmlApplicationContext("file:"+configFile.getAbsolutePath());
            logger.info("Done.");
        } catch (Exception espring) {
            logger.error("Error while starting spring:" + espring.getMessage(), espring);
        }
        
        if (context == null) {
            logger.error("Unable to load spring context");
            return;
        }
        
        logger.info("Main finished");   
        
        Timer timer = new Timer();
        // repeat the check every second
        timer.schedule( new CamelRunner(configFile), new Date(), 1000 );

    }

    public CamelRunner(File configFile)
    {
        this.configFile=configFile;
        lastFileUpdateTime=configFile.lastModified();
    }
    
    @Override
    public void run()
    {
        //logger.info("Checking File.");
        if(configFile.lastModified()!=lastFileUpdateTime)
        {
            logger.info("File chanded. Exiting.");
            System.exit(0);
        }
    }
    
}
