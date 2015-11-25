import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

/////////////////////////
    public void testRoot2() {
            Rational s = new Rational( -1, 9 );
            Rational sRoot = null;
            try {
                sRoot = s.root();
            } catch (IllegalArgumentToSquareRootException e) {
                e.printStackTrace();
            }
            assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) )
                       && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

    public void testPlus(){
            Rational x = new Rational(1,2);
            Rational zero = new Rational(0,2);
            Rational z = new Rational(-1,2);
            //Rational w =  
            assertTrue(x.plus(z).equals(zero));
    }
    public void testTimes(){
        Rational x = new Rational(1,2);
        Rational zero = new Rational(0,2);
        Rational z = new Rational(-1,2);
        assertTrue(x.times(zero).equals(zero));
    }

    public void testMinus(){
        Rational x = new Rational(1,2);
        Rational zero = new Rational(0,2);
        Rational z = new Rational(-1,2);
        assertTrue(zero.minus(x).equals(z));
    }

    public void testMinus2(){
        Rational x=new Rational(1073741824,1);       
        Rational y=new Rational(-1073741824,1);
        Rational zero=new Rational(0,1);
        assertTrue(!x.minus(y).isLessThan(zero));
    }

    public void testDivides(){
        Rational x = new Rational(1,2);
            Rational zero = new Rational(0,2);
            Rational z = new Rational(-1,2);
            Rational one = new Rational(-1,1);

            assertTrue(x.divides(z).equals(one));
    }

    public void testDivides2(){
        Rational x=new Rational(-1073741824,1); 
        Rational z=new Rational(2,1);
        
        assertEquals(x,x.plus(x).divides(z));
    }

    public void testAbs(){
        Rational x= new Rational(5,0);
        Rational y = new Rational(-3,0);
        assertFalse(x.abs().equals(y.abs()));

    }

    public void testAbs2(){
        Rational x= new Rational(5,0);
        Rational y = new Rational(-5,0);
        assertTrue(x.abs().equals(y.abs()));

    }

    public void testIsLessThan(){
        Rational x= new Rational(0,2);
        Rational y = new Rational(0,1);
        assertFalse(x.isLessThan(y));
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}