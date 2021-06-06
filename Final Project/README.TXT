

FINAL PROJECT
  by Dune Rose Zawadzki
         
   ASCII ART BABYYYYY
         5/24 + 5/25 
     Test.java Description:
     
   I want to map my progress chronologically through a series of test classes, as well
   as a final class to combine these. My test class accesses an image (which will be
   user-chosen soon) and establishes height and width. I found the appropriate import statements online
   and cut many uneccesary ones to trim down my code, and to make sure I knew which corresponded to 
   which java capabilities.
   
import java.io.File - 
    this statement gives me access a class that allows me to interact with files :)  I 
    put this first "ascii-pineapple" image directly into BlueJ, so it's a fairly simple game in 
    retrieving it.

import java.awt.image.BufferedImage - 
    this statemenet goes through multiple subhierarchies in the graphics tool kit in
    order to let me access a series of methods for java image processing. Essentially allowing java
    to recognize a file as an image and an image as a group of pixels (?)

import javax.imageio.ImageIO - 
    this import is a class of static methods for decoding and encoding images. 
    
    I've included a try-catch  because I think it's important, and to avoid throwing
    an out-of-bounds exception 
         
         PLAN:
         In the coming few days will store my image data in a 2D array of RGB values
         After that is operating properly, will do a series of alternate converstions to 
         brightness/luminosity 
         VARISOS VERSIONS
         Converting RGB Values based on what the user wants
         0 for black and white
         1 for photometric
         2 for percieved luminosity
         3 
         
         
         
         
    Sources:
    
    https://robertheaton.com/2018/06/12/programming-projects-for-advanced-beginners-ascii-art/
    https://www.tutorialspoint.com/java_dip/java_buffered_image.htm
    https://www.w3schools.com/java/java_files_create.asp
    
    