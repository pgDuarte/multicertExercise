package spring.webservices.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class User {

		@Id
		@Column(name = "nif", nullable=false)  private String nif;
		@Column(name = "name", nullable=false)  private String name;
		@Column(name = "phoneNumber", nullable=false)  private String phoneNumber;
		@Column(name = "address", nullable=false)  private String address;
		
		
		
		public String getNif() {
			return nif;
		}
		public void setNif(String nif) {
			this.nif = nif;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}


		
}
