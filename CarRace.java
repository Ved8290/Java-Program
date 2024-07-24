import java.awt.*;
import java.awt.event.*;

class CarRace extends Frame implements Runnable 
{
	    private int x1,x2;
        private Thread t1,t2; 
	    public CarRace()
        {
		setTitle("Car Racing");
		setSize(500,300);
		setLocation(100,100);
		setVisible(true);
        x1=0;
        x2=0;

		t1 = new Thread(this);
		t2 = new Thread(this);
       
		t1.start();
		t2.start();
        
	}

    public void update(Graphics g){
        paint(g);
    }
    
	public void paint(Graphics g)
        {
		super.paint(g);

		g.setColor(Color.RED);
		g.fillRect(x1,70,75,45);

		g.setColor(Color.GREEN);
		g.fillRect(x2,150,75,45);
	}


		
		public void run()
                 {
			while(true)
             {
                if(Thread.currentThread() == t1){
                    x1 +=20;
                    
                    if(x1>getWidth()) x1=0;
                }
                else if(Thread.currentThread() == t2){
                    x2 +=15;

                    if(x2>getWidth()) x2=0;
                }

				try
                                {
					Thread.sleep(1000);
				}catch(Exception e){
                    e.printStackTrace();
                }

				repaint();
			}
		}
     

		public static void main(String args[])
        {
	     new CarRace();
         
	}
}
									
			
