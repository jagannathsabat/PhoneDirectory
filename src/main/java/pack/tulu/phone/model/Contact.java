package pack.tulu.phone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT")
public class Contact {
	
	@Id 
	@GeneratedValue
	private Integer contactId;
	@Column(unique=true)
	private String contactName;
	@Column(unique=true)
	private String contactNumber;
	
	@ManyToOne()
	@JoinColumn(name="userId")
	private User user;
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [contactId=");
		builder.append(contactId);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", contactNumber=");
		builder.append(contactNumber);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	

}
