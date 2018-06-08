package joker.ConnectionDB;

import java.util.List;

import joker.models.User;

public interface UserInterface 
{
	public int InsertUser(User uer);//插入一条user信息，返回影响的行数
	public int DeleteUserById(int id);//根据用户编号删除该数据的用户信息
	
	public int UpdateUserByName(String name,String phonenum);//更改用户名
	public int UpdateUserByPassword(String password,String phonenum);//更新用户密码
	public int UpdateUserByBalance(float balance,String phonenum);//跟新余额
	public int UpdateUserByPhone(String newphonenum,String oldphonenum);//更新电话号码
	public int UpdtaeUserByKey(int key,String phonenum);//更新身份，是否为VIP
	public int UpdateUserByDiscount(float discount,int key/*过滤掉非VIP会员*/,String phonenum);//更新折扣
	public int UpdateUserById(int id,String phonenum);//跟新id
	
	public User GetUserByPhone(String phonenum);//通过电话号码得到一条用户信息
	public String GetUserPassword(String phonenum);//通过电话拿到密码（登陆）
	public List<User> GetUsers(int key);//通过key关键字得到VIP 和 非VIP
	public String GetUserPhone(String phonenum);
	
	public int GetMaxId();
	
}
