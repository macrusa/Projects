public class Agent
{
	private Space _location;
	public Space getLocation()
	{
		return _location;
	}
	public void setLocation(Space newLocation)
	{
		_location = newLocation;
	}
	private String _name;
	public String getName()
	{
		return _name;
	}
	public void setName(String newName)
	{
		_name = newName;
	}
	public String toString()
	{
		return _name;
	}
	public String toStringLong()
	{
		String s = toString() + " is in " + _location;
		return s;
	}
	public boolean usePortal()
	{
		if(_location == null)
		{
			return false;
		}
		else
		{
			Space s1 = this.getLocation();
			String str = s1.toString();
			Portal p1 = s1.getPortal();
			this.setLocation(p1.getDestination());
			System.out.println(_name + " is moving from " + str + " to " + _location);
			return true;
		}
	}
}