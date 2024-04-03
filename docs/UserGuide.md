# BookBuddy User Guide

## Overview
BookBuddy is an application that helps users track and manage the list of books
that they are reading. It is optimised for users that are familiar with the CLI so that
the tracking and management objectives can be achieved more efficiently.

## Table of Contents
* [Getting Started](#getting-started)
* [Features](#features)
    * [help](#viewing-all-commands-help)
    * [add](#adding-a-book-add)
    * [remove](#removing-a-book-remove)
    * [list](#viewing-all-books-list)
    * [mark](#marking-a-book-as-read-mark)
    * [unmark](#marking-a-book-as-unread-unmark)
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
View all the commands available in BookBuddy and instructions on their usage.

Format: `help`

Example of usage:

```
help
```

### Adding a book: `add`
Adds a new book to the book list.

Format: `add [BOOK_TITLE]`

Example of usage:

```
add Harry Potter
```

### Removing a book: `remove`
Removes a specific book from the book list.

Format: `remove [BOOK_INDEX]`

Example of usage:

```
remove 1
```

### Viewing all books: `list`
Shows all books in the list along with their titles and status.

Format: `list`

Example of usage:

```
list
```

### Marking a book as read: `mark`
Changes the status of a specific book to read.

Format: `mark [BOOK_INDEX]`

Example of usage:

```
mark 1
```

### Marking a book as unread: `unmark`
Changes the status of a specific book to unread.

Format: `unmark [BOOK_INDEX]`

Example of usage:

```
unmark 1
```

### Setting the genre of a book: `set-genre`

Sets the genre of a specific book to the provided input.

Format: `set-genre [BOOK_INDEX]` followed by `[NUMBER]` then `[CUSTOM_GENRE]` if 6 is entered
in the previous step

Example of usage with expected output:

```
set-genre 1
Available genres:
1. Fiction
2. Non-Fiction
3. Mystery
4. Science Fiction
5. Fantasy
6. Add a new genre
Enter the number for the desired genre, or add a new one:
6
Enter the new genre:
satire
okii categorised [animal farm] as [satire]
remember to read it soon....
```

### Labelling a book: `label`

Sets the label of a specific book to the provided input.

Format: `label [BOOK_INDEX] [LABEL]`

Example of usage:

```
label 1 very cool
```

### Adding a book summary: `give-summary`
Provides a summary for the specified book.

Format: `give-summary [BOOK_INDEX] [BOOK_SUMMARY]`

Example of usage:

```
give-summary 1 A book about a young boy who is invited to study at Hogwarts.
```

### Rating a book: `rate`
Assigns a rating to a specific book, from a scale of 1-5.

Format: `rate [BOOK_INDEX] [BOOK_RATING]`

Example of usage:

```
rate 1 3
```

### Sorting books by rating: `list-rated`
Prints a list of books and their ratings in descending order.

Format: `list-rated`

Example of usage:

```
list-rated
```

### Displaying the details of a book: `display`
Gives more detailed information about a specific book like its genre, label and summary.

Format: `display [BOOK_INDEX]`

Example of usage:

```
display 1
```

### Finding a book by title: `find-title`
Returns all books in the book list that contain the keyword in their title.

Format: `find-title`

Example of usage:

```
find-title harry
```

### Finding a book by genre: `find-genre`
Returns all books in the book list that has the matching genre.

Format: `find-genre` followed by `[NUMBER]`

Example of usage:

```
find-genre
Available genres:
1. Fiction
2. Non-Fiction
3. Mystery
4. Science Fiction
5. Fantasy
Enter the number for the desired genre:
1
1. [U] harry potter
```

### Exiting the program: `bye`

Exits the application and saves all tasks in a file.

Format: `bye`

Example of usage:

```
bye
```

## FAQ

**Q**: How do I load and save data from a previous session?

**A**: All data entered is automatically saved by the program and does not require any
commands from the user. Upon running the file for the first time, the `books.txt` file
will be created in the `data` folder. This folder will be in the same folder as the JAR file.

**Users MUST exit the program with the `bye` command for the data in the session
to be saved.**

## Command Summary

* View commands: `help`
* Add book: `add [BOOK_TITLE]`
* Remove book: `remove [BOOK_INDEX]`
* View all books: `list`
* Mark book as read: `mark [BOOK_INDEX]`
* Mark book as unread: `unmark [BOOK_INDEX]`
* Set genre: `set-genre [BOOK_INDEX]` followed by `[NUMBER]` then `[CUSTOM_GENRE]` if necessary
* Label book: `label [BOOK_INDEX] [LABEL]`
* Add summary: `give-summary [BOOK_INDEX] [BOOK_SUMMARY]`
* Rate a book: `rate [BOOK_INDEX] [BOOK_RATING]`
* Sort books by rating: `list-rated`
* Display details: `display [BOOK_INDEX]`
* Find books with specific title: `find-title [KEYWORD]`
* Find books with specific genre: `find-genre` followed by `[NUMBER]`
* Exit program: `bye`
