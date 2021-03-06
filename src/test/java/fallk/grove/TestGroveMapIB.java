// THIS CODE IS MACHINE-GENERATED, DO NOT EDIT!

package fallk.grove;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import gnu.trove.map.TIntByteMap;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntByteHashMap;
import gnu.trove.map.hash.TIntObjectHashMap;

// Tokens:
// int, byte = byte, char, etc.
// I, B = B, C, etc.
// Int, Byte = Byte, Char, etc.
// Integer, Byte = Byte, Character, etc.
// IntByte = ByteByte, ByteChar, etc.
public final class TestGroveMapIB {
    private Random rand;

    @Before
    public void setUp() throws Exception {
        rand = new Random(4); // chosen by fair dice roll. guaranteed to be random.
    }

    @After
    public void tearDown() throws Exception {
    }

    @SuppressWarnings("all")
    @Test
    public void test() {
        Gson gson = new GroveBuilder().create();

        int[] f = new int[300];
        byte[] r = new byte[300];
        for (int i = 0; i < f.length; i++) {
            f[i] = (int) (rand.nextDouble() * 9999);
            r[i] = (byte) ((byte) (rand.nextDouble() * 9999)+127);
        }
        TIntByteMap list = new TIntByteHashMap();
        for (int i = 0; i < f.length; i++) {
            list.put(f[i], r[i]);
        }

        String s = gson.toJson(list, TIntByteMap.class);
        System.out.println(s);
        TIntByteMap after = gson.fromJson(s, TIntByteMap.class);

        Assert.assertEquals(list.size(), after.size());

        list.forEachEntry((a, b) -> {
            AssertUtil.equals(after.get(a), b);
            return true;
        });
    }
}
