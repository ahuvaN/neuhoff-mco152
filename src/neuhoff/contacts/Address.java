package neuhoff.contacts;

public class Address {
	private String street;
	private String suite;
	private String city;
	private String zipcode;

	public String getStreet() {
		return street;
	}

	public String getSuite() {
		return suite;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String line1() {
		return suite + " " + street;
	}
	
	public String line2(){
		return city + " " + zipcode;
	}
}
