/*
How much do you pay an auto rickshaw? There is a fixed minimum charge of Rs. 35 which takes you the first 1.6 km. After that every km and part there of is charged at Rs.10 per km. Waiting charges are at Rs 1 per minute and luggage charges are at Rs 5 per 10kg 
*/

public class p3 {
    public static void main(String[] args) {
        float distance = 2f, luggages = 10f;
        int waitingTime = 120;
        System.out.println(autofare(distance, luggages, waitingTime));
    }
    
    //distance in km, luggages in kg, waitingTime in seconds
    static int autofare(float distance, float luggages, int waitingTime) {
        //mindistance = 1.6, mincharge = 35, distanccharges = 10/1km, waitingcharges = 1/minute, luggagecharges = 5/10kg;
        if(distance <= 1.6f) {
            return  Math.round(35 + (luggages*5 / 10) + waitingTime/60);
        }
        else {
            return Math.round(35 + (distance - 1.6f)*10 + (luggages*5 / 10) + waitingTime/60);
        }
    }
}
