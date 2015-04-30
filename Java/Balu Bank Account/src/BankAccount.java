public class BankAccount
{
	private float _balance;
	private String _user;
	private String _password;
	
	public BankAccount(String name, String password, float balance)
	{
		_balance = balance;
		_user = name;
		_password = password;
	}
	public void logIn(String user, String password)
	{
		if(user == _user)
		{
			
		}
		else if(user == null)
		{
			
		}
		if(password.equals(_password))
		{
			
		}
		else if(password.equals(null))
		{
			System.out.println("");
		}
	}

}
