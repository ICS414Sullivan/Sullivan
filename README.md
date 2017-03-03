Sullivan
Actual LOC to-date: 0 LOC
Requirements
The display of VOR
Deflection calculation of needle
Methods of GOOD/BAD and FR/TO signal.
What are the parameters?

Initialize radial: parameters (int x1, int x2, int y1, int y2) : Initialize that radial with the given x and y values in the middle of the map using a GUI
Initialize station: parameters():this.x = 0 this.y = 0 initialize the station to be the origin
Initialize plane: parameters(int x, int y): This.x = x, this.y=y, this.angle= angle
Find angle function: parameters(int x, int y) To find the angle of the plane relative to the station, find the inverse tangent of y/x.   
overStation function: parameters (): overStation = randomly generated number.  If our plane is equivalent to 1, it is over the station and the signal will be bad.  Else it will be good.
To/Fr method : parameters(int angle) get the angle from the plane relative to the station and compare it to the OBS degrees from To (90-270 or whatever the OBS range currently is) and if the plane is in this boundary, set a boolean to true (true=To, false= FR).
Good/Bad signal method: parameters(int x, int y) have a value that is set for the max x and y position to receive a good signal. If the plane's x or y position is greater than that of the max boundaries or anything less than the minimum boundaries, return false(bad signal).

Update OBS: parameters(int change) have the value of the left x (x1= 90), right x (x2 = 270), up(y1 = 0), and down (y2 = 180). Increase each of these by the value of change and mod the numbers by 360, incase they go over and update the radial image to match. 

Flight deflection: parameters(int deflection) compares the y value of  aircraft and subtract the y-axis value. There are 4 dots and each dot represents 2 degrees off.  An additional two dots, implying a full turn, indicates anything more than 10 degrees away from the origin point.  If the value after subtracting is positive, it deflects right, otherwise it deflects left. 

In order to test our VOR, we would have to simulate radio frequencies over a specified time lapse.  (i.e. from the time we start the program to the time we terminate it).  We could randomly generate integer values for the intercepted radials, a 3-letter sequence to represent our own radials (with which to cross reference and ensure we are being given the correct information) and a test to identify if we are over the station.  

Theoretically speaking, we believe the entire program should be no more than 500 LOC.  This is because each of the aforementioned methods will be no more than 20-30 lines each.  The bulk of the code, however, will come from testing the program itself.  This includes setting up instances of our VOR radial and the VOR station, propagating the master and rotating the secondary signals and ensuring each distance checking function (To/From, abeam, overStation) is properly functioning.

We will be using github to host our project. The repository/organization of which can be found at https://github.com/ICS414Sullivan/Sullivan

Total effort to-date: Steven Braun: 3 hours (12, 15-minute increments)
		         Jipeng Huang : 3 hours (12, 15-minute increments)
		         Anthony Kuloloia: 3 hours (12, 15-minute increments)
