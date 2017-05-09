package test.sprint1;
import static org.junit.Assert.*;
import org.junit.Test;
import sprint1.IND;
import sprint1.channel;
import sprint1.time;
import sprint1.chronotimer;
import sprint1.electric_eye;
public class testIND {
	private time t;
	private channel c1;
	private channel c2;
	private channel c3;
	private IND ind;
	private chronotimer chrono = new chronotimer();
	private electric_eye eye = new electric_eye();
	public testIND(){
		t = new time();
		c1 = new channel(chrono,1,eye);
		c2 = new channel(chrono,2,eye);
		c3 = new channel(chrono,3,eye);
		ind = new IND();
	}
	@Test
	public void testEVENT(){
		assertEquals("IND", ind.toString());
	}
	@Test
	public void testRaceIND(){
		//checking that competitor is properly added.
		ind.addCompetitor(123);
		assertEquals(123,ind.getCompetitorInLine().peek().getID());
		//testing start with enable off
		ind.start(t, c1);
		assertEquals(null,ind.getCompetitorRunning().peek());
		//testing start with enable on and making sure competitor started
		c1.enable();
		ind.start(t, c1);
		assertEquals(123,ind.getCompetitorRunning().peek().getID());
		//testing finish 
		c2.enable();
		assertTrue(c2.state());
		ind.finish(t, c2);
		assertEquals(123,ind.getCompetitorWhoTriggered().getID());
		assertNotNull(ind.getCompetitorWhoTriggered().getElapsed());
	}
	@Test
	public void testEnable(){
		c1.enable();
		assertTrue(c1.state());
		c2.enable();
		assertTrue(c2.state());
	}
	@Test
	public void testSwap(){
		ind.addCompetitor(123);
		ind.addCompetitor(456);
		assertEquals(2,ind.getCompetitorInLine().size());
		c1.enable();
		c3.enable();
		ind.start(t, c1);
		ind.start(t, c3);
		assertEquals(2,ind.getCompetitorRunning().size());
		assertEquals(123,ind.getCompetitorRunning().peek().getID());
		ind.swap();
		assertEquals(456,ind.getCompetitorRunning().peek().getID());
	}
	@Test
	public void testCancel(){
		ind.addCompetitor(123);
		ind.addCompetitor(456);
		c1.enable();
		ind.start(t, c1);
		ind.cancel();
		assertEquals(123,ind.getCompetitorInLine().peek().getID());
		
	}
}
