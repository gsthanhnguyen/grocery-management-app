package model;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item item01;


    @BeforeEach
    public void setUp() {
        item01 = new Item(1,"item01 name",100,"A",100.0,110.0);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, item01.getItemID());
        assertEquals("item01 name", item01.getItemName());
        assertEquals(100, item01.getItemCount());
        assertEquals("A", item01.getItemPosition());
        assertEquals(100.0, item01.getItemInPrice());
        assertEquals(110.0, item01.getItemOutPrice());
    }

    @Test
    public void testPriceTax() {
        assertEquals(123.2, item01.priceAfterBCTax());
    }

    @Test
    public void testChangeID() {
        assertEquals(11,item01.changeItemID(11));
    }

    @Test
    public void testChangeName() {
        assertEquals("new name", item01.changeItemName("new name"));
    }

    @Test
    public void testChangeCount() {
        assertEquals(111, item01.changeItemCount(111));
    }

    @Test
    public void testChangePosition() {
        assertEquals("B", item01.changeItemPosition("B"));
    }

    @Test
    public void testChangeInPrice() {
        assertEquals(100.0, item01.changeItemInPrice(100.0));
    }

    @Test
    public void testChangeOutPrice() {
        assertEquals(100.0, item01.changeItemOutPrice(100.0));
    }

    @Test
    public void toJsonTest() {
        JSONObject testItem1 = item01.toJson();
        assertEquals(1,testItem1.getInt("id"));
        assertEquals("item01 name", testItem1.getString("name"));
        assertEquals(100,testItem1.getInt("count"));
        assertEquals("A", testItem1.getString("position"));
        assertEquals(100.0,testItem1.getDouble("inprice"));
        assertEquals(110.0,testItem1.getDouble("outprice"));
     }
}

