package util;

public class Logic {
    public static IntTupel findNextBigField(IntTupel input){
        IntTupel result = new IntTupel(-1, -1);
        int rx1 = input.getX1() % 3;
        int rx2 = input.getX2() % 3;
        rx1 = rx1 == 0 ? 3 : rx1;
        rx2 = rx2 == 0 ? 3 : rx2;
        result.setX1(rx1);
        result.setX2(rx2);
        return result;
    }

    public static IntTupel findActiveField(IntTupel intTupel){
        IntTupel result = new IntTupel(-1, -1);
        int rx1 = (int) Math.ceil((double) (intTupel.getX1()) / 3);
        int rx2 = (int) Math.ceil((double) (intTupel.getX2()) / 3);
        result.setX1(rx1);
        result.setX2(rx2);
        return result;
    }

    public static boolean isString(String s){
        try{
            Integer.parseInt(s);
            return false;
        } catch (Exception e){
            return true;
        }
    }

    //TODO winlogic
}