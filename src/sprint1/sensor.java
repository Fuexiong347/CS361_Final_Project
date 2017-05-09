package sprint1;

/*
 * used to represent sensors. it will be implemented in future sprints
 */
interface sensor extends Runnable{
	
	//public void trigger();
	public boolean isHooked();
	public void plug(channel c);
	public void unplug(channel c);
}
