# Project Description

## https://ghibliapi.herokuapp.com/films returns all films
## https://ghibliapi.herokuapp.com/films/<id> returns specific film with a given ID

Note that in each step you should only display the necessary fields, and not the entire HTTP response or the entire JSON document.

 

Study the documentation and examples at https://ghibliapi.herokuapp.com/ (Links to an external site.)  in order to learn about the API requests that are available to you from this particular API, and use the patterns that we learned in class to perform the following tasks:

1) Connect to the Studio Ghibli API and retrieve a list of all movies.  Display this list of movies to the user.  You should display the title and description of the movie.

2) Repeatedly prompt the user to select a movie or quit.  The user should select a movie by typing its title.  Note: This may be a bit tricky if you use the API call that is expecting you to specify a movie by its ID.

3) Display the title, description, release date , and producer of that selected movie, or "Movie not found" if that title doesn't exist in the API.

4) Upload your assignment as either a NetBeans exported ZIP file, or a VSCode project/folder compressed into a ZIP file.  Note that other compression formats (e.g. 7zip, tar.gz, etc.) will not be accepted and will result in a grade of zero.

 

Extra credit:

 

For up to three points of extra credit, use an additional API to display the spelling/grammatical correctness and/or sentiment analysis of each movie description.