package environmentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${env}.properties" })
public interface Environment extends Config{
	String osName();
	
	@Key("app.url")
	String applicationUrl();
	
	@Key("app.username")
	String applicationUsername();
	
	@Key("app.password")
	String applicationPassword();
}
