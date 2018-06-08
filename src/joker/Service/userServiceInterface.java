package joker.Service;
import java.util.List;
import joker.models.User;
public interface userServiceInterface 
{
	public boolean LogIn(String phone ,String password);
	public int Register(User user);
	public List<User> QueryIsVip(int key);
	
	public int GetMaxId();
	public User GetUserById(String uid);
	

	
}
