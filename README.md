# Sullivan

### Requirments
1. The display of VOR
2. Deflection caculation of needle 
3. Methods of GOOD/BAD and FR/TO signal.
4. What are the parameters?

To/Fr method : parameters(int angle)
get the angle from the plane relative to the station and compare it to the OBS degrees from To (90-270 or whatever the OBS range currently is) and if the plane is in this boundary, set a boolean to true (true=To, false= FR). 

Good/Bad signal method: parameters(intx, int y)
have a value that is set for the max x and y position to receive a good signal. If the plane's x or y position is greater than that of the max boundaries, return false(bad signal).



