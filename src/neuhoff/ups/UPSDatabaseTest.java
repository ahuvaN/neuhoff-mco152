package neuhoff.ups;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase ups = new UPSDatabase();
		Location location = new Location(12L, 34L);
		Package pkg = new Package("1234");
		ups.addPackageToLocation(location, pkg);
		Assert.assertTrue(ups.getPackages(location).contains(pkg));
		Assert.assertTrue(location.hashCode() == ups.getLocation(pkg).hashCode());
		
	}
	
	@Test 
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase ups = new UPSDatabase();
		Location origLocation = new Location(12L, 34L);
		Location newLocation = new Location(56L, 78L);
		Package pkg = new Package("1234");
		ups.addPackageToLocation(origLocation, pkg);
		ups.updatePackageLocation(pkg, newLocation);
		Assert.assertFalse(ups.getPackages(origLocation).contains(pkg));
		Assert.assertTrue(ups.getPackages(newLocation).contains(pkg));
		Assert.assertTrue(newLocation.hashCode() == ups.getLocation(pkg).hashCode());
	}
	
	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase ups = new UPSDatabase();
		Location location = new Location(12L, 34L);
		Location loc = new Location(56L, 78L);
		Package pkg = new Package("1234");
		ups.addPackageToLocation(location, pkg);
		Assert.assertEquals(new HashSet<Package>() ,ups.getPackages(loc));
	}
	
	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase ups = new UPSDatabase();
		Location location = new Location(12L, 34L);
		Package pkg = new Package("1234");
		ups.addPackageToLocation(location, pkg);
		Assert.assertNull(ups.getLocation(new Package("3456")));
	}
	
}
