package pl.mykitchen.mykitchen.contollers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndexControllerTest {
    IndexController controller;

    @Before
    public void setUp() {
        controller = new IndexController();
    }

    @Test
    public void getIndexPage() {
        // Given
        String viewName = controller.getIndexPage();
        // When
        // Then
        assertEquals("index", viewName);
    }
}