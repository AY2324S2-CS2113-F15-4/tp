# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

Reference to AB-3 Developer Guide
* [Source URL](https://se-education.org/addressbook-level3/DeveloperGuide.html#documentation-logging-testing-configuration-dev-ops)
* Used as template to structure this DeveloperGuide
* Reference to AB-3 diagrams code

Reference to AB-3 diagrams code
* [Source URL](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams)
* Used as reference to understand PlantUML syntax


## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}
### Categorising the different books by their genres
This functionality enables the categorization of books into distinct groups based on their genres, facilitating better 
organization and tracking. The implementation of this feature involves interactions across multiple classes within the 
system. 
#### Overview
The process of categorizing books by genre is a multi-step operation that involves the following classes:
1. `BookDetails`: This class contains methods that handle the categorization of books.
2. `Book`: Individual book objects are updated with their respective genres directly in this class.
3. `Parser`: This class is responsible for parsing the input command to extract the specific index and genre.

#### Detailed Workflow
Below is an example usage:  
Here’s a step-by-step guide on how the feature works:
Step 1: The user initiates the process by inputting a command like `set-genre 1 Fantasy`. Here, the `Parser` class plays
a crucial role as it interprets the command and segregates it into a manageable array. The first part of this array holds 
the command `set-genre`, which indicates the action to be executed.

Step 2: The second segment of the input string is then further dissected into two components, which are the index (`1`) 
and the genre (`Fantasy`). This step is essential for identifying the specific book and the genre it needs to be 
associated with.

Step 3: With the index and genre clearly identified, these parameters are passed to the `setBookGenreByIndex` method 
within the `BookDetails` class. This method is then responsible for assigning the specified genre to the book located at 
the given index.

#### Implementation and Rationale
The decision to involve multiple classes in this operation is driven by the principles of object-oriented programming, 
which emphasize modularity, encapsulation, and separation of concerns. By distributing responsibilities across different
classes, the system remains flexible, with each class focusing on a specific aspect of the functionality.

* The `BookDetails` class is central to managing book attributes and behaviors, making it the logical location for methods 
* that categorize books.
* The `Book` class represents individual books, and it is here that genre information is ultimately stored, aligning with 
* the principle that objects should manage their own state.
* The `Parser` class abstracts the complexity of command interpretation, ensuring that user inputs are correctly understood 
* and acted upon by the system.

#### Alternatives Considered
An alternative design could have centralized the categorization logic within a single class, such as `BookDetails` or 
`Parser`. However, this approach was discarded in favor of the current design to avoid overloading a single class with 
multiple responsibilities and to adhere to the Single Responsibility Principle. By distributing the tasks, the system 
gains in maintainability and scalability, facilitating future enhancements and modifications. 

### BookList Class Component
The `BookList` class is responsible for all actions involving the list of books that the user has. 

#### Overview
The `BookList` class contains one protected static ArrayList named books. This ArrayList will contain Book objects. The methods in 
this class all change the ArrayList according to the command given.

#### Detailed Workflow
Apart from the constructor, the methods of this class like getSize(), addBook() all either return a piece of information about the ArrayList,
the book object that is selected or change an attribute of the ArrayList or selected book object. For the printAllBooks() method, the ArrayList
is iterated through, with the details of each book being printed out according to the toString() format of each book. Other than that, methods like
markDoneByIndex() and markUndoneByIndex() both will change the isRead() attribute of the book of the given index. This class handles errors related to the
ArrayList, throwing exceptions for invalid indexes and invalid actions based on current state (if trying to mark a book that is already read).

#### Implementation and Rationale

### Parser Class Component
The `Parser` class is responsible for parsing any input from the user and making sense of them to execute the correct commands.

#### Overview
The `Parser` class contains several predefined string constants representing the valid commands and a public method to parse the 
input from the user.

#### Detailed Workflow
Whenever input from the user is detected by the program, the `Parser` class will split the command into 2 parts, with the first part
containing the command and the second containing details of the command (if present). The command entered is then evaluated using a
switch statement, with the value of it being compared to the values of each case. In the case of a match, the `Parser` class will then 
execute the respective action associated with that command by calling other classes from the program such as `BookList` or `BookDetails`. 
This class also handles errors and exceptions associated with the users input. For example, if the user were to give the command `mark` without
specifying an index for which book to mark, or gives a negative number, an appropriate error message will be shown and the command will be rendered
invalid.

#### Implementation and Rationale
The `Parser` class incorporates exception handling to detect invalid or unrecognized commands. This allows the program to continue running
while prompting the user for valid input

By abstracting out the parsing functionality of BookBuddy into a separate `Parser` class, the complexity of parsing user input is removed
from the main code. It is instead replaced by a simple interface for the user to work with, adhering to the abstraction concept of
object-oriented programming.

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
