public class Space
{
	private String _name;
	public String getName()
	{
		return _name;
	}
	public void setName(String newName)
	{
		_name = newName;
		
	}
	private String _description;
	public String getDescription()
	{
		return _description;
	}
	public void setDescription(String newDescription)
	{
		_description = newDescription;
	}
	private Portal _portal;
	public Portal getPortal()
	{
		return _portal;
	}
	public void setPortal(Portal newPortal)
	{
		_portal = newPortal;
	}
	public String toString()
	{
		return _name;
	}
	public String toStringLong()
	{
		String s = _name + ": " + _description;
		if (_portal == null)
		{
			return s;
		}
		else
		{
			String newS = s + "with a " + _portal.toStringLong();
			return newS;
		}
	}
}
	
	