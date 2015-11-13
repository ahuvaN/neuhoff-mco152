package neuhoff.airline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

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
	
	private void fillPlane(){
		StringBuilder sb = new StringBuilder();
		String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		for (int row = 1; row <= totalRows; row++){
			for (int col = 0; col < totalCols; col++){
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

		if (!airplane.containsKey(seatName)){
			throw new SeatOutOfBoundsException();
		} else if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		}
		else{
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
	 *         ABCD\n 
	 *       1 #oo#\n 
	 *       2 #ooo\n 
	 *       3 ###o\n 
	 *       4 ##oo\n 
	 *       5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		 Collections.sort(seatNames, new Comparator<String>() {
		        @Override
		        public int compare(String s1, String s2) {
		            return s1.compareTo(s2);
		        }
		    });
		 
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int col = 65; col < totalCols + 65; col++){
			sb.append(String.valueOf(Character.toChars(col)));
		}
		sb.append("\n");
		int row = 1;
		sb.append(row++);
		sb.append(" ");
				
		for (int i = 0; i <= seatNames.size(); i++){
			if (i +1 < 1 && seatNames.get(i).charAt(0) != seatNames.get(i - 1).charAt(0)){
				sb.append("\n");
				sb.append(row++);
				sb.append(" ");
			}
			sb.append(airplane.get(seatNames.get(i)).toString());
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
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException {
		ArrayList<String> group = new ArrayList<String>();
		if (numberOfSeatsTogether > totalCols || isPlaneFull()){
			throw new NotEnoughSeatsException();
		}
		//if (airplane.containsKey(key))
		return group;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return !airplane.containsValue('o');
	}

}
