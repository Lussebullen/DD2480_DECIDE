package group17;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;






public class InputHandler {
    int NUMPOINTS;
    double[][] POINTS;
    double LENGTH1;
    double RADIUS1;
    double EPSILON;
    double AREA1;
    int Q_PTS;
    int QUADS;
    double DIST;
    int N_PTS;
    int K_PTS;
    int A_PTS;
    int B_PTS;
    int C_PTS;
    int D_PTS;
    int E_PTS;
    int F_PTS;
    double LENGTH2;
    double RADIUS2;
    double AREA2;
    String[][] LCM;
    boolean[] PUV;
    public InputHandler(String filepath) {    
        try {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file into a JsonNode
        JsonNode jsonNode = objectMapper.readTree(new File("decide/sampleData.json"));
        NUMPOINTS = jsonNode.get("NUMPOINTS").asInt();
        POINTS = jsonNode.get("POINTS").traverse(objectMapper).readValueAs(double[][].class); 
        LENGTH1 = jsonNode.get("LENGTH1").asDouble();
        RADIUS1 = jsonNode.get("RADIUS1").asDouble();
        EPSILON = jsonNode.get("EPSILON").asDouble();
        AREA1 = jsonNode.get("AREA1").asDouble();
        Q_PTS = jsonNode.get("Q_PTS").asInt();
        QUADS = jsonNode.get("QUADS").asInt();
        DIST = jsonNode.get("DIST").asDouble();
        N_PTS = jsonNode.get("N_PTS").asInt();
        K_PTS = jsonNode.get("K_PTS").asInt();
        A_PTS = jsonNode.get("A_PTS").asInt();
        B_PTS = jsonNode.get("B_PTS").asInt();
        C_PTS = jsonNode.get("C_PTS").asInt();
        D_PTS = jsonNode.get("D_PTS").asInt();
        E_PTS = jsonNode.get("E_PTS").asInt();
        F_PTS = jsonNode.get("F_PTS").asInt();
        RADIUS2 = jsonNode.get("RADIUS2").asDouble();
        AREA1 = jsonNode.get("AREA1").asDouble();
        AREA2 = jsonNode.get("AREA2").asDouble();
        LCM = jsonNode.get("LCM").traverse(objectMapper).readValueAs(String[][].class); 
        PUV = jsonNode.get("PUV").traverse(objectMapper).readValueAs(boolean[].class); 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
