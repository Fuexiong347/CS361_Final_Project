package test.sprint1;
import static org.junit.Assert.*;
import org.junit.Test;
import sprint1.PARAIND;
import sprint1.channel;
import sprint1.time;
import sprint1.chronotimer;
import sprint1.electric_eye;
public class testPARAIND {
	private time t;
	private channel c1;
	private channel c2;
	private channel c3;
	private channel c4;
	private PARAIND paraInd;
	private chronotimer chrono = new chronotimer();
	private electric_eye eye = new electric_eye();
	public testPARAIND(){
		t = new time();
		c1 = new channel(chrono,1,eye);
		c2 = new channel(chrono,2,eye);
		c3 = new channel(chrono,3,eye);
		c4 = new channel(chrono,4,eye);
		paraInd = new PARAIND();
	}
	@Test
	public void testEvent(){
		assertEquals("PARAIND",paraInd.toString());
	}
	@Test
	public void testAdd(){
		paraInd.addCompetitor(123);
		paraInd.addCompetitor(234);
		paraInd.addCompetitor(345);
		paraInd.addCompetitor(456);
		assertEquals(4,paraInd.getStart().size());
	}
	@Test
	public void testStart(){
		paraInd.addCompetitor(123);
		paraInd.addCompetitor(234);
		paraInd.addCompetitor(345);
		paraInd.addCompetitor(456);
		paraInd.start(t, c1);
		paraInd.start(t, c3);
		assertEquals(2,paraInd.getRunning().size());
	}
	@Test
	public void testFinish(){
		paraInd.addCompetitor(123);
		paraInd.addCompetitor(234);
		paraInd.addCompetitor(345);
		paraInd.addCompetitor(456);
		paraInd.start(t, c1);
		paraInd.start(t, c3);
		paraInd.finish(t, c2);
		paraInd.finish(t, c4);
		assertEquals(2,paraInd.getRun().size());
	}
	@Test
	public void testCancel(){
		paraInd.addCompetitor(123);
		paraInd.addCompetitor(234);
		paraInd.addCompetitor(345);
		paraInd.addCompetitor(456);
		paraInd.start(t, c1);
		paraInd.start(t, c3);
		paraInd.finish(t, c2);
		paraInd.finish(t, c4);
		paraInd.start(t, c1);
		paraInd.start(t, c3);
		assertEquals(2,paraInd.getRunning().size());
		assertEquals(2,paraInd.getRun().size());
		paraInd.cancel();
		assertEquals(2,paraInd.getStart().size());
		assertEquals(345,paraInd.getStart().poll().getID());
		assertEquals(456,paraInd.getStart().poll().getID());
	}
}
