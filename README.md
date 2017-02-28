# Sullivan

### Requirments
1. The display of VOR
2. Deflection caculation of needle 
3. Methods of GOOD/BAD and FR/TO signal.
4. What are the parameters?

Initialize radial: parameters (int x1, int x2, int y1, int y2) : Initialize that radial with the given x and y values in the middle of the map using a GUI.

Initialize station: parameters():this.x = 0 this.y = 0 initialize the station to be the origin

Initialize plane: parameters(int x, int y): This.x = x, this.y=y, this.angle=find angle function

Find angle function: parameters(int x, int y) To find the angle of the plane relative to the station, find the inverse tangent of y/x.   
To/Fr method : parameters(int angle) get the angle from the plane relative to the station and compare it to the OBS degrees from To (90-270 or whatever the OBS range currently is) and if the plane is in this boundary, set a boolean to true (true=To, false= FR).

Good/Bad signal method: parameters(intx, int y) have a value that is set for the max x and y position to receive a good signal. If the plane's x or y position is greater than that of the max boundaries, return false(bad signal).

Update OBS: parameters(int change) have the value of the left x (x1= 90), right x (x2 = 270), up(y1 = 0), and down (y2 = 180). Increase each of these by the value of change and mod the numbers by 360, incase they go over and update the radial image to match. 

Flight deflection: parameters(int deflection) compares the y value of  aircraft and subtract the y-axis value. There are 4 dots and each dot represents 2 degree off. If the value after subtract is positive, it deflects right, otherwise it deflects left. 

