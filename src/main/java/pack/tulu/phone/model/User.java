package pack.tulu.phone.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public class User {
	
	/**
	 * id field is must in every entity bean
	 * and type of id should be number type for example: Long, Integer, etc
	 */
	@Id //for primary key
	@GeneratedValue //for auto_increment
	private Integer userId;
	
	//allow mobileNumber to register once, or else will get multiple results while executing query
	@Column(unique=true)	
	private String mobileNumber;	
	private String userName;
	private String userPassword;
	
	@OneToMany(mappedBy="user")
	private Collection<Contact> contacts = new ArrayList<>();
	
	public User(){}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer id) {
		this.userId = id;
	}
	public Collection<Contact> getContact() {
		return contacts;
	}
	public void setContact(Collection<Contact> contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userPassword=");
		builder.append(userPassword);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append("]");
		return builder.toString();
	} 
	
	
}
