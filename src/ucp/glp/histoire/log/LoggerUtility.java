package ucp.glp.histoire.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class LoggerUtility {
	
	private static final String HTML_LOG_CONFIG = "src/ucp/glp/histoire/log/log4j-html.properties";
	
	public static Logger getLogger(Class<?> logClass) {
		PropertyConfigurator.configure(HTML_LOG_CONFIG);
		String className = logClass.getName();
		return Logger.getLogger(className);
	}
}
