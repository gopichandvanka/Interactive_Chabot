import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

public class FactoryEnterpriseBot {

	private String pathName="C:/Folder-1/GitHub/IntreactiveChatbot/EnterpriseChatBot";
	private String botName="EnterpriseBot";
	private Bot bot;
	
	FactoryEnterpriseBot()
	{
		this.bot=new Bot(botName, pathName);	
	}
	public Bot getBot()
	{
		return this.bot;
	}
	public Chat getChatSession()
	{
		return new Chat(bot);
	}
}
