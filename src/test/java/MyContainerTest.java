

import org.example.MyContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyContainerTest {
    private MyContainer<String> container;

    @BeforeEach
    public void setUp() {
        container = new MyContainer<>();
    }

    @Test
    public void testAddAndGet() {
        container.add("Item 1");
        container.add("Item 2");

        assertEquals("Item 1", container.get(0));
        assertEquals("Item 2", container.get(1));
    }

    @Test
    public void testRemove() {
        container.add("Item 1");
        container.add("Item 2");
        container.add("Item 3");

        container.remove(1);

        assertEquals("Item 1", container.get(0));
        assertEquals("Item 3", container.get(1));
        assertEquals(2, container.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, container.size());

        container.add("Item 1");
        container.add("Item 2");

        assertEquals(2, container.size());
    }

    @Test
    public void testGetOutOfBounds() {
        container.add("Item 1");

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1));
    }

    @Test
    public void testRemoveOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(0));
    }
}
