package group17;

import java.util.List;
import java.util.ArrayList;

public class LicAnalyzer {

    public boolean lic0(InputHandler input) {
        return false;
    }

    public boolean lic1(InputHandler input) {
        return false;
    }

    public boolean lic2(InputHandler input) {
        return false;
    }

    public boolean lic3(InputHandler input) {
        return false;
    }

    /**
     *  Checks if Q_PTS consecutive data points lie in more than QUADS quadrants.
     *  @returns true, false, or @throws IllegalArgumentException
     *  @param input.NUMPOINTS,QUADS,Q_PTS,X_COORD,Y_COORD
    */
    public boolean lic4(InputHandler input) throws IllegalArgumentException {
        //Note: 
        //  q1 = {x = [0, inf), y = [0, inf)},
        //  q2 = {x = (0, -inf), y = [0, inf)},
        //  q3 = {x = [0, -inf), y = (0, -inf)},
        //  q4 = {x = (0, inf), y = (0, -inf)}
        
        //Throw exeception for invalid inputs
        if (input.NUMPOINTS  <= 1 || input.NUMPOINTS > 100) 
        {
            throw new IllegalArgumentException();    
        }
        else if (input.QUADS > 3 || input.QUADS <= 0) 
        {
            throw new IllegalArgumentException();    
        }
        else if (input.Q_PTS > input.NUMPOINTS || input.Q_PTS <= 1) 
        {
            throw new IllegalArgumentException();    
        }
        else if (input.NUMPOINTS  < input.Q_PTS) 
        {
                throw new IllegalArgumentException();    
            }
        
        //Valid input edge case that must be false
        if (input.Q_PTS  <= input.QUADS) 
        {
            return false;    
        }
        
        //Initialize
        ArrayList<Integer> numOfQuadrantsCovered = new ArrayList<Integer>();
        int currentPointQuadrant = 0;

        //Create sliding window of size Q_PTS to check
        // if points in window lie in more than QUADS quadrants.
        for (int i = 0; i < input.NUMPOINTS - input.Q_PTS; i++)
        {
            for(int j = i; j < input.Q_PTS + i; j++)
            {
                if(input.X_COORD[j] >= 0 && input.Y_COORD[j] >= 0)
                    currentPointQuadrant = 1;
                else if(input.X_COORD[j] < 0 && input.Y_COORD[j] >= 0)
                    currentPointQuadrant = 2;
                else if(input.X_COORD[j] <= 0 && input.Y_COORD[j] < 0)
                    currentPointQuadrant = 3;
                else if(input.X_COORD[j] > 0 && input.Y_COORD[j] < 0)
                    currentPointQuadrant = 4;

                //If quadrant is not already covered, increase coverage.
                if(!numOfQuadrantsCovered.contains(currentPointQuadrant))
                {
                    numOfQuadrantsCovered.add(currentPointQuadrant);
                    //Seen points covers more than QUADS
                    if(numOfQuadrantsCovered.size() > input.QUADS)
                        return true;
                }
            }
            //If points in tested window failed, restart coverage check n move window.
            numOfQuadrantsCovered.clear();
        }
 
        return false;
    }

    public boolean lic5(InputHandler input) {
        return false;
    }

    public boolean lic6(InputHandler input) {
        return false;
    }

    public boolean lic7(InputHandler input) {
        return false;
    }

    public boolean lic8(InputHandler input) {
        return false;
    }

    public boolean lic9(InputHandler input) {
        return false;
    }

    public boolean lic10(InputHandler input) {
        return false;
    }

    public boolean lic11(InputHandler input) {
        return false;
    }

    public boolean lic12(InputHandler input) {
        return false;
    }

    public boolean lic13(InputHandler input) {
        return false;
    }

    public boolean lic14(InputHandler input) {
        return false;
    }

    public boolean lic15(InputHandler input) {
        return false;
    }

}
