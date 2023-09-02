package exemplo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void calculaMultTeste(){
        int num1 = 6;
        int num2 = 9;
        int res = App.calculaMult(num1, num2);
        assertEquals(null, 54, res);
    }
    @Test
    public void verificaMaiorTeste(){
        double num1 = 10.0;
        double num2 = 4.0;
        boolean res = App.comparaNumeros(num1, num2);
        assertTrue(res);
    }
    @Test
    public void parouimparTeste(){
        double num_teste = 11;
        boolean res = App.parouimpar(num_teste);
        assertFalse(null, res);
    }
}
