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
  * [list-by-date](#listing-read-books-by-date-list-by-date)
  * [list-genre](#viewing-all-genres-list-genre)
  * [set-genre](#setting-the-genre-of-a-book-set-genre)
  * [remove-genre](#removing-a-genre-remove-genre)
  * [set-author](#setting-the-author-of-a-book-set-author)
  * [label](#labelling-a-book-label)
  * [give-summary](#adding-a-book-summary-give-summary)
  * [rate](#rating-a-book-rate)
  * [list-rated](#sorting-books-by-rating-list-rated)
  * [display](#displaying-the-details-of-a-book-display)
  * [find-title](#finding-a-book-by-title-find-title)
  * [find-genre](#finding-a-book-by-genre-find-genre)
  * [find-read](#find-books-that-are-read-find-read)
  * [find-unread](#find-books-that-are-unread-find-unread)
  * [find-label](#find-books-that-are-labelled-find-label)
  * [find-rate](#find-books-that-are-labelled-find-rate)
  * [find-author](#find-books-that-are-written-by-specific-author-find-author)
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

Example of usage with expected output:
```
//input
help

//output
Here's a list of commands to get you started!!
add [BOOK_TITLE] -> to add new books to the list
remove [BOOK_INDEX] -> to remove a book from the list
list -> to show whole list of added books
mark [BOOK_INDEX] -> to mark book as read [R]
unmark [BOOK_INDEX] -> to mark book as unread [U]
list-by-date -> to print out all books sorted in descending order of date
list-genre -> to see all genres stored in the list
(basic) set-genre [BOOK_INDEX] -> to set a genre for a book
(advanced) set-genre [BOOK_INDEX] [GENRE] -> to set a genre for a book
remove-genre -> to remove a specific genre from the list
set-author [BOOK_INDEX] [BOOK_AUTHOR] -> to set an author for a book")
label [BOOK_INDEX] [LABEL] -> to set a label for a book
give-summary [BOOK_INDEX] [BOOK_SUMMARY] -> to give a book a summary
rate [BOOK_INDEX] [BOOK_RATING] -> to rate a book from 1-5
list-rated -> to sort books by rating in descending order
display [BOOK_INDEX] -> to view more details about a book
find-title [KEYWORD] -> to find books with keyword in their title
(basic) find-genre -> to find books under specific genres
(advanced) find-genre [GENRE] -> to find books under specific genres
find-read -> to find list of books that are read
find-unread -> to find list of books that are unread
find-label [KEYWORD] -> to find list of books that stored under a certain label
find-rate [RATING] -> to find list of books with specified rating
find-author [AUTHOR] -> to find list of books written by specific author
bye -> to exit BookBuddy software
```

### Adding a book: `add`
Adds a new book to the book list.

Format: `add [BOOK_TITLE]`

Example of usage with expected output:
```
//input
add Harry Potter

//output
okii added [Harry Potter] to the list.
remember to read it soon....
```

### Removing a book: `remove`
Removes a specific book from the book list by its index.

Format: `remove [BOOK_INDEX]`

Example of usage with expected output:

```
//input
remove 1

//output
alright.. i've removed Harry Potter from the list.
```

### Viewing all books: `list`
Shows all books stored in the list along with their titles and read or unread status.

Format: `list`

Example of usage with expected output:

```
//input
list

//output
All books:
1. [U] Harry Potter
2. [U] Geronimo Stilton
```

### Marking a book as read: `mark`
Changes the status of a specific book to read and records the current date
and time in which it is marked.

Format: `mark [BOOK_INDEX]`

Example of usage with expected output:

```
//input
mark 1

//output
Successfully marked [Harry Potter] as read.
```

### Marking a book as unread: `unmark`
Changes the status of a specific book to unread.

Format: `unmark [BOOK_INDEX]`

Example of usage with expected output:

```
//input
unmark 1

//output
Successfully marked Harry Potter as unread.
```

### Listing read books by date: `list-by-date`
Lists all read books by their date read, in order of most recently read.

Format: `list-by-date`

Example of usage with expected output:

```
//input
list-by-date

//output
Harry Potter : 6.57 PM, 09-04-2024
Geronimo Stilton : 6.52 PM, 09-04-2024
```

### Viewing all genres: `list-genre`
Shows all genres stored in the list

Format: `list-genre`

Example of usage with expected output:

```
//input
list-genre

//output
All Genres:
1. Fiction
2. Non-Fiction
3. Mystery
4. Science Fiction
5. Fantasy
```

### Setting the genre of a book: `set-genre`
Sets the genre of a specific book based on the provided input and the provided index.

For new users:

Format: `set-genre [BOOK_INDEX]` followed by `[NUMBER]` <br>
followed by `[GENRE]` if last option is selected in the previous step

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
```

For advanced users:

Format: `set-genre [BOOK_INDEX] [GENRE]`

Example of usage with expected output:

```
//input
set-genre 1 Fiction

//output
okii categorised [Harry Potter] as [Fiction]
remember to read it soon....
```

### Removing a genre: `remove-genre`
Removes a specific genre from the genre list by its index.
Index 1 to 5 are default genres and cannot be removed.

Format: `remove-genre [GENRE_INDEX]`

Example of usage with expected output:

```
//input
remove-genre 6

//output
okii [Classic] removed from the genre list!
```

### Setting the author of a book: `set-author`
Sets the author of a specific book based on the provided input and the provided index.

Format: `set-author [BOOK_INDEX] [BOOK_AUTHOR]` 

Example of usage with expected output:

```
//input
set-author 1 zonyao

//output
okii you have have set: [zonyao] as the author for the book: [book1]
remember to read it soon....
```

### Labelling a book: `label`
Sets the label of a specific book to the provided input by its index.

Format: `label [BOOK_INDEX] [LABEL]`

Example of usage with expected output:

```
//input
label 1 very cool

//output
okii labeled [Harry Potter] as [very cool]
remember to read it soon....
```

### Adding a book summary: `give-summary`
Provides a summary for the specified book.

Format: `give-summary [BOOK_INDEX] [BOOK_SUMMARY]`

Example of usage with expected output:

```
//input
give-summary 1 A book about a young boy who is invited to study at Hogwarts.

//output
okii you have written: [A book about a young boy who is invited to study at Hogwarts.] for the book: [Harry Potter]
remember to read it soon....
```

### Rating a book: `rate`
Assigns a rating to a specific book, from a scale of 1-5.

Format: `rate [BOOK_INDEX] [BOOK_RATING]`

Example of usage with expected output:

```
//input
rate 1 3

//output
okii set rating for [Harry Potter] as [3]
remember to read it soon....
```

### Sorting books by rating: `list-rated`
Prints a list of books and their ratings in descending order.

Format: `list-rated`

Example of usage with expected output:

```
//input
list-rated

//output
Books sorted by rating:
The Boy in Striped Pyjamas - 5
Geronimo Stilton - 4
Harry Potter - 3
```

### Displaying the details of a book: `display`
Gives more detailed information about a specific book like its genre, label and summary.

Format: `display [BOOK_INDEX]`

Example of usage with expected output:

```
//input
display 1

//output
Here are the details of your book:
Title: Harry Potter
Status: Read on 1.10 AM, 11-04-2024
Label: very cool
Genre: No genre provided
Rating: 3
Summary: A book about a young boy who is invited to study at Hogwarts.
```

### Finding a book by title: `find-title`
Returns all books in the book list that contain the keyword in their title.
The keyword is not case-sensitive.

Format: `find-title [KEYWORD]`

Example of usage with expected output:

```
//input
find-title harry

//output
books with [harry] in the title:
1. [R] Harry Potter
```

### Finding a book by genre: `find-genre`
Returns all books in the saved book list that are stored under the matching genre.
The keyword is not case-sensitive.

For new users:

Format: `find-genre` followed by `[NUMBER]`

Example of usage with expected output:

```
//input
find-genre

//ouput
Available genres:
1. Fiction
2. Non-Fiction
3. Mystery
4. Science Fiction
5. Fantasy
Enter the number for the desired genre:

//input
1

//output
fiction books: 
1. [U] harry potter
````

For advanced users:

Format: `find-genre [KEYWORD]`

Example of usage with expected output:

```
//input
find-genre fiction

//output
fiction books: 
1. [U] Harry Potter
```

### Find books that are read: `find-read`
Returns all books in the saved book list that are marked read.

Format: `find-read`

Example of usage with expected output:

```
//input
find-read

//output
1. [R] harry potter
```

### Find books that are unread: `find-unread`
Returns all books in the saved book list that are marked unread.

Format: `find-unread`

Example of usage with expected output:

```
//input
find-unread

//output
1. [U] Geronimo Stilton
2. [U] The Boy in Striped Pyjamas
```

### Find books that are labelled: `find-label`
Returns all books in the saved book list that stored under a specific label.
The keyword is not case-sensitive.

Format: `find-label [KEYWORD]`

Example of usage with expected output:

```
//input
find-label very cool

//output
books with [very cool] in their label:
1. [R] harry potter
```

### Find books that are labelled: `find-rate`
Returns all books in the saved book list that have a specific rating.

Format: `find-rate [RATING]`

Example of usage with expected output:

```
//input
find-rate 3

//output
books rated [3] :
1. [R] harry potter
```
### Find books that are written by specific author: `find-author`
Returns all books in the saved book list that are written by the same author.
The author is not case-sensitive.

Format: `find-author [AUTHOR]`

Example of usage with expected output:

```
//input
find-author jk rowling

//output
books written by [jk rowling] :
1. [R] harry potter
```

### Exiting the program: `bye`
Exits the application and saves all tasks in a file.

Format: `bye`

Example of usage with expected output:

```
//input
bye

//output
Writing successful. Data has been saved.
Thank you for using BookBuddy! Hope to see you again keke :)
```

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
|                       Purpose of Command                        |                               Command Syntax                                |
|:---------------------------------------------------------------:|:---------------------------------------------------------------------------:|
|                        View all commands                        |                                   `help`                                    |
|                           Add a book                            |                             `add [BOOK_TITLE]`                              |
|                          Remove a book                          |                            `remove [BOOK_INDEX]`                            |
|                         View all books                          |                                   `list`                                    |
|                        Mark book as read                        |                             `mark [BOOK_INDEX]`                             |
|                       Mark book as unread                       |                            `unmark [BOOK_INDEX]`                            |
|                   Listing read books by date                    |                               `list-by-date`                                |
|                         List all genres                         |                                `list-genre`                                 |
|           Set genre (Single-step for advanced users)            |                      `set-genre [BOOK_INDEX] [GENRE]`                       |
|              Set genre (Multi-step for new users)               | `set-genre [BOOK_INDEX]` followed by `[NUMBER]` then `[GENRE]` if necessary |
|                         Remove a genre                          |                        `remove-genre [GENRE_INDEX]`                         |
|                       Add author for book                       |                     `set-author [BOOK_INDEX] [AUTHOR]`                      |
|                           Label book                            |                        `label [BOOK_INDEX] [LABEL]`                         |
|                      Add summary for book                       |                 `give-summary [BOOK_INDEX] [BOOK_SUMMARY]`                  |
|                            Rate book                            |                      `rate [BOOK_INDEX] [BOOK_RATING]`                      |
|                      Sort books by rating                       |                                `list-rated`                                 |
|                     Display details of book                     |                           `display [BOOK_INDEX]`                            |
|                 Find books with specific title                  |                           `find-title [KEYWORD]`                            |
| Find books with specific genre (Single-step for advanced users) |                            `find-genre [GENRE]`                             |
|    Find books with specific genre (Multi-step for new users)    |                     `find-genre` followed by `[NUMBER]`                     |
|                    Find books that are read                     |                                 `find-read`                                 |
|                   Find books that are unread                    |                                `find-unread`                                |
|                 Find books with specific label                  |                           `find-label [KEYWORD]`                            |
|                 Find books with specific rating                 |                            `find-rate [RATING]`                             |
|                 Find books with specific author                 |                           `find-author [AUTHOR]`                            |
|                          Exit program                           |                                    `bye`                                    |
