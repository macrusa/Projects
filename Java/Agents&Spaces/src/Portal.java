public class Portal
{
	public Portal(String name, String direction, Space destination)
	{
		_name = name;
		_direction = direction;
		_destination = destination;
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
	private String _direction;
	public String getDirection()
	{
		return _direction;
	}
	public void setDirection(String newDirection)
	{
		_direction = newDirection;
	}
	private Space _destination;
	public Space getDestination()
	{
		return _destination;
	}
	public void setDestination(Space newDestination)
	{
		if (_destination == null)
		{
			_destination = newDestination;
		}
		else
		{
			System.out.println("Access denied!");
		}
	}
	public String toString()
	{
		String port = _name + " that goes " + this.getDirection();
		return port;		
	}
	public String toStringLong()
	{
		String descrip = toString() + " to " + this.getDestination();
		return descrip;
	}
	public void transport(Agent a1)
	{
		a1.setLocation(_destination);
	}
}
