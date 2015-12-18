package neuhoff.contacts;

public class Contact implements Comparable<Contact> {

	private String name;
	private String email;
	private Address address;
	private String phone;
	private String first;
	private String last;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getLastName() {
		String[] name = this.name.split(" ");
		int length = name.length;
		if (length > 2) {
			if (name[length - 1].length() < 2) {
				first = name[0];
				last = name[1] + " " + name[2];
			} else {
				first = name[0] + " " + name[1];
				last = name[2];
			}
		} else {
			first = name[0];
			last = name[1];
		}
		return last;
	}

	@Override
	public int compareTo(Contact o) {
		return getLastName().compareTo(o.getLastName());
	}
	
	public String toString(){
		return first + " " + last;
	}

}
