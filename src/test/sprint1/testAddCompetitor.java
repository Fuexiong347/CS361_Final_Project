package test.sprint1;
import static org.junit.Assert.*;
import org.junit.Test;
import sprint1.competitor;
import sprint1.time;
public class testAddCompetitor {
	private competitor c1;
	private competitor c2;
	private competitor c3;
	private time start;
	private time finish;
	@Test
	public void testAdd(){
		c1 = new competitor(123);
		c2 = new competitor(234);
		c3 = new competitor(345);
		assertEquals(123,c1.getID());
		assertEquals(234,c2.getID());
		assertEquals(345,c3.getID());
	}
	@Test
	public void testTime(){
		c1 = new competitor(123);
		start = new time(1012345);
		finish = new time(1019988);
		c1.setStart(start);
		c1.setFinish(finish);
		
		assertEquals(start.getTime(),c1.getStart().getTime());
		assertEquals(finish.getTime(),c1.getFinish().getTime());
		assertEquals("0:0:7.643", c1.calculateElapsed().getTime());
		
	}
}
