package IO;

import util.IntTupel;
import util.Logic;
import util.NotValidMoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class In {
    public IntTupel readMove() throws NotValidMoveException {//x1 = x && x2 = y
        IntTupel input = new IntTupel(-1, -1);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new NotValidMoveException();
        }

        //region check if statement is legal
        if (s.length() != 2) {
            throw new NotValidMoveException();
        } else {
            String s1 = s.substring(0, 1);
            String s2 = s.substring(1, 2);

            int x1, x2;

            if (Logic.isString(s1) && !Logic.isString(s2)){
                x1 = convertCharToInt(s1);
                x2 = Integer.parseInt(s2);
            } else if (!Logic.isString(s1) && Logic.isString(s2)) {
                x2 = convertCharToInt(s2);
                x1 = Integer.parseInt(s1);
            } else {
                throw new NotValidMoveException();
            }

            if (x2 < 1 || x2 > 9) {
                throw new NotValidMoveException();
            } else {
                input.setX1(x2);
                input.setX2(x1);
            }
        }
        //endregion

        return input;
    }

    private int convertCharToInt(String s1) throws NotValidMoveException {
        int i = -1;
        char c = s1.toCharArray()[0];

        if (!(c > 96 && c < 107)){
            throw new NotValidMoveException();
        } else {
            c -= 96;
            i = c;
        }

        return i;
    }
}