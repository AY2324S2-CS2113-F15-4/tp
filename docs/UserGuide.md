# BookBuddy User Guide

## Overview

BookBuddy is an application that helps users track and manage the list of books
that they are reading. It is optimised for users that are familiar with the CLI so that
the tracking and management objectives can be achieved more efficiently.

## Getting Started

1. Ensure that you have Java 11 or above installed.
2. Download the latest JAR file of BookBuddy [here](https://github.com/AY2324S2-CS2113-F15-4/tp/releases).
3. Move the JAR file into an empty folder.
4. In any command terminal, use the `cd` command to switch to the folder containing the JAR file.
5. Enter `java -jar BookBuddy.jar` in the command terminal to run the application.
6. Refer to the features below for details of the various commands and how to use BookBuddy.

## Features

### Adding a book: `help`
View all the commands available in BookBuddy and instructions on their formatting.

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

Format: `set-genre [BOOK_INDEX] [BOOK_GENRE]`

Example of usage:

```
set-genre 1 fiction
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

### Displaying the details of a book: `display`
Gives more detailed information about a specific book like its genre, label and summary.

Format: `display [BOOK_INDEX]`

Example of usage:

```
display 1
```

### Finding a book: `find`
Returns all books in the book list that contains the keyword.

Format: `find [KEYWORD]`

Example of usage:

```
find harry
```

### Exiting the program: `bye`

Exits the application.

Format: `bye`

Example of usage:

```
bye
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
