//Agents and Spaces 2
//CSE1102 04, Spring 2013
//Nancy Cheng
//3/09/14
//TA: Saahil Moledina
//Section: 007
//Instructor: Jeffrey A. Meunier

public class Space
{
	public Space(String spacename, String description, String image, Portal portal)
	{
		_name = spacename;
		_description = description;
		_portal = portal;
		_imagename = image;
		this.setPortal(getPortal());
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
	private String _imagename;
	public String getImagename()
	{
		return _imagename;
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
			String newS = s + " with a " + _portal.toStringLong();
			return newS;
		}
	}
}
