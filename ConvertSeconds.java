public class ConvertSeconds {
 
        public static void main(String[] args) {
            int seconds = 187530;
    
            // calculate days, hours, minutes, and remaining seconds
            int days = seconds / 86400;
            int hours = (seconds % 86400) / 3600;
            int minutes = ((seconds % 86400) % 3600) / 60;
            int remainingSeconds = ((seconds % 86400) % 3600) % 60;
    
            // print results
            System.out.println(seconds + " seconds is equal to:");
            System.out.println(days + " days, " + hours + " hours, " + minutes + " minutes, and " + remainingSeconds + " seconds.");
        }
    }

