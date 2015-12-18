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

	public String address() {
		StringBuffer sb = new StringBuffer();
		sb.append(suite);
		sb.append(" ");
		sb.append(street);
		sb.append("/n");
		sb.append(city);
		sb.append(" ");
		sb.append(zipcode);
		return sb.toString();
	}
}
