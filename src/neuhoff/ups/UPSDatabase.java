package neuhoff.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {

	private Map<Location, Set<Package>> ups; 
	private Map<Package, Location> reverse;
	
	public UPSDatabase(){
		ups = new HashMap<Location, Set<Package>>();
		reverse = new HashMap<Package, Location>();
	}
	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation( Location location, Package pkg ) {
		reverse.put(pkg, location);
		if (ups.containsKey(location)){
			Set<Package> pkgs = getPackages(location);
			pkgs.add(pkg);
			ups.put(location, pkgs);
		}
		else{
			Set<Package> pkgs = new HashSet<Package>();
			pkgs.add(pkg);
			ups.put(location, pkgs);
		}
	}
	
	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation( Package pkg, Location location ) {
		//find the original location
		if (reverse.containsKey(pkg)){
			Location found = getLocation(pkg);
			reverse.put(pkg, location);
		
			//update the original location
			Set<Package> foundPkgs = ups.get(found);
			foundPkgs.remove(pkg);
			ups.put(found, foundPkgs);
		
			//put it into new set
			Set<Package> pkgs = getPackages(location);
			if (pkgs == null){
				pkgs = new HashSet<Package>();
			}
			pkgs.add(pkg);
			ups.put(location, pkgs);
		}
	}
	
	/**
	 * @return a Set of Packages at the specified Location or an empty Set if 
	 * the Location doesn't exist or there are no Packages at that Location.
	 */
	public Set<Package> getPackages( Location location ) {
		if (ups.containsKey(location)){
			return ups.get(location);
		}
		else
			return null;
	}
	
	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		if (reverse.containsKey(pkg)){
			return reverse.get(pkg);
		}
		return null;
	}
	
	
}
