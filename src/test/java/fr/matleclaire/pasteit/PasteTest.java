package fr.matleclaire.pasteit;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring-context.xml")
public class PasteTest {

    @Autowired
    private PasteRepository pasteRepository;



    @Before public void setUp() {
        // prepare data
        Paste p1 = new Paste("test-1", "hello", "world");
        Paste p2 = new Paste("test-2", "test 2", "All your base are belong to us");

        pasteRepository.save(p1);
        pasteRepository.save(p2);

    }



    @Test
    public void test() throws Exception {
        assertThat(true).isTrue();
    }



    @Test
    public void shouldFindAllElement() throws Exception {
        List<Paste> pasteList = pasteRepository.findAll();
        assertThat(pasteList).onProperty("id").contains("test-1", "test-2");
    }


    @After
    public void tearDown() {
        pasteRepository.deleteAll();
    }
}
