# playwithj8
Affiliate clean up

Context: Web Scrapper plugin gives the content of a web page in a csv format. We want to insert this content into elastic search. 

Goal: Make it easier to verify the content and insert it to elastic search


0) Compile the code
javac Cleaner.java

Usage:

1) Add links and img tags 
java Cleaner file_absolute_path 

To save the result in a file add " > file.html" to the end of command. The following saves the result in the outputfile.html

java Cleaner file_absolute_path > outputfile.html

2) Do one Plus ignore a certain url
java Cleaner /media/c/projects/sanabe/affiliate/Svala/svala.csv https://www



Useful commands:
java Cleaner /media/c/projects/sanabe/affiliate/Svala/svala.csv https://www > out.html

