package neuhoff.airline;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private int totalRows;
	private int totalCols;
	private HashMap<String, Boolean> airplane;
	private ArrayList<String> seatNames;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.totalRows = rows;
		this.totalCols = columns;
		this.airplane = new HashMap<String, Boolean>();
		this.seatNames = new ArrayList<String>();
		fillPlane();
	}

	private void fillPlane() {
		StringBuilder sb = new StringBuilder();
		String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		for (int row = 1; row <= totalRows; row++) {
			for (int col = 0; col < totalCols; col++) {
				sb.append(alpha[col]);
				sb.append(Integer.toString(row));
				seatNames.add(sb.toString());
				airplane.put(sb.toString(), false);
				sb.setLength(0);
			}
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException,
			SeatOutOfBoundsException {

		if (!airplane.containsKey(seatName)) {
			throw new SeatOutOfBoundsException();
		} else if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		} else {
			airplane.put(seatName, true);
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return airplane.get(seatName);
	}

	public boolean isReserved(ArrayList<String> reserved) {
		boolean is = false;
		for (String seatName : seatNames) {
			is = isReserved(seatName);
			if (!is) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD\n 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {

		String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int col = 65; col < totalCols + 65; col++) {
			sb.append(String.valueOf(Character.toChars(col)));
		}
		sb.append("\n");

		StringBuilder seat = new StringBuilder();
		for (int row = 1; row <= totalRows; row++) {
			sb.append(row);
			sb.append(" ");
			for (int col = 0; col < totalCols; col++) {
				seat.append(alpha[col]);
				seat.append(Integer.toString(row));

				if (seatNames.contains(seat.toString())) {
					sb.append(isReserved(seat.toString()) ? "#" : "o");
				}
				seat.setLength(0);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int num) //numberOfSeatsTogether
			throws NotEnoughSeatsException {
		ArrayList<String> emptySeats = new ArrayList<String>();
		ArrayList<String> group = new ArrayList<String>();
		if (num > totalCols || isPlaneFull()){
			throw new NotEnoughSeatsException();
		}
		else {
			String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

			StringBuilder seat = new StringBuilder();
			for (int row = 1; row <= totalRows; row++){
				for (int col = 0; col < totalCols; col++){
					seat.append(alpha[col]);
					seat.append(Integer.toString(row));
				
					if (seatNames.contains(seat.toString())){
						if(!isReserved(seat.toString())){
							emptySeats.add(seat.toString());
						}
					}
				seat.setLength(0);
				}
				if (emptySeats.size() < num){
					emptySeats.clear();
				}
				else{
					while (group.size() < num){
						for(int i = 0; i < emptySeats.size(); i++){
							if (i + 1 == emptySeats.size()){
								group.add(emptySeats.get(i));
							}
							else if (emptySeats.get(i).charAt(0) + 1 == emptySeats.get(i+1).charAt(0)){
								group.add(emptySeats.get(i));
							}
							else {
								group.clear();
							}	
									
							}
						}
					}
				}
		
			}
		
	if (group.size() != num)
		group.subList(num, group.size()).clear();
	return group;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return !airplane.containsValue(false);
	}

}
