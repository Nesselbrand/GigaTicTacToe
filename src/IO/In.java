package IO;

import util.IntTupel;
import util.NotValidMoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class In {
    public IntTupel readMove() throws NotValidMoveException {//x1 = x && x2 = y

        boolean finished;
        do {
            finished = false;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s = "";

            try {
                s = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (s.length() != 2) {
                throw new NotValidMoveException();
            } else {

            }
        } while (!finished);


        IntTupel input = new IntTupel(-1, -1); //-1 cathch error und sachen
        return input;
    }
}