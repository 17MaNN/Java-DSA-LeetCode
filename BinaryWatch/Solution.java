class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                // Count total set bits in hour and minute
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {

                    // Format minute with leading zero
                    String time = hour + ":" + 
                                  (minute < 10 ? "0" + minute : minute);

                    result.add(time);
                }
            }
        }

        return result;
