import static org.junit.jupiter.api.Assertions.*;
import com.sun.net.httpserver.Authenticator;
import org.junit.jupiter.api.Test;

import java.util.List;

class Testing {

    @Test
    void testGetChange() {
        int array[] = {25,21,10,1};
        assertEquals(List.of(25,21,1,1,1), Coins.makeChange(array,49));
    }

    @Test
    void testBigChange() {
        int array[] = {25,10,5,1};
        Exception e = assertThrows(IllegalArgumentException.class, () -> {  Coins.makeChange(array,1500); } );
        assertEquals("Too much change back give them dollar bills first!", e.getMessage());
    }

    @Test
    void testGetChangeEmptyArray() {
        int array[] = {};
        Exception e = assertThrows(IllegalArgumentException.class, () -> {  Coins.makeChange(array,38); } );
        assertEquals("Array of size 0 is not allowed", e.getMessage());
    }
    @Test
    void testTooBigDenom(){
        int array []={25,1000,5,0};
        Exception e = assertThrows(IllegalArgumentException.class, () -> {  Coins.makeChange(array,78); } );
        assertEquals("What kind of coin is that?", e.getMessage());
    }
    @Test
    void shouldWork(){
        int array []={25,21,5,1};
        CoinArr.coins(array,92);
        assertEquals(List.of(25,21,21,21,1),Coins.makeChange(array,89));
        List list=Coins.makeChange(array,89);
        System.out.println(list);
        new Authenticator.Retry(3);
        }
}
