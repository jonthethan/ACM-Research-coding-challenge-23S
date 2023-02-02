Hi! I decided to find some averages across the entire data set and also most common occurences of items. Here is how I went about doing this:
1. Copy and paste all data from .csv file to .txt file
2. For every line, make a new Star object and populate data, also keep track of how many of each type, color, and spectral classes there are
3. Calculate average temperature, luminosity, Radius, and Absolute magnitude of set
4. Make three similar methods to find most common occurence of type, color, and spectral class:
  a. Make an array that holds the number of items of each type
  b. Find the maximum of that array
  c. Index matching maximum corresponds to most common occurence
  d. Output to screen
