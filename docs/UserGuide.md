# BookBuddy User Guide

## Overview
BookBuddy is an application that helps users track and manage the list of books
that they are reading. It is optimised for users that are familiar with the CLI so that
the tracking and management objectives can be achieved more efficiently.

#### Target user and value proposition
BookBuddy targets people who are comfortable and proficient with using command-line-interfaces(CLI). These users 
typically prefers the efficiency and flexibility of CLI environments over Graphical user Interfaces (GUIs). They are 
likely to be avid readers who read multiple books simultaneously and who need an effective way to organise their reading 
lists.

Therefore, BookBuddy offers a streamlined and efficient solution for tracking and managing reading lists directly from 
the command line. It provides quick access to book management features for users who prefer keyboard-driven commands and
enjoy the directness and simplicity of CLI tools. With BookBuddy, users can easily add, update, and review their reading
progress without the overhead of navigating traditional graphical applications, saving time and enhancing their reading 
experience.

## Table of Contents
* [Getting Started](#getting-started)
* [Features](#features)
    * [help](#viewing-all-commands-help)
    * [add](#adding-a-book-add)
    * [remove](#removing-a-book-remove)
    * [list](#viewing-all-books-list)
    * [mark](#marking-a-book-as-read-mark)
    * [unmark](#marking-a-book-as-unread-unmark)
    * [list-by-date](#listing-read-books-by-date)
    * [set-genre](#setting-the-genre-of-a-book-set-genre)
    * [label](#labelling-a-book-label)
    * [give-summary](#adding-a-book-summary-give-summary)
    * [rate](#rating-a-book-rate)
    * [list-rated](#sorting-books-by-rating-list-rated)
    * [display](#displaying-the-details-of-a-book-display)
    * [find-title](#finding-a-book-by-title-find-title)
    * [find-genre](#finding-a-book-by-genre-find-genre)
    * [bye](#exiting-the-program-bye)
* [FAQ](#faq)
* [Command Summary](#command-summary)

## Getting Started
1. Ensure that you have Java 11 or above installed.
2. Download the latest JAR file of BookBuddy [here](https://github.com/AY2324S2-CS2113-F15-4/tp/releases).
3. Move the JAR file into an empty folder.
4. In any command terminal, use the `cd` command to switch to the folder containing the JAR file.
5. Enter `java -jar BookBuddy.jar` in the command terminal to run the application.
6. Refer to the features below for details of the various commands and how to use BookBuddy.

## Features

### Viewing all commands: `help`
View all the commands available in BookBuddy and specific instructions on how the commands should be used.

Format: `help`

Example usage:
```
help
```
Example output:
````
Here's a list of commands to get you started!!
add [BOOK_TITLE] -> to add new books to the list
remove [BOOK_INDEX] -> to remove a book from the list
list -> to show whole list of added books
mark [BOOK_INDEX] -> to mark book as read [R]
unmark [BOOK_INDEX] -> to mark book as unread [U]
set-genre [BOOK_INDEX] -> to set a genre for a book
label [BOOK_INDEX] [LABEL] -> to set a label for a book
give-summary [BOOK_INDEX] [BOOK_SUMMARY] -> to give a book a summary
rate [BOOK_INDEX] [BOOK_RATING] -> to rate a book from 1-5
list-rated -> to sort books by rating in descending order
display [BOOK_INDEX] -> to view more details about a book
find-title [KEYWORD] -> to find books with keyword in their title
(advanced)find-genre [GENRE] -> to find books under specific genres
find-genre -> to find books under specific genres
find-read -> to find list of books that are read
find-unread -> to find list of books that are unread
find-label [KEYWORD] -> to find list of books that stored under a certain label
find-rate [RATING] -> to find list of books with specified rating
bye -> to exit BookBuddy software
````

### Adding a book: `add`
Adds a new book to the book list.

Format: `add [BOOK_TITLE]`

Example usage:
```
add Harry Potter
```
Example output:
````
okii added [Harry Potter] to the list.
remember to read it soon....
````

### Removing a book: `remove`
Removes a specific book from the book list by its index.

Format: `remove [BOOK_INDEX]`

Example of usage:

```
remove 1
```

Example output

````
alright.. i've removed Harry Potter from the list.
````

### Viewing all books: `list`
Shows all books stored in the list along with their titles and read or unread status.

Format: `list`

Example usage:

```
list
```

Example output

````
All books:
1. [U] Harry Potter
2. [U] Geronimo Stilton
````

### Marking a book as read: `mark`
Changes the status of a specific book to read.

Format: `mark [BOOK_INDEX]`

Example of usage:

```
mark 1
```

Example output:

````
Successfully marked Harry Potter as read.
````

### Marking a book as unread: `unmark`
Changes the status of a specific book to unread.

Format: `unmark [BOOK_INDEX]`

Example of usage:

```
unmark 1
```
Example output:

````
Successfully marked Harry Potter as unread.
````

### Listing-read-books-by-date `list-by-date`

Lists all read books by descending order of date read.

Format: `list-by-date`

Example of usage with expected output:

```
//input
list-by-date

//output
booky : 6.57 PM, 09-04-2024
book2 : 6.57 PM, 09-04-2024
```



### Setting the genre of a book: `set-genre`

Sets the genre of a specific book based on the provided input and the provided index.

Format: `set-genre [BOOK_INDEX]` followed by `[NUMBER]` then `[CUSTOM_GENRE]` if last option is selected
in the previous step

Or for Pro Users:

Format: `set-genre [BOOK_INDEX] [GENRE]`


Example of usage with expected output:

```
//input
set-genre 1

//output
Available genres:
1. Fiction
2. Non-Fiction
3. Mystery
4. Science Fiction
5. Fantasy
6. Add a new genre
Enter the number for the desired genre, or add a new one:

//input
6

//output
Enter the new genre:

//input
satire

//output
okii categorised [animal farm] as [satire]
remember to read it soon....
````

````
//input
set-genre 1 Fiction
okii categorised [Harry Potter] as [Fiction]
remember to read it soon....

//output
Genre set to Fiction for book at index 1
````

### Labelling a book: `label`

Sets the label of a specific book to the provided input by its index.

Format: `label [BOOK_INDEX] [LABEL]`

Example of usage:

```
label 1 very cool
```

Example output:

````
okii labeled [Harry Potter] as [very cool]
remember to read it soon....
````

### Adding a book summary: `give-summary`
Provides a summary for the specified book.

Format: `give-summary [BOOK_INDEX] [BOOK_SUMMARY]`

Example of usage:

```
give-summary 1 A book about a young boy who is invited to study at Hogwarts.
```

Example output:
````
okii you have written: [A book about a young boy who is invited to study at Hogwarts.] for the book: [Harry Potter]
remember to read it soon....
````

### Rating a book: `rate`
Assigns a rating to a specific book, from a scale of 1-5.

Format: `rate [BOOK_INDEX] [BOOK_RATING]`

Example of usage:

```
rate 1 3
```

Example output:

````
okii set rating for [Harry Potter] as [3]
remember to read it soon....
````

### Sorting books by rating: `list-rated`
Prints a list of books and their ratings in descending order.

Format: `list-rated`

Example of usage:

```
list-rated
```

Example output:

````
Books sorted by rating:
The Boy in Striped Pyjamas - 5
Geronimo Stilton - 4
Harry Potter - 3
````

### Displaying the details of a book: `display`
Gives more detailed information about a specific book like its genre, label and summary.

Format: `display [BOOK_INDEX]`

Example of usage:

```
display 1
```

Example output:
````
Here are the details of your book:
Title: Harry Potter
Status: Read
Label: very cool
Genre: No genre provided
Rating: 3
Summary: A book about a young boy who is invited to study at Hogwarts.
````

### Finding a book by title: `find-title`
Returns all books in the book list that contain the keyword in their title.

Format: `find-title`

Example of usage:

```
find-title Harry
```

Example output:

````
1. [R] Harry Potter
````

### Finding a book by genre: `find-genre`
Returns all books in the saved book list that are stored under the matching genre.

Format: `find-genre [KEYWORD]` or `find-genre` where user will receive a prompt.

Example of usage with expected output:

for more advanced users

```
//input
find-genre
```
````
//ouput
___________________________________
fiction books: 
1. [U] harry potter
_____________
````
for basic users
```
//input
find-genre
```
````
//ouput
Available genres:
1. Fiction
2. Non-Fiction
3. Mystery
4. Science Fiction
5. Fantasy
Enter the number for the desired genre:
````
```
//input
1
```
````
//ouput
___________________________________
fiction books: 
1. [U] harry potter
_____________
````

### Find books that are read: `find-read`
Returns all books in the saved book list that are marked read.

Format: `find-read`

Example of usage with expected output:
````
//input
find-read
````
````
//ouput
1. [R] harry potter
````
### Find books that are unread: `find-unread`
Returns all books in the saved book list that are marked unread.

Format: `find-unread`

Example of usage with expected output:
````
//input
find-unread
````
````
//ouput
1. [U] geronimo stilton
2. [U] The Boy in Striped Pyjamas
````
### Find books that are labelled: `find-label`
Returns all books in the saved book list that stored under specific label.

Format: `find-label [KEYWORD]`

Example of usage with expected output:
````
//input
find-label very cool
````
````
//ouput
___________________________________
books with [very cool] in their label:
1. [R] harry potter
_____________
````
### Find books that are labelled: `find-rate`
Returns all books in the saved book list that have specific rating.

Format: `find-rate [RATING]`

Example of usage with expected output:
````
//input
find-rate 3
````
````
//ouput
___________________________________
books rated [3] :
1. [R] harry potter
_____________
````
### Exiting the program: `bye`

Exits the application and saves all tasks in a file.

Format: `bye`

Example of usage:

```
bye
```

Example output:
````
Writing successful. Data has been saved.
Thank you for using BookBuddy! Hope to see you again keke :)
````

## FAQ

**Q**: How do I load and save data from a previous session?

**A**: All data entered is automatically saved by the program and does not require any
commands from the user. Upon running the file for the first time, the `books.txt` file
will be created in the `data` folder. This folder will be in the same folder as the JAR file (For example, if
JAR file is located in /Users/ZongYao/Desktop then the `books.txt` will be located in /Users/ZongYao/Desktop/data).

**Q**: What happens if I give an invalid command or command argument?

**A**: All invalid commands and invalid arguments are handled gracefully with exceptions. You will just
be prompted to re-enter the command with an instruction on how to properly type the command.

**Users MUST exit the program with the `bye` command for the data in the session
to be saved.**

## Command Summary

* View commands: `help`
* Add book: `add [BOOK_TITLE]`
* Remove book: `remove [BOOK_INDEX]`
* View all books: `list`
* Mark book as read: `mark [BOOK_INDEX]`
* Mark book as unread: `unmark [BOOK_INDEX]`
* Set genre: `set-genre [BOOK_INDEX] [GENRE]` (Single-Step for Pro users)
* Set genre: `set-genre [BOOK_INDEX]` followed by `[NUMBER]` then `[CUSTOM_GENRE]` if necessary (Multi-Step)
* Label book: `label [BOOK_INDEX] [LABEL]`
* Add summary: `give-summary [BOOK_INDEX] [BOOK_SUMMARY]`
* Rate a book: `rate [BOOK_INDEX] [BOOK_RATING]`
* Sort books by rating: `list-rated`
* Display details: `display [BOOK_INDEX]`
* Find books with specific title: `find-title [KEYWORD]`
* Find books with specific genre: `find-genre [KEYWORD]`
* Find books that are read: `find-read`
* Find books that are unread: `find-unread`
* Exit program: `bye`
