package environmentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${evn}.properties" })
public interface Environment extends Config{
	String osName();
	
	@Key("app.url")
	String appUrl();
	
	@Key("app.username")
	String appUsername();
	
	@Key("app.password")
	String appPassword();
}
