package com.epam.collections.propertyparser;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Date: 09.02.2017
 *
 * @author Karapetyan N.K
 */
public class PropertyReaderTest {
    @Test
    public void getValue() throws Exception {
        PropertyReader pr = new PropertyReader("src/test/resources/prop.properties");
        assertThat(pr.getValue("db1"), is("first element"));
        assertNull(pr.getValue("db3"));
    }

}