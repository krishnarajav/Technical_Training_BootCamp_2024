/*
Input:
Number of vehicles: 200
Number of wheels: 540

Output:
Two Wheelers =130 
Four Wheelers =  70 
*/

public class p4 {
    public static void main(String[] args) {
        int W = 539, V = 200;
        vehiclecount(W, V);
    }

    static void vehiclecount(int W, int V) {
        if(W > V) {
            int FW = (W - (2*V)) / 2;
            int TW = V - FW;
            System.out.println("Four Wheelers = "+FW);
            System.out.println("Two Wheelers = "+TW);
        }
        else 
            System.out.println("Number of Wheels must be greater than number of Vehicles.");
    }
}
