/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader; 

class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int numTestCases =  Integer.parseInt(br.readLine());
	    while(numTestCases-->0){
	        int numOfMeetings =  Integer.parseInt(br.readLine());
	        String meetStartTime = br.readLine();
	        String meetEndTime = br.readLine();
	        String [] meetStartTimeArr = meetStartTime.split(" ");
	        String [] meetEndTimeeArr = meetEndTime.split(" ");
	        List<Activity> activityList = new ArrayList<>();
	        for(int i=0;i<meetStartTimeArr.length;i++)
	            activityList.add(new Activity(Integer.parseInt(meetStartTimeArr[i]),Integer.parseInt(meetEndTimeeArr[i]),i));
	        Collections.sort(activityList);
	        System.out.print(activityList.get(0).index+1);
	        int finishTime = activityList.get(0).endTime;
	       /* for(int i=0 ;i<activityList.size();i++)
	            System.out.println(" "+(activityList.get(i).index+1)+" "+activityList.get(i).endTime+"");*/
	        for(int i=1;i<activityList.size();i++)
	            if(finishTime<=activityList.get(i).startTime){
	                System.out.print(" "+(activityList.get(i).index+1));
	                finishTime = activityList.get(i).endTime;
	            }
	        System.out.println();        
	    }
		//code
	
	}

    private static class Activity implements Comparable<Activity> {
        Integer index =0;
        Integer startTime = 0;
        Integer endTime = 0;

        private Activity(Integer st, Integer et, Integer ind) {
            index=ind;
            startTime = st;
            endTime = et;
        }

        //@Override
        public int compareTo(Activity o) {
            return this.endTime.compareTo(o.endTime);
        }

        
        //public String toString() {
           // return "(" + startTime + "-" + endTime + ")\n";
       // }
    }
}
