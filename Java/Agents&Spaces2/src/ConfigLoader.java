//Agents and Spaces 2
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/09/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

//String section = "spaces";
//String key = "classroom";
//String value = ini.get(section, key);
import jeff.ini.Ini;
import java.util.HashMap;
import java.io.File;

public class ConfigLoader 
{
	private Ini _ini;
	private HashMap<String, Space> _spaces = new HashMap<String,Space>();
	private HashMap<String, Portal> _portals = new HashMap<String, Portal>();
	private HashMap<String, Agent> _agents = new HashMap<String, Agent>();

	public ConfigLoader(File iniFile)
	{
		_ini = new Ini(iniFile);
	}
	private void _buildSpaces()
	{
		for(String spaceName : _ini.keys("spaces"))
		{
			//_ini.get("spaces", spaceName) is description of space
			//spaceName = spaceDescription
			String spaceDescription = _ini.get("spaces", spaceName);
			String imageName = _ini.get("images", spaceName);
			Space spaceInstance = new Space(spaceName, spaceDescription, imageName, null);
			_spaces.put(spaceName, spaceInstance);
		}
	}
	private void _buildPortals()
	{
		for(String portalName : _ini.keys("portals"))
		{
			//_ini.get("portals", portalName) is description of portal
			String x = _ini.get("portals", portalName);
			//portalName = destinationDescription
			Portal portalInstance = new Portal(portalName, x, null);
			_portals.put(portalName,  portalInstance);
		}
	}
	private void _buildExits()
	{
		for(String spaceName : _ini.keys("exits"))
		{
			String exitPortalName = _ini.get("exits", spaceName);
			Space spaceInstance = _spaces.get(spaceName);
			//spaceName = portalName;
			Portal portalInstance = _portals.get(exitPortalName);
			spaceInstance.setPortal(portalInstance);
		}
	}
	private void _buildDestinations()
	{
		for(String portalName : _ini.keys("destinations"))
		{
			//door that goes outside
			//portalName = destinationSpaceName
			Portal portalInstance = _portals.get(portalName);
			//sidewalk
			String destinationSpaceName = _ini.get("destinations", portalName);
			Space destinationSpace = _spaces.get(destinationSpaceName);
			if(destinationSpace == null)
			{
				System.out.println("Error! Space is null!");
				System.exit(1);
			}
			else
			{
				//set portal's destination to be that space
				portalInstance.setDestination(destinationSpace);
			}
		}
	}
	private void _buildAgents()
	{
		for(String agentName : _ini.keys("agents"))
		{
			//agentName = startSpaceName
			String startSpaceName = _ini.get("agents", agentName);
			Space spaceInstance = _spaces.get(startSpaceName);
			if(spaceInstance == null)
			{
				System.out.println("Error! Space is null");
				System.exit(1);
			}
			else
			{
				Agent agentInstance = new Agent(spaceInstance, agentName);
				_agents.put(agentName, agentInstance);
			}
		}
	}
	private Agent _selectStartAgent()
	{
		//agent = startingAgentName
		String startAgent = _ini.get("start", "agent");
		Agent a = _agents.get(startAgent);
		if(a == null)
		{
			System.out.println(startAgent);
			System.exit(1);
		}
		return a;
	}
	public Agent buildAll()
	{
		_buildSpaces();
		_buildPortals();
		_buildExits();
		_buildDestinations();
		_buildAgents();
		return _selectStartAgent();
	}
}