package test.sprint1;
import static org.junit.Assert.*;
import org.junit.Test;
import sprint1.GRP;
import sprint1.channel;
import sprint1.time;
import sprint1.chronotimer;
import sprint1.electric_eye;
public class testGRP {
	private time t;
	private channel c1;
	private channel c2;
	private GRP grp;
	private chronotimer chrono = new chronotimer();
	private electric_eye eye = new electric_eye();
	public testGRP(){
		t = new time();
		c1 = new channel(chrono,1,eye);
		c2 = new channel(chrono,2,eye);
		grp = new GRP();
	}
	@Test
	public void testStart(){
		grp.start(t, c1);
		assertEquals(t.getTime(),grp.getStartTime().getTime());
	}
	@Test
	public void testFinish(){
		grp.start(t, c1);
		grp.finish(t, c2);
		grp.finish(t, c2);
		grp.finish(t, c2);
		grp.finish(t, c2);
		grp.addCompetitor(123);
		grp.addCompetitor(456);
		grp.addCompetitor(789);
		grp.addCompetitor(134);
		assertEquals(4,grp.getRun().size());
	}
}
