import com.pathfinderGenerator.app.object.Monster;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

//testing
import com.pathfinderGenerator.app.generator.RandomEncounter;

import java.util.Collections;
import java.util.List;

public class RandomEncounterTest {

    RandomEncounter randomEncounter = new RandomEncounter();

    @Test
    @DisplayName("Running query 1000 times to try an rng error (outside of bounds)")
    public void rngVerify() {
        System.out.println("Prepping it iterate through all environments");
        for(int i = 0; i < 1000; i++){
            int rnd = i;
            String sense = "";
            switch (rnd%6) {
                case 0: sense = "Forest"; break;
                case 1: sense = "Aquatic"; break;
                case 2: sense = "Swamp"; break;
                case 3: sense = "Mountain"; break;
                case 4: sense = "Plains"; break;
                case 5: sense = "Arctic"; break;
            }
            List<Monster> rndEncGenerator = randomEncounter.rndEncGenerator(sense, 4, 4, Collections.singletonList("Testing"));
            if(rndEncGenerator.size() != 0){
                if(rndEncGenerator.get(0).getEncType().equals("hazard")){
                    Assert.assertEquals(rndEncGenerator.get(0).getEncType(),"hazard");
                }
            }
        }
        System.out.println("If no error test completed");
    }

}
